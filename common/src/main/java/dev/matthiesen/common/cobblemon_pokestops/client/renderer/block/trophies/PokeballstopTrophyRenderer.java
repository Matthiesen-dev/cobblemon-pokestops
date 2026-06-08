package dev.matthiesen.common.cobblemon_pokestops.client.renderer.block.trophies;

import dev.matthiesen.common.cobblemon_pokestops.block.entity.trophies.PokeballstopTrophyEntity;
import dev.matthiesen.common.cobblemon_pokestops.client.model.block.trophies.PokeballstopTrophyModel;
import software.bernie.geckolib.renderer.GeoBlockRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;

public class PokeballstopTrophyRenderer extends GeoBlockRenderer<PokeballstopTrophyEntity> {
    public PokeballstopTrophyRenderer() {
        super(new PokeballstopTrophyModel());
        addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }
}
