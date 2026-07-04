package dev.matthiesen.cobblemon_pokestops.common.client.renderer.item.trophies;

import dev.matthiesen.cobblemon_pokestops.common.client.model.item.trophies.WingedstopTrophyItemModel;
import dev.matthiesen.cobblemon_pokestops.common.item.trophies.WingedstopTrophyItem;
import software.bernie.geckolib.renderer.GeoItemRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;

public class WingedstopTrophyItemRenderer extends GeoItemRenderer<WingedstopTrophyItem> {
    public WingedstopTrophyItemRenderer() {
        super(new WingedstopTrophyItemModel());
        addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }
}
