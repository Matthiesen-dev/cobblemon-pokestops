package dev.matthiesen.common.cobblemon_pokestops.registry;

import dev.matthiesen.common.cobblemon_pokestops.CobblemonPokestops;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.function.Supplier;

public class BlockEntityRegistry {
    public static void init() {}

//    public static final Supplier<BlockEntityType<GeckoHabitatBlockEntity>> GECKO_HABITAT =
//            registerBlockEntity("habitat", () -> BlockEntityType.Builder.of(GeckoHabitatBlockEntity::new, BlockRegistry.GECKO_HABITAT.get()).build(null));

    private static <T extends BlockEntity> Supplier<BlockEntityType<T>> registerBlockEntity(String id, Supplier<BlockEntityType<T>> blockEntity) {
        return CobblemonPokestops.COMMON_PLATFORM.registerBlockEntity(id, blockEntity);
    }
}
