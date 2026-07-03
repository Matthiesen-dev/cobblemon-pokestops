package dev.matthiesen.common.cobblemon_pokestops.registry;

import dev.matthiesen.common.cobblemon_pokestops.Constants;
import dev.matthiesen.common.cobblemon_pokestops.item.SectionHeaderItem;
import dev.matthiesen.common.cobblemon_pokestops.item.stops.*;
import dev.matthiesen.common.cobblemon_pokestops.item.trophies.*;
import dev.matthiesen.common.cobblemon_pokestops.templates.item.StopItemTemplate;
import dev.matthiesen.common.matthiesen_lib.registry.AbstractItemRegistry;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;

public class ItemRegistry extends AbstractItemRegistry {
    private static final ItemRegistry INSTANCE = new ItemRegistry();

    private ItemRegistry() {
        super(Constants.MOD_ID);
    }

    public static void init() {}

    // Collections for Creative Menu
    public static Map<String, Supplier<? extends StopItemTemplate>> ALL_POKESTOPS = new HashMap<>();
    public static Map<String, Supplier<? extends StopItemTemplate>> ALL_TROPHIES = new HashMap<>();

    // Primary Item Collections
    public static Map<String, Supplier<? extends StopItemTemplate>> POKESTOP_ITEMS = new HashMap<>();
    public static Map<String, Supplier<? extends StopItemTemplate>> WINGEDSTOP_ITEMS = new HashMap<>();
    public static Map<String, Supplier<? extends StopItemTemplate>> POKEBALLSTOP_ITEMS = new HashMap<>();
    public static Map<String, Supplier<? extends StopItemTemplate>> HEALINGSTOP_ITEMS = new HashMap<>();

    public static Map<String, Supplier<? extends StopItemTemplate>> POKESTOP_TROPHY_ITEMS = new HashMap<>();
    public static Map<String, Supplier<? extends StopItemTemplate>> WINGEDSTOP_TROPHY_ITEMS = new HashMap<>();
    public static Map<String, Supplier<? extends StopItemTemplate>> POKEBALLSTOP_TROPHY_ITEMS = new HashMap<>();
    public static Map<String, Supplier<? extends StopItemTemplate>> HEALINGSTOP_TROPHY_ITEMS = new HashMap<>();

    public static Supplier<SectionHeaderItem> SECTION_HEADER =
            INSTANCE.register("section_header", () -> new SectionHeaderItem(new Item.Properties().stacksTo(1)));

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
                BlockRegistry.POKEBALLSTOPS,
                POKEBALLSTOP_ITEMS,
                ALL_POKESTOPS,
                block -> new PokeballstopItem(block, new Item.Properties())
        );
        registerStopItems(
                BlockRegistry.HEALINGSTOPS,
                HEALINGSTOP_ITEMS,
                ALL_POKESTOPS,
                block -> new HealingstopItem(block, new Item.Properties())
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
        registerStopItems(
                BlockRegistry.POKEBALLSTOP_TROPHIES,
                POKEBALLSTOP_TROPHY_ITEMS,
                ALL_TROPHIES,
                block -> new PokeballstopTrophyItem(block, new Item.Properties().rarity(Rarity.EPIC))
        );
        registerStopItems(
                BlockRegistry.HEALINGSTOP_TROPHIES,
                HEALINGSTOP_TROPHY_ITEMS,
                ALL_TROPHIES,
                block -> new HealingstopTrophyItem(block, new Item.Properties().rarity(Rarity.EPIC))
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

    private static <T extends Item> Supplier<T> registerItem(String id, Supplier<T> item) {
        return INSTANCE.register(id, item);
    }
}
