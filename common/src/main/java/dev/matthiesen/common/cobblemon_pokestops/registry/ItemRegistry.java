package dev.matthiesen.common.cobblemon_pokestops.registry;

import dev.matthiesen.common.cobblemon_pokestops.CobblemonPokestops;
import dev.matthiesen.common.cobblemon_pokestops.Constants;
import dev.matthiesen.common.cobblemon_pokestops.item.PokestopItem;
import dev.matthiesen.common.cobblemon_pokestops.item.PokestopTrophyItem;
import dev.matthiesen.common.cobblemon_pokestops.item.WingedstopItem;
import dev.matthiesen.common.cobblemon_pokestops.item.WingedstopTrophyItem;
import dev.matthiesen.common.cobblemon_pokestops.templates.item.StopItemTemplate;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;

public class ItemRegistry {
    public static void init() {}

    // Collections for Creative Menu
    public static Map<String, Supplier<? extends StopItemTemplate>> ALL_POKESTOPS = new HashMap<>();
    public static Map<String, Supplier<? extends StopItemTemplate>> ALL_TROPHIES = new HashMap<>();

    // Primary Item Collections
    public static Map<String, Supplier<? extends StopItemTemplate>> POKESTOP_ITEMS = new HashMap<>();
    public static Map<String, Supplier<? extends StopItemTemplate>> WINGEDSTOP_ITEMS = new HashMap<>();
    public static Map<String, Supplier<? extends StopItemTemplate>> POKESTOP_TROPHY_ITEMS = new HashMap<>();
    public static Map<String, Supplier<? extends StopItemTemplate>> WINGEDSTOP_TROPHY_ITEMS = new HashMap<>();

    static {
        registerStopItems(
                BlockRegistry.POKESTOPS,
                POKESTOP_ITEMS,
                ALL_POKESTOPS,
                block -> new PokestopItem(block, new Item.Properties())
        );
        registerStopItems(
                BlockRegistry.WINGEDSTOPS,
                WINGEDSTOP_ITEMS,
                ALL_POKESTOPS,
                block -> new WingedstopItem(block, new Item.Properties())
        );
        registerStopItems(
                BlockRegistry.WINGEDSTOP_TROPHIES,
                WINGEDSTOP_TROPHY_ITEMS,
                ALL_TROPHIES,
                block -> new WingedstopTrophyItem(block, new Item.Properties().rarity(Rarity.EPIC))
        );
        registerStopItems(
                BlockRegistry.POKESTOP_TROPHIES,
                POKESTOP_TROPHY_ITEMS,
                ALL_TROPHIES,
                block -> new PokestopTrophyItem(block, new Item.Properties().rarity(Rarity.EPIC))
        );
    }

    private static <B extends Block> void registerStopItems(
            Map<String, Supplier<B>> blocks,
            Map<String, Supplier<? extends StopItemTemplate>> targetItems,
            Map<String, Supplier<? extends StopItemTemplate>> targetCollection,
            Function<B, ? extends StopItemTemplate> itemFactory
    ) {
        for (var entry : blocks.entrySet()) {
            String name = entry.getKey();
            Supplier<B> blockSupplier = entry.getValue();
            Supplier<StopItemTemplate> itemSupplier = registerItem(name, () -> itemFactory.apply(blockSupplier.get()));
            targetItems.put(name, itemSupplier);
            targetCollection.put(name, itemSupplier);
        }
    }

    private static void addAllItemsToCreativeTab(CreativeModeTab.Output entries, List<Map<String, Supplier<? extends StopItemTemplate>>> itemMaps) {
        for (Map<String, Supplier<? extends StopItemTemplate>> itemMap : itemMaps) {
            for (var entry : itemMap.entrySet()) {
                entries.accept(entry.getValue().get());
            }
        }
    }

    private static <T extends Item> Supplier<T> registerItem(String id, Supplier<T> item) {
        return CobblemonPokestops.COMMON_PLATFORM.registerItem(id, item);
    }

    @SuppressWarnings("unused")
    public static final Supplier<CreativeModeTab> POKESTOPS_TAB = CobblemonPokestops.COMMON_PLATFORM
            .registerCreativeModeTab("cobblemon_pokestops_pokestops", () -> CobblemonPokestops.COMMON_PLATFORM
                    .newCreativeTabBuilder()
                    .title(Component.translatable("itemGroup." + Constants.MOD_ID + ".cobblemon_pokestops_pokestops"))
                    .icon(() -> new ItemStack(ItemRegistry.ALL_POKESTOPS.get("pokestop").get()))
                    .displayItems((enabledFeatures, entries) ->
                            addAllItemsToCreativeTab(entries, List.of(ItemRegistry.ALL_POKESTOPS))
                    )
                    .build()
            );

    @SuppressWarnings("unused")
    public static final Supplier<CreativeModeTab> POKESTOPS_TROPHIES_TAB = CobblemonPokestops.COMMON_PLATFORM
            .registerCreativeModeTab("cobblemon_pokestops_trophies", () -> CobblemonPokestops.COMMON_PLATFORM
                    .newCreativeTabBuilder()
                    .title(Component.translatable("itemGroup." + Constants.MOD_ID + ".cobblemon_pokestops_trophies"))
                    .icon(() -> new ItemStack(ItemRegistry.ALL_TROPHIES.get("wingedstop_trophy").get()))
                    .displayItems((enabledFeatures, entries) ->
                            addAllItemsToCreativeTab(entries, List.of(ItemRegistry.ALL_TROPHIES))
                    )
                    .build()
            );
}
