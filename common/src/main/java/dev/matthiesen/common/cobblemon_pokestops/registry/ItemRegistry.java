package dev.matthiesen.common.cobblemon_pokestops.registry;

import dev.matthiesen.common.cobblemon_pokestops.CobblemonPokestops;
import dev.matthiesen.common.cobblemon_pokestops.Constants;
import dev.matthiesen.common.cobblemon_pokestops.item.PokestopItem;
import dev.matthiesen.common.cobblemon_pokestops.item.PokestopTrophyItem;
import dev.matthiesen.common.cobblemon_pokestops.item.WingedstopItem;
import dev.matthiesen.common.cobblemon_pokestops.item.WingedstopTrophyItem;
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
    public static Map<String, Supplier<BlockItem>> ALL_POKESTOPS = new HashMap<>();
    public static Map<String, Supplier<BlockItem>> ALL_TROPHIES = new HashMap<>();

    static {
        registerStopItems(
                BlockRegistry.POKESTOPS,
                ALL_POKESTOPS,
                block -> new PokestopItem(block, new Item.Properties())
        );
        registerStopItems(
                BlockRegistry.WINGEDSTOPS,
                ALL_POKESTOPS,
                block -> new WingedstopItem(block, new Item.Properties())
        );
        registerStopItems(
                BlockRegistry.WINGEDSTOP_TROPHIES,
                ALL_TROPHIES,
                block -> new WingedstopTrophyItem(block, new Item.Properties().rarity(Rarity.EPIC))
        );
        registerStopItems(
                BlockRegistry.POKESTOP_TROPHIES,
                ALL_TROPHIES,
                block -> new PokestopTrophyItem(block, new Item.Properties().rarity(Rarity.EPIC))
        );
    }

    private static <B extends Block> void registerStopItems(
            Map<String, Supplier<B>> blocks,
            Map<String, Supplier<BlockItem>> targetCollection,
            Function<B, BlockItem> itemFactory
    ) {
        for (var entry : blocks.entrySet()) {
            String name = entry.getKey();
            Supplier<B> blockSupplier = entry.getValue();
            Supplier<BlockItem> itemSupplier = registerItem(name, () -> itemFactory.apply(blockSupplier.get()));
            targetCollection.put(name, itemSupplier);
        }
    }

    private static void addAllItemsToCreativeTab(CreativeModeTab.Output entries, List<Map<String, Supplier<BlockItem>>> itemMaps) {
        for (Map<String, Supplier<BlockItem>> itemMap : itemMaps) {
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
