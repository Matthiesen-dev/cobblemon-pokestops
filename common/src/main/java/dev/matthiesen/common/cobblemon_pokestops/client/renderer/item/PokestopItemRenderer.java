package dev.matthiesen.common.cobblemon_pokestops.client.renderer.item;

import dev.matthiesen.common.cobblemon_pokestops.client.model.item.PokestopItemModel;
import dev.matthiesen.common.cobblemon_pokestops.item.PokestopItem;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class PokestopItemRenderer extends GeoItemRenderer<PokestopItem> {
    public PokestopItemRenderer() {
        super(new PokestopItemModel());
    }
}
