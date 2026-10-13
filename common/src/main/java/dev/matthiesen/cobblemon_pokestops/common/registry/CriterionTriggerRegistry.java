package dev.matthiesen.cobblemon_pokestops.common.registry;

import dev.matthiesen.cobblemon_pokestops.common.CobblemonPokestopsCommon;
import dev.matthiesen.cobblemon_pokestops.common.advancements.StopScoreTrackingCriterion;
import dev.matthiesen.cobblemon_pokestops.common.advancements.UsedStopCriterion;
import dev.matthiesen.matthiesen_core.common.registry.AbstractCriteriaTriggerRegistry;

import java.util.function.Supplier;

public final class CriterionTriggerRegistry extends AbstractCriteriaTriggerRegistry {
    private static final CriterionTriggerRegistry INSTANCE = new CriterionTriggerRegistry();

    private CriterionTriggerRegistry() {
        super(CobblemonPokestopsCommon.MOD_ID);
    }

    public static void init() {}

    public static final Supplier<UsedStopCriterion> USE_POKESTOP;
    public static final Supplier<UsedStopCriterion> USE_WINGED_POKESTOP;
    public static final Supplier<UsedStopCriterion> USE_POKEBALLSTOP;
    public static final Supplier<UsedStopCriterion> USE_HEALINGSTOP;

    public static final Supplier<StopScoreTrackingCriterion> POKESTOP_SCORE;
    public static final Supplier<StopScoreTrackingCriterion> WINGED_POKESTOP_SCORE;
    public static final Supplier<StopScoreTrackingCriterion> POKEBALLSTOP_SCORE;
    public static final Supplier<StopScoreTrackingCriterion> HEALINGSTOP_SCORE;

    static {
        USE_POKESTOP = INSTANCE.register("used_pokestop", UsedStopCriterion::new);
        USE_WINGED_POKESTOP = INSTANCE.register("used_winged_pokestop", UsedStopCriterion::new);
        USE_POKEBALLSTOP = INSTANCE.register("used_pokeballstop", UsedStopCriterion::new);
        USE_HEALINGSTOP = INSTANCE.register("used_healingstop", UsedStopCriterion::new);

        POKESTOP_SCORE = INSTANCE.register("pokestop_score", StopScoreTrackingCriterion::new);
        WINGED_POKESTOP_SCORE = INSTANCE.register("winged_pokestop_score", StopScoreTrackingCriterion::new);
        POKEBALLSTOP_SCORE = INSTANCE.register("pokeballstop_score", StopScoreTrackingCriterion::new);
        HEALINGSTOP_SCORE = INSTANCE.register("healingstop_score", StopScoreTrackingCriterion::new);
    }
}
