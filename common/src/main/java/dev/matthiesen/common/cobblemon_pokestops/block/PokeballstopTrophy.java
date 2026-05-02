package dev.matthiesen.common.cobblemon_pokestops.block;

import dev.matthiesen.common.cobblemon_pokestops.registry.BlockEntityRegistry;
import dev.matthiesen.common.cobblemon_pokestops.templates.block.TrophyTemplate;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public class PokeballstopTrophy extends TrophyTemplate {
    @Override
    protected Supplier<? extends net.minecraft.world.level.block.entity.BlockEntityType<?>> getEntityType() {
        return BlockEntityRegistry.POKEBALLSTOP_TROPHY_BE;
    }

    @Override
    protected @NotNull VoxelShape createShape() {
        VoxelShape shape = Shapes.empty();
        shape = Shapes.join(shape, Shapes.box(0.36875, 0, 0.36875, 0.63125, 0.021875, 0.63125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.390625, 0.021875, 0.390625, 0.609375, 0.04375, 0.609375), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.4125, 0.04375, 0.4125, 0.5875, 0.0875, 0.5875), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.434375, 0.0875, 0.434375, 0.565625, 0.175, 0.565625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.45625, 0.175, 0.45625, 0.54375, 0.328125, 0.54375), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.478125, 0.328125, 0.478125, 0.521875, 0.6343749999999999, 0.521875), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.390625, 0.04375, 0.390625, 0.4125, 0.678125, 0.4125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.5875, 0.04375, 0.390625, 0.609375, 0.678125, 0.4125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.5875, 0.04375, 0.5875, 0.609375, 0.678125, 0.609375), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.390625, 0.04375, 0.5875, 0.4125, 0.678125, 0.609375), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.45625, 0.6343749999999999, 0.45625, 0.54375, 0.65625, 0.54375), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.434375, 0.65625, 0.434375, 0.565625, 0.678125, 0.565625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.36875, 0.678125, 0.36875, 0.63125, 0.7, 0.63125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.5875, 0.6890624999999999, 0.390625, 0.609375, 0.7109375, 0.609375), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.390625, 0.6890624999999999, 0.390625, 0.4125, 0.7109375, 0.609375), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.4125, 0.6890624999999999, 0.390625, 0.5875, 0.7109375, 0.4125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.4125, 0.6890624999999999, 0.5875, 0.5875, 0.7109375, 0.609375), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.42265625, 0.77578125, 0.42265625, 0.57734375, 0.8429687499999999, 0.57734375), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.4125, 0.765625, 0.4125, 0.5875, 0.8531249999999999, 0.5875), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.4125, 0.8531249999999999, 0.4125, 0.5875, 0.9406249999999999, 0.5875), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.478125, 0.8312499999999999, 0.406921875, 0.521875, 0.875, 0.406921875), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.4230625, 0.8636874999999999, 0.4230625, 0.5769375, 0.9300624999999999, 0.5769375), BooleanOp.OR);
        return shape.optimize();
    }
}
