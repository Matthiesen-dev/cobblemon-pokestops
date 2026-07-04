package dev.matthiesen.cobblemon_pokestops.common.registry;

import dev.matthiesen.cobblemon_pokestops.common.CobblemonPokestopsCommon;
import dev.matthiesen.cobblemon_pokestops.common.block.entity.DummyBlockEntity;
import dev.matthiesen.cobblemon_pokestops.common.block.entity.stops.*;
import dev.matthiesen.cobblemon_pokestops.common.block.entity.trophies.*;
import dev.matthiesen.common.matthiesen_lib.registry.AbstractBlockEntityRegistry;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Supplier;

public class BlockEntityRegistry extends AbstractBlockEntityRegistry {
    private static final BlockEntityRegistry INSTANCE = new BlockEntityRegistry();

    private BlockEntityRegistry() {
        super(CobblemonPokestopsCommon.MOD_ID);
    }

    public static final Supplier<BlockEntityType<PokestopEntity>> POKESTOP_BE;
    public static final Supplier<BlockEntityType<WingedstopEntity>> WINGEDSTOP_BE;
    public static final Supplier<BlockEntityType<PokeballstopEntity>> POKEBALLSTOP_BE;
    public static final Supplier<BlockEntityType<HealingstopEntity>> HEALINGSTOP_BE;
    public static final Supplier<BlockEntityType<PokestopTrophyEntity>> POKESTOP_TROPHY_BE;
    public static final Supplier<BlockEntityType<WingedstopTrophyEntity>> WINGEDSTOP_TROPHY_BE;
    public static final Supplier<BlockEntityType<PokeballstopTrophyEntity>> POKEBALLSTOP_TROPHY_BE;
    public static final Supplier<BlockEntityType<HealingstopTrophyEntity>> HEALINGSTOP_TROPHY_BE;
    public static final Supplier<BlockEntityType<DummyBlockEntity>> DUMMY_BE;

    static {
        POKESTOP_BE = registerBlockEntity("pokestop", () -> buildType(PokestopEntity::new, BlockRegistry.POKESTOPS));
        WINGEDSTOP_BE = registerBlockEntity("wingedstop", () -> buildType(WingedstopEntity::new, BlockRegistry.WINGEDSTOPS));
        POKEBALLSTOP_BE = registerBlockEntity("pokeballstop", () -> buildType(PokeballstopEntity::new, BlockRegistry.POKEBALLSTOPS));
        HEALINGSTOP_BE = registerBlockEntity("healingstop", () -> buildType(HealingstopEntity::new, BlockRegistry.HEALINGSTOPS));
        POKESTOP_TROPHY_BE = registerBlockEntity("pokestop_trophy", () -> buildType(PokestopTrophyEntity::new, BlockRegistry.POKESTOP_TROPHIES));
        WINGEDSTOP_TROPHY_BE = registerBlockEntity("wingedstop_trophy", () -> buildType(WingedstopTrophyEntity::new, BlockRegistry.WINGEDSTOP_TROPHIES));
        POKEBALLSTOP_TROPHY_BE = registerBlockEntity("pokeballstop_trophy", () -> buildType(PokeballstopTrophyEntity::new, BlockRegistry.POKEBALLSTOP_TROPHIES));
        HEALINGSTOP_TROPHY_BE = registerBlockEntity("healingstop_trophy", () -> buildType(HealingstopTrophyEntity::new, BlockRegistry.HEALINGSTOP_TROPHIES));
        DUMMY_BE = registerBlockEntity("dummy_block_entity", () -> buildType(DummyBlockEntity::new, BlockRegistry.DUMMY_BLOCKS));
    }

    public static void init() {}

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
        return INSTANCE.register(id, blockEntity);
    }
}
