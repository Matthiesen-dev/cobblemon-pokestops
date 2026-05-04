package dev.matthiesen.common.cobblemon_pokestops.templates.block;

import com.cobblemon.mod.common.CobblemonSounds;
import com.google.common.collect.Maps;
import com.mojang.serialization.MapCodec;
import dev.matthiesen.common.cobblemon_pokestops.registry.SoundRegistry;
import dev.matthiesen.common.cobblemon_pokestops.templates.entity.StopEntityTemplate;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.DustColorTransitionOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stat;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3f;

import java.util.Map;
import java.util.function.Supplier;

public abstract class BaseStopTemplate extends HorizontalDirectionalBlock implements EntityBlock {
    private static final DustColorTransitionOptions PARTICLE = createParticle();

    private final Map<Direction, VoxelShape> shapes = Maps.newEnumMap(Direction.class);
    private final VoxelShape baseShape;

    protected BaseStopTemplate() {
        super(Properties.of().noOcclusion().strength(-1.0f, -1.0f));
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
        this.baseShape = createShape();
        initializeShapes();
    }

    /**
     * Supplies the block entity type used by this stop family.
     */
    protected abstract Supplier<? extends BlockEntityType<?>> getEntityType();

    /**
     * Supplies the per-player cooldown, in seconds, after a successful use.
     */
    protected abstract int getCooldownSeconds();

    /**
     * Translation key displayed when the stop is successfully used.
     */
    protected abstract String getSpinMessageKey();

    /**
     * Translation key displayed when the stop is on cooldown.
     */
    protected abstract String getCooldownMessageKey();

    /**
     * Creates the north-facing voxel shape for this stop.
     */
    protected abstract VoxelShape createShape();

    /**
     * Statistic awarded when the stop is successfully used.
     */
    protected abstract Stat<ResourceLocation> getStats();

    /**
     * Criteria hook fired after a successful use.
     */
    protected abstract void criterionTrigger(ServerPlayer player);

    /**
     * Dummy block placed above the main stop block.
     */
    protected abstract Supplier<? extends Block> getDummyBlock();

    /**
     * Reward behavior executed when the stop is successfully used.
     */
    protected abstract void grantReward(ServerPlayer player);

    private void initializeShapes() {
        shapes.put(Direction.NORTH, baseShape);
        shapes.put(Direction.SOUTH, calculateRotation(Direction.SOUTH, baseShape));
        shapes.put(Direction.EAST, calculateRotation(Direction.EAST, baseShape));
        shapes.put(Direction.WEST, calculateRotation(Direction.WEST, baseShape));
    }

    private static DustColorTransitionOptions createParticle() {
        Vector3f fromColor = new Vector3f(0.0f, 0.75f, 1.0f);
        Vector3f toColor = new Vector3f(0.73f, 0.93f, 0.99f);
        float scale = 1.25f;
        return new DustColorTransitionOptions(fromColor, toColor, scale);
    }

    @Override
    public @NotNull InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hit) {
        if (level.isClientSide) {
            return InteractionResult.SUCCESS;
        }

        if (!(player instanceof ServerPlayer serverPlayer)) {
            return InteractionResult.PASS;
        }

        BlockEntity blockEntity = level.getBlockEntity(pos);
        if (!(blockEntity instanceof StopEntityTemplate stopEntity)) {
            return InteractionResult.PASS;
        }

        ServerLevel serverLevel = (ServerLevel) level;
        if (!stopEntity.canPlayerSpin(serverPlayer)) {
            handleCooldown(serverLevel, pos, serverPlayer, stopEntity);
            return InteractionResult.FAIL;
        }

        grantReward(serverPlayer);
        handleSuccessfulSpin(serverLevel, pos, state, serverPlayer, stopEntity);
        return InteractionResult.SUCCESS;
    }

    private void handleSuccessfulSpin(ServerLevel level, BlockPos pos, BlockState state, ServerPlayer player, StopEntityTemplate stopEntity) {
        stopEntity.setPlayerCooldown(player, getCooldownSeconds());
        level.sendBlockUpdated(pos, state, state, 3);
        stopEntity.triggerAnim("cooldown-spinner", "spin_trigger");
        stopEntity.triggerSpin();
        player.displayClientMessage(Component.translatable(getSpinMessageKey()).withStyle(ChatFormatting.GREEN), true);
        level.sendParticles(PARTICLE, pos.getX() + 0.5, pos.getY() + 2.5, pos.getZ() + 0.5, 100, 0.75, 0.75, 0.75, 0.0);
        level.playSound(null, pos, SoundRegistry.POKESTOP_SPIN.get(), SoundSource.MASTER, 1.0f, 1.0f);
        player.awardStat(getStats());
        criterionTrigger(player);
    }

    private void handleCooldown(ServerLevel level, BlockPos pos, ServerPlayer player, StopEntityTemplate stopEntity) {
        player.displayClientMessage(Component.translatable(getCooldownMessageKey(), stopEntity.getPlayerCooldown(player)).withStyle(ChatFormatting.RED), true);
        level.sendParticles(ParticleTypes.ELECTRIC_SPARK, pos.getX() + 0.5, pos.getY() + 2.5, pos.getZ() + 0.5, 20, 0.2, 0.5, 0.2, 0.0);
        level.playSound(null, pos, CobblemonSounds.POKE_BALL_HIT, SoundSource.MASTER, 1.0f, 1.0f);
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
    public void setPlacedBy(Level level, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {
        BlockState dummyState = getDummyBlock().get().defaultBlockState();
        level.setBlock(pos.above(), dummyState, 3);
        level.setBlock(pos.above(2), dummyState, 3);
    }

    @Override
    public void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean moved) {
        if (!state.is(newState.getBlock())) {
            level.removeBlock(pos.above(), false);
            level.removeBlock(pos.above(2), false);
            super.onRemove(state, level, pos, newState, moved);
        }
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
        if (level.isClientSide) {
            return null;
        }

        if (type == getEntityType().get()) {
            return (lvl, pos, st, be) -> StopEntityTemplate.tick(lvl, (StopEntityTemplate) be);
        }

        return null;
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


