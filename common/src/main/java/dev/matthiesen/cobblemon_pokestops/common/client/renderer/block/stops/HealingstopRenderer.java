package dev.matthiesen.cobblemon_pokestops.common.client.renderer.block.stops;

import dev.matthiesen.cobblemon_pokestops.common.client.model.block.stops.HealingstopModel;
import dev.matthiesen.cobblemon_pokestops.common.block.entity.stops.HealingstopEntity;
import software.bernie.geckolib.renderer.GeoBlockRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;

public final class HealingstopRenderer extends GeoBlockRenderer<HealingstopEntity> {
    public HealingstopRenderer() {
        super(new HealingstopModel());
        addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }
}
