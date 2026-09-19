package dev.matthiesen.cobblemon_pokestops.common.client.renderer.util;

import com.mojang.blaze3d.vertex.PoseStack;
import dev.matthiesen.cobblemon_pokestops.common.config.PokestopsConfig;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BeaconRenderer;
import net.minecraft.world.level.block.entity.BlockEntity;

public final class BeamRenderer {
    public interface BeamEntity {
        int getBeamColor();
        int getBlockHeight();
    }

    public static <T extends BlockEntity & BeamEntity> void render(T animatable, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, int packedOverlay) {
        if (animatable.getLevel() == null || !PokestopsConfig.CLIENT_CONFIG.pokestopBeaconBeamsEnabled.getAsBoolean()) return;
        var player = Minecraft.getInstance().player;
        if (player == null) return;
        // Compare squared distance to avoid sqrt
        final double maxDistance = 12.0D;
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
                BeaconRenderer.BEAM_LOCATION, // Vanilla beam texture: minecraft:textures/entity/beacon_beam.png
                partialTick,
                0.75F,                     // Scale factor (1.0F is standard beacon thickness)
                animatable.getLevel().getGameTime(),
                animatable.getBlockHeight(),  // Base Y level offset inside the segment calculation
                256,                          // Height limit of the segment
                animatable.getBeamColor(),
                0.15F,                     // Inner beam radius (Vanilla standard = 0.2F)
                0.2F                          // Outer beam radius (Vanilla standard = 0.25F)
        );
    }
}
