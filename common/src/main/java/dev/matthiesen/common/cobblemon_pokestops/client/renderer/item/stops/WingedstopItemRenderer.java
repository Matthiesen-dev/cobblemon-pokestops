package dev.matthiesen.common.cobblemon_pokestops.client.renderer.item.stops;

import dev.matthiesen.common.cobblemon_pokestops.client.model.item.stops.WingedstopItemModel;
import dev.matthiesen.common.cobblemon_pokestops.item.stops.WingedstopItem;
import software.bernie.geckolib.renderer.GeoItemRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;

public class WingedstopItemRenderer extends GeoItemRenderer<WingedstopItem> {
    public WingedstopItemRenderer() {
        super(new WingedstopItemModel());
        addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }
}
