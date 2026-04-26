package dev.matthiesen.common.template_cobblemon_sidemod.config;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import dev.matthiesen.common.template_cobblemon_sidemod.Constants;
import dev.matthiesen.common.template_cobblemon_sidemod.interfaces.IConfigManager;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class ConfigManager implements IConfigManager {
    public static ModConfig config;

    @Override
    public ModConfig loadConfig() {
        String configFileLoc = System.getProperty("user.dir") + File.separator + "config" +
                File.separator + Constants.MOD_ID + File.separator + "config.json";
        Constants.createInfoLog("Loading config file found at: " + configFileLoc);
        File configFile = new File(configFileLoc);
        boolean madeDir = configFile.getParentFile().mkdirs();

        if (madeDir) {
            Constants.createInfoLog("Config Directory exists");
        }

        // Check config existence and load if it exists, otherwise create default.
        if (configFile.exists()) {
            try {
                FileReader fileReader = new FileReader(configFile);

                // Create a default config instance
                ModConfig defaultConfig = new ModConfig();
                String defaultConfigJson = ModConfig.GSON.toJson(defaultConfig);

                JsonElement fileConfigElement = JsonParser.parseReader(fileReader);

                // Convert default config JSON string to JsonElement
                JsonElement defaultConfigElement = JsonParser.parseString(defaultConfigJson);

                // Merge default config with the file config
                JsonElement mergedConfigElement = mergeConfigs(
                        defaultConfigElement.getAsJsonObject(),
                        fileConfigElement.getAsJsonObject()
                );

                // Deserialize the merged JsonElement back to PokemonToItemConfig
                ModConfig finalConfig;
                finalConfig = ModConfig.GSON.fromJson(
                        mergedConfigElement,
                        ModConfig.class
                );

                config = finalConfig;

                fileReader.close();
            } catch (Exception e) {
                Constants.createErrorLog("Failed to load the config! Using default config as fallback");
                e.printStackTrace();
                config = new ModConfig();
            }
        } else {
            config = new ModConfig();
        }

        saveConfig();

        return config;
    }

    @Override
    public JsonElement mergeConfigs(JsonObject defaultConfig, JsonObject fileConfig) {
        // For every entry in the default config, check if it exists in the file config
        Constants.createInfoLog("Checking for config merge.");
        boolean merged = false;

        for (String key : defaultConfig.keySet()) {
            if (!fileConfig.has(key)) {
                // If the file config does not have the key, add it from the default config
                fileConfig.add(key, defaultConfig.get(key));
                Constants.createInfoLog(key + " not found in file config, adding from default.");
                merged = true;
            } else {
                // If it's a nested object, recursively merge it
                if (defaultConfig.get(key).isJsonObject() && fileConfig.get(key).isJsonObject()) {
                    mergeConfigs(defaultConfig.getAsJsonObject(key), fileConfig.getAsJsonObject(key));
                }
            }
        }

        if (merged) {
            Constants.createInfoLog("Successfully merged config.");
        }

        return fileConfig;
    }

    @Override
    public void saveConfig() {
        try {
            String configFileLoc = System.getProperty("user.dir") + File.separator + "config" +
                    File.separator + Constants.MOD_ID + File.separator + "config.json";
            Constants.createInfoLog("Saving config to: " + configFileLoc);
            File configFile = new File(configFileLoc);
            FileWriter fileWriter = new FileWriter(configFile);
            ModConfig.GSON.toJson(config, fileWriter);
            fileWriter.flush();
            fileWriter.close();
        } catch (Exception e) {
            Constants.createErrorLog("Failed to save config");
            e.printStackTrace();
        }
    }
}
