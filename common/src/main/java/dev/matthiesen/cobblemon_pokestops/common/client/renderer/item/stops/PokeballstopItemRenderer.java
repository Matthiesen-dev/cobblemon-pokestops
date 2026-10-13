package dev.matthiesen.cobblemon_pokestops.common.client.renderer.item.stops;

import dev.matthiesen.cobblemon_pokestops.common.client.model.item.stops.PokeballstopItemModel;
import dev.matthiesen.cobblemon_pokestops.common.client.renderer.util.EmissiveLayer;
import dev.matthiesen.cobblemon_pokestops.common.item.stops.PokeballstopItem;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public final class PokeballstopItemRenderer extends GeoItemRenderer<PokeballstopItem> {
    public PokeballstopItemRenderer() {
        super(new PokeballstopItemModel());
        addRenderLayer(new EmissiveLayer<>(this));
    }
}
