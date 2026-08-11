package dev.matthiesen.cobblemon_pokestops.fabric;

import dev.matthiesen.cobblemon_pokestops.common.CobblemonPokestopsCommonClient;
import net.fabricmc.api.ClientModInitializer;

public final class CobblemonPokestopsFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        var instance = CobblemonPokestopsCommonClient.INSTANCE;
        instance.initialize();
        instance.initializeRenderers();
    }
}
