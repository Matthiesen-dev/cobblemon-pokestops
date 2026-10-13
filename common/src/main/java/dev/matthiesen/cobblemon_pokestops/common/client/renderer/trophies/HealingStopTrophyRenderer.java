package dev.matthiesen.cobblemon_pokestops.common.client.renderer.trophies;

import dev.matthiesen.cobblemon_pokestops.common.block.entity.trophies.HealingstopTrophyEntity;
import dev.matthiesen.cobblemon_pokestops.common.client.renderer.util.UnifiedBlockRenderer;
import dev.matthiesen.cobblemon_pokestops.common.item.trophies.HealingstopTrophyItem;

public final class HealingStopTrophyRenderer extends UnifiedBlockRenderer<HealingstopTrophyEntity, HealingstopTrophyItem> {
    public static final HealingStopTrophyRenderer INSTANCE = new HealingStopTrophyRenderer();

    public HealingStopTrophyRenderer() {
        super("healingstop_trophy", true);
    }
}
