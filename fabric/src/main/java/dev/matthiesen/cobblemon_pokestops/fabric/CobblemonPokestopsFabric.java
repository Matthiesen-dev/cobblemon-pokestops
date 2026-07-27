package dev.matthiesen.cobblemon_pokestops.fabric;

import dev.matthiesen.cobblemon_pokestops.common.CobblemonPokestopsCommon;
import net.fabricmc.api.ModInitializer;

public final class CobblemonPokestopsFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        var instance = CobblemonPokestopsCommon.INSTANCE;
        instance.createInfoLog("Loading for Fabric Mod Loader");
        instance.initialize();
    }
}
