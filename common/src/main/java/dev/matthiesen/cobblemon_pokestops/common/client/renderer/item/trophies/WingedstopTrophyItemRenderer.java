package dev.matthiesen.cobblemon_pokestops.common.client.renderer.item.trophies;

import dev.matthiesen.cobblemon_pokestops.common.client.model.item.trophies.WingedstopTrophyItemModel;
import dev.matthiesen.cobblemon_pokestops.common.client.renderer.util.EmissiveLayer;
import dev.matthiesen.cobblemon_pokestops.common.item.trophies.WingedstopTrophyItem;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public final class WingedstopTrophyItemRenderer extends GeoItemRenderer<WingedstopTrophyItem> {
    public WingedstopTrophyItemRenderer() {
        super(new WingedstopTrophyItemModel());
        addRenderLayer(new EmissiveLayer<>(this));
    }
}
