package dev.matthiesen.cobblemon_pokestops.common.client.model.item.stops;

import dev.matthiesen.cobblemon_pokestops.common.item.stops.WingedstopItem;
import dev.matthiesen.cobblemon_pokestops.common.templates.block.StopItemModelTemplate;

public class WingedstopItemModel extends StopItemModelTemplate<WingedstopItem> {
    @Override
    protected String getModelName() {
        return "wingedstop";
    }

    @Override
    protected String getAnimationName() {
        return "wingedstop";
    }
}
