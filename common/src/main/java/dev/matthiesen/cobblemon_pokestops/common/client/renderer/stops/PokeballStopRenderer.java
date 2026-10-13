package dev.matthiesen.cobblemon_pokestops.common.client.renderer.stops;

import dev.matthiesen.cobblemon_pokestops.common.block.entity.stops.PokeballstopEntity;
import dev.matthiesen.cobblemon_pokestops.common.client.renderer.util.UnifiedBeamBlockRenderer;
import dev.matthiesen.cobblemon_pokestops.common.item.stops.PokeballstopItem;

public final class PokeballStopRenderer extends UnifiedBeamBlockRenderer<PokeballstopEntity, PokeballstopItem> {
    public static final PokeballStopRenderer INSTANCE = new PokeballStopRenderer();

    public PokeballStopRenderer() {
        super("pokeballstop", true);
    }
}
