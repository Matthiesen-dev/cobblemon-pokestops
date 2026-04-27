package dev.matthiesen.common.cobblemon_pokestops.registry;

import dev.matthiesen.common.cobblemon_pokestops.CobblemonPokestops;
import dev.matthiesen.common.cobblemon_pokestops.Constants;
import dev.matthiesen.common.cobblemon_pokestops.item.PokestopItem;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.function.Supplier;

public class ItemRegistry {
    public static void init() {}

    public static final Supplier<BlockItem> POKESTOP =
            registerItem("pokestop", () -> new PokestopItem(BlockRegistry.POKESTOP.get(), new Item.Properties()));

    private static <T extends Item> Supplier<T> registerItem(String id, Supplier<T> item) {
        return CobblemonPokestops.COMMON_PLATFORM.registerItem(id, item);
    }

    public static final Supplier<CreativeModeTab> POKESTOPS_TAB = CobblemonPokestops.COMMON_PLATFORM.registerCreativeModeTab("cobblemon_pokestops_items", () -> CobblemonPokestops.COMMON_PLATFORM.newCreativeTabBuilder()
            .title(Component.translatable("itemGroup." + Constants.MOD_ID + ".cobblemon_pokestops_items"))
            .icon(() -> new ItemStack(ItemRegistry.POKESTOP.get()))
            .displayItems((enabledFeatures, entries) -> {
                entries.accept(ItemRegistry.POKESTOP.get());
            })
            .build());
}
