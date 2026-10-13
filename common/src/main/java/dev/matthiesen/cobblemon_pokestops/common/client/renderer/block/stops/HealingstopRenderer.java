package dev.matthiesen.cobblemon_pokestops.common.client.renderer.block.stops;

import dev.matthiesen.cobblemon_pokestops.common.client.model.block.stops.HealingstopModel;
import dev.matthiesen.cobblemon_pokestops.common.block.entity.stops.HealingstopEntity;
import dev.matthiesen.cobblemon_pokestops.common.client.renderer.util.CustomBeamBlockRenderer;
import dev.matthiesen.cobblemon_pokestops.common.client.renderer.util.EmissiveLayer;

public final class HealingstopRenderer extends CustomBeamBlockRenderer<HealingstopEntity> {
    public HealingstopRenderer() {
        super(new HealingstopModel());
        addRenderLayer(new EmissiveLayer<>(this));
    }
}
