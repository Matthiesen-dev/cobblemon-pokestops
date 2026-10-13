package dev.matthiesen.cobblemon_pokestops.common.client.renderer.item.stops;

import dev.matthiesen.cobblemon_pokestops.common.item.stops.PokestopItem;
import dev.matthiesen.cobblemon_pokestops.common.templates.block.StopItemModelTemplate;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public final class PokestopItemRenderer extends GeoItemRenderer<PokestopItem> {
    public PokestopItemRenderer() {
        super(new StopItemModelTemplate<>("pokestop"));
    }
}
