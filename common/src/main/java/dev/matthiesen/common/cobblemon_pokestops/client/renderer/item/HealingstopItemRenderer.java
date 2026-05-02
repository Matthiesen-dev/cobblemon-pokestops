package dev.matthiesen.common.cobblemon_pokestops.client.renderer.item;

import dev.matthiesen.common.cobblemon_pokestops.client.model.item.HealingstopItemModel;
import dev.matthiesen.common.cobblemon_pokestops.item.HealingstopItem;
import software.bernie.geckolib.renderer.GeoItemRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;

public class HealingstopItemRenderer extends GeoItemRenderer<HealingstopItem> {
    public HealingstopItemRenderer() {
        super(new HealingstopItemModel());
        addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }
}
