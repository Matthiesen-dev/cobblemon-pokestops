package dev.matthiesen.cobblemon_pokestops.neoforge;

import dev.matthiesen.cobblemon_pokestops.common.CobblemonPokestopsCommon;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(CobblemonPokestopsCommon.MOD_ID)
public class CobblemonPokestopsNeoForge {
    public CobblemonPokestopsNeoForge(IEventBus modBus) {
        var instance = CobblemonPokestopsCommon.INSTANCE;
        instance.createInfoLog("Loading for NeoForge Mod Loader");
        instance.initialize();
    }
}
