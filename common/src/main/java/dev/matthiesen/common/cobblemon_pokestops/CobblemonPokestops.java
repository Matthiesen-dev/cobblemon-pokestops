package dev.matthiesen.common.cobblemon_pokestops;

import dev.matthiesen.common.cobblemon_pokestops.config.*;
import dev.matthiesen.common.cobblemon_pokestops.registry.*;

public class CobblemonPokestops {
    public static ModConfig config;

    public static void initialize() {
        Constants.createInfoLog("Registering Server/Client Resources");
        config = new ConfigManager().loadConfig();
        SoundRegistry.init();
        StatsRegistry.init();
        BlockRegistry.init();
        BlockEntityRegistry.init();
        ItemRegistry.init();
        CreativeModeTabRegistry.init();
        CriterionTriggerRegistry.init();
    }
}
