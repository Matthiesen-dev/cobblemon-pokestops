package dev.matthiesen.common.cobblemon_pokestops.client.model.item;

import dev.matthiesen.common.cobblemon_pokestops.item.PokestopTrophyItem;
import dev.matthiesen.common.cobblemon_pokestops.templates.block.StopItemModelTemplate;

public class PokestopTrophyItemModel extends StopItemModelTemplate<PokestopTrophyItem> {
    @Override
    protected String getModelName() {
        return "pokestop_trophy";
    }

    @Override
    protected String getAnimationName() {
        return "pokestop_trophy";
    }
}
