package dev.matthiesen.cobblemon_pokestops.common.client.model.block.stops;

import dev.matthiesen.cobblemon_pokestops.common.block.entity.stops.HealingstopEntity;
import dev.matthiesen.cobblemon_pokestops.common.templates.block.StopModelTemplate;

public final class HealingstopModel extends StopModelTemplate<HealingstopEntity> {
    @Override
    protected String getModelName() {
        return "healingstop";
    }
}
