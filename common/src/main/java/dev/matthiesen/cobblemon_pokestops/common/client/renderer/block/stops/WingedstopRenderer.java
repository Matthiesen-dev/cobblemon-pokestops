package dev.matthiesen.cobblemon_pokestops.common.client.renderer.block.stops;

import dev.matthiesen.cobblemon_pokestops.common.client.model.block.stops.WingedstopModel;
import dev.matthiesen.cobblemon_pokestops.common.block.entity.stops.WingedstopEntity;
import dev.matthiesen.cobblemon_pokestops.common.client.renderer.util.CustomBeamBlockRenderer;
import dev.matthiesen.cobblemon_pokestops.common.client.renderer.util.EmissiveLayer;

public final class WingedstopRenderer extends CustomBeamBlockRenderer<WingedstopEntity> {
    public WingedstopRenderer() {
        super(new WingedstopModel());
        addRenderLayer(new EmissiveLayer<>(this));
    }
}
