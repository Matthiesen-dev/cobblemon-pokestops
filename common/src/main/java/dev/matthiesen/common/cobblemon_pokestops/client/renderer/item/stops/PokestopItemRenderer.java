package dev.matthiesen.common.cobblemon_pokestops.client.renderer.item.stops;

import dev.matthiesen.common.cobblemon_pokestops.client.model.item.stops.PokestopItemModel;
import dev.matthiesen.common.cobblemon_pokestops.item.stops.PokestopItem;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class PokestopItemRenderer extends GeoItemRenderer<PokestopItem> {
    public PokestopItemRenderer() {
        super(new PokestopItemModel());
    }
}
