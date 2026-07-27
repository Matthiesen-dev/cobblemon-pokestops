package dev.matthiesen.cobblemon_pokestops.common.client.renderer.item.trophies;

import dev.matthiesen.cobblemon_pokestops.common.client.model.item.trophies.PokeballstopTrophyItemModel;
import dev.matthiesen.cobblemon_pokestops.common.item.trophies.PokeballstopTrophyItem;
import software.bernie.geckolib.renderer.GeoItemRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;

public final class PokeballstopTrophyItemRenderer extends GeoItemRenderer<PokeballstopTrophyItem> {
    public PokeballstopTrophyItemRenderer() {
        super(new PokeballstopTrophyItemModel());
        addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }
}
