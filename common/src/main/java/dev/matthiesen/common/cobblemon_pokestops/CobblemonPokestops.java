package dev.matthiesen.common.cobblemon_pokestops;

import com.mojang.brigadier.CommandDispatcher;
import dev.matthiesen.common.cobblemon_pokestops.commands.CommandRegistry;
import dev.matthiesen.common.cobblemon_pokestops.config.*;
import dev.matthiesen.common.cobblemon_pokestops.permissions.ModPermissions;
import dev.matthiesen.common.cobblemon_pokestops.platform.CobblemonPokestopsPlatform;
import dev.matthiesen.common.cobblemon_pokestops.registry.*;
import net.minecraft.commands.CommandBuildContext;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.server.MinecraftServer;

import java.util.ServiceLoader;

public class CobblemonPokestops {
    public static ModPermissions permissions;
    public static ModConfig config;
    public static MinecraftServer currentServer;
    public static final CobblemonPokestopsPlatform COMMON_PLATFORM = ServiceLoader.load(CobblemonPokestopsPlatform.class).findFirst().orElseThrow();

    public static void preinitialize() {
        Constants.createInfoLog("Registering Resources");
        SoundRegistry.init();
        BlockRegistry.init();
        BlockEntityRegistry.init();
        ItemRegistry.init();
    }

    public static void initialize() {
        Constants.createInfoLog("Initialized");
        config = new ConfigManager().loadConfig();
        permissions = new ModPermissions();
    }

    public static void onStartup(MinecraftServer server) {
        Constants.createInfoLog("Server starting, Setting up");
        currentServer = server;
    }

    public static void onShutdown() {
        Constants.createInfoLog("Server stopping, shutting down");
        new ConfigManager().saveConfig();
    }

    public static void registerCommands(CommandDispatcher<CommandSourceStack> dispatcher, CommandBuildContext registry, Commands.CommandSelection context) {
        Constants.createInfoLog("Registering Commands");
        CommandRegistry.init(dispatcher, registry, context);
    }
}
