package dev.matthiesen.cobblemon_pokestops.common.client.renderer.trophies;

import dev.matthiesen.cobblemon_pokestops.common.block.entity.trophies.PokeballstopTrophyEntity;
import dev.matthiesen.cobblemon_pokestops.common.client.renderer.util.UnifiedBlockRenderer;
import dev.matthiesen.cobblemon_pokestops.common.item.trophies.PokeballstopTrophyItem;

public final class PokeballStopTrophyRenderer extends UnifiedBlockRenderer<PokeballstopTrophyEntity, PokeballstopTrophyItem> {
    public static final PokeballStopTrophyRenderer INSTANCE = new PokeballStopTrophyRenderer();

    public PokeballStopTrophyRenderer() {
        super("pokeballstop_trophy", true);
    }
}
