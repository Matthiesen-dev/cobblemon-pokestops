package dev.matthiesen.cobblemon_pokestops.common.client.renderer.item.stops;

import dev.matthiesen.cobblemon_pokestops.common.client.model.item.stops.PokestopItemModel;
import dev.matthiesen.cobblemon_pokestops.common.item.stops.PokestopItem;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class PokestopItemRenderer extends GeoItemRenderer<PokestopItem> {
    public PokestopItemRenderer() {
        super(new PokestopItemModel());
    }
}
