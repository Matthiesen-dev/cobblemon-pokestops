package dev.matthiesen.cobblemon_pokestops.common.client.renderer.block.trophies;

import dev.matthiesen.cobblemon_pokestops.common.client.model.block.trophies.WingedstopTrophyModel;
import dev.matthiesen.cobblemon_pokestops.common.block.entity.trophies.WingedstopTrophyEntity;
import dev.matthiesen.cobblemon_pokestops.common.client.renderer.util.CustomBlockRenderer;
import dev.matthiesen.cobblemon_pokestops.common.client.renderer.util.EmissiveLayer;

public final class WingedstopTrophyRenderer extends CustomBlockRenderer<WingedstopTrophyEntity> {
    public WingedstopTrophyRenderer() {
        super(new WingedstopTrophyModel());
        addRenderLayer(new EmissiveLayer<>(this));
    }
}
