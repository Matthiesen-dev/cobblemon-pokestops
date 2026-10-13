package dev.matthiesen.cobblemon_pokestops.common.client.renderer.block.trophies;

import dev.matthiesen.cobblemon_pokestops.common.client.model.block.trophies.HealingstopTrophyModel;
import dev.matthiesen.cobblemon_pokestops.common.block.entity.trophies.HealingstopTrophyEntity;
import dev.matthiesen.cobblemon_pokestops.common.client.renderer.util.CustomBlockRenderer;
import dev.matthiesen.cobblemon_pokestops.common.client.renderer.util.EmissiveLayer;

public final class HealingstopTrophyRenderer extends CustomBlockRenderer<HealingstopTrophyEntity> {
    public HealingstopTrophyRenderer() {
        super(new HealingstopTrophyModel());
        addRenderLayer(new EmissiveLayer<>(this));
    }
}
