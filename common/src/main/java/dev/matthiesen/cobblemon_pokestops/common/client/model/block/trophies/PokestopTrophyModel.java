package dev.matthiesen.cobblemon_pokestops.common.client.model.block.trophies;

import dev.matthiesen.cobblemon_pokestops.common.block.entity.trophies.PokestopTrophyEntity;
import dev.matthiesen.cobblemon_pokestops.common.templates.block.TrophyModelTemplate;

public final class PokestopTrophyModel extends TrophyModelTemplate<PokestopTrophyEntity> {
    @Override
    protected String getModelName() {
        return "pokestop_trophy";
    }
}
