package dev.matthiesen.common.template_cobblemon_sidemod;

import com.mojang.brigadier.CommandDispatcher;
import dev.matthiesen.common.template_cobblemon_sidemod.commands.CommandRegistry;
import dev.matthiesen.common.template_cobblemon_sidemod.config.ConfigManager;
import dev.matthiesen.common.template_cobblemon_sidemod.config.ModConfig;
import dev.matthiesen.common.template_cobblemon_sidemod.permissions.ModPermissions;
import net.minecraft.commands.CommandBuildContext;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.server.MinecraftServer;

public class CommonModExample {
    public static ModPermissions permissions;
    public static ModConfig config;
    public static MinecraftServer currentServer;

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
