package dev.matthiesen.cobblemon_pokestops.common.client.model.block.trophies;

import dev.matthiesen.cobblemon_pokestops.common.block.entity.trophies.PokeballstopTrophyEntity;
import dev.matthiesen.cobblemon_pokestops.common.templates.block.TrophyModelTemplate;

public final class PokeballstopTrophyModel extends TrophyModelTemplate<PokeballstopTrophyEntity> {
    @Override
    protected String getModelName() {
        return "pokeballstop_trophy";
    }
}
