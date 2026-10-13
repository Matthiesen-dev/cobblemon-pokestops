package dev.matthiesen.cobblemon_pokestops.common.client.renderer.item.stops;

import dev.matthiesen.cobblemon_pokestops.common.client.renderer.util.EmissiveLayer;
import dev.matthiesen.cobblemon_pokestops.common.item.stops.WingedstopItem;
import dev.matthiesen.cobblemon_pokestops.common.templates.block.StopItemModelTemplate;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public final class WingedstopItemRenderer extends GeoItemRenderer<WingedstopItem> {
    public WingedstopItemRenderer() {
        super(new StopItemModelTemplate<>("wingedstop"));
        addRenderLayer(new EmissiveLayer<>(this));
    }
}
