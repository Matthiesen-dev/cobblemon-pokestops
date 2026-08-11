package dev.matthiesen.cobblemon_pokestops.common.client.renderer.item.stops;

import dev.matthiesen.cobblemon_pokestops.common.client.model.item.stops.WingedstopItemModel;
import dev.matthiesen.cobblemon_pokestops.common.item.stops.WingedstopItem;
import software.bernie.geckolib.renderer.GeoItemRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;

public final class WingedstopItemRenderer extends GeoItemRenderer<WingedstopItem> {
    public WingedstopItemRenderer() {
        super(new WingedstopItemModel());
        addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }
}
