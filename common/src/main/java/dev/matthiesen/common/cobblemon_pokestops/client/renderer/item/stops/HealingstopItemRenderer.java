package dev.matthiesen.common.cobblemon_pokestops.client.renderer.item.stops;

import dev.matthiesen.common.cobblemon_pokestops.client.model.item.stops.HealingstopItemModel;
import dev.matthiesen.common.cobblemon_pokestops.item.stops.HealingstopItem;
import software.bernie.geckolib.renderer.GeoItemRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;

public class HealingstopItemRenderer extends GeoItemRenderer<HealingstopItem> {
    public HealingstopItemRenderer() {
        super(new HealingstopItemModel());
        addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }
}
