package dev.matthiesen.cobblemon_pokestops.common.item.trophies;

import dev.matthiesen.cobblemon_pokestops.common.templates.item.StopItemTemplate;
import net.minecraft.world.level.block.Block;
import software.bernie.geckolib.animation.RawAnimation;

public final class WingedstopTrophyItem extends StopItemTemplate {
    private static final RawAnimation IDLE_ANIM = RawAnimation.begin()
            .thenLoop("animation.wingedstop_trophy.idle_open");

    public WingedstopTrophyItem(Block block, Properties properties) {
        super(block, properties);
    }

    @Override
    protected RawAnimation getIdleAnimation() {
        return IDLE_ANIM;
    }
}
