package dev.matthiesen.cobblemon_pokestops.common.client.renderer.item.trophies;

import dev.matthiesen.cobblemon_pokestops.common.client.renderer.util.EmissiveLayer;
import dev.matthiesen.cobblemon_pokestops.common.item.trophies.PokeballstopTrophyItem;
import dev.matthiesen.cobblemon_pokestops.common.templates.block.StopItemModelTemplate;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public final class PokeballstopTrophyItemRenderer extends GeoItemRenderer<PokeballstopTrophyItem> {
    public PokeballstopTrophyItemRenderer() {
        super(new StopItemModelTemplate<>("pokeballstop_trophy"));
        addRenderLayer(new EmissiveLayer<>(this));
    }
}
