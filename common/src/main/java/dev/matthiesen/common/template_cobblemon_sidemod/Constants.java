package dev.matthiesen.common.template_cobblemon_sidemod;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Constants {
    public static final String MOD_ID = "template_cobblemon_sidemod";
    public static final String ModName = "Template Side-Mod";

    public enum PERMISSION_LEVELS {
        NONE(0),
        SPAWN_PROTECTION_BYPASS(1),
        CHEAT_COMMANDS_AND_COMMAND_BLOCKS(2),
        MULTIPLAYER_MANAGEMENT(3),
        ALL_COMMANDS(4);

        private final int level;

        PERMISSION_LEVELS(int level) {
            this.level = level;
        }

        public int getLevel() {
            return level;
        }
    }

    public static Logger LOGGER = LogManager.getLogger(ModName);

    public static void createInfoLog(String message) {
        LOGGER.info(message);
    }

    public static void createErrorLog(String message) {
        LOGGER.error(message);
    }
}
