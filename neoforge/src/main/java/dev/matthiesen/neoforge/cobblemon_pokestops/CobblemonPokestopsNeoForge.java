package dev.matthiesen.neoforge.cobblemon_pokestops;

import dev.matthiesen.common.cobblemon_pokestops.CobblemonPokestops;
import dev.matthiesen.common.cobblemon_pokestops.Constants;
import dev.matthiesen.neoforge.cobblemon_pokestops.worldgen.CobblemonPokestopsNeoForgeFeatures;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(Constants.MOD_ID)
public class CobblemonPokestopsNeoForge {
    public CobblemonPokestopsNeoForge(IEventBus modBus) {
        Constants.createInfoLog("Loading for NeoForge Mod Loader");
        CobblemonPokestops.initialize();
        CobblemonPokestopsNeoForgeFeatures.init(modBus);
    }
}
