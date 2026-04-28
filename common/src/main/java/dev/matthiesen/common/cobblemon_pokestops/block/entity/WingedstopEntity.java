package dev.matthiesen.common.cobblemon_pokestops.block.entity;

import dev.matthiesen.common.cobblemon_pokestops.templates.entity.StopEntityTemplate;
import dev.matthiesen.common.cobblemon_pokestops.registry.BlockEntityRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import software.bernie.geckolib.animation.RawAnimation;

public class WingedstopEntity extends StopEntityTemplate {
    private static final RawAnimation IDLE_ANIM = RawAnimation.begin()
            .thenLoop("animation.wingedstop.idle_closed");
    private static final RawAnimation IDLE_COOLDOWN_ANIM = RawAnimation.begin()
            .thenLoop("animation.wingedstop.idle_open");
    private static final RawAnimation SPIN_ANIM = RawAnimation.begin()
            .thenPlay("animation.wingedstop.open");

    public WingedstopEntity(BlockPos pos, BlockState state) {
        super(pos, state, BlockEntityRegistry.WINGEDSTOP_BE);
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