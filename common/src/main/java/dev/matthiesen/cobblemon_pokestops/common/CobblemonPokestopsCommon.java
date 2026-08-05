package dev.matthiesen.cobblemon_pokestops.common;

import dev.matthiesen.cobblemon_pokestops.common.config.PokestopsConfig;
import dev.matthiesen.cobblemon_pokestops.common.registry.*;
import dev.matthiesen.cobblemon_pokestops.common.translations.GlobalTranslations;
import dev.matthiesen.libs.faststats.Token;
import dev.matthiesen.matthiesen_core.common.AbstractCommonMod;
import dev.matthiesen.matthiesen_core.common.api.platform.loader.ModConfigType;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public final class CobblemonPokestopsCommon extends AbstractCommonMod {
    public static final String MOD_ID = "cobblemon_pokestops";
    public static final String MOD_NAME = "Cobblemon Pokestops";
    private static @Token final String METRICS_TOKEN = "77e42e7ca5467f1d8eb079095534aa32";

    public static final CobblemonPokestopsCommon INSTANCE = new CobblemonPokestopsCommon();

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
        registerModConfig(MOD_ID, ModConfigType.SERVER, PokestopsConfig.SERVER_SPEC, "cobblemon_pokestops/server.toml");

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
    public @NotNull @Token String getMetricsToken() {
        return METRICS_TOKEN;
    }
}
