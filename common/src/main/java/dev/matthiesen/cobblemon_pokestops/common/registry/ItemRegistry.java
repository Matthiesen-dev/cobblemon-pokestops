package dev.matthiesen.cobblemon_pokestops.common.registry;

import dev.matthiesen.cobblemon_pokestops.common.CobblemonPokestopsCommon;
import dev.matthiesen.cobblemon_pokestops.common.item.StopRemover;
import dev.matthiesen.cobblemon_pokestops.common.item.stops.*;
import dev.matthiesen.cobblemon_pokestops.common.item.trophies.*;
import dev.matthiesen.cobblemon_pokestops.common.templates.item.StopItemTemplate;
import dev.matthiesen.common.matthiesen_lib.core.MatthiesenLibCreativeModeTabSectionsManager;
import dev.matthiesen.common.matthiesen_lib.registry.AbstractItemRegistry;
import net.minecraft.data.models.model.ModelTemplate;
import net.minecraft.data.models.model.ModelTemplates;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.block.Block;

import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;

public class ItemRegistry extends AbstractItemRegistry {
    private static final ItemRegistry INSTANCE = new ItemRegistry();

    private ItemRegistry() {
        super(CobblemonPokestopsCommon.MOD_ID);
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

    public static final Supplier<Item> STOP_REMOVER = registerItem("stop_remover", StopRemover::new);

    public static Supplier<ItemStack> getPokestopsCreativeTabIcon() {
        return () -> new ItemStack(POKESTOP_ITEMS.get("pokestop").get());
    }

    public static void addPokestopsToCreativeMenu(MatthiesenLibCreativeModeTabSectionsManager.SectionBuilder builder, ResourceLocation resourceLocation) {
        for (var entry : ALL_POKESTOPS.entrySet()) {
            builder.addItemToSection(resourceLocation, new ItemStack(entry.getValue().get()));
        }
        builder.addItemToSection(resourceLocation, new ItemStack(STOP_REMOVER.get()));
    }

    public static void addTrophiesToCreativeMenu(MatthiesenLibCreativeModeTabSectionsManager.SectionBuilder builder, ResourceLocation resourceLocation) {
        for (var entry : ALL_TROPHIES.entrySet()) {
            builder.addItemToSection(resourceLocation, new ItemStack(entry.getValue().get()));
        }
    }

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

    // --- Datagen ---

    public static Collection<DataTemplate> getAllTemplates() {
        List<DataTemplate> templates = new ArrayList<>();

        templates.add(new DataTemplate(STOP_REMOVER, ModelTemplates.FLAT_ITEM));

        return templates;
    }

    public record DataTemplate(Supplier<? extends Item> itemSupplier, ModelTemplate modelTemplate) {}
}
