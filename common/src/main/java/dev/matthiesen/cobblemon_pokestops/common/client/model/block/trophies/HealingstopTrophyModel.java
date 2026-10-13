package dev.matthiesen.cobblemon_pokestops.common.client.model.block.trophies;

import dev.matthiesen.cobblemon_pokestops.common.block.entity.trophies.HealingstopTrophyEntity;
import dev.matthiesen.cobblemon_pokestops.common.templates.block.TrophyModelTemplate;

public final class HealingstopTrophyModel extends TrophyModelTemplate<HealingstopTrophyEntity> {
    @Override
    protected String getModelName() {
        return "healingstop_trophy";
    }
}
