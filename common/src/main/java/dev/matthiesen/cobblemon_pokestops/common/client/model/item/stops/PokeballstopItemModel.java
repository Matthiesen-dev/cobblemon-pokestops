package dev.matthiesen.cobblemon_pokestops.common.client.model.item.stops;

import dev.matthiesen.cobblemon_pokestops.common.item.stops.PokeballstopItem;
import dev.matthiesen.cobblemon_pokestops.common.templates.block.StopItemModelTemplate;

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
