package dev.matthiesen.common.template_cobblemon_sidemod.interfaces;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import dev.matthiesen.common.template_cobblemon_sidemod.config.ModConfig;

public interface IConfigManager {
    ModConfig loadConfig();
    JsonElement mergeConfigs(JsonObject defaultConfig, JsonObject fileConfig);
    void saveConfig();
}
