package dev.matthiesen.cobblemon_pokestops.common.client.model.item.stops;

import dev.matthiesen.cobblemon_pokestops.common.item.stops.HealingstopItem;
import dev.matthiesen.cobblemon_pokestops.common.templates.block.StopItemModelTemplate;

public class HealingstopItemModel extends StopItemModelTemplate<HealingstopItem> {
    @Override
    protected String getModelName() {
        return "healingstop";
    }

    @Override
    protected String getAnimationName() {
        return "healingstop";
    }
}
