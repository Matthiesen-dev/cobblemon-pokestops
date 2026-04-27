package dev.matthiesen.common.cobblemon_pokestops.registry;

import dev.matthiesen.common.cobblemon_pokestops.CobblemonPokestops;
import dev.matthiesen.common.cobblemon_pokestops.Constants;
import dev.matthiesen.common.cobblemon_pokestops.block.Pokestop;
import dev.matthiesen.common.cobblemon_pokestops.item.PokestopItem;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class ItemRegistry {
    public static void init() {}

    public static Map<String, Supplier<BlockItem>> POKESTOP_ITEMS = new HashMap<>();

    static {
        for (var entry : BlockRegistry.POKESTOPS.entrySet()) {
            String name = entry.getKey();
            Supplier<Pokestop> blockSupplier = entry.getValue();
            Supplier<BlockItem> itemSupplier = registerItem(name, () -> new PokestopItem(blockSupplier.get(), new Item.Properties()));
            POKESTOP_ITEMS.put(name, itemSupplier);
        }
    }

    private static <T extends Item> Supplier<T> registerItem(String id, Supplier<T> item) {
        return CobblemonPokestops.COMMON_PLATFORM.registerItem(id, item);
    }

    @SuppressWarnings("unused")
    public static final Supplier<CreativeModeTab> POKESTOPS_TAB = CobblemonPokestops.COMMON_PLATFORM
            .registerCreativeModeTab("cobblemon_pokestops_items", () -> CobblemonPokestops.COMMON_PLATFORM
                    .newCreativeTabBuilder()
                    .title(Component.translatable("itemGroup." + Constants.MOD_ID + ".cobblemon_pokestops_items"))
                    .icon(() -> new ItemStack(ItemRegistry.POKESTOP_ITEMS.get("pokestop").get()))
                    .displayItems((enabledFeatures, entries) -> {
                        for (var entry : ItemRegistry.POKESTOP_ITEMS.entrySet()) {
                            entries.accept(entry.getValue().get());
                        }
                    })
                    .build()
            );
}
