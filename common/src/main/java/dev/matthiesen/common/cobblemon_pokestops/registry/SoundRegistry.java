package dev.matthiesen.common.cobblemon_pokestops.registry;

import dev.matthiesen.common.cobblemon_pokestops.CobblemonPokestops;
import dev.matthiesen.common.cobblemon_pokestops.Constants;
import net.minecraft.sounds.SoundEvent;

import java.util.function.Supplier;

public class SoundRegistry {
    public static void init() {}

    public static Supplier<SoundEvent> POKESTOP_SPIN = registerSound("pokestop_spin", () ->
            SoundEvent.createVariableRangeEvent(Constants.modResource("pokestop_spin")));

    private static <T extends SoundEvent> Supplier<T> registerSound(String id, Supplier<T> sound) {
        return CobblemonPokestops.COMMON_PLATFORM.registerSound(id, sound);
    }
}
