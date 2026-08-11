package dev.matthiesen.cobblemon_pokestops.neoforge;

import dev.matthiesen.cobblemon_pokestops.common.CobblemonPokestopsCommon;
import dev.matthiesen.cobblemon_pokestops.common.CobblemonPokestopsCommonClient;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

@Mod(value = CobblemonPokestopsCommon.MOD_ID, dist = Dist.CLIENT)
public final class CobblemonPokestopsNeoForgeClient {
    public static final CobblemonPokestopsCommonClient INSTANCE = CobblemonPokestopsCommonClient.INSTANCE;

    public CobblemonPokestopsNeoForgeClient(IEventBus modBus) {
        modBus.addListener(this::registerRenderers);
        INSTANCE.initialize();
    }

    public void registerRenderers(final EntityRenderersEvent.RegisterRenderers event) {
        INSTANCE.initializeRenderers();
    }
}
