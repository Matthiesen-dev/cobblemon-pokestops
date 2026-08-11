package dev.matthiesen.cobblemon_pokestops.common.block.entity;

import dev.matthiesen.cobblemon_pokestops.common.templates.entity.StopEntityTemplate;
import dev.matthiesen.cobblemon_pokestops.common.registry.BlockEntityRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public final class DummyBlockEntity extends BlockEntity {
    public DummyBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(BlockEntityRegistry.DUMMY_BE.get(), blockPos, blockState);

    }

    public StopEntityTemplate getParentEntity(Level level, BlockPos pos) {
        int parentSearchDepth = 2;
        for (int i = 0; i < parentSearchDepth; i++) {
            pos = pos.below();
            BlockEntity blockEntity = level.getBlockEntity(pos);
            if (blockEntity instanceof StopEntityTemplate stopEntity) {
                return stopEntity;
            }
        }
        return null;
    }
}
