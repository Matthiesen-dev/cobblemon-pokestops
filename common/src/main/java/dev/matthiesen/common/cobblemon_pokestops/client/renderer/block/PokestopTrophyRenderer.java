package dev.matthiesen.common.cobblemon_pokestops.client.renderer.block;

import dev.matthiesen.common.cobblemon_pokestops.block.entity.PokestopTrophyEntity;
import dev.matthiesen.common.cobblemon_pokestops.client.model.block.PokestopTrophyModel;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class PokestopTrophyRenderer extends GeoBlockRenderer<PokestopTrophyEntity> {
    public PokestopTrophyRenderer() {
        super(new PokestopTrophyModel());
    }
}
