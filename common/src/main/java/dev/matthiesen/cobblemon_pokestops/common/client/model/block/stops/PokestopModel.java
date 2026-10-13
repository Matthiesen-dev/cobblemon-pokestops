package dev.matthiesen.cobblemon_pokestops.common.client.model.block.stops;

import dev.matthiesen.cobblemon_pokestops.common.block.entity.stops.PokestopEntity;
import dev.matthiesen.cobblemon_pokestops.common.templates.block.StopModelTemplate;

public final class PokestopModel extends StopModelTemplate<PokestopEntity> {
    @Override
    protected String getModelName() {
        return "pokestop";
    }
}
