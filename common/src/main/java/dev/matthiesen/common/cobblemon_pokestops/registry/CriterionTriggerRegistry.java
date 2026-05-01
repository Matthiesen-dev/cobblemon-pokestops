package dev.matthiesen.common.cobblemon_pokestops.registry;

import dev.matthiesen.common.cobblemon_pokestops.CobblemonPokestops;
import dev.matthiesen.common.cobblemon_pokestops.advancements.*;
import net.minecraft.advancements.CriterionTrigger;

import java.util.function.Supplier;

public class CriterionTriggerRegistry {
    public static void init() {}

    public static final Supplier<UsedPokestopCriterion> USE_POKESTOP = register("used_pokestop", UsedPokestopCriterion::new);
    public static final Supplier<UsedWingedPokestopCriterion> USE_WINGED_POKESTOP = register("used_winged_pokestop", UsedWingedPokestopCriterion::new);
    public static final Supplier<UsedPokeballstopCriterion> USE_POKEBALLSTOP = register("used_pokeballstop", UsedPokeballstopCriterion::new);

    public static final Supplier<PokestopScoreTracker> POKESTOP_SCORE = register("pokestop_score", PokestopScoreTracker::new);
    public static final Supplier<WingedPokestopScoreTracker> WINGED_POKESTOP_SCORE = register("winged_pokestop_score", WingedPokestopScoreTracker::new);
    public static final Supplier<PokeballstopScoreTracker> POKEBALLSTOP_SCORE = register("pokeballstop_score", PokeballstopScoreTracker::new);

    private static <T extends CriterionTrigger<?>>Supplier<T> register(String id, Supplier<T> criterionTrigger) {
        return CobblemonPokestops.COMMON_PLATFORM.registerCriteriaTriggers(id, criterionTrigger);
    }
}
