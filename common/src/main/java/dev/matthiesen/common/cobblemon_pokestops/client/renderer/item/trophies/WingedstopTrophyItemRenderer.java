package dev.matthiesen.common.cobblemon_pokestops.client.renderer.item.trophies;

import dev.matthiesen.common.cobblemon_pokestops.client.model.item.trophies.WingedstopTrophyItemModel;
import dev.matthiesen.common.cobblemon_pokestops.item.trophies.WingedstopTrophyItem;
import software.bernie.geckolib.renderer.GeoItemRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;

public class WingedstopTrophyItemRenderer extends GeoItemRenderer<WingedstopTrophyItem> {
    public WingedstopTrophyItemRenderer() {
        super(new WingedstopTrophyItemModel());
        addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }
}
