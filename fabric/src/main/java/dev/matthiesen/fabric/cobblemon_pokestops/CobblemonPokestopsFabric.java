package dev.matthiesen.fabric.cobblemon_pokestops;

import dev.matthiesen.common.cobblemon_pokestops.CobblemonPokestops;
import dev.matthiesen.common.cobblemon_pokestops.Constants;
import dev.matthiesen.common.cobblemon_pokestops.registry.CreativeModeTabRegistry;
import dev.matthiesen.fabric.cobblemon_pokestops.worldgen.CobblemonPokestopsFabricFeatures;
import net.fabricmc.api.ModInitializer;

public class CobblemonPokestopsFabric implements ModInitializer {

    @Override
    public void onInitialize() {
        Constants.createInfoLog("Loading for Fabric Mod Loader");
        CobblemonPokestops.initialize();
        CobblemonPokestopsFabricFeatures.init();

        CreativeModeTabRegistry.buildSections();
    }

}
