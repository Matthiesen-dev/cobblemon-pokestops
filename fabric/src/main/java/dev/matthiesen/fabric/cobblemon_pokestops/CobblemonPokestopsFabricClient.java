package dev.matthiesen.fabric.cobblemon_pokestops;

import dev.matthiesen.common.cobblemon_pokestops.client.CobblemonPokestopsClient;
import net.fabricmc.api.ClientModInitializer;

public class CobblemonPokestopsFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        CobblemonPokestopsClient.initializeRenderers();
    }
}
