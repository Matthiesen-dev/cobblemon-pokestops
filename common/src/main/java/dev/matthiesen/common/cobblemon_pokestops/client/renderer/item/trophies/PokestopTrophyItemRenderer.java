package dev.matthiesen.common.cobblemon_pokestops.client.renderer.item.trophies;

import dev.matthiesen.common.cobblemon_pokestops.client.model.item.trophies.PokestopTrophyItemModel;
import dev.matthiesen.common.cobblemon_pokestops.item.trophies.PokestopTrophyItem;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class PokestopTrophyItemRenderer extends GeoItemRenderer<PokestopTrophyItem> {
    public PokestopTrophyItemRenderer() {
        super(new PokestopTrophyItemModel());
    }
}
