package dev.matthiesen.common.cobblemon_pokestops.client.renderer.block.stops;

import dev.matthiesen.common.cobblemon_pokestops.block.entity.stops.WingedstopEntity;
import dev.matthiesen.common.cobblemon_pokestops.client.model.block.stops.WingedstopModel;
import software.bernie.geckolib.renderer.GeoBlockRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;

public class WingedstopRenderer extends GeoBlockRenderer<WingedstopEntity> {
    public WingedstopRenderer() {
        super(new WingedstopModel());
        addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }
}
