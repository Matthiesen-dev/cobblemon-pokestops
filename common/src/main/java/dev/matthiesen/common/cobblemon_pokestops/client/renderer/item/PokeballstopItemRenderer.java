package dev.matthiesen.common.cobblemon_pokestops.client.renderer.item;

import dev.matthiesen.common.cobblemon_pokestops.client.model.item.PokeballstopItemModel;
import dev.matthiesen.common.cobblemon_pokestops.item.PokeballstopItem;
import software.bernie.geckolib.renderer.GeoItemRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;

public class PokeballstopItemRenderer extends GeoItemRenderer<PokeballstopItem> {
    public PokeballstopItemRenderer() {
        super(new PokeballstopItemModel());
        addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }
}
