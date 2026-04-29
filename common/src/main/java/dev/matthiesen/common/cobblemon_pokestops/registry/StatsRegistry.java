package dev.matthiesen.common.cobblemon_pokestops.registry;

import dev.matthiesen.common.cobblemon_pokestops.CobblemonPokestops;
import dev.matthiesen.common.cobblemon_pokestops.Constants;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.stats.Stat;
import net.minecraft.stats.Stats;

import java.util.function.Supplier;

public class StatsRegistry {
    public static final Supplier<ResourceLocation> POKESTOP_TIMES_SPUN = registerStats("pokestop_times_spun", () -> Constants.modResource("pokestop_times_spun"));
    public static final Supplier<ResourceLocation> WINGEDSTOP_TIMES_SPUN = registerStats("wingedstop_times_spun", () -> Constants.modResource("wingedstop_times_spun"));

    public static Stat<ResourceLocation> POKESTOP_TIMES_SPUN_STAT;
    public static Stat<ResourceLocation> WINGEDSTOP_TIMES_SPUN_STAT;

    public static void init() {
        POKESTOP_TIMES_SPUN_STAT = Stats.CUSTOM.get(POKESTOP_TIMES_SPUN.get());
        WINGEDSTOP_TIMES_SPUN_STAT = Stats.CUSTOM.get(WINGEDSTOP_TIMES_SPUN.get());
    }

    public static Stat<ResourceLocation> getPokestopTimesSpunStat() {
        if (POKESTOP_TIMES_SPUN_STAT == null) {
            init();
        }
        return POKESTOP_TIMES_SPUN_STAT;
    }

    public static Stat<ResourceLocation> getWingedstopTimesSpunStat() {
        if (WINGEDSTOP_TIMES_SPUN_STAT == null) {
            init();
        }
        return WINGEDSTOP_TIMES_SPUN_STAT;
    }

    private static <T extends ResourceLocation> Supplier<T> registerStats(String id, Supplier<T> stats) {
        return CobblemonPokestops.COMMON_PLATFORM.registerStats(id, stats);
    }
}
