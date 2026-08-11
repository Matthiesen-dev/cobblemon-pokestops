package dev.matthiesen.cobblemon_pokestops.common.client.renderer.block.stops;

import dev.matthiesen.cobblemon_pokestops.common.client.model.block.stops.WingedstopModel;
import dev.matthiesen.cobblemon_pokestops.common.block.entity.stops.WingedstopEntity;
import software.bernie.geckolib.renderer.GeoBlockRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;

public final class WingedstopRenderer extends GeoBlockRenderer<WingedstopEntity> {
    public WingedstopRenderer() {
        super(new WingedstopModel());
        addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }
}
