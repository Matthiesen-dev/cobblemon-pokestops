package dev.matthiesen.cobblemon_pokestops.common.client.renderer.block.stops;

import dev.matthiesen.cobblemon_pokestops.common.client.model.block.stops.PokeballstopModel;
import dev.matthiesen.cobblemon_pokestops.common.block.entity.stops.PokeballstopEntity;
import dev.matthiesen.cobblemon_pokestops.common.client.renderer.util.CustomBeamBlockRenderer;
import dev.matthiesen.cobblemon_pokestops.common.client.renderer.util.EmissiveLayer;

public final class PokeballstopRenderer extends CustomBeamBlockRenderer<PokeballstopEntity> {
    public PokeballstopRenderer() {
        super(new PokeballstopModel());
        addRenderLayer(new EmissiveLayer<>(this));
    }
}
