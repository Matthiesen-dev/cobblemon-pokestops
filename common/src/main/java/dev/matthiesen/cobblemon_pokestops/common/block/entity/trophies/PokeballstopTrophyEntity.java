package dev.matthiesen.cobblemon_pokestops.common.block.entity.trophies;

import dev.matthiesen.cobblemon_pokestops.common.templates.entity.TrophyEntityTemplate;
import dev.matthiesen.cobblemon_pokestops.common.registry.BlockEntityRegistry;
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