package dev.matthiesen.cobblemon_pokestops.common.client.renderer.block.trophies;

import dev.matthiesen.cobblemon_pokestops.common.client.model.block.trophies.PokestopTrophyModel;
import dev.matthiesen.cobblemon_pokestops.common.block.entity.trophies.PokestopTrophyEntity;
import dev.matthiesen.cobblemon_pokestops.common.client.renderer.util.CustomBlockRenderer;

public final class PokestopTrophyRenderer extends CustomBlockRenderer<PokestopTrophyEntity> {
    public PokestopTrophyRenderer() {
        super(new PokestopTrophyModel());
    }
}
