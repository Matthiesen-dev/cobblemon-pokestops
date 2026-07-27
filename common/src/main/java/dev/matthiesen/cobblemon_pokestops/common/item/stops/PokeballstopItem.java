package dev.matthiesen.cobblemon_pokestops.common.item.stops;

import dev.matthiesen.cobblemon_pokestops.common.templates.item.StopItemTemplate;
import net.minecraft.world.level.block.Block;
import software.bernie.geckolib.animation.RawAnimation;

public final class PokeballstopItem extends StopItemTemplate {
    private static final RawAnimation IDLE_ANIM = RawAnimation.begin()
            .thenLoop("animation.pokeballstop.idle_closed");

    public PokeballstopItem(Block block, Properties properties) {
        super(block, properties);
    }

    @Override
    protected RawAnimation getIdleAnimation() {
        return IDLE_ANIM;
    }
}
