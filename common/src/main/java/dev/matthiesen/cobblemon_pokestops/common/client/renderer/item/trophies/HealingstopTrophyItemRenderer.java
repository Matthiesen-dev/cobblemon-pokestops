package dev.matthiesen.cobblemon_pokestops.common.client.renderer.item.trophies;

import dev.matthiesen.cobblemon_pokestops.common.client.model.item.trophies.HealingstopTrophyItemModel;
import dev.matthiesen.cobblemon_pokestops.common.client.renderer.util.EmissiveLayer;
import dev.matthiesen.cobblemon_pokestops.common.item.trophies.HealingstopTrophyItem;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public final class HealingstopTrophyItemRenderer extends GeoItemRenderer<HealingstopTrophyItem> {
    public HealingstopTrophyItemRenderer() {
        super(new HealingstopTrophyItemModel());
        addRenderLayer(new EmissiveLayer<>(this));
    }
}
