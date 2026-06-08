package dev.matthiesen.common.cobblemon_pokestops.client.renderer.item.trophies;

import dev.matthiesen.common.cobblemon_pokestops.client.model.item.trophies.PokeballstopTrophyItemModel;
import dev.matthiesen.common.cobblemon_pokestops.item.trophies.PokeballstopTrophyItem;
import software.bernie.geckolib.renderer.GeoItemRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;

public class PokeballstopTrophyItemRenderer extends GeoItemRenderer<PokeballstopTrophyItem> {
    public PokeballstopTrophyItemRenderer() {
        super(new PokeballstopTrophyItemModel());
        addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }
}
