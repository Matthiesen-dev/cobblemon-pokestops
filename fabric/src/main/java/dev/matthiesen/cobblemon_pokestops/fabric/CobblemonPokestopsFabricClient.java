package dev.matthiesen.cobblemon_pokestops.fabric;

import dev.matthiesen.cobblemon_pokestops.common.CobblemonPokestopsCommon;
import net.fabricmc.api.ClientModInitializer;

public class CobblemonPokestopsFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        var instance = CobblemonPokestopsCommon.INSTANCE;
        instance.initialize();
    }
}
