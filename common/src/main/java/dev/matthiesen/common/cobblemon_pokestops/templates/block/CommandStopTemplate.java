package dev.matthiesen.common.cobblemon_pokestops.templates.block;

import com.cobblemon.mod.common.CobblemonSounds;
import com.google.common.collect.Maps;
import com.mojang.serialization.MapCodec;
import dev.matthiesen.common.cobblemon_pokestops.registry.SoundRegistry;
import dev.matthiesen.common.cobblemon_pokestops.templates.entity.StopEntityTemplate;
import dev.matthiesen.common.cobblemon_pokestops.utils.Commander;
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

public abstract class CommandStopTemplate extends HorizontalDirectionalBlock implements EntityBlock {
    private static final DustColorTransitionOptions PARTICLE = createParticle();
    private final Map<Direction, VoxelShape> shapes = Maps.newEnumMap(Direction.class);
    private final VoxelShape baseShape;

    public CommandStopTemplate() {
        super(Properties.of().noOcclusion().strength(-1.0f, -1.0f));
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
        this.baseShape = createShape();
        initializeShapes();
    }

    /**
     * Subclasses must provide the entity type for this stop.
     */
    protected abstract Supplier<? extends BlockEntityType<?>> getEntityType();

    /**
     * Subclasses must provide the cooldown duration in seconds from config.
     */
    protected abstract int getCooldownSeconds();

    /**
     * Subclasses must provide the reward command
     * <br>
     * Available Placeholders:<br>
     * - %player%
     */
    @NotNull
    protected abstract String getRewardCommand();

    /**
     * Subclasses must provide the spin message translation key.
     */
    protected abstract String getSpinMessageKey();

    /**
     * Subclasses must provide the cooldown message translation key.
     */
    protected abstract String getCooldownMessageKey();

    /**
     * Subclasses must provide the VoxelShape representing this stop's structure.
     */
    protected abstract VoxelShape createShape();

    protected abstract Stat<ResourceLocation> getStats();

    protected abstract void criterionTrigger(ServerPlayer player);

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
        if (level.isClientSide) return InteractionResult.SUCCESS;

        BlockEntity blockEntity = level.getBlockEntity(pos);
        if (blockEntity instanceof StopEntityTemplate be) {
            ServerLevel serverLevel = (ServerLevel) level;
            if (be.canPlayerSpin(player)) {
                String command = getRewardCommand().replace("%player%", player.getName().getString());
                Commander.runServerCommand(command);
                be.setPlayerCooldown(player, getCooldownSeconds());
                level.sendBlockUpdated(pos, state, state, 3);
                be.triggerAnim("cooldown-spinner", "spin_trigger");
                be.triggerSpin();
                player.displayClientMessage(Component.translatable(getSpinMessageKey())
                        .withStyle(ChatFormatting.GREEN), true);
                serverLevel.sendParticles(
                        PARTICLE,
                        pos.getX() + 0.5, pos.getY() + 2.5, pos.getZ() + 0.5,
                        100, 0.75, 0.75, 0.75, 0.0
                );
                serverLevel.playSound(null, pos, SoundRegistry.POKESTOP_SPIN.get(), SoundSource.MASTER, 1.0f, 1.0f);
                player.awardStat(getStats());
                criterionTrigger((ServerPlayer) player);
                return InteractionResult.SUCCESS;
            } else {
                player.displayClientMessage(Component.translatable(getCooldownMessageKey(), be.getPlayerCooldown(player))
                        .withStyle(ChatFormatting.RED), true);
                serverLevel.sendParticles(
                        ParticleTypes.ELECTRIC_SPARK,
                        pos.getX() + 0.5, pos.getY() + 2.5, pos.getZ() + 0.5,
                        20, 0.2, 0.5, 0.2, 0.0
                );
                serverLevel.playSound(null, pos, CobblemonSounds.POKE_BALL_HIT, SoundSource.MASTER, 1.0f, 1.0f);
                return InteractionResult.FAIL;
            }
        }
        return InteractionResult.PASS;
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
        // Automatically place dummy blocks above
        level.setBlock(pos.above(), getDummyBlock().get().defaultBlockState(), 3);
        level.setBlock(pos.above(2), getDummyBlock().get().defaultBlockState(), 3);
    }

    /**
     * Subclasses must provide the dummy block to place above this stop.
     */
    protected abstract Supplier<? extends Block> getDummyBlock();

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
        if (level.isClientSide) return null;
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
