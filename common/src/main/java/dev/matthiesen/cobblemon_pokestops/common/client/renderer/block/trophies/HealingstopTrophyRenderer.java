package dev.matthiesen.cobblemon_pokestops.common.client.renderer.block.trophies;

import dev.matthiesen.cobblemon_pokestops.common.client.model.block.trophies.HealingstopTrophyModel;
import dev.matthiesen.cobblemon_pokestops.common.block.entity.trophies.HealingstopTrophyEntity;
import software.bernie.geckolib.renderer.GeoBlockRenderer;
import software.bernie.geckolib.renderer.layer.AutoGlowingGeoLayer;

public final class HealingstopTrophyRenderer extends GeoBlockRenderer<HealingstopTrophyEntity> {
    public HealingstopTrophyRenderer() {
        super(new HealingstopTrophyModel());
        addRenderLayer(new AutoGlowingGeoLayer<>(this));
    }
}
