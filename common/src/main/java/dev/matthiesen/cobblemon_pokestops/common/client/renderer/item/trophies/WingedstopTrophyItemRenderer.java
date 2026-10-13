package dev.matthiesen.cobblemon_pokestops.common.client.renderer.item.trophies;

import dev.matthiesen.cobblemon_pokestops.common.client.renderer.util.EmissiveLayer;
import dev.matthiesen.cobblemon_pokestops.common.item.trophies.WingedstopTrophyItem;
import dev.matthiesen.cobblemon_pokestops.common.templates.block.StopItemModelTemplate;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public final class WingedstopTrophyItemRenderer extends GeoItemRenderer<WingedstopTrophyItem> {
    public WingedstopTrophyItemRenderer() {
        super(new StopItemModelTemplate<>("wingedstop_trophy"));
        addRenderLayer(new EmissiveLayer<>(this));
    }
}
