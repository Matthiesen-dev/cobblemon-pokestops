package dev.matthiesen.cobblemon_pokestops.common.client.renderer.item.trophies;

import dev.matthiesen.cobblemon_pokestops.common.item.trophies.PokestopTrophyItem;
import dev.matthiesen.cobblemon_pokestops.common.templates.block.StopItemModelTemplate;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public final class PokestopTrophyItemRenderer extends GeoItemRenderer<PokestopTrophyItem> {
    public PokestopTrophyItemRenderer() {
        super(new StopItemModelTemplate<>("pokestop_trophy"));
    }
}
