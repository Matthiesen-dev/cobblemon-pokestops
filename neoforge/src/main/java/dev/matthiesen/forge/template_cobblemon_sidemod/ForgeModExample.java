package dev.matthiesen.forge.template_cobblemon_sidemod;

import dev.matthiesen.common.template_cobblemon_sidemod.CommonModExample;
import dev.matthiesen.common.template_cobblemon_sidemod.Constants;
import net.minecraft.server.MinecraftServer;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.RegisterCommandsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.neoforged.neoforge.event.server.ServerStoppingEvent;

@Mod(Constants.MOD_ID)
public class ForgeModExample {
    public ForgeModExample(IEventBus modBus) {
        Constants.createInfoLog("Loading for NeoForge Mod Loader");
        CommonModExample.initialize();
        NeoForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        MinecraftServer server = event.getServer();
        CommonModExample.onStartup(server);
    }

    @SubscribeEvent
    public void onCommandRegistration(RegisterCommandsEvent event) {
        CommonModExample.registerCommands(event.getDispatcher(), event.getBuildContext(), event.getCommandSelection());
    }

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public void onServerStopping(ServerStoppingEvent event) {
        CommonModExample.onShutdown();
    }
}
