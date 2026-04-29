package dev.matthiesen.common.cobblemon_pokestops.client.renderer.item;

import dev.matthiesen.common.cobblemon_pokestops.client.model.item.PokestopTrophyItemModel;
import dev.matthiesen.common.cobblemon_pokestops.item.PokestopTrophyItem;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class PokestopTrophyItemRenderer extends GeoItemRenderer<PokestopTrophyItem> {
    public PokestopTrophyItemRenderer() {
        super(new PokestopTrophyItemModel());
    }
}
