package dev.matthiesen.common.cobblemon_pokestops.utils;

import dev.matthiesen.common.cobblemon_pokestops.CobblemonPokestops;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;

public class Commander {
    public static void runServerCommand(String command) {
        MinecraftServer server = CobblemonPokestops.COMMON_PLATFORM.server();
        server.getCommands().performPrefixedCommand(server.createCommandSourceStack(), command);
    }

    public static void runPlayerCommand(ServerPlayer player, String command) {
        MinecraftServer server = CobblemonPokestops.COMMON_PLATFORM.server();
        server.getCommands().performPrefixedCommand(player.createCommandSourceStack(), command);
    }
}
