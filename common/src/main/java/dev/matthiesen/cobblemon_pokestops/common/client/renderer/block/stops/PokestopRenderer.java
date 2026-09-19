package dev.matthiesen.cobblemon_pokestops.common.client.renderer.block.stops;

import com.mojang.blaze3d.vertex.PoseStack;
import dev.matthiesen.cobblemon_pokestops.common.client.model.block.stops.PokestopModel;
import dev.matthiesen.cobblemon_pokestops.common.block.entity.stops.PokestopEntity;
import dev.matthiesen.cobblemon_pokestops.common.client.renderer.util.BeamRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public final class PokestopRenderer extends GeoBlockRenderer<PokestopEntity> {
    public PokestopRenderer() {
        super(new PokestopModel());
    }

    @Override
    @SuppressWarnings("UnstableApiUsage")
    public void render(PokestopEntity animatable, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, int packedOverlay) {
        super.render(animatable, partialTick, poseStack, bufferSource, packedLight, packedOverlay);
        BeamRenderer.render(animatable, partialTick, poseStack, bufferSource, packedLight, packedOverlay);
    }
}
