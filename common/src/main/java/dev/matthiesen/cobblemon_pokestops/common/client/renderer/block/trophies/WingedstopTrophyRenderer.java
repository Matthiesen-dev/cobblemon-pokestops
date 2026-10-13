package dev.matthiesen.cobblemon_pokestops.common.client.renderer.block.trophies;

import dev.matthiesen.cobblemon_pokestops.common.block.entity.trophies.WingedstopTrophyEntity;
import dev.matthiesen.cobblemon_pokestops.common.client.renderer.util.CustomBlockRenderer;
import dev.matthiesen.cobblemon_pokestops.common.client.renderer.util.EmissiveLayer;
import dev.matthiesen.cobblemon_pokestops.common.templates.block.TrophyModelTemplate;

public final class WingedstopTrophyRenderer extends CustomBlockRenderer<WingedstopTrophyEntity> {
    public WingedstopTrophyRenderer() {
        super(new TrophyModelTemplate<>("wingedstop_trophy"));
        addRenderLayer(new EmissiveLayer<>(this));
    }
}
