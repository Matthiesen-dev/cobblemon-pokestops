package dev.matthiesen.common.cobblemon_pokestops.client.model.item;

import dev.matthiesen.common.cobblemon_pokestops.Constants;
import dev.matthiesen.common.cobblemon_pokestops.item.PokestopItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class PokestopItemModel extends GeoModel<PokestopItem> {
    private final ResourceLocation model = Constants.modResource("geo/block/pokestop.geo.json");
    private final ResourceLocation texture = Constants.modResource("textures/block/pokestop.png");
    private final ResourceLocation animations = Constants.modResource("animations/block/pokestop.animation.json");
    @Override
    public ResourceLocation getModelResource(PokestopItem animatable) {
        return this.model;
    }

    @Override
    public ResourceLocation getTextureResource(PokestopItem animatable) {
        return this.texture;
    }

    @Override
    public ResourceLocation getAnimationResource(PokestopItem animatable) {
        return this.animations;
    }
}
