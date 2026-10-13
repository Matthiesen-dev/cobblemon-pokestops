package dev.matthiesen.cobblemon_pokestops.common.client.renderer.stops;

import dev.matthiesen.cobblemon_pokestops.common.block.entity.stops.HealingstopEntity;
import dev.matthiesen.cobblemon_pokestops.common.client.renderer.util.UnifiedBeamBlockRenderer;
import dev.matthiesen.cobblemon_pokestops.common.item.stops.HealingstopItem;

public final class HealingStopRenderer extends UnifiedBeamBlockRenderer<HealingstopEntity, HealingstopItem> {
    public static final HealingStopRenderer INSTANCE = new HealingStopRenderer();

    public HealingStopRenderer() {
        super("healingstop", true);
    }
}
