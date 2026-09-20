package dev.matthiesen.cobblemon_pokestops.common.client.renderer.block.stops;

import com.mojang.blaze3d.vertex.PoseStack;
import dev.matthiesen.cobblemon_pokestops.common.client.model.block.stops.PokeballstopModel;
import dev.matthiesen.cobblemon_pokestops.common.block.entity.stops.PokeballstopEntity;
import dev.matthiesen.cobblemon_pokestops.common.client.renderer.util.BeamRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import software.bernie.geckolib.renderer.GeoBlockRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;

public final class PokeballstopRenderer extends GeoBlockRenderer<PokeballstopEntity> {
    public PokeballstopRenderer() {
        super(new PokeballstopModel());
        addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }

    @Override
    @SuppressWarnings("UnstableApiUsage")
    public void render(PokeballstopEntity animatable, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, int packedOverlay) {
        super.render(animatable, partialTick, poseStack, bufferSource, packedLight, packedOverlay);
        BeamRenderer.render(animatable, partialTick, poseStack, bufferSource);
    }
}
