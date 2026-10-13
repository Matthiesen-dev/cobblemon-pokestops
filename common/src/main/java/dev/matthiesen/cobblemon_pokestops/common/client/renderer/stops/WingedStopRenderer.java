package dev.matthiesen.cobblemon_pokestops.common.client.renderer.stops;

import dev.matthiesen.cobblemon_pokestops.common.block.entity.stops.WingedstopEntity;
import dev.matthiesen.cobblemon_pokestops.common.client.renderer.util.UnifiedBeamBlockRenderer;
import dev.matthiesen.cobblemon_pokestops.common.item.stops.WingedstopItem;

public final class WingedStopRenderer extends UnifiedBeamBlockRenderer<WingedstopEntity, WingedstopItem> {
    public static final WingedStopRenderer INSTANCE = new WingedStopRenderer();

    public WingedStopRenderer() {
        super("wingedstop", true);
    }
}
