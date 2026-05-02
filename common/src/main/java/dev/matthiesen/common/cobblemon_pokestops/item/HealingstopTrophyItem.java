package dev.matthiesen.common.cobblemon_pokestops.item;

import dev.matthiesen.common.cobblemon_pokestops.templates.item.StopItemTemplate;
import net.minecraft.world.level.block.Block;
import software.bernie.geckolib.animation.RawAnimation;

public class HealingstopTrophyItem extends StopItemTemplate {
    private static final RawAnimation IDLE_ANIM = RawAnimation.begin()
            .thenLoop("animation.healingstop_trophy.idle_closed");

    public HealingstopTrophyItem(Block block, Properties properties) {
        super(block, properties);
    }

    @Override
    protected RawAnimation getIdleAnimation() {
        return IDLE_ANIM;
    }
}
