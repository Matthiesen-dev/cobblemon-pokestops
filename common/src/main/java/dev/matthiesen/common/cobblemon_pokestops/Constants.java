package dev.matthiesen.common.cobblemon_pokestops;

import dev.matthiesen.common.cobblemon_pokestops.utils.MetricManager;
import dev.matthiesen.libs.faststats.Token;
import net.minecraft.resources.ResourceLocation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Constants {
    public static final String MOD_ID = "cobblemon_pokestops";
    public static final String ModName = "Cobblemon Pokestops";
    public static @Token final String METRICS_TOKEN = "77e42e7ca5467f1d8eb079095534aa32";

    public static ResourceLocation modResource(String path) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
    }

    public static String modResourceFile(String path) {
        return Constants.MOD_ID + ":" + path;
    }

    public static Logger LOGGER = LogManager.getLogger(ModName);

    public static void createInfoLog(String message) {
        LOGGER.info(message);
    }

    public static void createErrorLog(String message) {
        LOGGER.error(message);
    }

    public static void createErrorLog(String message, Throwable throwable) {
        MetricManager.ERROR_TRACKER.trackError(throwable);
        LOGGER.error(message, throwable);
    }
}
