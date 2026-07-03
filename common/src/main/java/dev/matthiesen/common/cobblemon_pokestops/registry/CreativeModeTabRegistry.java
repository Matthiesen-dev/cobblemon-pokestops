package dev.matthiesen.common.cobblemon_pokestops.registry;

import dev.matthiesen.common.cobblemon_pokestops.Constants;
import dev.matthiesen.common.matthiesen_lib.registry.AbstractCreativeModeTabRegistry;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

import java.util.function.Supplier;

public class CreativeModeTabRegistry extends AbstractCreativeModeTabRegistry {
    private static final CreativeModeTabRegistry INSTANCE = new CreativeModeTabRegistry();

    private CreativeModeTabRegistry() {
        super(Constants.MOD_ID);
    }

    public static void init() {}

    public static final Supplier<CreativeModeTab> POKESTOPS_TAB;

    static {
        POKESTOPS_TAB = INSTANCE.register("cobblemon_pokestops_pokestops", () -> INSTANCE.getRegistryBuilder()
                .newCreativeTabBuilder()
                .title(Component.translatable("itemGroup." + Constants.MOD_ID + ".cobblemon_pokestops_pokestops"))
                .icon(() -> new ItemStack(ItemRegistry.ALL_POKESTOPS.get("pokestop").get()))
                .displayItems((parameters, output) ->
                        // Add items to make the tab visible; the full sectioned layout is injected by the mixin in selectTab
                        CreativeSectionRegistry.SECTIONS.values()
                                .forEach(items -> items.forEach(output::accept))
                )
                .build()
        );
    }

    public static void buildSections() {
        ResourceLocation pokestopsSectionId = new ResourceLocation(Constants.MOD_ID, "pokestops");
        ResourceLocation trophiesSectionId = new ResourceLocation(Constants.MOD_ID, "trophies");

        CreativeSectionRegistry.registerSection(
                pokestopsSectionId,
                Component.translatable("itemGroup.cobblemon_pokestops.cobblemon_pokestops_pokestops"),
                100
        );

        CreativeSectionRegistry.registerSection(
                trophiesSectionId,
                Component.translatable("itemGroup.cobblemon_pokestops.cobblemon_pokestops_trophies"),
                50,
                builder -> builder.setSectionTitleColor(0x55FFFF)
        );

        for (var entry : ItemRegistry.ALL_POKESTOPS.entrySet()) {
            CreativeSectionRegistry.addItemToSection(pokestopsSectionId, new ItemStack(entry.getValue().get()));
        }

        for (var entry : ItemRegistry.ALL_TROPHIES.entrySet()) {
            CreativeSectionRegistry.addItemToSection(trophiesSectionId, new ItemStack(entry.getValue().get()));
        }
    }
}
