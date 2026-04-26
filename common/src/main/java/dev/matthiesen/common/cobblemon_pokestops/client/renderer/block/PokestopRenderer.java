package dev.matthiesen.common.cobblemon_pokestops.client.renderer.block;

import dev.matthiesen.common.cobblemon_pokestops.block.entity.PokestopEntity;
import dev.matthiesen.common.cobblemon_pokestops.client.model.block.PokestopModel;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class PokestopRenderer extends GeoBlockRenderer<PokestopEntity> {
    public PokestopRenderer() {
        super(new PokestopModel());
    }
}
