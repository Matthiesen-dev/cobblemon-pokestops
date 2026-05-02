package dev.matthiesen.fabric.cobblemon_pokestops;

import dev.matthiesen.common.cobblemon_pokestops.CobblemonPokestops;
import dev.matthiesen.common.cobblemon_pokestops.Constants;
import dev.matthiesen.fabric.cobblemon_pokestops.worldgen.CobblemonPokestopsFabricFeatures;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.minecraft.server.MinecraftServer;

public class CobblemonPokestopsFabric implements ModInitializer {
    public static MinecraftServer MC_SERVER;

    @Override
    public void onInitialize() {
        Constants.createInfoLog("Loading for Fabric Mod Loader");
        CobblemonPokestops.initialize();
        CobblemonPokestopsFabricFeatures.init();

        ServerLifecycleEvents.SERVER_STARTING.register(server -> {
            CobblemonPokestops.onStartup();
            MC_SERVER = server;
        });
        ServerLifecycleEvents.SERVER_STOPPING.register(server -> {
            CobblemonPokestops.onShutdown();
            MC_SERVER = null;
        });
    }

}
