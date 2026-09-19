package dev.matthiesen.cobblemon_pokestops.common.block.entity.stops;

import dev.matthiesen.cobblemon_pokestops.common.client.renderer.util.BeamRenderer;
import dev.matthiesen.cobblemon_pokestops.common.templates.entity.StopEntityTemplate;
import dev.matthiesen.cobblemon_pokestops.common.registry.BlockEntityRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.BlockState;
import software.bernie.geckolib.animation.RawAnimation;

import java.util.Locale;

public final class PokestopEntity extends StopEntityTemplate implements BeamRenderer.BeamEntity {
    private static final RawAnimation IDLE_ANIM = RawAnimation.begin()
            .thenLoop("animation.pokestop.idle_closed");
    private static final RawAnimation IDLE_COOLDOWN_ANIM = RawAnimation.begin()
            .thenLoop("animation.pokestop.idle_open");
    private static final RawAnimation SPIN_ANIM = RawAnimation.begin()
            .thenPlay("animation.pokestop.open");

    public PokestopEntity(BlockPos pos, BlockState state) {
        super(pos, state, BlockEntityRegistry.POKESTOP_BE);
    }

    @Override
    protected RawAnimation getIdleAnimation() {
        return IDLE_ANIM;
    }

    @Override
    protected RawAnimation getIdleCooldownAnimation() {
        return IDLE_COOLDOWN_ANIM;
    }

    @Override
    protected RawAnimation getSpinAnimation() {
        return SPIN_ANIM;
    }

    @Override
    public int getBeamColor() {
        ResourceLocation blockId = BuiltInRegistries.BLOCK.getKey(this.getBlockState().getBlock());
        String path = blockId.getPath();
        var parts = path.split("_");
        if (parts[0].equals("pokestop") && parts.length > 1) {
            String variant = parts[1].toLowerCase(Locale.ROOT);
            return getColorForVariant(variant);
        }
        return -285192961;
    }

    private int getColorForVariant(String variant) {
        return switch (variant) {
            case "gold" -> -271929600;
            case "black" -> -285081600;
            case "green" -> -285147392;
            default -> -285192961;
        };
    }

    @Override
    public int getBlockHeight() {
        return 4;
    }
}