package dev.matthiesen.fabric.cobblemon_pokestops;

import dev.matthiesen.common.cobblemon_pokestops.CobblemonPokestops;
import dev.matthiesen.common.cobblemon_pokestops.client.CobblemonPokestopsClient;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.WorldRenderEvents;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.Objects;

public class CobblemonPokestopsFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        CobblemonPokestops.clientPreinitialize();
        CobblemonPokestopsClient.registerRenderers(EntityRendererRegistry::register, BlockEntityRenderers::register);
        WorldRenderEvents.BEFORE_BLOCK_OUTLINE.register((context, hitResult) -> {
            if (hitResult instanceof BlockHitResult blockHit) {
                BlockPos basePos = CobblemonPokestopsClient.getBasePos(context.world(), blockHit.getBlockPos());
                if (basePos != null) {
                    // 1. Manually render the highlight at the base position
                    BlockState baseState = context.world().getBlockState(basePos);
                    VoxelShape shape = baseState.getShape(context.world(), basePos);

                    // Minecraft uses camera-relative coordinates for world rendering
                    double x = basePos.getX() - context.camera().getPosition().x();
                    double y = basePos.getY() - context.camera().getPosition().y();
                    double z = basePos.getZ() - context.camera().getPosition().z();

                    LevelRenderer.renderVoxelShape(
                            context.matrixStack(),
                            Objects.requireNonNull(context.consumers()).getBuffer(RenderType.lines()),
                            shape,
                            x, y, z,
                            0.0F, 0.0F, 0.0F, 0.4F, false
                    );
                    return false;
                }
            }
            return true;
        });
    }
}
