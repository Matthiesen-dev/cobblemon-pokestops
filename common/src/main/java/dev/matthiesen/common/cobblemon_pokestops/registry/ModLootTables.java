package dev.matthiesen.common.cobblemon_pokestops.registry;

import com.cobblemon.mod.common.CobblemonItems;
import dev.matthiesen.common.cobblemon_pokestops.Constants;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;

import java.util.HashMap;
import java.util.Map;

public class ModLootTables {
    public static final ResourceKey<LootTable> POKESTOP_LOOT = ResourceKey.create(
            Registries.LOOT_TABLE,
            Constants.modResource("gameplay/pokestop_loot")
    );

    public static final ResourceKey<LootTable> POKESTOP_TROPHY_LOOT = ResourceKey.create(
            Registries.LOOT_TABLE,
            Constants.modResource("gameplay/pokestop_trophy")
    );

    public static final ResourceKey<LootTable> WINGEDSTOP_LOOT = ResourceKey.create(
            Registries.LOOT_TABLE,
            Constants.modResource("gameplay/wingedstop_loot")
    );

    public static final ResourceKey<LootTable> WINGED_TROPHY_LOOT = ResourceKey.create(
            Registries.LOOT_TABLE,
            Constants.modResource("gameplay/wingedstop_trophy")
    );

    public static final LootTable.Builder POKESTOP_LOOT_POOL =
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
            );

    // TODO: Change loot table for wingedstop to be different from pokestop, maybe add some exclusive items?
    public static final LootTable.Builder WINGEDSTOP_LOOT_POOL =
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
            );

    public static final LootTable.Builder POKESTOP_TROPHY_LOOT_POOL =
            LootTable.lootTable().withPool(
                    LootPool.lootPool()
                            .setRolls(ConstantValue.exactly(1f))
                            .add(createLootItem(ItemRegistry.POKESTOP_TROPHY_ITEMS.get("pokestop_trophy").get(), 100, 1.0f))
            );

    public static final LootTable.Builder WINGEDSTOP_TROPHY_LOOT_POOL =
            LootTable.lootTable().withPool(
                    LootPool.lootPool()
                            .setRolls(ConstantValue.exactly(1f))
                            .add(createLootItem(ItemRegistry.WINGEDSTOP_TROPHY_ITEMS.get("wingedstop_trophy").get(), 100, 1.0f))
            );

    // --- Datagen ---

    public static Map<ResourceKey<LootTable>, LootTable.Builder> LOOT_TABLES = new HashMap<>();

    static {
        LOOT_TABLES.put(POKESTOP_LOOT, POKESTOP_LOOT_POOL);
        LOOT_TABLES.put(WINGEDSTOP_LOOT, WINGEDSTOP_LOOT_POOL);
        LOOT_TABLES.put(POKESTOP_TROPHY_LOOT, POKESTOP_TROPHY_LOOT_POOL);
        LOOT_TABLES.put(WINGED_TROPHY_LOOT, WINGEDSTOP_TROPHY_LOOT_POOL);
    }

    @SuppressWarnings("SameParameterValue")
    private static LootPoolEntryContainer.Builder<?> createLootItem (ItemLike item, int weight, float count) {
        return LootItem.lootTableItem(item)
                .setWeight(weight)
                .apply(SetItemCountFunction.setCount(ConstantValue.exactly(count)));
    }
}
