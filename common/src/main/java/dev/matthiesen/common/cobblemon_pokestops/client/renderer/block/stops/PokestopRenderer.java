package dev.matthiesen.common.cobblemon_pokestops.client.renderer.block.stops;

import dev.matthiesen.common.cobblemon_pokestops.block.entity.stops.PokestopEntity;
import dev.matthiesen.common.cobblemon_pokestops.client.model.block.stops.PokestopModel;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class PokestopRenderer extends GeoBlockRenderer<PokestopEntity> {
    public PokestopRenderer() {
        super(new PokestopModel());
    }
}
