package dev.matthiesen.common.cobblemon_pokestops.registry;

import dev.matthiesen.common.cobblemon_pokestops.Constants;
import dev.matthiesen.common.cobblemon_pokestops.templates.item.StopItemTemplate;
import dev.matthiesen.common.matthiesen_lib.registry.AbstractCreativeModeTabRegistry;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class CreativeModeTabRegistry extends AbstractCreativeModeTabRegistry {
    private static final CreativeModeTabRegistry INSTANCE = new CreativeModeTabRegistry();

    private CreativeModeTabRegistry() {
        super(Constants.MOD_ID);
    }

    public static void init() {}

    public static final Supplier<CreativeModeTab> POKESTOPS_TAB;
    public static final Supplier<CreativeModeTab> POKESTOPS_TROPHIES_TAB;

    static {
        POKESTOPS_TAB = INSTANCE.register("cobblemon_pokestops_pokestops", () -> INSTANCE.getRegistryBuilder()
                .newCreativeTabBuilder()
                .title(Component.translatable("itemGroup." + Constants.MOD_ID + ".cobblemon_pokestops_pokestops"))
                .icon(() -> new ItemStack(ItemRegistry.ALL_POKESTOPS.get("pokestop").get()))
                .displayItems((enabledFeatures, entries) ->
                        addAllItemsToCreativeTab(entries, List.of(ItemRegistry.ALL_POKESTOPS))
                )
                .build()
        );
        POKESTOPS_TROPHIES_TAB = INSTANCE.register("cobblemon_pokestops_trophies", () -> INSTANCE.getRegistryBuilder()
                .newCreativeTabBuilder()
                .title(Component.translatable("itemGroup." + Constants.MOD_ID + ".cobblemon_pokestops_trophies"))
                .icon(() -> new ItemStack(ItemRegistry.ALL_TROPHIES.get("wingedstop_trophy").get()))
                .displayItems((enabledFeatures, entries) ->
                        addAllItemsToCreativeTab(entries, List.of(ItemRegistry.ALL_TROPHIES))
                )
                .build()
        );
    }

    private static void addAllItemsToCreativeTab(CreativeModeTab.Output entries, List<Map<String, Supplier<? extends StopItemTemplate>>> itemMaps) {
        for (Map<String, Supplier<? extends StopItemTemplate>> itemMap : itemMaps) {
            for (var entry : itemMap.entrySet()) {
                entries.accept(entry.getValue().get());
            }
        }
    }
}
