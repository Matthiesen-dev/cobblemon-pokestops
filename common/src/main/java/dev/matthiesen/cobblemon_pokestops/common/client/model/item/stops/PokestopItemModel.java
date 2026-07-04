package dev.matthiesen.cobblemon_pokestops.common.client.model.item.stops;

import dev.matthiesen.cobblemon_pokestops.common.item.stops.PokestopItem;
import dev.matthiesen.cobblemon_pokestops.common.templates.block.StopItemModelTemplate;

public class PokestopItemModel extends StopItemModelTemplate<PokestopItem> {
    @Override
    protected String getModelName() {
        return "pokestop";
    }

    @Override
    protected String getAnimationName() {
        return "pokestop";
    }
}
