package dev.matthiesen.common.cobblemon_pokestops.templates.block;

import dev.matthiesen.common.cobblemon_pokestops.CobblemonPokestops;
import dev.matthiesen.common.cobblemon_pokestops.Constants;
import net.minecraft.ChatFormatting;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public abstract class LootStopTemplate extends BaseStopTemplate {
    public LootStopTemplate() {
        super();
    }

    /**
     * Subclasses must provide the loot table resource key.
     */
    @NotNull
    protected abstract ResourceKey<net.minecraft.world.level.storage.loot.LootTable> getLootTableKey();

    /**
     * Subclasses must provide the broadcast prefix (e.g., "PokéStop" or "WingedStop").
     */
    protected abstract String getBroadcastPrefix();

    private boolean isRareEnough(ItemStack stack) {
        if (stack.getRarity() == Rarity.RARE || stack.getRarity() == Rarity.EPIC) {
            return true;
        }
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

    private void generateLoot(ServerPlayer player) {
        ServerLevel serverLevel = player.serverLevel();
        net.minecraft.world.level.storage.loot.LootTable table = serverLevel.getServer().reloadableRegistries().getLootTable(getLootTableKey());

        LootParams params = new LootParams.Builder(serverLevel)
                .withParameter(LootContextParams.ORIGIN, player.position())
                .withParameter(LootContextParams.THIS_ENTITY, player)
                .create(LootContextParamSets.CHEST);

        List<ItemStack> items = table.getRandomItems(params);

        for (ItemStack stack : items) {
            if (isRareEnough(stack)) {
                broadcastRareFind(player, stack);
            }
            if (!player.getInventory().add(stack)) {
                player.drop(stack, false);
            }
        }
    }

    private void broadcastRareFind(ServerPlayer player, ItemStack stack) {
        Component message = Component.empty()
                .append(Component.literal(getBroadcastPrefix()).withStyle(ChatFormatting.BOLD, ChatFormatting.BLUE))
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

    @Override
    protected void grantReward(ServerPlayer player) {
        generateLoot(player);
    }
}
