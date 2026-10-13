package dev.matthiesen.cobblemon_pokestops.common.client.renderer.block.stops;

import dev.matthiesen.cobblemon_pokestops.common.block.entity.stops.PokeballstopEntity;
import dev.matthiesen.cobblemon_pokestops.common.client.renderer.util.CustomBeamBlockRenderer;
import dev.matthiesen.cobblemon_pokestops.common.client.renderer.util.EmissiveLayer;
import dev.matthiesen.cobblemon_pokestops.common.templates.block.StopModelTemplate;

public final class PokeballstopRenderer extends CustomBeamBlockRenderer<PokeballstopEntity> {
    public PokeballstopRenderer() {
        super(new StopModelTemplate<>("pokeballstop"));
        addRenderLayer(new EmissiveLayer<>(this));
    }
}
