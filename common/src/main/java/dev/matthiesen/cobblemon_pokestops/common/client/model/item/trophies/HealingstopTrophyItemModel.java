package dev.matthiesen.cobblemon_pokestops.common.client.model.item.trophies;

import dev.matthiesen.cobblemon_pokestops.common.item.trophies.HealingstopTrophyItem;
import dev.matthiesen.cobblemon_pokestops.common.templates.block.StopItemModelTemplate;

public final class HealingstopTrophyItemModel extends StopItemModelTemplate<HealingstopTrophyItem> {
    @Override
    protected String getModelName() {
        return "healingstop_trophy";
    }

    @Override
    protected String getAnimationName() {
        return "healingstop_trophy";
    }
}
