package dev.matthiesen.cobblemon_pokestops.common.client.renderer.item.stops;

import dev.matthiesen.cobblemon_pokestops.common.client.model.item.stops.HealingstopItemModel;
import dev.matthiesen.cobblemon_pokestops.common.item.stops.HealingstopItem;
import software.bernie.geckolib.renderer.GeoItemRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;

public class HealingstopItemRenderer extends GeoItemRenderer<HealingstopItem> {
    public HealingstopItemRenderer() {
        super(new HealingstopItemModel());
        addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }
}
