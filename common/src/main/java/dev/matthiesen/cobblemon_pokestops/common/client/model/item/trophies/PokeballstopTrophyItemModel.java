package dev.matthiesen.cobblemon_pokestops.common.client.model.item.trophies;

import dev.matthiesen.cobblemon_pokestops.common.item.trophies.PokeballstopTrophyItem;
import dev.matthiesen.cobblemon_pokestops.common.templates.block.StopItemModelTemplate;

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
