package dev.matthiesen.cobblemon_pokestops.common.client.renderer.block.stops;

import dev.matthiesen.cobblemon_pokestops.common.block.entity.stops.HealingstopEntity;
import dev.matthiesen.cobblemon_pokestops.common.client.renderer.util.CustomBeamBlockRenderer;
import dev.matthiesen.cobblemon_pokestops.common.client.renderer.util.EmissiveLayer;
import dev.matthiesen.cobblemon_pokestops.common.templates.block.StopModelTemplate;

public final class HealingstopRenderer extends CustomBeamBlockRenderer<HealingstopEntity> {
    public HealingstopRenderer() {
        super(new StopModelTemplate<>("healingstop"));
        addRenderLayer(new EmissiveLayer<>(this));
    }
}
