package dev.matthiesen.cobblemon_pokestops.common.client.model.item.trophies;

import dev.matthiesen.cobblemon_pokestops.common.item.trophies.WingedstopTrophyItem;
import dev.matthiesen.cobblemon_pokestops.common.templates.block.StopItemModelTemplate;

public class WingedstopTrophyItemModel extends StopItemModelTemplate<WingedstopTrophyItem> {
    @Override
    protected String getModelName() {
        return "wingedstop_trophy";
    }

    @Override
    protected String getAnimationName() {
        return "wingedstop_trophy";
    }
}
