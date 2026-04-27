package dev.matthiesen.common.cobblemon_pokestops.registry;

import dev.matthiesen.common.cobblemon_pokestops.CobblemonPokestops;
import dev.matthiesen.common.cobblemon_pokestops.block.entity.PokestopEntity;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.function.Supplier;

public class BlockEntityRegistry {
    public static void init() {}

    public static final Supplier<BlockEntityType<PokestopEntity>> POKESTOP_BE =
            registerBlockEntity("pokestop", () -> BlockEntityType.Builder.of(
                    PokestopEntity::new,
                    BlockRegistry.POKESTOPS.values()
                            .stream()
                            .map(Supplier::get)
                            .toArray(net.minecraft.world.level.block.Block[]::new)
            ).build(null));

    @SuppressWarnings("SameParameterValue")
    private static <T extends BlockEntity> Supplier<BlockEntityType<T>> registerBlockEntity(String id, Supplier<BlockEntityType<T>> blockEntity) {
        return CobblemonPokestops.COMMON_PLATFORM.registerBlockEntity(id, blockEntity);
    }
}
