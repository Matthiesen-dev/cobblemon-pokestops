package dev.matthiesen.common.cobblemon_pokestops.client.renderer.item.stops;

import dev.matthiesen.common.cobblemon_pokestops.client.model.item.stops.PokeballstopItemModel;
import dev.matthiesen.common.cobblemon_pokestops.item.stops.PokeballstopItem;
import software.bernie.geckolib.renderer.GeoItemRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;

public class PokeballstopItemRenderer extends GeoItemRenderer<PokeballstopItem> {
    public PokeballstopItemRenderer() {
        super(new PokeballstopItemModel());
        addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }
}
