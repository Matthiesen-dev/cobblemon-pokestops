package dev.matthiesen.cobblemon_pokestops.common.client.renderer.stops;

import dev.matthiesen.cobblemon_pokestops.common.block.entity.stops.PokestopEntity;
import dev.matthiesen.cobblemon_pokestops.common.client.renderer.util.UnifiedBeamBlockRenderer;
import dev.matthiesen.cobblemon_pokestops.common.item.stops.PokestopItem;

public final class PokeStopRenderer extends UnifiedBeamBlockRenderer<PokestopEntity, PokestopItem> {
    public static final PokeStopRenderer INSTANCE = new PokeStopRenderer();

    public PokeStopRenderer() {
        super("pokestop");
    }
}
