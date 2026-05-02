package dev.matthiesen.common.cobblemon_pokestops.block;

import dev.matthiesen.common.cobblemon_pokestops.CobblemonPokestops;
import dev.matthiesen.common.cobblemon_pokestops.registry.*;
import dev.matthiesen.common.cobblemon_pokestops.templates.block.CommandStopTemplate;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stat;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public class Healingstop extends CommandStopTemplate {
    @Override
    protected Supplier<? extends net.minecraft.world.level.block.entity.BlockEntityType<?>> getEntityType() {
        return BlockEntityRegistry.HEALINGSTOP_BE;
    }

    @Override
    protected int getCooldownSeconds() {
        return CobblemonPokestops.config.healingstopCooldownSeconds;
    }

    @Override
    protected @NotNull String getRewardCommand() {
        return "healpokemon %player%";
    }


    @Override
    protected String getSpinMessageKey() {
        return "message.cobblemon_pokestops.healingstop_spin";
    }

    @Override
    protected String getCooldownMessageKey() {
        return "message.cobblemon_pokestops.healingstop_cooldown";
    }

    @Override
    protected Stat<ResourceLocation> getStats() {
        return StatsRegistry.getHealingstopTimesSpunStat();
    }

    @Override
    protected void criterionTrigger(ServerPlayer player) {
        CriterionTriggerRegistry.HEALINGSTOP_SCORE.get().trigger(player);
        CriterionTriggerRegistry.USE_HEALINGSTOP.get().trigger(player);
    }

    @Override
    @SuppressWarnings("override")
    protected Supplier<? extends Block> getDummyBlock() {
        return BlockRegistry.HEALINGSTOP_DUMMY;
    }

    @Override
    protected @NotNull VoxelShape createShape() {
        VoxelShape shape = Shapes.empty();
        shape = Shapes.join(shape, Shapes.box(0.125, 0, 0.125, 0.875, 0.0625, 0.875), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.1875, 0.0625, 0.1875, 0.8125, 0.1875, 0.8125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.25, 0.1875, 0.25, 0.75, 0.4375, 0.75), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.4375, 0.4375, 0.4375, 0.5625, 2.5, 0.5625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.25, 2.5, 0.25, 0.75, 2.5625, 0.75), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.1875, 2.5625, 0.1875, 0.8125, 2.625, 0.8125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.3125, 0.5, 0.4375, 0.375, 0.5625, 0.5625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.3125, 0.5625, 0.5, 0.375, 0.625, 0.625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.3125, 0.625, 0.5625, 0.375, 0.6875, 0.6875), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.3125, 0.6875, 0.625, 0.4375, 0.75, 0.6875), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.375, 0.75, 0.625, 0.5, 0.8125, 0.6875), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.4375, 0.8125, 0.625, 0.5625, 0.875, 0.6875), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.5, 0.875, 0.625, 0.625, 0.9375, 0.6875), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.5625, 0.9375, 0.625, 0.6875, 1, 0.6875), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.625, 1, 0.5625, 0.6875, 1.0625, 0.6875), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.625, 1.0625, 0.5, 0.6875, 1.125, 0.625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.625, 1.125, 0.4375, 0.6875, 1.1875, 0.5625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.625, 1.1875, 0.375, 0.6875, 1.25, 0.5), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.625, 1.25, 0.3125, 0.6875, 1.3125, 0.4375), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.5625, 1.3125, 0.3125, 0.6875, 1.375, 0.375), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.5, 1.375, 0.3125, 0.625, 1.4375, 0.375), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.4375, 1.4375, 0.3125, 0.5625, 1.5, 0.375), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.375, 1.5, 0.3125, 0.5, 1.5625, 0.375), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.3125, 1.5625, 0.3125, 0.4375, 1.625, 0.375), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.3125, 1.625, 0.3125, 0.375, 1.6875, 0.4375), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.3125, 1.6875, 0.375, 0.375, 1.75, 0.5), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.3125, 1.75, 0.4375, 0.375, 1.8125, 0.5625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.3125, 1.8125, 0.5, 0.375, 1.875, 0.625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.3125, 1.875, 0.5625, 0.375, 1.9375, 0.6875), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.3125, 1.9375, 0.625, 0.4375, 2, 0.6875), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.375, 2, 0.625, 0.5, 2.0625, 0.6875), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.4375, 2.0625, 0.625, 0.5625, 2.125, 0.6875), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.5, 2.125, 0.625, 0.625, 2.1875, 0.6875), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.5625, 2.1875, 0.625, 0.6875, 2.25, 0.6875), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.625, 2.25, 0.5625, 0.6875, 2.3125, 0.6875), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.625, 2.3125, 0.5, 0.6875, 2.375, 0.625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.625, 2.375, 0.4375, 0.6875, 2.4375, 0.5625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.625, 2.4375, 0.375, 0.6875, 2.5, 0.5), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.3125, 0.4375, 0.375, 0.375, 0.5, 0.5), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.625, 2.4375, 0.3125, 0.6875, 2.5, 0.4375), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.3125, 0.4375, 0.3125, 0.375, 0.5, 0.4375), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.3125, 0.5, 0.375, 0.375, 0.5625, 0.5), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.3125, 0.5625, 0.4375, 0.375, 0.625, 0.5625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.3125, 0.625, 0.5, 0.375, 0.6875, 0.625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.3125, 0.6875, 0.5625, 0.4375, 0.75, 0.625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.375, 0.75, 0.5625, 0.5, 0.8125, 0.625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.4375, 0.8125, 0.5625, 0.5625, 0.875, 0.625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.5, 0.875, 0.5625, 0.625, 0.9375, 0.625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.5625, 0.9375, 0.5625, 0.6875, 1, 0.625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.625, 1, 0.5, 0.6875, 1.0625, 0.625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.625, 1.0625, 0.4375, 0.6875, 1.125, 0.5625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.625, 1.125, 0.375, 0.6875, 1.1875, 0.5), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.625, 1.1875, 0.3125, 0.6875, 1.25, 0.4375), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.625, 1.25, 0.25, 0.6875, 1.3125, 0.375), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.5625, 1.3125, 0.25, 0.6875, 1.375, 0.3125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.5, 1.375, 0.25, 0.625, 1.4375, 0.3125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.4375, 1.4375, 0.25, 0.5625, 1.5, 0.3125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.375, 1.5, 0.25, 0.5, 1.5625, 0.3125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.3125, 1.5625, 0.25, 0.4375, 1.625, 0.3125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.3125, 1.625, 0.25, 0.375, 1.6875, 0.375), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.3125, 1.6875, 0.3125, 0.375, 1.75, 0.4375), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.3125, 1.75, 0.375, 0.375, 1.8125, 0.5), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.3125, 1.8125, 0.4375, 0.375, 1.875, 0.5625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.3125, 1.875, 0.5, 0.375, 1.9375, 0.625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.3125, 1.9375, 0.5625, 0.4375, 2, 0.625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.375, 2, 0.5625, 0.5, 2.0625, 0.625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.4375, 2.0625, 0.5625, 0.5625, 2.125, 0.625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.5, 2.125, 0.5625, 0.625, 2.1875, 0.625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.5625, 2.1875, 0.5625, 0.6875, 2.25, 0.625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.625, 2.25, 0.5, 0.6875, 2.3125, 0.625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.625, 2.3125, 0.4375, 0.6875, 2.375, 0.5625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.625, 2.375, 0.375, 0.6875, 2.4375, 0.5), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.6875, 2.59375, 0.3125, 0.75, 2.65625, 0.6875), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.25, 2.59375, 0.3125, 0.3125, 2.65625, 0.6875), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.3125, 2.59375, 0.25, 0.6875, 2.65625, 0.3125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.3125, 2.59375, 0.6875, 0.6875, 2.65625, 0.75), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.3125, 2.8125, 0.4375, 0.6875, 2.875, 0.5625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.4375, 3, 0.4375, 0.5625, 3.375, 0.5625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.3125, 3.125, 0.4375, 0.4375, 3.25, 0.5625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.5625, 3.125, 0.4375, 0.6875, 3.25, 0.5625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.3125, 3.5, 0.4375, 0.6875, 3.5625, 0.5625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.125, 3, 0.4375, 0.1875, 3.375, 0.5625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.8125, 3, 0.4375, 0.875, 3.375, 0.5625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.75, 3.3125, 0.4375, 0.8125, 3.4375, 0.5625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.1875, 3.3125, 0.4375, 0.25, 3.4375, 0.5625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.1875, 2.9375, 0.4375, 0.25, 3.0625, 0.5625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.75, 2.9375, 0.4375, 0.8125, 3.0625, 0.5625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.625, 3.4375, 0.4375, 0.75, 3.5, 0.5625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.625, 2.875, 0.4375, 0.75, 2.9375, 0.5625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.25, 2.875, 0.4375, 0.375, 2.9375, 0.5625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.25, 3.4375, 0.4375, 0.375, 3.5, 0.5625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.6875, 2.9375, 0.4375, 0.75, 3, 0.5625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.6875, 3.375, 0.4375, 0.75, 3.4375, 0.5625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.25, 3.375, 0.4375, 0.3125, 3.4375, 0.5625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.25, 2.9375, 0.4375, 0.3125, 3, 0.5625), BooleanOp.OR);
        return shape.optimize();
    }
}
