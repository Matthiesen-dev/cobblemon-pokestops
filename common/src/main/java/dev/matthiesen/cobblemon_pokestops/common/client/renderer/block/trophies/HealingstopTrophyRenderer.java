package dev.matthiesen.cobblemon_pokestops.common.client.renderer.block.trophies;

import dev.matthiesen.cobblemon_pokestops.common.block.entity.trophies.HealingstopTrophyEntity;
import dev.matthiesen.cobblemon_pokestops.common.client.renderer.util.CustomBlockRenderer;
import dev.matthiesen.cobblemon_pokestops.common.client.renderer.util.EmissiveLayer;
import dev.matthiesen.cobblemon_pokestops.common.templates.block.TrophyModelTemplate;

public final class HealingstopTrophyRenderer extends CustomBlockRenderer<HealingstopTrophyEntity> {
    public HealingstopTrophyRenderer() {
        super(new TrophyModelTemplate<>("healingstop_trophy"));
        addRenderLayer(new EmissiveLayer<>(this));
    }
}
