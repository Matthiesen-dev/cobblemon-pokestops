package dev.matthiesen.cobblemon_pokestops.common.client.renderer.util;

import com.mojang.blaze3d.vertex.PoseStack;
import dev.matthiesen.cobblemon_pokestops.common.config.PokestopsConfig;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BeaconRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.entity.BlockEntity;

public final class BeamRenderer {
    public interface BeamEntity {
        int getBeamColor();
        int getBlockHeight();
    }

    public static final ResourceLocation BEAM_TEXTURE = BeaconRenderer.BEAM_LOCATION; // Vanilla beam texture: minecraft:textures/entity/beacon_beam.png
    public static final float BEAM_SCALE = 0.75F;
    public static final int BEAM_HEIGHT_LIMIT = 256;
    public static final float BEAM_INNER_RADIUS = 0.15F;
    public static final float BEAM_OUTER_RADIUS = 0.2F;

    public static <T extends BlockEntity & BeamEntity> void render(T animatable, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource) {
        if (animatable.getLevel() == null || !PokestopsConfig.CLIENT_CONFIG.pokestopBeaconBeamsEnabled.getAsBoolean()) return;
        var player = Minecraft.getInstance().player;
        if (player == null) return;
        final double maxDistance = PokestopsConfig.CLIENT_CONFIG.pokestopBeaconHideDistance.getAsDouble();
        final double maxDistanceSqr = maxDistance * maxDistance;
        var pos = animatable.getBlockPos();
        if (player.distanceToSqr(
                pos.getX() + 0.5D,
                pos.getY() + 0.5D,
                pos.getZ() + 0.5D
        ) < maxDistanceSqr) {
            return; // Too close: hide beam
        }
        BeaconRenderer.renderBeaconBeam(
                poseStack,
                bufferSource,
                BEAM_TEXTURE,
                partialTick,
                BEAM_SCALE,
                animatable.getLevel().getGameTime(),
                animatable.getBlockHeight(),
                BEAM_HEIGHT_LIMIT,
                animatable.getBeamColor(),
                BEAM_INNER_RADIUS,
                BEAM_OUTER_RADIUS
        );
    }
}
