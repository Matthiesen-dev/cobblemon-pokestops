package dev.matthiesen.cobblemon_pokestops.common.client.renderer.block.stops;

import dev.matthiesen.cobblemon_pokestops.common.block.entity.stops.PokestopEntity;
import dev.matthiesen.cobblemon_pokestops.common.client.renderer.util.CustomBeamBlockRenderer;
import dev.matthiesen.cobblemon_pokestops.common.templates.block.StopModelTemplate;

public final class PokestopRenderer extends CustomBeamBlockRenderer<PokestopEntity> {
    public PokestopRenderer() {
        super(new StopModelTemplate<>("pokestop"));
    }
}
