package dev.matthiesen.cobblemon_pokestops.common.client.renderer.block.trophies;

import dev.matthiesen.cobblemon_pokestops.common.block.entity.trophies.PokeballstopTrophyEntity;
import dev.matthiesen.cobblemon_pokestops.common.client.renderer.util.CustomBlockRenderer;
import dev.matthiesen.cobblemon_pokestops.common.client.renderer.util.EmissiveLayer;
import dev.matthiesen.cobblemon_pokestops.common.templates.block.TrophyModelTemplate;

public final class PokeballstopTrophyRenderer extends CustomBlockRenderer<PokeballstopTrophyEntity> {
    public PokeballstopTrophyRenderer() {
        super(new TrophyModelTemplate<>("pokeballstop_trophy"));
        addRenderLayer(new EmissiveLayer<>(this));
    }
}
