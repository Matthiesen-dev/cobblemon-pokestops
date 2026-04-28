package dev.matthiesen.common.cobblemon_pokestops.client.renderer.block;

import dev.matthiesen.common.cobblemon_pokestops.block.entity.WingedstopEntity;
import dev.matthiesen.common.cobblemon_pokestops.client.model.block.WingedstopModel;
import software.bernie.geckolib.renderer.GeoBlockRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;

public class WingedstopRenderer extends GeoBlockRenderer<WingedstopEntity> {
    public WingedstopRenderer() {
        super(new WingedstopModel());
        addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }
}
