package dev.matthiesen.cobblemon_pokestops.common.client.renderer.trophies;

import dev.matthiesen.cobblemon_pokestops.common.block.entity.trophies.PokestopTrophyEntity;
import dev.matthiesen.cobblemon_pokestops.common.client.renderer.util.UnifiedBlockRenderer;
import dev.matthiesen.cobblemon_pokestops.common.item.trophies.PokestopTrophyItem;

public final class PokeStopTrophyRenderer extends UnifiedBlockRenderer<PokestopTrophyEntity, PokestopTrophyItem> {
    public static final PokeStopTrophyRenderer INSTANCE = new PokeStopTrophyRenderer();

    public PokeStopTrophyRenderer() {
        super("pokestop_trophy");
    }
}
