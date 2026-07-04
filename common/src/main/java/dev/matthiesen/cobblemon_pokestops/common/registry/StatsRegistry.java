package dev.matthiesen.cobblemon_pokestops.common.registry;

import dev.matthiesen.cobblemon_pokestops.common.CobblemonPokestopsCommon;
import dev.matthiesen.common.matthiesen_lib.registry.AbstractStatsRegistry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.stats.Stat;
import net.minecraft.stats.Stats;

import java.util.function.Supplier;

public class StatsRegistry extends AbstractStatsRegistry {
    private static final StatsRegistry INSTANCE = new StatsRegistry();

    public static final Supplier<ResourceLocation> POKESTOP_TIMES_SPUN;
    public static final Supplier<ResourceLocation> WINGEDSTOP_TIMES_SPUN;
    public static final Supplier<ResourceLocation> POKEBALLSTOP_TIMES_SPUN;
    public static final Supplier<ResourceLocation> HEALINGSTOP_TIMES_SPUN;

    static {
        POKESTOP_TIMES_SPUN = INSTANCE.register("pokestop_times_spun", () -> CobblemonPokestopsCommon.modResource("pokestop_times_spun"));
        WINGEDSTOP_TIMES_SPUN = INSTANCE.register("wingedstop_times_spun", () -> CobblemonPokestopsCommon.modResource("wingedstop_times_spun"));
        POKEBALLSTOP_TIMES_SPUN = INSTANCE.register("pokeballstop_times_spun", () -> CobblemonPokestopsCommon.modResource("pokeballstop_times_spun"));
        HEALINGSTOP_TIMES_SPUN = INSTANCE.register("healingstop_times_spun", () -> CobblemonPokestopsCommon.modResource("healingstop_times_spun"));
    }

    public static Stat<ResourceLocation> POKESTOP_TIMES_SPUN_STAT;
    public static Stat<ResourceLocation> WINGEDSTOP_TIMES_SPUN_STAT;
    public static Stat<ResourceLocation> POKEBALLSTOP_TIMES_SPUN_STAT;
    public static Stat<ResourceLocation> HEALINGSTOP_TIMES_SPUN_STAT;

    private StatsRegistry() {
        super(CobblemonPokestopsCommon.MOD_ID);
    }

    public static void init() {}

    public static void load() {
        POKESTOP_TIMES_SPUN_STAT = Stats.CUSTOM.get(POKESTOP_TIMES_SPUN.get());
        WINGEDSTOP_TIMES_SPUN_STAT = Stats.CUSTOM.get(WINGEDSTOP_TIMES_SPUN.get());
        POKEBALLSTOP_TIMES_SPUN_STAT = Stats.CUSTOM.get(POKEBALLSTOP_TIMES_SPUN.get());
        HEALINGSTOP_TIMES_SPUN_STAT = Stats.CUSTOM.get(HEALINGSTOP_TIMES_SPUN.get());
    }

    public static Stat<ResourceLocation> getPokestopTimesSpunStat() {
        if (POKESTOP_TIMES_SPUN_STAT == null) {
            load();
        }
        return POKESTOP_TIMES_SPUN_STAT;
    }

    public static Stat<ResourceLocation> getWingedstopTimesSpunStat() {
        if (WINGEDSTOP_TIMES_SPUN_STAT == null) {
            load();
        }
        return WINGEDSTOP_TIMES_SPUN_STAT;
    }

    public static Stat<ResourceLocation> getPokeballstopTimesSpunStat() {
        if (POKEBALLSTOP_TIMES_SPUN_STAT == null) {
            load();
        }
        return POKEBALLSTOP_TIMES_SPUN_STAT;
    }

    public static  Stat<ResourceLocation> getHealingstopTimesSpunStat() {
        if (HEALINGSTOP_TIMES_SPUN_STAT == null) {
            load();
        }
        return HEALINGSTOP_TIMES_SPUN_STAT;
    }
}
