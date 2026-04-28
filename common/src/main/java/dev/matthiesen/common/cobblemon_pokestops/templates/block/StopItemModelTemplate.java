package dev.matthiesen.common.cobblemon_pokestops.templates.block;

import dev.matthiesen.common.cobblemon_pokestops.Constants;
import dev.matthiesen.common.cobblemon_pokestops.templates.item.StopItemTemplate;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.model.GeoModel;

public abstract class StopItemModelTemplate<T extends StopItemTemplate> extends GeoModel<T> {
    /**
     * Subclasses must provide the model file path (e.g., "pokestop", "wingedstop").
     */
    protected abstract String getModelName();

    /**
     * Subclasses must provide the animation file path (e.g., "pokestop", "wingedstop").
     */
    protected abstract String getAnimationName();

    protected final ResourceLocation getModelResource() {
        return Constants.modResource("geo/block/" + getModelName() + ".geo.json");
    }

    protected final ResourceLocation getAnimationResource() {
        return Constants.modResource("animations/block/" + getAnimationName() + ".animation.json");
    }

    protected final ResourceLocation getMainTexture(T animatable) {
        String name = BuiltInRegistries.BLOCK.getKey(animatable.getBlock()).getPath();
        return Constants.modResource("textures/block/" + name + ".png");
    }

    @Override
    public @NotNull ResourceLocation getModelResource(T animatable) {
        return getModelResource();
    }

    @Override
    public @NotNull ResourceLocation getTextureResource(T animatable) {
        return getMainTexture(animatable);
    }

    @Override
    public @NotNull ResourceLocation getAnimationResource(T animatable) {
        return getAnimationResource();
    }
}
