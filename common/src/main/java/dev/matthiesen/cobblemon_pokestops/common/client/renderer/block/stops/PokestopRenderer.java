package dev.matthiesen.cobblemon_pokestops.common.client.renderer.block.stops;

import dev.matthiesen.cobblemon_pokestops.common.client.model.block.stops.PokestopModel;
import dev.matthiesen.cobblemon_pokestops.common.block.entity.stops.PokestopEntity;
import dev.matthiesen.cobblemon_pokestops.common.client.renderer.util.CustomBeamBlockRenderer;

public final class PokestopRenderer extends CustomBeamBlockRenderer<PokestopEntity> {
    public PokestopRenderer() {
        super(new PokestopModel());
    }
}
