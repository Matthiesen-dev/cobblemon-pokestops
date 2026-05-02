package dev.matthiesen.common.cobblemon_pokestops.client.renderer.item;

import dev.matthiesen.common.cobblemon_pokestops.client.model.item.HealingstopTrophyItemModel;
import dev.matthiesen.common.cobblemon_pokestops.item.HealingstopTrophyItem;
import software.bernie.geckolib.renderer.GeoItemRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;

public class HealingstopTrophyItemRenderer extends GeoItemRenderer<HealingstopTrophyItem> {
    public HealingstopTrophyItemRenderer() {
        super(new HealingstopTrophyItemModel());
        addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }
}
