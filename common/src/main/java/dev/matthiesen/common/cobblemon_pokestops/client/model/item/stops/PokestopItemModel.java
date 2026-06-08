package dev.matthiesen.common.cobblemon_pokestops.client.model.item.stops;

import dev.matthiesen.common.cobblemon_pokestops.item.stops.PokestopItem;
import dev.matthiesen.common.cobblemon_pokestops.templates.block.StopItemModelTemplate;

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
