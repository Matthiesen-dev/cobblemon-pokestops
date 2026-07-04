package dev.matthiesen.cobblemon_pokestops.common.client.renderer.item.trophies;

import dev.matthiesen.cobblemon_pokestops.common.client.model.item.trophies.PokestopTrophyItemModel;
import dev.matthiesen.cobblemon_pokestops.common.item.trophies.PokestopTrophyItem;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class PokestopTrophyItemRenderer extends GeoItemRenderer<PokestopTrophyItem> {
    public PokestopTrophyItemRenderer() {
        super(new PokestopTrophyItemModel());
    }
}
