package dev.matthiesen.cobblemon_pokestops.common.client.renderer.block.trophies;

import dev.matthiesen.cobblemon_pokestops.common.client.model.block.trophies.WingedstopTrophyModel;
import dev.matthiesen.cobblemon_pokestops.common.block.entity.trophies.WingedstopTrophyEntity;
import software.bernie.geckolib.renderer.GeoBlockRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;

public class WingedstopTrophyRenderer extends GeoBlockRenderer<WingedstopTrophyEntity> {
    public WingedstopTrophyRenderer() {
        super(new WingedstopTrophyModel());
        addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }
}
