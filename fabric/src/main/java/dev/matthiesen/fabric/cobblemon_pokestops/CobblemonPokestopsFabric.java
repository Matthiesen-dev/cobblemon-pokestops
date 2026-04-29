package dev.matthiesen.fabric.cobblemon_pokestops;

import dev.matthiesen.common.cobblemon_pokestops.CobblemonPokestops;
import dev.matthiesen.common.cobblemon_pokestops.Constants;
import dev.matthiesen.fabric.cobblemon_pokestops.worldgen.FabricFeatures;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.minecraft.server.MinecraftServer;

public class CobblemonPokestopsFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        Constants.createInfoLog("Loading for Fabric Mod Loader");
        CobblemonPokestops.preinitialize();
        FabricFeatures.init();
        CobblemonPokestops.initialize();
        ServerLifecycleEvents.SERVER_STARTING.register(server -> CobblemonPokestops.onStartup());
        ServerLifecycleEvents.SERVER_STOPPING.register(server -> CobblemonPokestops.onShutdown());
    }

}
