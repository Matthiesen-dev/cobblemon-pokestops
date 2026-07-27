package dev.matthiesen.cobblemon_pokestops.common.client.renderer.block.stops;

import dev.matthiesen.cobblemon_pokestops.common.client.model.block.stops.PokeballstopModel;
import dev.matthiesen.cobblemon_pokestops.common.block.entity.stops.PokeballstopEntity;
import software.bernie.geckolib.renderer.GeoBlockRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;

public final class PokeballstopRenderer extends GeoBlockRenderer<PokeballstopEntity> {
    public PokeballstopRenderer() {
        super(new PokeballstopModel());
        addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }
}
