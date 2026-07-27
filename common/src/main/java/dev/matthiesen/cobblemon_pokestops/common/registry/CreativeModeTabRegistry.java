package dev.matthiesen.cobblemon_pokestops.common.registry;

import dev.matthiesen.cobblemon_pokestops.common.CobblemonPokestopsCommon;
import dev.matthiesen.matthiesen_core.common.registry.AbstractCreativeModeTabRegistry;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;

import java.util.function.Supplier;

public class CreativeModeTabRegistry extends AbstractCreativeModeTabRegistry {
    private static final CreativeModeTabRegistry INSTANCE = new CreativeModeTabRegistry();

    private static final ResourceLocation POKESTOPS_TAB_ID = CobblemonPokestopsCommon.modResource("cobblemon_pokestops_tab");
    private static final ResourceLocation POKESTOPS_POKESTOPS_SECTION_ID = CobblemonPokestopsCommon.modResource("pokestops");
    private static final ResourceLocation POKESTOPS_TROPHIES_SECTION_ID = CobblemonPokestopsCommon.modResource("trophies");

    private CreativeModeTabRegistry() {
        super(CobblemonPokestopsCommon.MOD_ID);
    }

    public static void init() {}

    public static final Supplier<CreativeModeTab> POKESTOPS_TAB;

    static {
        POKESTOPS_TAB = INSTANCE.registerSectionedCreativeTab(
                POKESTOPS_TAB_ID,
                Component.translatable("itemGroup.cobblemon_pokestops.cobblemon_pokestops_tab_title"),
                ItemRegistry.getPokestopsCreativeTabIcon(),
                builder -> {
                    builder.registerSection(POKESTOPS_POKESTOPS_SECTION_ID, Component.translatable("itemGroup.cobblemon_pokestops.cobblemon_pokestops_tab_pokestops_section"), 100);
                    builder.registerSection(POKESTOPS_TROPHIES_SECTION_ID, Component.translatable("itemGroup.cobblemon_pokestops.cobblemon_pokestops_tab_trophies_section"), 50,
                            sectionBuilder -> sectionBuilder.setSectionTitleColor(0x55FFFF)
                    );
                    ItemRegistry.addPokestopsToCreativeMenu(builder, POKESTOPS_POKESTOPS_SECTION_ID);
                    ItemRegistry.addTrophiesToCreativeMenu(builder, POKESTOPS_TROPHIES_SECTION_ID);
                }
        );
    }
}
