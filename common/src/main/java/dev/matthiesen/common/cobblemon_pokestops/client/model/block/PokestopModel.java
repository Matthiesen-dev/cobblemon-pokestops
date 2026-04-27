package dev.matthiesen.common.cobblemon_pokestops.client.model.block;

import dev.matthiesen.common.cobblemon_pokestops.Constants;
import dev.matthiesen.common.cobblemon_pokestops.block.entity.PokestopEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import software.bernie.geckolib.model.GeoModel;

public class PokestopModel extends GeoModel<PokestopEntity> {
    private final ResourceLocation model = Constants.modResource("geo/block/pokestop.geo.json");
    private final ResourceLocation animations = Constants.modResource("animations/block/pokestop.animation.json");

    private ResourceLocation getMainTexture(PokestopEntity entity) {
        String name = BuiltInRegistries.BLOCK.getKey(entity.getBlockState().getBlock()).getPath();
        return Constants.modResource("textures/block/" + name + ".png");
    }

    private ResourceLocation getCooldownTexture(PokestopEntity entity) {
        String name = BuiltInRegistries.BLOCK.getKey(entity.getBlockState().getBlock()).getPath();
        return Constants.modResource("textures/block/" + name + "_cooldown.png");
    }

    @Override
    public ResourceLocation getModelResource(PokestopEntity animatable) {
        return this.model;
    }

    @Override
    public ResourceLocation getTextureResource(PokestopEntity animatable) {
        Player player = Minecraft.getInstance().player;
        if (player != null && !animatable.canPlayerSpin(player)) {
            return getCooldownTexture(animatable);
        }
        return getMainTexture(animatable);
    }

    @Override
    public ResourceLocation getAnimationResource(PokestopEntity animatable) {
        return this.animations;
    }
}
