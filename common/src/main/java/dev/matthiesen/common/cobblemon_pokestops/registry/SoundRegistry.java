package dev.matthiesen.common.cobblemon_pokestops.registry;

import dev.matthiesen.common.cobblemon_pokestops.Constants;
import dev.matthiesen.common.matthiesen_lib.registry.AbstractSoundRegistry;
import net.minecraft.sounds.SoundEvent;

import java.util.function.Supplier;

public class SoundRegistry extends AbstractSoundRegistry {
    private static final SoundRegistry INSTANCE = new SoundRegistry();

    private SoundRegistry() {
        super(Constants.MOD_ID);
    }

    public static void init() {}

    public static Supplier<SoundEvent> POKESTOP_SPIN;

    static {
        POKESTOP_SPIN = INSTANCE.register("pokestop_spin", () ->
                SoundEvent.createVariableRangeEvent(Constants.modResource("pokestop_spin")));
    }
}
