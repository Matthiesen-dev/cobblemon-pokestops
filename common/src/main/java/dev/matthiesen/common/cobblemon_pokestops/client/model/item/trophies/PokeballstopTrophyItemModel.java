package dev.matthiesen.common.cobblemon_pokestops.client.model.item.trophies;

import dev.matthiesen.common.cobblemon_pokestops.item.trophies.PokeballstopTrophyItem;
import dev.matthiesen.common.cobblemon_pokestops.templates.block.StopItemModelTemplate;

public class PokeballstopTrophyItemModel extends StopItemModelTemplate<PokeballstopTrophyItem> {
    @Override
    protected String getModelName() {
        return "pokeballstop_trophy";
    }

    @Override
    protected String getAnimationName() {
        return "pokeballstop_trophy";
    }
}
