package dev.matthiesen.cobblemon_pokestops.common.client.renderer.item.trophies;

import dev.matthiesen.cobblemon_pokestops.common.client.renderer.util.EmissiveLayer;
import dev.matthiesen.cobblemon_pokestops.common.item.trophies.HealingstopTrophyItem;
import dev.matthiesen.cobblemon_pokestops.common.templates.block.StopItemModelTemplate;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public final class HealingstopTrophyItemRenderer extends GeoItemRenderer<HealingstopTrophyItem> {
    public HealingstopTrophyItemRenderer() {
        super(new StopItemModelTemplate<>("healingstop_trophy"));
        addRenderLayer(new EmissiveLayer<>(this));
    }
}
