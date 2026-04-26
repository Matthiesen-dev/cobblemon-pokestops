package dev.matthiesen.common.cobblemon_pokestops.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;
import dev.matthiesen.common.cobblemon_pokestops.Constants;

public class ModConfig {
    @SerializedName("permissionlevels")
    public PermissionLevels permissionLevels = new PermissionLevels();

    public static class PermissionLevels {
        @SerializedName("command.example")
        public int COMMAND_EXAMPLE_PERMISSION_LEVEL =
                Constants.PERMISSION_LEVELS.CHEAT_COMMANDS_AND_COMMAND_BLOCKS.getLevel();

        @SerializedName("command.example-cool")
        public int COMMAND_EXAMPLE_COOL_PERMISSION_LEVEL =
                Constants.PERMISSION_LEVELS.CHEAT_COMMANDS_AND_COMMAND_BLOCKS.getLevel();
    }

    public static final Gson GSON = new GsonBuilder()
            .disableHtmlEscaping()
            .setPrettyPrinting()
            .create();
}
