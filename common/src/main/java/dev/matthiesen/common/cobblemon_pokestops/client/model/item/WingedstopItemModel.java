package dev.matthiesen.common.cobblemon_pokestops.client.model.item;

import dev.matthiesen.common.cobblemon_pokestops.item.WingedstopItem;
import dev.matthiesen.common.cobblemon_pokestops.templates.block.StopItemModelTemplate;

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
