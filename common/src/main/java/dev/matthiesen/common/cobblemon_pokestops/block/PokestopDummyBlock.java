package dev.matthiesen.common.cobblemon_pokestops.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

public class PokestopDummyBlock extends Block {
    public PokestopDummyBlock() {
        super(Properties.of().noOcclusion().strength(-1.0f, -1.0f));
    }

    @Override
    public @NotNull InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hit) {
        // Search downwards to find the Pokestop base
        for (int i = 1; i <= 2; i++) {
            BlockPos checkPos = pos.below(i);
            if (level.getBlockState(checkPos).getBlock() instanceof Pokestop) {
                // Relay the interaction to the base block
                return level.getBlockState(checkPos).useWithoutItem(level, player, hit.withPosition(checkPos));
            }
        }
        return InteractionResult.PASS;
    }

    @Override
    public @NotNull RenderShape getRenderShape(BlockState state) {
        return RenderShape.INVISIBLE; // Visually hidden; model is drawn by the Base
    }

    @Override
    public @NotNull VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        // Check if we are the top block (2 blocks above base)
        if (world.getBlockState(pos.below(2)).getBlock() instanceof Pokestop) {
            return Block.box(2.0D, 0.0D, 2.0D, 14.0D, 16.0D, 14.0D); // Slightly wider top
        }
        // Default to wall-width for the middle section
        return Block.box(4.0D, 0.0D, 4.0D, 12.0D, 16.0D, 12.0D);
    }
}

