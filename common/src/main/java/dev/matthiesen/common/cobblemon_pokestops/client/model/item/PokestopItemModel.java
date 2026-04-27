package dev.matthiesen.common.cobblemon_pokestops.client.model.item;

import dev.matthiesen.common.cobblemon_pokestops.Constants;
import dev.matthiesen.common.cobblemon_pokestops.item.PokestopItem;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class PokestopItemModel extends GeoModel<PokestopItem> {
    private final ResourceLocation model = Constants.modResource("geo/block/pokestop.geo.json");
    private final ResourceLocation animations = Constants.modResource("animations/block/pokestop.animation.json");

    private ResourceLocation getMainTexture(PokestopItem entity) {
        String name = BuiltInRegistries.BLOCK.getKey(entity.getBlock()).getPath();
        return Constants.modResource("textures/block/" + name + ".png");
    }

    @Override
    public ResourceLocation getModelResource(PokestopItem animatable) {
        return this.model;
    }

    @Override
    public ResourceLocation getTextureResource(PokestopItem animatable) {
        return getMainTexture(animatable);
    }

    @Override
    public ResourceLocation getAnimationResource(PokestopItem animatable) {
        return this.animations;
    }
}
