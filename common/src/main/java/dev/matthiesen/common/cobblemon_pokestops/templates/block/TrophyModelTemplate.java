package dev.matthiesen.common.cobblemon_pokestops.templates.block;

import dev.matthiesen.common.cobblemon_pokestops.Constants;
import dev.matthiesen.common.cobblemon_pokestops.templates.entity.TrophyEntityTemplate;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.model.GeoModel;

public abstract class TrophyModelTemplate<T extends TrophyEntityTemplate> extends GeoModel<T> {
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

    protected final ResourceLocation getMainTexture(T entity) {
        String name = BuiltInRegistries.BLOCK.getKey(entity.getBlockState().getBlock()).getPath();
        return Constants.modResource("textures/block/" + name + ".png");
    }

    @Override
    public @NotNull ResourceLocation getModelResource(T animatable) {
        return getModelResource();
    }

    @Override
    public @NotNull ResourceLocation getAnimationResource(T animatable) {
        return getAnimationResource();
    }
}
