package dev.matthiesen.common.cobblemon_pokestops.templates.block;

import com.google.common.collect.Maps;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Map;
import java.util.function.Supplier;

public abstract class TrophyTemplate extends HorizontalDirectionalBlock implements EntityBlock {
    private final Map<Direction, VoxelShape> shapes = Maps.newEnumMap(Direction.class);
    private final VoxelShape baseShape;

    public TrophyTemplate() {
        super(Properties.of().noOcclusion().strength(4f).requiresCorrectToolForDrops().sound(SoundType.METAL));
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
        this.baseShape = createShape();
        initializeShapes();
    }

    /**
     * Subclasses must provide the entity type for this stop.
     */
    protected abstract Supplier<? extends BlockEntityType<?>> getEntityType();

    /**
     * Subclasses must provide the VoxelShape representing this stop's structure.
     */
    protected abstract VoxelShape createShape();

    private void initializeShapes() {
        shapes.put(Direction.NORTH, baseShape);
        shapes.put(Direction.SOUTH, calculateRotation(Direction.SOUTH, baseShape));
        shapes.put(Direction.EAST, calculateRotation(Direction.EAST, baseShape));
        shapes.put(Direction.WEST, calculateRotation(Direction.WEST, baseShape));
    }

    @SuppressWarnings("NullableProblems")
    @Override
    protected @Nullable MapCodec<? extends HorizontalDirectionalBlock> codec() {
        return null;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return getEntityType().get().create(pos, state);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }

    @Override
    public @NotNull RenderShape getRenderShape(BlockState state) {
        return RenderShape.ENTITYBLOCK_ANIMATED;
    }

    @Override
    public @NotNull VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return shapes.getOrDefault(state.getValue(FACING), baseShape);
    }

    protected static VoxelShape calculateRotation(Direction direction, VoxelShape base) {
        VoxelShape[] buffer = new VoxelShape[]{base, Shapes.empty()};
        int times = (direction.get2DDataValue() - Direction.NORTH.get2DDataValue() + 4) % 4;
        for (int i = 0; i < times; i++) {
            buffer[0].forAllBoxes((minX, minY, minZ, maxX, maxY, maxZ) ->
                    buffer[1] = Shapes.joinUnoptimized(buffer[1],
                            Shapes.box(1 - maxZ, minY, minX, 1 - minZ, maxY, maxX), BooleanOp.OR));
            buffer[0] = buffer[1].optimize();
            buffer[1] = Shapes.empty();
        }
        return buffer[0];
    }
}
