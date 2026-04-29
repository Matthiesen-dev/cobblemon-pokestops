package dev.matthiesen.common.cobblemon_pokestops.client.model.item;

import dev.matthiesen.common.cobblemon_pokestops.item.WingedstopTrophyItem;
import dev.matthiesen.common.cobblemon_pokestops.templates.block.StopItemModelTemplate;

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
