package dev.matthiesen.common.cobblemon_pokestops.templates.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import software.bernie.geckolib.animatable.GeoBlockEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.*;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.function.Supplier;

public abstract class TrophyEntityTemplate extends BlockEntity implements GeoBlockEntity {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    public TrophyEntityTemplate(BlockPos pos, BlockState state, Supplier<? extends BlockEntityType<?>> type) {
        super(type.get(), pos, state);
    }

    /**
     * Subclasses must provide the idle-closed animation for when the stop is available.
     */
    protected abstract RawAnimation getIdleAnimation();

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, "idle", 0, this::predicate));
    }

    private PlayState predicate(AnimationState<? extends TrophyEntityTemplate> event) {
        event.getController().setAnimation(getIdleAnimation());
        return PlayState.CONTINUE;
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }
}
