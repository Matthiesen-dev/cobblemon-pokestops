package dev.matthiesen.common.cobblemon_pokestops.client.renderer.block;

import dev.matthiesen.common.cobblemon_pokestops.block.entity.PokeballstopEntity;
import dev.matthiesen.common.cobblemon_pokestops.client.model.block.PokeballstopModel;
import software.bernie.geckolib.renderer.GeoBlockRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;

public class PokeballstopRenderer extends GeoBlockRenderer<PokeballstopEntity> {
    public PokeballstopRenderer() {
        super(new PokeballstopModel());
        addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }
}
