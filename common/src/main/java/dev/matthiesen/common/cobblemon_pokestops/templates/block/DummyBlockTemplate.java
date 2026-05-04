package dev.matthiesen.common.cobblemon_pokestops.templates.block;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.TagKey;
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

import java.util.function.Predicate;

public class DummyBlockTemplate extends Block {
    private static final VoxelShape DEFAULT_MIDDLE_SHAPE = Block.box(4.0D, 0.0D, 4.0D, 12.0D, 16.0D, 12.0D);
    private static final VoxelShape DEFAULT_TOP_SHAPE = Block.box(2.0D, 0.0D, 2.0D, 14.0D, 16.0D, 14.0D);

    private final Predicate<BlockState> parentMatcher;
    private final int parentSearchDepth;
    private final int topParentOffset;
    private final VoxelShape middleShape;
    private final VoxelShape topShape;

    public DummyBlockTemplate(Predicate<BlockState> parentMatcher) {
        this(defaultProperties(), parentMatcher, 2, 2, DEFAULT_MIDDLE_SHAPE, DEFAULT_TOP_SHAPE);
    }

    @SuppressWarnings("unused")
    public DummyBlockTemplate(Properties properties, Predicate<BlockState> parentMatcher) {
        this(properties, parentMatcher, 2, 2, DEFAULT_MIDDLE_SHAPE, DEFAULT_TOP_SHAPE);
    }

    public DummyBlockTemplate(
            Properties properties,
            Predicate<BlockState> parentMatcher,
            int parentSearchDepth,
            int topParentOffset,
            VoxelShape middleShape,
            VoxelShape topShape
    ) {
        super(properties);
        this.parentMatcher = parentMatcher;
        this.parentSearchDepth = parentSearchDepth;
        this.topParentOffset = topParentOffset;
        this.middleShape = middleShape;
        this.topShape = topShape;
    }

    public static Properties defaultProperties() {
        return Properties.of().noOcclusion().strength(-1.0f, -1.0f);
    }

    protected static Predicate<BlockState> matchesRegistered(TagKey<Block> registeredBlocks) {
        return state -> state.is(registeredBlocks);
    }

    public BlockState getParentBlockState(Level level, BlockPos pos) {
        for (int i = 1; i <= parentSearchDepth; i++) {
            BlockState checkState = level.getBlockState(pos.below(i));
            if (parentMatcher.test(checkState)) {
                return checkState;
            }
        }
        return null;
    }

    @Override
    public @NotNull InteractionResult useWithoutItem(
            BlockState state,
            Level level,
            BlockPos pos,
            Player player,
            BlockHitResult hit
    ) {
        for (int i = 1; i <= parentSearchDepth; i++) {
            BlockPos checkPos = pos.below(i);
            BlockState checkState = level.getBlockState(checkPos);
            if (parentMatcher.test(checkState)) {
                return checkState.useWithoutItem(level, player, hit.withPosition(checkPos));
            }
        }

        return InteractionResult.PASS;
    }

    @Override
    public void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean isMoving) {
        if (!state.is(newState.getBlock())) {
            for (int i = 1; i <= parentSearchDepth; i++) {
                BlockPos checkPos = pos.below(i);
                if (parentMatcher.test(level.getBlockState(checkPos))) {
                    level.removeBlock(checkPos, false);
                    break;
                }
            }
        }

        super.onRemove(state, level, pos, newState, isMoving);
    }

    @Override
    public @NotNull RenderShape getRenderShape(BlockState state) {
        return RenderShape.INVISIBLE;
    }

    @Override
    public @NotNull VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        if (parentMatcher.test(world.getBlockState(pos.below(topParentOffset)))) {
            return topShape;
        }

        return middleShape;
    }
}
