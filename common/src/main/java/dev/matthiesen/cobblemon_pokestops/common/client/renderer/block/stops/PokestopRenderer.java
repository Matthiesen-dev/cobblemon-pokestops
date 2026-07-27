package dev.matthiesen.cobblemon_pokestops.common.client.renderer.block.stops;

import dev.matthiesen.cobblemon_pokestops.common.client.model.block.stops.PokestopModel;
import dev.matthiesen.cobblemon_pokestops.common.block.entity.stops.PokestopEntity;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public final class PokestopRenderer extends GeoBlockRenderer<PokestopEntity> {
    public PokestopRenderer() {
        super(new PokestopModel());
    }
}
