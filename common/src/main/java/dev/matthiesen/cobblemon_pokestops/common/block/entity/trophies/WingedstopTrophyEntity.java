package dev.matthiesen.cobblemon_pokestops.common.block.entity.trophies;

import dev.matthiesen.cobblemon_pokestops.common.templates.entity.TrophyEntityTemplate;
import dev.matthiesen.cobblemon_pokestops.common.registry.BlockEntityRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import software.bernie.geckolib.animation.RawAnimation;

public final class WingedstopTrophyEntity extends TrophyEntityTemplate {
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