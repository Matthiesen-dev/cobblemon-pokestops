package dev.matthiesen.common.cobblemon_pokestops.block;

import com.mojang.serialization.MapCodec;
import dev.matthiesen.common.cobblemon_pokestops.CobblemonPokestops;
import dev.matthiesen.common.cobblemon_pokestops.Constants;
import dev.matthiesen.common.cobblemon_pokestops.block.entity.PokestopEntity;
import dev.matthiesen.common.cobblemon_pokestops.registry.*;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.DustColorTransitionOptions;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DirectionalBlock;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3f;

import java.util.List;

public class Pokestop extends DirectionalBlock implements EntityBlock {
    public Pokestop() {
        super(Properties.of().noOcclusion().strength(-1.0f, -1.0f));
    }

    private DustColorTransitionOptions getParticle() {// Convert your 0.0-1.0 floats to Vector3f
        Vector3f fromColor = new Vector3f(0.0f, 0.75f, 1.0f);
        Vector3f toColor = new Vector3f(0.73f, 0.93f, 0.99f);
        float scale = 1.25f;

        // Create the particle options object
        return new DustColorTransitionOptions(fromColor, toColor, scale);
    }

    @Override
    public @NotNull InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hit) {
        if (level.isClientSide) return InteractionResult.SUCCESS;

        if (level.getBlockEntity(pos) instanceof PokestopEntity be) {
            if (be.canPlayerSpin(player)) {
                generatePokestopLoot(player);
                be.setPlayerCooldown(player, 300); // 5 minute cooldown
                level.sendBlockUpdated(pos, state, state, 3);
                be.triggerAnim("cooldown-spinner", "spin_trigger");
                be.triggerSpin();
                player.displayClientMessage(Component.translatable("message.cobblemon_pokestops.spin")
                        .withStyle(ChatFormatting.GREEN), true);
                ServerLevel serverLevel = (ServerLevel) level;
                serverLevel.sendParticles(
                        getParticle(), // The particle type
                        pos.getX() + 0.5, pos.getY() + 2.5, pos.getZ() + 0.5, // Center of the model
                        100,   // Number of particles
                        0.75, 0.75, 0.75, // Spread (randomness in position)
                        0.0   // Speed/Velocity
                );
                serverLevel.playSound(null, pos, SoundRegistry.POKESTOP_SPIN.get(), SoundSource.MASTER, 1.0f, 1.0f);
                return InteractionResult.SUCCESS;
            } else {
                player.displayClientMessage(Component.translatable("message.cobblemon_pokestops.cooldown", be.getPlayerCooldown(player))
                        .withStyle(ChatFormatting.RED), true);
                return InteractionResult.FAIL;
            }
        }
        return InteractionResult.PASS;
    }

    private boolean isRareEnough(ItemStack stack) {
        if (stack.getRarity() == Rarity.RARE) return true;
        if (stack.getRarity() == Rarity.EPIC) return true;
        Item item = stack.getItem();
        for (String entry : CobblemonPokestops.config.extraRarities) {
            ResourceLocation entryId = ResourceLocation.tryParse(entry);
            if (entryId != null) {
                Item itemToCompare = BuiltInRegistries.ITEM.get(entryId);
                if (item == Items.AIR && !entryId.equals(BuiltInRegistries.ITEM.getKey(Items.AIR))) {
                    Constants.LOGGER.warn("Config entry '{}' is not a valid item and will be ignored.", entry);
                } else if (item == itemToCompare) {
                    return true;
                }
            }
        }
        return false;
    }

    private void generatePokestopLoot(Player player) {
        ServerLevel serverLevel = (ServerLevel) player.level();
        ServerPlayer serverPlayer = (ServerPlayer) player;
        LootTable table = serverLevel.getServer().reloadableRegistries().getLootTable(ModLootTables.POKESTOP_LOOT);

        LootParams params = new LootParams.Builder(serverLevel)
                .withParameter(LootContextParams.ORIGIN, player.position())
                .withParameter(LootContextParams.THIS_ENTITY, player)
                .create(LootContextParamSets.CHEST);

        List<ItemStack> items = table.getRandomItems(params);

        for (ItemStack stack : items) {
            if (isRareEnough(stack)) {
                broadcastRareFind(serverPlayer, stack);
            }

            // Give item to player
            if (!player.getInventory().add(stack)) {
                player.drop(stack, false);
            }
        }
    }

    private void broadcastRareFind(ServerPlayer player, ItemStack stack) {
        Component message = Component.empty()
                .append(Component.literal("PokéStop").withStyle(ChatFormatting.BOLD, ChatFormatting.BLUE))
                .append(Component.literal(": "))
                .append(player.getName().copy().withStyle(ChatFormatting.GREEN))
                .append(Component.literal(" just found "))
                .append(stack.getDisplayName().copy().withStyle(stack.getRarity().color()))
                .append(Component.literal("!"));

        if (CobblemonPokestops.config.enableGlobalBroadcast) {
            player.server.getPlayerList().broadcastSystemMessage(message, false);
        } else {
            double radius = CobblemonPokestops.config.localBroadcastRadius;
            for (ServerPlayer nearbyPlayer : player.serverLevel().players()) {
                if (nearbyPlayer.distanceToSqr(player) < radius * radius) {
                    nearbyPlayer.sendSystemMessage(message);
                }
            }
        }
    }

    @SuppressWarnings("NullableProblems")
    @Override
    public @Nullable MapCodec<? extends DirectionalBlock> codec() {
        return null;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return BlockEntityRegistry.POKESTOP_BE.get().create(pos, state);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return defaultBlockState().setValue(FACING, context.getNearestLookingDirection().getOpposite());
    }

    @Override
    public void setPlacedBy(Level level, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {
        // Automatically place dummy blocks above
        level.setBlock(pos.above(), BlockRegistry.POKESTOP_DUMMY.get().defaultBlockState(), 3);
        level.setBlock(pos.above(2), BlockRegistry.POKESTOP_DUMMY.get().defaultBlockState(), 3);
    }

    @Override
    public void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean moved) {
        if (!state.is(newState.getBlock())) {
            // Remove dummies when base is broken
            level.removeBlock(pos.above(), false);
            level.removeBlock(pos.above(2), false);
            super.onRemove(state, level, pos, newState, moved);
        }
    }
    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
        if (level.isClientSide) return null;
        if (type == BlockEntityRegistry.POKESTOP_BE.get()) {
            return (lvl, pos, st, be) -> PokestopEntity.tick(lvl, (PokestopEntity) be);
        }
        return null;
    }

    @Override
    public @NotNull RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    @Override
    public @NotNull VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        VoxelShape shape = Shapes.empty();
        shape = Shapes.join(shape, Shapes.box(0.1875, 0, 0.1875, 0.8125, 0.0625, 0.8125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.3125, 0.0625, 0.3125, 0.6875, 0.6875, 0.6875), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.375, 0.6875, 0.375, 0.625, 2.0625, 0.625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.3125, 2.0625, 0.3125, 0.6875, 2.1875, 0.6875), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.25, 2.1875, 0.25, 0.75, 2.25, 0.75), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.1875, 2.25, 0.1875, 0.8125, 2.375, 0.8125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.125, 2.625, 0.125, 0.875, 3.375, 0.875), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.375, 2.625, 0.125, 0.625, 2.8125, 0.875), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.375, 2.8125, 0.125, 0.625, 2.9375, 0.25), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.375, 2.8125, 0.75, 0.625, 2.9375, 0.875), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.375, 3, 0.125, 0.625, 3.1875, 0.875), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.375, 3.1875, 0.125, 0.625, 3.3125, 0.25), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.375, 3.1875, 0.75, 0.625, 3.3125, 0.875), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.375, 2.875, 0.375, 0.625, 3.125, 0.625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.4375, 2.4375, 0.0625, 0.5625, 2.5625, 0.9375), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.4375, 3.4375, 0.0625, 0.5625, 3.5625, 0.9375), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.4375, 2.5625, 0.9375, 0.5625, 3.4375, 1.0625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.4375, 2.5625, -0.0625, 0.5625, 3.4375, 0.0625), BooleanOp.OR);
        return shape;
    }
}
