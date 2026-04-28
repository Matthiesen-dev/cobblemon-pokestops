package dev.matthiesen.fabric.cobblemon_pokestops.datagen;

import com.cobblemon.mod.common.CobblemonItems;
import dev.matthiesen.common.cobblemon_pokestops.registry.ModLootTables;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.SimpleFabricLootTableProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;

import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;

public class ModLootTableProvider extends SimpleFabricLootTableProvider {
    public static final ResourceKey<LootTable> POKESTOP_LOOT = ModLootTables.POKESTOP_LOOT;
    public static final ResourceKey<LootTable> WINGEDSTOP_LOOT = ModLootTables.WINGEDSTOP_LOOT;

    public ModLootTableProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(output, registryLookup, LootContextParamSets.CHEST);
    }

    public LootPoolEntryContainer.Builder<?> createLootItem (ItemLike item, int weight, float count) {
        return LootItem.lootTableItem(item)
                .setWeight(weight)
                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(count)));
    }

    @Override
    public void generate(BiConsumer<ResourceKey<LootTable>, LootTable.Builder> biConsumer) {
        biConsumer.accept(
                POKESTOP_LOOT,
                LootTable.lootTable().withPool(
                        LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1f))
                                .setBonusRolls(ConstantValue.exactly(0.6f))
                                .add(createLootItem(Items.IRON_INGOT, 50, 1.0f))
                                .add(createLootItem(Items.COAL, 50, 1.0f))
                                .add(createLootItem(Items.GOLD_INGOT, 30, 1.0f))
                                .add(createLootItem(Items.LAPIS_LAZULI, 30, 1.0f))
                                .add(createLootItem(Items.DIAMOND, 15, 1.0f))
                                .add(createLootItem(CobblemonItems.POKE_BALL, 50, 1.0f))
                                .add(createLootItem(CobblemonItems.POTION, 50, 1.0f))
                                .add(createLootItem(CobblemonItems.ANTIDOTE, 50, 1.0f))
                                .add(createLootItem(CobblemonItems.RELIC_COIN, 50, 1.0f))
                                .add(createLootItem(CobblemonItems.SUPER_POTION, 30, 1.0f))
                                .add(createLootItem(CobblemonItems.REVIVE, 30, 1.0f))
                                .add(createLootItem(CobblemonItems.ULTRA_BALL, 15, 1.0f))
                                .add(createLootItem(CobblemonItems.HYPER_POTION, 15, 1.0f))
                                .add(createLootItem(CobblemonItems.RARE_CANDY, 15, 1.0f))
                                .add(createLootItem(CobblemonItems.MASTER_BALL, 5, 1.0f))
                                .add(createLootItem(CobblemonItems.MAX_REVIVE, 5, 1.0f))
                                .add(createLootItem(CobblemonItems.ABILITY_CAPSULE, 5, 1.0f))
                )
        );

        // TODO: Change loot table for wingedstop to be different from pokestop, maybe add some exclusive items?
        biConsumer.accept(
                WINGEDSTOP_LOOT,
                LootTable.lootTable().withPool(
                        LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1f))
                                .setBonusRolls(ConstantValue.exactly(0.6f))
                                .add(createLootItem(Items.IRON_INGOT, 50, 1.0f))
                                .add(createLootItem(Items.COAL, 50, 1.0f))
                                .add(createLootItem(Items.GOLD_INGOT, 30, 1.0f))
                                .add(createLootItem(Items.LAPIS_LAZULI, 30, 1.0f))
                                .add(createLootItem(Items.DIAMOND, 15, 1.0f))
                                .add(createLootItem(CobblemonItems.POKE_BALL, 50, 1.0f))
                                .add(createLootItem(CobblemonItems.POTION, 50, 1.0f))
                                .add(createLootItem(CobblemonItems.ANTIDOTE, 50, 1.0f))
                                .add(createLootItem(CobblemonItems.RELIC_COIN, 50, 1.0f))
                                .add(createLootItem(CobblemonItems.SUPER_POTION, 30, 1.0f))
                                .add(createLootItem(CobblemonItems.REVIVE, 30, 1.0f))
                                .add(createLootItem(CobblemonItems.ULTRA_BALL, 15, 1.0f))
                                .add(createLootItem(CobblemonItems.HYPER_POTION, 15, 1.0f))
                                .add(createLootItem(CobblemonItems.RARE_CANDY, 15, 1.0f))
                                .add(createLootItem(CobblemonItems.MASTER_BALL, 5, 1.0f))
                                .add(createLootItem(CobblemonItems.MAX_REVIVE, 5, 1.0f))
                                .add(createLootItem(CobblemonItems.ABILITY_CAPSULE, 5, 1.0f))
                )
        );
    }
}
