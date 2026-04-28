package dev.matthiesen.common.cobblemon_pokestops.registry;

import dev.matthiesen.common.cobblemon_pokestops.CobblemonPokestops;
import dev.matthiesen.common.cobblemon_pokestops.block.entity.PokestopEntity;
import dev.matthiesen.common.cobblemon_pokestops.block.entity.WingedstopEntity;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Supplier;

public class BlockEntityRegistry {
    public static void init() {}

    public static final Supplier<BlockEntityType<PokestopEntity>> POKESTOP_BE =
            registerBlockEntity("pokestop", () -> buildType(PokestopEntity::new, BlockRegistry.POKESTOPS));

    public static final Supplier<BlockEntityType<WingedstopEntity>> WINGEDSTOP_BE =
            registerBlockEntity("wingedstop", () -> buildType(WingedstopEntity::new, BlockRegistry.WINGEDSTOPS));

    private static Block[] resolveBlocks(Map<String, ? extends Supplier<? extends Block>> registeredBlocks) {
        return registeredBlocks.values()
                .stream()
                .map(Supplier::get)
                .toArray(Block[]::new);
    }

    private static <T extends BlockEntity> BlockEntityType<T> buildType(
            BiFunction<net.minecraft.core.BlockPos, net.minecraft.world.level.block.state.BlockState, T> entityFactory,
            Map<String, ? extends Supplier<? extends Block>> registeredBlocks
    ) {
        return BlockEntityType.Builder.of(entityFactory::apply, resolveBlocks(registeredBlocks)).build(null);
    }

    @SuppressWarnings("SameParameterValue")
    private static <T extends BlockEntity> Supplier<BlockEntityType<T>> registerBlockEntity(String id, Supplier<BlockEntityType<T>> blockEntity) {
        return CobblemonPokestops.COMMON_PLATFORM.registerBlockEntity(id, blockEntity);
    }
}
