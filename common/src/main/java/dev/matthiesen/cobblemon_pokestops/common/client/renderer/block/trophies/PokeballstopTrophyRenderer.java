package dev.matthiesen.cobblemon_pokestops.common.client.renderer.block.trophies;

import dev.matthiesen.cobblemon_pokestops.common.client.model.block.trophies.PokeballstopTrophyModel;
import dev.matthiesen.cobblemon_pokestops.common.block.entity.trophies.PokeballstopTrophyEntity;
import dev.matthiesen.cobblemon_pokestops.common.client.renderer.util.CustomBlockRenderer;
import dev.matthiesen.cobblemon_pokestops.common.client.renderer.util.EmissiveLayer;

public final class PokeballstopTrophyRenderer extends CustomBlockRenderer<PokeballstopTrophyEntity> {
    public PokeballstopTrophyRenderer() {
        super(new PokeballstopTrophyModel());
        addRenderLayer(new EmissiveLayer<>(this));
    }
}
