package dev.matthiesen.cobblemon_pokestops.common.client.model.item.trophies;

import dev.matthiesen.cobblemon_pokestops.common.item.trophies.PokestopTrophyItem;
import dev.matthiesen.cobblemon_pokestops.common.templates.block.StopItemModelTemplate;

public final class PokestopTrophyItemModel extends StopItemModelTemplate<PokestopTrophyItem> {
    @Override
    protected String getModelName() {
        return "pokestop_trophy";
    }

    @Override
    protected String getAnimationName() {
        return "pokestop_trophy";
    }
}
