package dev.matthiesen.common.cobblemon_pokestops.client.renderer.block;

import dev.matthiesen.common.cobblemon_pokestops.block.entity.HealingstopEntity;
import dev.matthiesen.common.cobblemon_pokestops.client.model.block.HealingstopModel;
import software.bernie.geckolib.renderer.GeoBlockRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;

public class HealingstopRenderer extends GeoBlockRenderer<HealingstopEntity> {
    public HealingstopRenderer() {
        super(new HealingstopModel());
        addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }
}
