package dev.matthiesen.cobblemon_pokestops.common.client.model.block.stops;

import dev.matthiesen.cobblemon_pokestops.common.block.entity.stops.PokeballstopEntity;
import dev.matthiesen.cobblemon_pokestops.common.templates.block.StopModelTemplate;

public final class PokeballstopModel extends StopModelTemplate<PokeballstopEntity> {
    @Override
    protected String getModelName() {
        return "pokeballstop";
    }
}
