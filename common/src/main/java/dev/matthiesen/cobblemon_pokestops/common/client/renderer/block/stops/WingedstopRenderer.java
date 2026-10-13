package dev.matthiesen.cobblemon_pokestops.common.client.renderer.block.stops;

import dev.matthiesen.cobblemon_pokestops.common.block.entity.stops.WingedstopEntity;
import dev.matthiesen.cobblemon_pokestops.common.client.renderer.util.CustomBeamBlockRenderer;
import dev.matthiesen.cobblemon_pokestops.common.client.renderer.util.EmissiveLayer;
import dev.matthiesen.cobblemon_pokestops.common.templates.block.StopModelTemplate;

public final class WingedstopRenderer extends CustomBeamBlockRenderer<WingedstopEntity> {
    public WingedstopRenderer() {
        super(new StopModelTemplate<>("wingedstop"));
        addRenderLayer(new EmissiveLayer<>(this));
    }
}
