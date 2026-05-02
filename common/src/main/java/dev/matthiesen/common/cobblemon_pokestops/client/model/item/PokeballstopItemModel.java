package dev.matthiesen.common.cobblemon_pokestops.client.model.item;

import dev.matthiesen.common.cobblemon_pokestops.item.PokeballstopItem;
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
