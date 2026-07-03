package dev.matthiesen.neoforge.cobblemon_pokestops;

import dev.matthiesen.common.cobblemon_pokestops.CobblemonPokestops;
import dev.matthiesen.common.cobblemon_pokestops.Constants;
import dev.matthiesen.common.cobblemon_pokestops.registry.CreativeModeTabRegistry;
import dev.matthiesen.neoforge.cobblemon_pokestops.worldgen.CobblemonPokestopsNeoForgeFeatures;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod(Constants.MOD_ID)
public class CobblemonPokestopsNeoForge {
    public CobblemonPokestopsNeoForge(IEventBus modBus) {
        Constants.createInfoLog("Loading for NeoForge Mod Loader");
        CobblemonPokestops.initialize();
        CobblemonPokestopsNeoForgeFeatures.init(modBus);
        modBus.addListener(this::onCommonSetup);
    }

    private void onCommonSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(CreativeModeTabRegistry::buildSections);
    }
}
