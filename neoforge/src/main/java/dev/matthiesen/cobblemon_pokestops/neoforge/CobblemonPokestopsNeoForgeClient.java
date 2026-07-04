package dev.matthiesen.cobblemon_pokestops.neoforge;

import dev.matthiesen.cobblemon_pokestops.common.CobblemonPokestopsCommon;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

@EventBusSubscriber(modid = CobblemonPokestopsCommon.MOD_ID, value = Dist.CLIENT)
public class CobblemonPokestopsNeoForgeClient {
    @SubscribeEvent
    public static void registerRenderers(final EntityRenderersEvent.RegisterRenderers event) {
        CobblemonPokestopsCommon.INSTANCE.initialize();
    }
}
