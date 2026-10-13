package dev.matthiesen.cobblemon_pokestops.common.client.renderer.trophies;

import dev.matthiesen.cobblemon_pokestops.common.block.entity.trophies.WingedstopTrophyEntity;
import dev.matthiesen.cobblemon_pokestops.common.client.renderer.util.UnifiedBlockRenderer;
import dev.matthiesen.cobblemon_pokestops.common.item.trophies.WingedstopTrophyItem;

public final class WingedStopTrophyRenderer extends UnifiedBlockRenderer<WingedstopTrophyEntity, WingedstopTrophyItem> {
    public static final WingedStopTrophyRenderer INSTANCE = new WingedStopTrophyRenderer();

    public WingedStopTrophyRenderer() {
        super("wingedstop_trophy", true);
    }
}
