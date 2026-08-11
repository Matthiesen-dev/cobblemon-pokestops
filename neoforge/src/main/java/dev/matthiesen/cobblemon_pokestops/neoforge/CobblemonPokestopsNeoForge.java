package dev.matthiesen.cobblemon_pokestops.neoforge;

import dev.matthiesen.cobblemon_pokestops.common.CobblemonPokestopsCommon;
import net.neoforged.fml.common.Mod;

@Mod(CobblemonPokestopsCommon.MOD_ID)
public final class CobblemonPokestopsNeoForge {
    public static final CobblemonPokestopsCommon INSTANCE = CobblemonPokestopsCommon.INSTANCE;

    public CobblemonPokestopsNeoForge() {
        INSTANCE.createInfoLog("Loading for NeoForge Mod Loader");
        INSTANCE.initialize();
    }
}
