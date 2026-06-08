package dev.matthiesen.common.cobblemon_pokestops.registry;

import dev.matthiesen.common.cobblemon_pokestops.Constants;
import dev.matthiesen.common.cobblemon_pokestops.advancements.*;
import dev.matthiesen.common.matthiesen_lib.registry.AbstractCriteriaTriggerRegistry;

import java.util.function.Supplier;

public class CriterionTriggerRegistry extends AbstractCriteriaTriggerRegistry {
    private static final CriterionTriggerRegistry INSTANCE = new CriterionTriggerRegistry();

    private CriterionTriggerRegistry() {
        super(Constants.MOD_ID);
    }

    public static void init() {}

    public static final Supplier<UsedPokestopCriterion> USE_POKESTOP;
    public static final Supplier<UsedWingedPokestopCriterion> USE_WINGED_POKESTOP;
    public static final Supplier<UsedPokeballstopCriterion> USE_POKEBALLSTOP;
    public static final Supplier<UsedHealingstopCriterion> USE_HEALINGSTOP;

    public static final Supplier<PokestopScoreTracker> POKESTOP_SCORE;
    public static final Supplier<WingedPokestopScoreTracker> WINGED_POKESTOP_SCORE;
    public static final Supplier<PokeballstopScoreTracker> POKEBALLSTOP_SCORE;
    public static final Supplier<HealingstopScoreTracker> HEALINGSTOP_SCORE;

    static {
        USE_POKESTOP = INSTANCE.register("used_pokestop", UsedPokestopCriterion::new);
        USE_WINGED_POKESTOP = INSTANCE.register("used_winged_pokestop", UsedWingedPokestopCriterion::new);
        USE_POKEBALLSTOP = INSTANCE.register("used_pokeballstop", UsedPokeballstopCriterion::new);
        USE_HEALINGSTOP = INSTANCE.register("used_healingstop", UsedHealingstopCriterion::new);

        POKESTOP_SCORE = INSTANCE.register("pokestop_score", PokestopScoreTracker::new);
        WINGED_POKESTOP_SCORE = INSTANCE.register("winged_pokestop_score", WingedPokestopScoreTracker::new);
        POKEBALLSTOP_SCORE = INSTANCE.register("pokeballstop_score", PokeballstopScoreTracker::new);
        HEALINGSTOP_SCORE = INSTANCE.register("healingstop_score", HealingstopScoreTracker::new);
    }
}
