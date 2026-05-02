package dev.matthiesen.common.cobblemon_pokestops.registry;

import dev.matthiesen.common.cobblemon_pokestops.CobblemonPokestops;
import dev.matthiesen.common.cobblemon_pokestops.block.entity.*;
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

    public static final Supplier<BlockEntityType<PokeballstopEntity>> POKEBALLSTOP_BE =
            registerBlockEntity("pokeballstop", () -> buildType(PokeballstopEntity::new, BlockRegistry.POKEBALLSTOPS));

    public static final Supplier<BlockEntityType<HealingstopEntity>> HEALINGSTOP_BE =
            registerBlockEntity("healingstop", () -> buildType(HealingstopEntity::new, BlockRegistry.HEALINGSTOPS));

    public static final Supplier<BlockEntityType<PokestopTrophyEntity>> POKESTOP_TROPHY_BE =
            registerBlockEntity("pokestop_trophy", () -> buildType(PokestopTrophyEntity::new, BlockRegistry.POKESTOP_TROPHIES));

    public static final Supplier<BlockEntityType<WingedstopTrophyEntity>> WINGEDSTOP_TROPHY_BE =
            registerBlockEntity("wingedstop_trophy", () -> buildType(WingedstopTrophyEntity::new, BlockRegistry.WINGEDSTOP_TROPHIES));

    public static final Supplier<BlockEntityType<PokeballstopTrophyEntity>> POKEBALLSTOP_TROPHY_BE =
            registerBlockEntity("pokeballstop_trophy", () -> buildType(PokeballstopTrophyEntity::new, BlockRegistry.POKEBALLSTOP_TROPHIES));

    public static final Supplier<BlockEntityType<HealingstopTrophyEntity>> HEALINGSTOP_TROPHY_BE =
            registerBlockEntity("healingstop_trophy", () -> buildType(HealingstopTrophyEntity::new, BlockRegistry.HEALINGSTOP_TROPHIES));

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
