package dev.matthiesen.cobblemon_pokestops.common.client.renderer.block.trophies;

import dev.matthiesen.cobblemon_pokestops.common.client.model.block.trophies.PokestopTrophyModel;
import dev.matthiesen.cobblemon_pokestops.common.block.entity.trophies.PokestopTrophyEntity;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class PokestopTrophyRenderer extends GeoBlockRenderer<PokestopTrophyEntity> {
    public PokestopTrophyRenderer() {
        super(new PokestopTrophyModel());
    }
}
