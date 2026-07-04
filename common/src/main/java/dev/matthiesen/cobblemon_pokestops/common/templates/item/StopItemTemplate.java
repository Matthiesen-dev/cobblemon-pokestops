package dev.matthiesen.cobblemon_pokestops.common.templates.item;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import org.apache.commons.lang3.mutable.MutableObject;
import software.bernie.geckolib.animatable.*;
import software.bernie.geckolib.animatable.client.GeoRenderProvider;
import software.bernie.geckolib.animatable.instance.*;
import software.bernie.geckolib.animation.*;

import java.util.function.Consumer;

public abstract class StopItemTemplate extends BlockItem implements GeoItem {
    private final AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);

    /**
     * Holds the GeoRenderProvider that is provided via Client side initialization.
     */
    public final MutableObject<GeoRenderProvider> renderProviderHolder = new MutableObject<>();

    public StopItemTemplate(Block block, Properties properties) {
        super(block, properties);
        SingletonGeoAnimatable.registerSyncedAnimatable(this);
    }

    /**
     * Subclasses must provide the idle animation for this stop item.
     */
    protected abstract RawAnimation getIdleAnimation();

    @Override
    public void createGeoRenderer(Consumer<GeoRenderProvider> consumer) {
        // Return the cached RenderProvider
        consumer.accept(this.renderProviderHolder.getValue());
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, state -> state.setAndContinue(getIdleAnimation())));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }
}
