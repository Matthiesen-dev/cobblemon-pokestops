package dev.matthiesen.cobblemon_pokestops.common.templates.block;

import dev.matthiesen.cobblemon_pokestops.common.CobblemonPokestopsCommon;
import dev.matthiesen.cobblemon_pokestops.common.templates.item.StopItemTemplate;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.model.GeoModel;

public class StopItemModelTemplate<T extends StopItemTemplate> extends GeoModel<T> {
    private final String modelName;

    public StopItemModelTemplate(String modelName) {
        this.modelName = modelName;
    }

    /**
     * Subclasses must provide the model file path (e.g., "pokestop", "wingedstop").
     */
    protected String getModelName() {
        return modelName;
    }

    protected final String getAnimationName() {
        return getModelName();
    }

    protected final ResourceLocation getModelResource() {
        return CobblemonPokestopsCommon.modResource("geo/block/" + getModelName() + ".geo.json");
    }

    protected final ResourceLocation getAnimationResource() {
        return CobblemonPokestopsCommon.modResource("animations/block/" + getAnimationName() + ".animation.json");
    }

    protected final ResourceLocation getMainTexture(T animatable) {
        String name = BuiltInRegistries.BLOCK.getKey(animatable.getBlock()).getPath();
        return CobblemonPokestopsCommon.modResource("textures/block/" + name + ".png");
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
