package dev.matthiesen.common.cobblemon_pokestops.block;

import dev.matthiesen.common.cobblemon_pokestops.registry.*;
import dev.matthiesen.common.cobblemon_pokestops.templates.block.TrophyTemplate;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public class WingedstopTrophy extends TrophyTemplate {
    @Override
    protected Supplier<? extends net.minecraft.world.level.block.entity.BlockEntityType<?>> getEntityType() {
        return BlockEntityRegistry.WINGEDSTOP_TROPHY_BE;
    }

    @Override
    protected @NotNull VoxelShape createShape() {
        VoxelShape shape = Shapes.empty();
        shape = Shapes.join(shape, Shapes.box(0.35, 0, 0.35, 0.65, 0.025, 0.65), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.4, 0.025, 0.4, 0.6, 0.05, 0.6), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.45, 0.05, 0.45, 0.55, 0.2, 0.55), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.475, 0.2, 0.475, 0.525, 0.55, 0.525), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.425, 0.55, 0.425, 0.575, 0.5750000000000001, 0.575), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.45, 0.7000000000000001, 0.55, 0.55, 0.7250000000000001, 0.625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.45, 0.7000000000000001, 0.375, 0.55, 0.7250000000000001, 0.45), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.375, 0.7000000000000001, 0.375, 0.45, 0.7250000000000001, 0.625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.55, 0.7000000000000001, 0.375, 0.625, 0.7250000000000001, 0.625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.4, 0.625, 0.4, 0.6, 0.65, 0.6), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.4625, 0.4625, 0.4875, 0.4875, 0.7375, 0.5125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.4875, 0.4625, 0.5125, 0.5125, 0.7375, 0.5375), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.4875, 0.45625000000000004, 0.4625, 0.5125, 0.7312500000000001, 0.4875), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.5125, 0.4625, 0.4875, 0.5375, 0.7375, 0.5125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.475, 0.75, 0.475, 0.525, 0.8, 0.525), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.475, 0.8, 0.475, 0.525, 0.8500000000000001, 0.525), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.49375, 0.76875, 0.4875, 0.64375, 0.7937500000000001, 0.5125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.49375, 0.7937500000000001, 0.4875, 0.64375, 0.8187500000000001, 0.5125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.49375, 0.8187500000000001, 0.4875, 0.64375, 0.84375, 0.5125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.49375, 0.84375, 0.4875, 0.64375, 0.86875, 0.5125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.46875, 0.84375, 0.4875, 0.66875, 0.86875, 0.5125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.46875, 0.84375, 0.4875, 0.69375, 0.86875, 0.5125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.46875, 0.84375, 0.4875, 0.71875, 0.86875, 0.5125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.35624999999999996, 0.76875, 0.4875, 0.50625, 0.7937500000000001, 0.5125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.35624999999999996, 0.7937500000000001, 0.4875, 0.50625, 0.8187500000000001, 0.5125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.35624999999999996, 0.8187500000000001, 0.4875, 0.50625, 0.84375, 0.5125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.35624999999999996, 0.84375, 0.4875, 0.50625, 0.86875, 0.5125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.33125, 0.84375, 0.4875, 0.53125, 0.86875, 0.5125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.30625, 0.84375, 0.4875, 0.53125, 0.86875, 0.5125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.28125, 0.84375, 0.4875, 0.53125, 0.86875, 0.5125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.4, 0.8, 0.4, 0.6, 1, 0.6), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.425, 0.7875000000000001, 0.425, 0.575, 0.8125, 0.575), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.5875, 0.8250000000000001, 0.425, 0.6125, 0.9750000000000001, 0.575), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.3875, 0.8250000000000001, 0.425, 0.4125, 0.9750000000000001, 0.575), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.425, 0.8250000000000001, 0.3875, 0.575, 0.9750000000000001, 0.4125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.425, 0.8250000000000001, 0.5875, 0.575, 0.9750000000000001, 0.6125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.425, 0.9875, 0.425, 0.575, 1.0125, 0.575), BooleanOp.OR);
        return shape.optimize();
    }
}
