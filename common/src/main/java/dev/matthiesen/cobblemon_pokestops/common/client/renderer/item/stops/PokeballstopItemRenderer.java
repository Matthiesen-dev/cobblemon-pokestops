package dev.matthiesen.cobblemon_pokestops.common.client.renderer.item.stops;

import dev.matthiesen.cobblemon_pokestops.common.client.renderer.util.EmissiveLayer;
import dev.matthiesen.cobblemon_pokestops.common.item.stops.PokeballstopItem;
import dev.matthiesen.cobblemon_pokestops.common.templates.block.StopItemModelTemplate;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public final class PokeballstopItemRenderer extends GeoItemRenderer<PokeballstopItem> {
    public PokeballstopItemRenderer() {
        super(new StopItemModelTemplate<>("pokeballstop"));
        addRenderLayer(new EmissiveLayer<>(this));
    }
}
