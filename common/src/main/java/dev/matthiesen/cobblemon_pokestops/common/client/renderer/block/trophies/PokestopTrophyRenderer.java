package dev.matthiesen.cobblemon_pokestops.common.client.renderer.block.trophies;

import dev.matthiesen.cobblemon_pokestops.common.block.entity.trophies.PokestopTrophyEntity;
import dev.matthiesen.cobblemon_pokestops.common.client.renderer.util.CustomBlockRenderer;
import dev.matthiesen.cobblemon_pokestops.common.templates.block.TrophyModelTemplate;

public final class PokestopTrophyRenderer extends CustomBlockRenderer<PokestopTrophyEntity> {
    public PokestopTrophyRenderer() {
        super(new TrophyModelTemplate<>("pokestop_trophy"));
    }
}
