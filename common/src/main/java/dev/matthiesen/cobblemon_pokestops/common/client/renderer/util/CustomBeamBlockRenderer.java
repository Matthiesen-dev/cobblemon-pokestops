package dev.matthiesen.cobblemon_pokestops.common.client.renderer.util;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.world.level.block.entity.BlockEntity;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.model.GeoModel;

public class CustomBeamBlockRenderer<T extends BlockEntity & GeoAnimatable & BeamRenderer.BeamEntity> extends CustomBlockRenderer<T> {
    public CustomBeamBlockRenderer(GeoModel<T> model) {
        super(model);
    }

    @Override
    @SuppressWarnings("UnstableApiUsage")
    public void render(T animatable, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, int packedOverlay) {
        super.render(animatable, partialTick, poseStack, bufferSource, packedLight, packedOverlay);
        BeamRenderer.render(animatable, partialTick, poseStack, bufferSource);
    }
}
