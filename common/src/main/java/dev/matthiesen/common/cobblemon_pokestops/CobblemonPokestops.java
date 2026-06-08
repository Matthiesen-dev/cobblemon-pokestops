package dev.matthiesen.common.cobblemon_pokestops;

import dev.matthiesen.common.cobblemon_pokestops.config.*;
import dev.matthiesen.common.cobblemon_pokestops.registry.*;
import dev.matthiesen.common.matthiesen_lib.MatthiesenLib;

public class CobblemonPokestops {
    private static final PokestopsConfigManager<PokestopsConfig> CONFIG_MANAGER
            = new PokestopsConfigManager<>(PokestopsConfig.class, "config");

    public static PokestopsConfig getConfig() {
        return CONFIG_MANAGER.getConfig();
    }

    public static void initialize() {
        Constants.createInfoLog("Registering Server/Client Resources");
        reload();
        SoundRegistry.init();
        StatsRegistry.init();
        BlockRegistry.init();
        BlockEntityRegistry.init();
        ItemRegistry.init();
        CreativeModeTabRegistry.init();
        CriterionTriggerRegistry.init();
        MatthiesenLib.registerReloadRunnable(Constants.MOD_ID, CobblemonPokestops::reload);
    }

    public static void reload() {
        CONFIG_MANAGER.loadConfig();
        Constants.createInfoLog("Reloaded Config");
    }
}
