package dev.matthiesen.common.cobblemon_pokestops.registry;

import dev.matthiesen.common.cobblemon_pokestops.CobblemonPokestops;
import dev.matthiesen.common.cobblemon_pokestops.block.Pokestop;
import dev.matthiesen.common.cobblemon_pokestops.block.PokestopDummyBlock;
import net.minecraft.world.level.block.Block;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class BlockRegistry {
    public static void init() {}

    public static String[] COLOR_VARIANTS = {"gold"};

    public static Map<String, Supplier<Pokestop>> POKESTOPS = new HashMap<>();

    static {
        POKESTOPS.put("pokestop", registerBlock("pokestop", Pokestop::new));

        for (String variant : COLOR_VARIANTS) {
            String name = "pokestop_" + variant;
            Supplier<Pokestop> blockSupplier = registerBlock(name, Pokestop::new);
            POKESTOPS.put(name, blockSupplier);
        }
    }

    // Utility block
    public static final Supplier<PokestopDummyBlock> POKESTOP_DUMMY = registerBlock("pokestop_dummy", PokestopDummyBlock::new);

    // Registration
    private static <T extends Block> Supplier<T> registerBlock(String id, Supplier<T> block) {
        return CobblemonPokestops.COMMON_PLATFORM.registerBlock(id, block);
    }
}
