package dev.matthiesen.cobblemon_pokestops.common.client.renderer.item.stops;

import dev.matthiesen.cobblemon_pokestops.common.client.renderer.util.EmissiveLayer;
import dev.matthiesen.cobblemon_pokestops.common.item.stops.HealingstopItem;
import dev.matthiesen.cobblemon_pokestops.common.templates.block.StopItemModelTemplate;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public final class HealingstopItemRenderer extends GeoItemRenderer<HealingstopItem> {
    public HealingstopItemRenderer() {
        super(new StopItemModelTemplate<>("healingstop"));
        addRenderLayer(new EmissiveLayer<>(this));
    }
}
