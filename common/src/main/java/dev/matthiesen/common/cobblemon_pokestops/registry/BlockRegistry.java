package dev.matthiesen.common.cobblemon_pokestops.registry;

import dev.matthiesen.common.cobblemon_pokestops.CobblemonPokestops;
import dev.matthiesen.common.cobblemon_pokestops.block.Pokestop;
import net.minecraft.world.level.block.Block;

import java.util.function.Supplier;

public class BlockRegistry {
    public static void init() {}

    public static final Supplier<Pokestop> POKESTOP = registerBlock("pokestop", Pokestop::new);

    private static <T extends Block> Supplier<T> registerBlock(String id, Supplier<T> block) {
        return CobblemonPokestops.COMMON_PLATFORM.registerBlock(id, block);
    }
}
