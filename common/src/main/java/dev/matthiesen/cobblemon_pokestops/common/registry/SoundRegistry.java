package dev.matthiesen.cobblemon_pokestops.common.registry;

import dev.matthiesen.cobblemon_pokestops.common.CobblemonPokestopsCommon;
import dev.matthiesen.matthiesen_core.common.registry.AbstractSoundRegistry;
import net.minecraft.sounds.SoundEvent;

import java.util.function.Supplier;

public final class SoundRegistry extends AbstractSoundRegistry {
    private static final SoundRegistry INSTANCE = new SoundRegistry();

    private SoundRegistry() {
        super(CobblemonPokestopsCommon.MOD_ID);
    }

    public static void init() {}

    public static Supplier<SoundEvent> POKESTOP_SPIN;

    static {
        POKESTOP_SPIN = INSTANCE.register("pokestop_spin", () ->
                SoundEvent.createVariableRangeEvent(CobblemonPokestopsCommon.modResource("pokestop_spin")));
    }
}
