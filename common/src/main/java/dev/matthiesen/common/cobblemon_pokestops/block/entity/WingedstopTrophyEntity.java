package dev.matthiesen.common.cobblemon_pokestops.block.entity;

import dev.matthiesen.common.cobblemon_pokestops.registry.BlockEntityRegistry;
import dev.matthiesen.common.cobblemon_pokestops.templates.entity.TrophyEntityTemplate;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import software.bernie.geckolib.animation.RawAnimation;

public class WingedstopTrophyEntity extends TrophyEntityTemplate {
    private static final RawAnimation IDLE_ANIM = RawAnimation.begin()
            .thenLoop("animation.wingedstop_trophy.idle_open");

    public WingedstopTrophyEntity(BlockPos pos, BlockState state) {
        super(pos, state, BlockEntityRegistry.WINGEDSTOP_TROPHY_BE);
    }

    @Override
    protected RawAnimation getIdleAnimation() {
        return IDLE_ANIM;
    }
}