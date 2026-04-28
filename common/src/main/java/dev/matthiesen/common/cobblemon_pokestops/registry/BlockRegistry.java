package dev.matthiesen.common.cobblemon_pokestops.registry;

import dev.matthiesen.common.cobblemon_pokestops.CobblemonPokestops;
import dev.matthiesen.common.cobblemon_pokestops.block.Pokestop;
import dev.matthiesen.common.cobblemon_pokestops.block.PokestopDummyBlock;
import dev.matthiesen.common.cobblemon_pokestops.block.Wingedstop;
import dev.matthiesen.common.cobblemon_pokestops.block.WingedstopDummyBlock;
import net.minecraft.world.level.block.Block;

import java.util.*;
import java.util.function.Supplier;

public class BlockRegistry {
    public static void init() {}

    public static final String[] POKESTOP_VARIANTS = {"gold", "black", "green"};
    public static final String[] WINGEDSTOP_VARIANTS = {"gold"};

    public static final Map<String, Supplier<Pokestop>> POKESTOPS = new HashMap<>();
    public static final Map<String, Supplier<Wingedstop>> WINGEDSTOPS = new HashMap<>();

    static {
        registerFamilyWithVariants(POKESTOPS, "pokestop", POKESTOP_VARIANTS, Pokestop::new);
        registerFamilyWithVariants(WINGEDSTOPS, "wingedstop", WINGEDSTOP_VARIANTS, Wingedstop::new);
    }

    private static <T extends Block> void registerFamilyWithVariants(
            Map<String, Supplier<T>> target,
            String baseId,
            String[] variants,
            Supplier<T> factory
    ) {
        target.put(baseId, registerBlock(baseId, factory));
        Arrays.stream(variants)
                .map(variant -> baseId + "_" + variant)
                .forEach(id -> target.put(id, registerBlock(id, factory)));
    }

    // Utility block
    public static final Supplier<PokestopDummyBlock> POKESTOP_DUMMY = registerBlock("pokestop_dummy", PokestopDummyBlock::new);
    public static final Supplier<WingedstopDummyBlock> WINGEDSTOP_DUMMY = registerBlock("wingedstop_dummy", WingedstopDummyBlock::new);

    // Registration
    private static <T extends Block> Supplier<T> registerBlock(String id, Supplier<T> block) {
        return CobblemonPokestops.COMMON_PLATFORM.registerBlock(id, block);
    }

    public static Collection<Supplier<? extends Block>> getAllTemplates() {
        List<Supplier<? extends Block>> templates = new ArrayList<>();
        POKESTOPS.forEach((id, block) -> templates.add(block));
        WINGEDSTOPS.forEach((id, block) -> templates.add(block));
        templates.add(POKESTOP_DUMMY);
        templates.add(WINGEDSTOP_DUMMY);
        return templates;
    }
}
