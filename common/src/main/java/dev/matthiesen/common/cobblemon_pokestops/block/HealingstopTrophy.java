package dev.matthiesen.common.cobblemon_pokestops.block;

import dev.matthiesen.common.cobblemon_pokestops.registry.BlockEntityRegistry;
import dev.matthiesen.common.cobblemon_pokestops.templates.block.TrophyTemplate;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public class HealingstopTrophy extends TrophyTemplate {
    @Override
    protected Supplier<? extends net.minecraft.world.level.block.entity.BlockEntityType<?>> getEntityType() {
        return BlockEntityRegistry.POKEBALLSTOP_TROPHY_BE;
    }

    @Override
    protected @NotNull VoxelShape createShape() {
        VoxelShape shape = Shapes.empty();
        shape = Shapes.join(shape, Shapes.box(0.40625, 0, 0.40625, 0.59375, 0.015625, 0.59375), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.421875, 0.015625, 0.421875, 0.578125, 0.046875, 0.578125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.4375, 0.046875, 0.4375, 0.5625, 0.109375, 0.5625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.484375, 0.109375, 0.484375, 0.515625, 0.625, 0.515625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.4375, 0.625, 0.4375, 0.5625, 0.640625, 0.5625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.421875, 0.640625, 0.421875, 0.578125, 0.65625, 0.578125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.453125, 0.125, 0.484375, 0.46875, 0.140625, 0.515625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.453125, 0.140625, 0.5, 0.46875, 0.15625, 0.53125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.453125, 0.15625, 0.515625, 0.46875, 0.171875, 0.546875), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.453125, 0.171875, 0.53125, 0.484375, 0.1875, 0.546875), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.46875, 0.1875, 0.53125, 0.5, 0.203125, 0.546875), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.484375, 0.203125, 0.53125, 0.515625, 0.21875, 0.546875), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.5, 0.21875, 0.53125, 0.53125, 0.234375, 0.546875), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.515625, 0.234375, 0.53125, 0.546875, 0.25, 0.546875), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.53125, 0.25, 0.515625, 0.546875, 0.265625, 0.546875), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.53125, 0.265625, 0.5, 0.546875, 0.28125, 0.53125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.53125, 0.28125, 0.484375, 0.546875, 0.296875, 0.515625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.53125, 0.296875, 0.46875, 0.546875, 0.3125, 0.5), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.53125, 0.3125, 0.453125, 0.546875, 0.328125, 0.484375), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.515625, 0.328125, 0.453125, 0.546875, 0.34375, 0.46875), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.5, 0.34375, 0.453125, 0.53125, 0.359375, 0.46875), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.484375, 0.359375, 0.453125, 0.515625, 0.375, 0.46875), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.46875, 0.375, 0.453125, 0.5, 0.390625, 0.46875), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.453125, 0.390625, 0.453125, 0.484375, 0.40625, 0.46875), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.453125, 0.40625, 0.453125, 0.46875, 0.421875, 0.484375), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.453125, 0.421875, 0.46875, 0.46875, 0.4375, 0.5), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.453125, 0.4375, 0.484375, 0.46875, 0.453125, 0.515625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.453125, 0.453125, 0.5, 0.46875, 0.46875, 0.53125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.453125, 0.46875, 0.515625, 0.46875, 0.484375, 0.546875), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.453125, 0.484375, 0.53125, 0.484375, 0.5, 0.546875), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.46875, 0.5, 0.53125, 0.5, 0.515625, 0.546875), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.484375, 0.515625, 0.53125, 0.515625, 0.53125, 0.546875), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.5, 0.53125, 0.53125, 0.53125, 0.546875, 0.546875), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.515625, 0.546875, 0.53125, 0.546875, 0.5625, 0.546875), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.53125, 0.5625, 0.515625, 0.546875, 0.578125, 0.546875), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.53125, 0.578125, 0.5, 0.546875, 0.59375, 0.53125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.53125, 0.59375, 0.484375, 0.546875, 0.609375, 0.515625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.53125, 0.609375, 0.46875, 0.546875, 0.625, 0.5), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.453125, 0.109375, 0.46875, 0.46875, 0.125, 0.5), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.53125, 0.609375, 0.453125, 0.546875, 0.625, 0.484375), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.453125, 0.109375, 0.453125, 0.46875, 0.125, 0.484375), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.453125, 0.125, 0.46875, 0.46875, 0.140625, 0.5), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.453125, 0.140625, 0.484375, 0.46875, 0.15625, 0.515625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.453125, 0.15625, 0.5, 0.46875, 0.171875, 0.53125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.453125, 0.171875, 0.515625, 0.484375, 0.1875, 0.53125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.46875, 0.1875, 0.515625, 0.5, 0.203125, 0.53125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.484375, 0.203125, 0.515625, 0.515625, 0.21875, 0.53125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.5, 0.21875, 0.515625, 0.53125, 0.234375, 0.53125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.515625, 0.234375, 0.515625, 0.546875, 0.25, 0.53125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.53125, 0.25, 0.5, 0.546875, 0.265625, 0.53125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.53125, 0.265625, 0.484375, 0.546875, 0.28125, 0.515625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.53125, 0.28125, 0.46875, 0.546875, 0.296875, 0.5), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.53125, 0.296875, 0.453125, 0.546875, 0.3125, 0.484375), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.53125, 0.3125, 0.4375, 0.546875, 0.328125, 0.46875), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.515625, 0.328125, 0.4375, 0.546875, 0.34375, 0.453125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.5, 0.34375, 0.4375, 0.53125, 0.359375, 0.453125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.484375, 0.359375, 0.4375, 0.515625, 0.375, 0.453125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.46875, 0.375, 0.4375, 0.5, 0.390625, 0.453125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.453125, 0.390625, 0.4375, 0.484375, 0.40625, 0.453125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.453125, 0.40625, 0.4375, 0.46875, 0.421875, 0.46875), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.453125, 0.421875, 0.453125, 0.46875, 0.4375, 0.484375), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.453125, 0.4375, 0.46875, 0.46875, 0.453125, 0.5), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.453125, 0.453125, 0.484375, 0.46875, 0.46875, 0.515625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.453125, 0.46875, 0.5, 0.46875, 0.484375, 0.53125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.453125, 0.484375, 0.515625, 0.484375, 0.5, 0.53125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.46875, 0.5, 0.515625, 0.5, 0.515625, 0.53125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.484375, 0.515625, 0.515625, 0.515625, 0.53125, 0.53125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.5, 0.53125, 0.515625, 0.53125, 0.546875, 0.53125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.515625, 0.546875, 0.515625, 0.546875, 0.5625, 0.53125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.53125, 0.5625, 0.5, 0.546875, 0.578125, 0.53125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.53125, 0.578125, 0.484375, 0.546875, 0.59375, 0.515625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.53125, 0.59375, 0.46875, 0.546875, 0.609375, 0.5), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.546875, 0.6484375, 0.453125, 0.5625, 0.6640625, 0.546875), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.4375, 0.6484375, 0.453125, 0.453125, 0.6640625, 0.546875), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.453125, 0.6484375, 0.4375, 0.546875, 0.6640625, 0.453125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.453125, 0.6484375, 0.546875, 0.546875, 0.6640625, 0.5625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.453125, 0.703125, 0.484375, 0.546875, 0.71875, 0.515625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.484375, 0.75, 0.484375, 0.515625, 0.84375, 0.515625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.453125, 0.78125, 0.484375, 0.484375, 0.8125, 0.515625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.515625, 0.78125, 0.484375, 0.546875, 0.8125, 0.515625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.453125, 0.875, 0.484375, 0.546875, 0.890625, 0.515625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.40625, 0.75, 0.484375, 0.421875, 0.84375, 0.515625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.578125, 0.75, 0.484375, 0.59375, 0.84375, 0.515625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.5625, 0.828125, 0.484375, 0.578125, 0.859375, 0.515625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.421875, 0.828125, 0.484375, 0.4375, 0.859375, 0.515625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.421875, 0.734375, 0.484375, 0.4375, 0.765625, 0.515625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.5625, 0.734375, 0.484375, 0.578125, 0.765625, 0.515625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.53125, 0.859375, 0.484375, 0.5625, 0.875, 0.515625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.53125, 0.71875, 0.484375, 0.5625, 0.734375, 0.515625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.4375, 0.71875, 0.484375, 0.46875, 0.734375, 0.515625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.4375, 0.859375, 0.484375, 0.46875, 0.875, 0.515625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.546875, 0.734375, 0.484375, 0.5625, 0.75, 0.515625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.546875, 0.84375, 0.484375, 0.5625, 0.859375, 0.515625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.4375, 0.84375, 0.484375, 0.453125, 0.859375, 0.515625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.4375, 0.734375, 0.484375, 0.453125, 0.75, 0.515625), BooleanOp.OR);
        return shape.optimize();
    }
}
