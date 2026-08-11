package dev.matthiesen.cobblemon_pokestops.common.client.renderer.block.trophies;

import dev.matthiesen.cobblemon_pokestops.common.client.model.block.trophies.PokeballstopTrophyModel;
import dev.matthiesen.cobblemon_pokestops.common.block.entity.trophies.PokeballstopTrophyEntity;
import software.bernie.geckolib.renderer.GeoBlockRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;

public final class PokeballstopTrophyRenderer extends GeoBlockRenderer<PokeballstopTrophyEntity> {
    public PokeballstopTrophyRenderer() {
        super(new PokeballstopTrophyModel());
        addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }
}
