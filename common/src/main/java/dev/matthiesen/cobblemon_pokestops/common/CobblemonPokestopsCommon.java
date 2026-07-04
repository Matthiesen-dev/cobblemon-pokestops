package dev.matthiesen.cobblemon_pokestops.common;

import dev.matthiesen.cobblemon_pokestops.common.config.PokestopsConfig;
import dev.matthiesen.cobblemon_pokestops.common.registry.*;
import dev.matthiesen.cobblemon_pokestops.common.translations.GlobalTranslations;
import dev.matthiesen.common.matthiesen_lib_api.abstracts.AbstractCommonMod;
import dev.matthiesen.common.matthiesen_lib_api.config.ConfigManager;
import dev.matthiesen.libs.faststats.Token;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public final class CobblemonPokestopsCommon extends AbstractCommonMod {
    public static final String MOD_ID = "cobblemon_pokestops";
    public static final String MOD_NAME = "Cobblemon Pokestops";
    private static @Token final String METRICS_TOKEN = "77e42e7ca5467f1d8eb079095534aa32";

    public static final CobblemonPokestopsCommon INSTANCE = new CobblemonPokestopsCommon();

    private static final ConfigManager<PokestopsConfig> CONFIG_MANAGER =
            INSTANCE.createConfigManager(PokestopsConfig.class, "config");

    public PokestopsConfig getConfig() {
        return CONFIG_MANAGER.getConfig();
    }

    public static ResourceLocation modResource(String path) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
    }

    public static String modResourceFile(String path) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, path).toString();
    }

    public CobblemonPokestopsCommon() {
        super(MOD_ID, MOD_NAME);
    }

    @Override
    public void initialize() {
        super.initialize();
        reload().run();

        GlobalTranslations.init();
        SoundRegistry.init();
        StatsRegistry.init();
        BlockRegistry.init();
        BlockEntityRegistry.init();
        ItemRegistry.init();
        CreativeModeTabRegistry.init();
        CriterionTriggerRegistry.init();

        createInfoLog("Initialized Cobblemon Pokestops Common");
    }

    @Override
    public Runnable reload() {
        return () -> {
            CONFIG_MANAGER.loadConfig();
            createInfoLog("Reloaded config");
        };
    }

    @Override
    public @NotNull @Token String getMetricsToken() {
        return METRICS_TOKEN;
    }
}
