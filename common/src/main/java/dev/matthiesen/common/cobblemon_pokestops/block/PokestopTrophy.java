package dev.matthiesen.common.cobblemon_pokestops.block;

import dev.matthiesen.common.cobblemon_pokestops.registry.BlockEntityRegistry;
import dev.matthiesen.common.cobblemon_pokestops.templates.block.TrophyTemplate;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public class PokestopTrophy extends TrophyTemplate {
    @Override
    protected Supplier<? extends net.minecraft.world.level.block.entity.BlockEntityType<?>> getEntityType() {
        return BlockEntityRegistry.POKESTOP_TROPHY_BE;
    }

    @Override
    protected @NotNull VoxelShape createShape() {
        VoxelShape shape = Shapes.empty();
        shape = Shapes.join(shape, Shapes.box(0.404375, 0, 0.404375, 0.595625, 0.019125, 0.595625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.442625, 0.019125, 0.442625, 0.557375, 0.21037499999999998, 0.557375), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.46175, 0.21037499999999998, 0.46175, 0.53825, 0.631125, 0.53825), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.442625, 0.631125, 0.442625, 0.557375, 0.669375, 0.557375), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.4235, 0.669375, 0.4235, 0.5765, 0.6884999999999999, 0.5765), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.404375, 0.6884999999999999, 0.404375, 0.595625, 0.72675, 0.595625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.38525, 0.80325, 0.38525, 0.61475, 1.03275, 0.61475), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.46175, 0.80325, 0.38525, 0.53825, 0.860625, 0.61475), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.46175, 0.860625, 0.38525, 0.53825, 0.898875, 0.4235), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.46175, 0.860625, 0.5765, 0.53825, 0.898875, 0.61475), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.46175, 0.9179999999999999, 0.38525, 0.53825, 0.975375, 0.61475), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.46175, 0.975375, 0.38525, 0.53825, 1.013625, 0.4235), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.46175, 0.975375, 0.5765, 0.53825, 1.013625, 0.61475), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.46175, 0.8797499999999999, 0.46175, 0.53825, 0.95625, 0.53825), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.480875, 0.745875, 0.366125, 0.519125, 0.784125, 0.633875), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.480875, 1.0518750000000001, 0.366125, 0.519125, 1.0901249999999998, 0.633875), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.480875, 0.784125, 0.633875, 0.519125, 1.0518750000000001, 0.672125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.480875, 0.784125, 0.327875, 0.519125, 1.0518750000000001, 0.366125), BooleanOp.OR);
        return shape.optimize();
    }
}
