package dev.matthiesen.common.cobblemon_pokestops.client.renderer.block.trophies;

import dev.matthiesen.common.cobblemon_pokestops.block.entity.trophies.WingedstopTrophyEntity;
import dev.matthiesen.common.cobblemon_pokestops.client.model.block.trophies.WingedstopTrophyModel;
import software.bernie.geckolib.renderer.GeoBlockRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;

public class WingedstopTrophyRenderer extends GeoBlockRenderer<WingedstopTrophyEntity> {
    public WingedstopTrophyRenderer() {
        super(new WingedstopTrophyModel());
        addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }
}
