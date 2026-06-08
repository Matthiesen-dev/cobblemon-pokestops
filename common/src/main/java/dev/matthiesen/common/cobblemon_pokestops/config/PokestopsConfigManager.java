package dev.matthiesen.common.cobblemon_pokestops.config;

import dev.matthiesen.common.cobblemon_pokestops.Constants;
import dev.matthiesen.common.matthiesen_lib_api.config.ConfigManager;

public class PokestopsConfigManager<T> extends ConfigManager<T> {
    public PokestopsConfigManager(Class<T> configClass, String configName) {
        super(configClass, configName, Constants.MOD_ID);
    }
}
