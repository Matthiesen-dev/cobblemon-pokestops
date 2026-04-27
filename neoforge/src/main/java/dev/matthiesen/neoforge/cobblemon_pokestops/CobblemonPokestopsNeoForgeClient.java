package dev.matthiesen.neoforge.cobblemon_pokestops;

import com.mojang.blaze3d.vertex.PoseStack;
import dev.matthiesen.common.cobblemon_pokestops.Constants;
import dev.matthiesen.common.cobblemon_pokestops.client.CobblemonPokestopsClient;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.BlockPos;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RenderHighlightEvent;

@EventBusSubscriber(modid = Constants.MOD_ID, value = Dist.CLIENT)
public class CobblemonPokestopsNeoForgeClient {
    @SubscribeEvent
    public static void registerRenderers(final EntityRenderersEvent.RegisterRenderers event) {
        CobblemonPokestopsClient.registerRenderers(event::registerEntityRenderer, event::registerBlockEntityRenderer);
    }
    @SubscribeEvent
    public static void onHighlight(RenderHighlightEvent.Block event) {
        assert Minecraft.getInstance().level != null;
        BlockPos basePos = CobblemonPokestopsClient.getBasePos(
                Minecraft.getInstance().level,
                event.getTarget().getBlockPos()
        );

        if (basePos != null) {
            event.setCanceled(true); // Stop drawing the dummy box

            // Draw the base box instead
            PoseStack poseStack = event.getPoseStack();
            MultiBufferSource buffer = event.getMultiBufferSource();
            Camera camera = event.getCamera();
            VoxelShape shape = Minecraft.getInstance().level.getBlockState(basePos).getShape(Minecraft.getInstance().level, basePos);

            LevelRenderer.renderVoxelShape(
                    poseStack, buffer.getBuffer(RenderType.lines()), shape,
                    basePos.getX() - camera.getPosition().x(),
                    basePos.getY() - camera.getPosition().y(),
                    basePos.getZ() - camera.getPosition().z(),
                    0, 0, 0, 0.4F, false
            );
        }
    }
}
