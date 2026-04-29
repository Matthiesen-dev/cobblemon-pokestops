package dev.matthiesen.common.cobblemon_pokestops.registry;

import dev.matthiesen.common.cobblemon_pokestops.CobblemonPokestops;
import dev.matthiesen.common.cobblemon_pokestops.advancements.UsedPokestopCriterion;
import dev.matthiesen.common.cobblemon_pokestops.advancements.UsedWingedPokestopCriterion;
import net.minecraft.advancements.CriterionTrigger;

import java.util.function.Supplier;

public class CriterionTriggerRegistry {
    public static void init() {}

    public static final Supplier<UsedPokestopCriterion> USE_POKESTOP = register("used_pokestop", UsedPokestopCriterion::new);
    public static final Supplier<UsedWingedPokestopCriterion> USE_WINGED_POKESTOP = register("used_winged_pokestop", UsedWingedPokestopCriterion::new);

    private static <T extends CriterionTrigger<?>>Supplier<T> register(String id, Supplier<T> criterionTrigger) {
        return CobblemonPokestops.COMMON_PLATFORM.registerCriteriaTriggers(id, criterionTrigger);
    }
}
