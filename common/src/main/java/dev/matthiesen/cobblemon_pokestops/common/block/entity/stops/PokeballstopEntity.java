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

public final class PokeballstopEntity extends StopEntityTemplate implements BeamRenderer.BeamEntity {
    private static final RawAnimation IDLE_ANIM = RawAnimation.begin()
            .thenLoop("animation.pokeballstop.idle_closed");
    private static final RawAnimation IDLE_COOLDOWN_ANIM = RawAnimation.begin()
            .thenLoop("animation.pokeballstop.idle_open");
    private static final RawAnimation SPIN_ANIM = RawAnimation.begin()
            .thenPlay("animation.pokeballstop.open");

    public PokeballstopEntity(BlockPos pos, BlockState state) {
        super(pos, state, BlockEntityRegistry.POKEBALLSTOP_BE);
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
        if (parts[0].equals("pokeballstop") && parts.length > 1) {
            String variant = parts[1].toLowerCase(Locale.ROOT);
            return getColorForVariant(variant);
        }
        return -283784704;
    }

    private int getColorForVariant(String variant) {
        return switch (variant) {
            case "masterball" -> -272035353;
            case "ultraball" -> -270015983;
            case "premierball" -> -268830215;
            case "parkball" -> -283784704;
            default -> -283784704;
        };
    }

    @Override
    public int getBlockHeight() {
        return 3;
    }
}