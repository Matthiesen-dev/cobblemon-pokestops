package dev.matthiesen.fabric.template_cobblemon_sidemod;

import dev.matthiesen.common.template_cobblemon_sidemod.CommonModExample;
import dev.matthiesen.common.template_cobblemon_sidemod.Constants;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.minecraft.server.MinecraftServer;

public class FabricModExample implements ModInitializer {

    @Override
    public void onInitialize() {
        Constants.createInfoLog("Loading for Fabric Mod Loader");
        CommonModExample.initialize();
        CommandRegistrationCallback.EVENT.register(CommonModExample::registerCommands);
        ServerLifecycleEvents.SERVER_STARTING.register(server -> {
            MinecraftServer runningServer = server.createCommandSourceStack().getServer();
            CommonModExample.onStartup(runningServer);
        });
        ServerLifecycleEvents.SERVER_STOPPING.register(server -> CommonModExample.onShutdown());
    }

}
