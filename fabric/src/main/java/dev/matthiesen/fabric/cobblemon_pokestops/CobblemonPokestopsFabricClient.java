package dev.matthiesen.fabric.cobblemon_pokestops;

import dev.matthiesen.common.cobblemon_pokestops.client.CobblemonPokestopsClient;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;

public class CobblemonPokestopsFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        CobblemonPokestopsClient.registerRenderers(EntityRendererRegistry::register, BlockEntityRenderers::register);
    }
}
