package dev.matthiesen.cobblemon_pokestops.common.item;

import dev.matthiesen.cobblemon_pokestops.common.config.PokestopsConfig;
import dev.matthiesen.cobblemon_pokestops.common.registry.ModTags;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

public final class StopRemover extends Item {
    private static final String CONFIRM_DATA = "StopRemoverConfirm";
    private static final String KEY_X = "x";
    private static final String KEY_Y = "y";
    private static final String KEY_Z = "z";
    private static final String KEY_DIMENSION = "dimension";
    private static final String KEY_EXPIRES_AT = "expiresAt";

    public StopRemover() {
        super(new Item.Properties());
    }

    @Override
    public @NotNull InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        if (level.isClientSide) {
            return InteractionResult.SUCCESS;
        }

        if (!(context.getPlayer() instanceof ServerPlayer player)) {
            return InteractionResult.PASS;
        }

        ItemStack remover = context.getItemInHand();
        Optional<TargetStopData> targetData = resolveTarget(level, context.getClickedPos());

        if (targetData.isEmpty()) {
            clearConfirmation(remover);
            sendMessage(player, "message.cobblemon_pokestops.stop_remover_invalid_target", ChatFormatting.RED);
            return InteractionResult.FAIL;
        }

        if (!player.getAbilities().mayBuild) {
            clearConfirmation(remover);
            sendMessage(player, "message.cobblemon_pokestops.stop_remover_adventure_denied", ChatFormatting.RED);
            return InteractionResult.FAIL;
        }

        var config = PokestopsConfig.SERVER_CONFIG;
        if (config.stopRemover_requireOp.getAsBoolean() && !player.hasPermissions(config.stopRemover_permissionLevel.get().getLevel())) {
            clearConfirmation(remover);
            sendMessage(player, "message.cobblemon_pokestops.stop_remover_no_permission", ChatFormatting.RED);
            return InteractionResult.FAIL;
        }

        TargetStopData target = targetData.get();
        ConfirmationData confirmation = getConfirmation(remover).orElse(null);
        long now = level.getGameTime();

        if (confirmation == null || confirmation.isExpired(now) || !confirmation.matchesDimension(level.dimension())) {
            if (confirmation != null && confirmation.isExpired(now)) {
                sendMessage(player, "message.cobblemon_pokestops.stop_remover_timeout", ChatFormatting.RED);
            }
            armConfirmation(remover, level, target.pos(), now + (Math.max(1, config.stopRemover_confirmWindowSeconds.getAsInt()) * 20L));
            sendMessage(player, "message.cobblemon_pokestops.stop_remover_armed", ChatFormatting.YELLOW);
            return InteractionResult.SUCCESS;
        }

        if (!confirmation.matchesPosition(target.pos())) {
            armConfirmation(remover, level, target.pos(), now + (Math.max(1, config.stopRemover_confirmWindowSeconds.getAsInt()) * 20L));
            sendMessage(player, "message.cobblemon_pokestops.stop_remover_mismatch", ChatFormatting.RED);
            return InteractionResult.SUCCESS;
        }

        if (!player.isCrouching()) {
            sendMessage(player, "message.cobblemon_pokestops.stop_remover_need_crouch", ChatFormatting.YELLOW);
            return InteractionResult.SUCCESS;
        }

        if (config.stopRemover_dropsStopItem.getAsBoolean() && !player.isCreative() && !hasFreeInventorySlot(player)) {
            clearConfirmation(remover);
            sendMessage(player, "message.cobblemon_pokestops.stop_remover_inventory_full", ChatFormatting.RED);
            return InteractionResult.FAIL;
        }

        level.destroyBlock(target.pos(), false, player);

        if (config.stopRemover_dropsStopItem.getAsBoolean() && !player.isCreative()) {
            ItemStack recoveredStack = new ItemStack(target.state().getBlock().asItem());
            if (!recoveredStack.isEmpty() && !player.getInventory().add(recoveredStack)) {
                player.drop(recoveredStack, false);
            }
        }

        clearConfirmation(remover);
        sendMessage(player, "message.cobblemon_pokestops.stop_remover_confirmed", ChatFormatting.GREEN);
        return InteractionResult.SUCCESS;
    }

    private static Optional<TargetStopData> resolveTarget(Level level, BlockPos clickedPos) {
        BlockState clickedState = level.getBlockState(clickedPos);
        if (isStopBlock(clickedState)) {
            return Optional.of(new TargetStopData(clickedPos, clickedState));
        }

        if (!clickedState.is(ModTags.Blocks.DUMMYBLOCKS)) {
            return Optional.empty();
        }

        for (int i = 1; i <= 2; i++) {
            BlockPos candidatePos = clickedPos.below(i);
            BlockState candidateState = level.getBlockState(candidatePos);
            if (isStopBlock(candidateState)) {
                return Optional.of(new TargetStopData(candidatePos, candidateState));
            }
        }

        return Optional.empty();
    }

    private static boolean isStopBlock(BlockState state) {
        return state.is(ModTags.Blocks.POKESTOPS)
                || state.is(ModTags.Blocks.WINGEDSTOPS)
                || state.is(ModTags.Blocks.POKEBALLSTOPS)
                || state.is(ModTags.Blocks.HEALINGSTOPS);
    }

    private static boolean hasFreeInventorySlot(ServerPlayer player) {
        for (int i = 0; i < player.getInventory().getContainerSize(); i++) {
            if (player.getInventory().getItem(i).isEmpty()) {
                return true;
            }
        }
        return false;
    }

    private static Optional<ConfirmationData> getConfirmation(ItemStack stack) {
        CompoundTag root = stack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag();
        if (!root.contains(CONFIRM_DATA, Tag.TAG_COMPOUND)) {
            return Optional.empty();
        }

        CompoundTag confirmTag = root.getCompound(CONFIRM_DATA);
        if (!confirmTag.contains(KEY_X) || !confirmTag.contains(KEY_Y) || !confirmTag.contains(KEY_Z)
                || !confirmTag.contains(KEY_DIMENSION) || !confirmTag.contains(KEY_EXPIRES_AT)) {
            return Optional.empty();
        }

        BlockPos pos = new BlockPos(confirmTag.getInt(KEY_X), confirmTag.getInt(KEY_Y), confirmTag.getInt(KEY_Z));
        ResourceLocation dimensionId = ResourceLocation.tryParse(confirmTag.getString(KEY_DIMENSION));
        if (dimensionId == null) {
            return Optional.empty();
        }

        return Optional.of(new ConfirmationData(pos, ResourceKey.create(net.minecraft.core.registries.Registries.DIMENSION, dimensionId), confirmTag.getLong(KEY_EXPIRES_AT)));
    }

    private static void armConfirmation(ItemStack stack, Level level, BlockPos pos, long expiresAt) {
        CustomData.update(DataComponents.CUSTOM_DATA, stack, root -> {
            CompoundTag confirmTag = new CompoundTag();
            confirmTag.putInt(KEY_X, pos.getX());
            confirmTag.putInt(KEY_Y, pos.getY());
            confirmTag.putInt(KEY_Z, pos.getZ());
            confirmTag.putString(KEY_DIMENSION, level.dimension().location().toString());
            confirmTag.putLong(KEY_EXPIRES_AT, expiresAt);
            root.put(CONFIRM_DATA, confirmTag);
        });
    }

    private static void clearConfirmation(ItemStack stack) {
        CustomData.update(DataComponents.CUSTOM_DATA, stack, root -> root.remove(CONFIRM_DATA));
    }

    private static void sendMessage(ServerPlayer player, String key, ChatFormatting style) {
        player.displayClientMessage(Component.translatable(key).withStyle(style), true);
    }

    private record TargetStopData(BlockPos pos, BlockState state) {}

    private record ConfirmationData(BlockPos pos, ResourceKey<Level> dimension, long expiresAt) {
        private boolean isExpired(long gameTime) {
            return gameTime > expiresAt;
        }

        private boolean matchesPosition(BlockPos other) {
            return pos.equals(other);
        }

        private boolean matchesDimension(ResourceKey<Level> other) {
            return dimension.equals(other);
        }
    }
}
