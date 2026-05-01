package dev.matthiesen.common.cobblemon_pokestops.block.entity;

import dev.matthiesen.common.cobblemon_pokestops.registry.BlockEntityRegistry;
import dev.matthiesen.common.cobblemon_pokestops.templates.entity.TrophyEntityTemplate;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import software.bernie.geckolib.animation.RawAnimation;

public class PokeballstopTrophyEntity extends TrophyEntityTemplate {
    private static final RawAnimation IDLE_ANIM = RawAnimation.begin()
            .thenLoop("animation.pokeballstop_trophy.idle_closed");

    public PokeballstopTrophyEntity(BlockPos pos, BlockState state) {
        super(pos, state, BlockEntityRegistry.POKEBALLSTOP_TROPHY_BE);
    }

    @Override
    protected RawAnimation getIdleAnimation() {
        return IDLE_ANIM;
    }
}