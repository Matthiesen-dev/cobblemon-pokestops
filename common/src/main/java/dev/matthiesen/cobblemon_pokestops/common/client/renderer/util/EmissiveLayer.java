package dev.matthiesen.cobblemon_pokestops.common.client.renderer.util;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.entity.Entity;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.cache.texture.AutoGlowingTexture;
import software.bernie.geckolib.renderer.GeoRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;
import software.bernie.geckolib.util.ClientUtil;

// this is supposed to allow Emissive textures with shaders but currently it does not work...
// must investigate solutions... for now this is just a placeholder till i can revisit this and figure out a solution
public final class EmissiveLayer<T extends GeoAnimatable> extends AutoGlowingGeoLayer<T> {
    public EmissiveLayer(GeoRenderer<T> renderer) {
        super(renderer);
    }

    @Override
    protected @Nullable RenderType getRenderType(T animatable, @Nullable MultiBufferSource bufferSource) {
        var textureResource = getTextureResource(animatable);
        var emissiveTexture = AutoGlowingTexture.getEmissiveResource(textureResource);
        if (!(animatable instanceof Entity entity)) {
            return RenderType.eyes(emissiveTexture);
        }
        boolean invisible = entity.isInvisible();
        if (invisible && !entity.isInvisibleTo(ClientUtil.getClientPlayer())) {
            return RenderType.itemEntityTranslucentCull(emissiveTexture);
        }

        if (Minecraft.getInstance().shouldEntityAppearGlowing(entity)) {
            if (invisible) {
                return RenderType.outline(emissiveTexture);
            }

            return AutoGlowingTexture.getOutlineRenderType(textureResource);
        }

        return invisible ? null : RenderType.eyes(emissiveTexture);
    }
}
