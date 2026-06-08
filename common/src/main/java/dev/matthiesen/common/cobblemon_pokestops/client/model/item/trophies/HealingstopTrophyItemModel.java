package dev.matthiesen.common.cobblemon_pokestops.client.model.item.trophies;

import dev.matthiesen.common.cobblemon_pokestops.item.trophies.HealingstopTrophyItem;
import dev.matthiesen.common.cobblemon_pokestops.templates.block.StopItemModelTemplate;

public class HealingstopTrophyItemModel extends StopItemModelTemplate<HealingstopTrophyItem> {
    @Override
    protected String getModelName() {
        return "healingstop_trophy";
    }

    @Override
    protected String getAnimationName() {
        return "healingstop_trophy";
    }
}
