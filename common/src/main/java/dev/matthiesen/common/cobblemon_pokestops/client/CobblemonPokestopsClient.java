package dev.matthiesen.common.cobblemon_pokestops.client;

import dev.matthiesen.common.cobblemon_pokestops.block.Pokestop;
import dev.matthiesen.common.cobblemon_pokestops.block.PokestopDummyBlock;
import dev.matthiesen.common.cobblemon_pokestops.client.renderer.block.PokestopRenderer;
import dev.matthiesen.common.cobblemon_pokestops.registry.BlockEntityRegistry;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.function.BiConsumer;

public class CobblemonPokestopsClient {
    @SuppressWarnings("rawtypes")
    public static void registerRenderers(BiConsumer<EntityType<? extends Entity>, EntityRendererProvider> entityRenderers,
                                         BiConsumer<BlockEntityType<? extends BlockEntity>, BlockEntityRendererProvider> blockEntityRenderers) {

        blockEntityRenderers.accept(BlockEntityRegistry.POKESTOP_BE.get(), context -> new PokestopRenderer());
    }

    public static BlockPos getBasePos(Level level, BlockPos hitPos) {
        if (level.getBlockState(hitPos).getBlock() instanceof PokestopDummyBlock) {
            for (int i = 1; i <= 2; i++) {
                BlockPos check = hitPos.below(i);
                if (level.getBlockState(check).getBlock() instanceof Pokestop) {
                    return check;
                }
            }
        }
        return null;
    }
}
