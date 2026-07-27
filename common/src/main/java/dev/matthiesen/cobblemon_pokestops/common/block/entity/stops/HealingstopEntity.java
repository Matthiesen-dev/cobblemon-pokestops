package dev.matthiesen.cobblemon_pokestops.common.block.entity.stops;

import dev.matthiesen.cobblemon_pokestops.common.templates.entity.StopEntityTemplate;
import dev.matthiesen.cobblemon_pokestops.common.registry.BlockEntityRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import software.bernie.geckolib.animation.RawAnimation;

public final class HealingstopEntity extends StopEntityTemplate {
    private static final RawAnimation IDLE_ANIM = RawAnimation.begin()
            .thenLoop("animation.healingstop.idle_closed");
    private static final RawAnimation IDLE_COOLDOWN_ANIM = RawAnimation.begin()
            .thenLoop("animation.healingstop.idle_open");
    private static final RawAnimation SPIN_ANIM = RawAnimation.begin()
            .thenPlay("animation.healingstop.open");

    public HealingstopEntity(BlockPos pos, BlockState state) {
        super(pos, state, BlockEntityRegistry.HEALINGSTOP_BE);
    }

    @Override
    protected RawAnimation getIdleAnimation() {
        return IDLE_ANIM;
    }

    @Override
    protected RawAnimation getIdleCooldownAnimation() {
        return IDLE_COOLDOWN_ANIM;
    }

    @Override
    protected RawAnimation getSpinAnimation() {
        return SPIN_ANIM;
    }
}