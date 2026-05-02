package dev.matthiesen.common.cobblemon_pokestops.client.model.item;

import dev.matthiesen.common.cobblemon_pokestops.item.HealingstopItem;
import dev.matthiesen.common.cobblemon_pokestops.templates.block.StopItemModelTemplate;

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
