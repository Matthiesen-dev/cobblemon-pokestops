package dev.matthiesen.common.cobblemon_pokestops.client.renderer.item;

import dev.matthiesen.common.cobblemon_pokestops.client.model.item.WingedstopItemModel;
import dev.matthiesen.common.cobblemon_pokestops.item.WingedstopItem;
import software.bernie.geckolib.renderer.GeoItemRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;

public class WingedstopItemRenderer extends GeoItemRenderer<WingedstopItem> {
    public WingedstopItemRenderer() {
        super(new WingedstopItemModel());
        addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }
}
