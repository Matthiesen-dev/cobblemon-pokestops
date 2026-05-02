package dev.matthiesen.common.cobblemon_pokestops.client.renderer.block;

import dev.matthiesen.common.cobblemon_pokestops.block.entity.HealingstopTrophyEntity;
import dev.matthiesen.common.cobblemon_pokestops.client.model.block.HealingstopTrophyModel;
import software.bernie.geckolib.renderer.GeoBlockRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;

public class HealingstopTrophyRenderer extends GeoBlockRenderer<HealingstopTrophyEntity> {
    public HealingstopTrophyRenderer() {
        super(new HealingstopTrophyModel());
        addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }
}
