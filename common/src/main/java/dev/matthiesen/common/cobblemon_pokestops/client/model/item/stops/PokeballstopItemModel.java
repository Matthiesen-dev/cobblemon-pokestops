package dev.matthiesen.common.cobblemon_pokestops.client.model.item.stops;

import dev.matthiesen.common.cobblemon_pokestops.item.stops.PokeballstopItem;
import dev.matthiesen.common.cobblemon_pokestops.templates.block.StopItemModelTemplate;

public class PokeballstopItemModel extends StopItemModelTemplate<PokeballstopItem> {
    @Override
    protected String getModelName() {
        return "pokeballstop";
    }

    @Override
    protected String getAnimationName() {
        return "pokeballstop";
    }
}
