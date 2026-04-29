package dev.matthiesen.common.cobblemon_pokestops.block;

import dev.matthiesen.common.cobblemon_pokestops.CobblemonPokestops;
import dev.matthiesen.common.cobblemon_pokestops.registry.*;
import dev.matthiesen.common.cobblemon_pokestops.templates.block.LootStopTemplate;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stat;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public class Wingedstop extends LootStopTemplate {
    @Override
    protected Supplier<? extends net.minecraft.world.level.block.entity.BlockEntityType<?>> getEntityType() {
        return BlockEntityRegistry.WINGEDSTOP_BE;
    }

    @Override
    protected int getCooldownSeconds() {
        return CobblemonPokestops.config.wingedstopCooldownSeconds;
    }

    @Override
    @NotNull
    protected ResourceKey<LootTable> getLootTableKey() {
        return ModLootTables.WINGEDSTOP_LOOT;
    }

    @Override
    protected String getSpinMessageKey() {
        return "message.cobblemon_pokestops.wingedstop_spin";
    }

    @Override
    protected String getCooldownMessageKey() {
        return "message.cobblemon_pokestops.wingedstop_cooldown";
    }

    @Override
    protected String getBroadcastPrefix() {
        return "Winged PokéStop";
    }

    @Override
    protected Stat<ResourceLocation> getStats() {
        return StatsRegistry.getWingedstopTimesSpunStat();
    }

    @Override
    protected void criterionTrigger(ServerPlayer player) {
        CriterionTriggerRegistry.WINGED_POKESTOP_SCORE.get().trigger(player);
        CriterionTriggerRegistry.USE_WINGED_POKESTOP.get().trigger(player);
    }

    @Override
    @SuppressWarnings("override")
    protected Supplier<? extends Block> getDummyBlock() {
        return BlockRegistry.WINGEDSTOP_DUMMY;
    }

    @Override
    protected @NotNull VoxelShape createShape() {
        VoxelShape shape = Shapes.empty();
        shape = Shapes.join(shape, Shapes.box(0.125, 0, 0.125, 0.875, 0.0625, 0.875), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.25, 0.0625, 0.25, 0.75, 0.125, 0.75), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.375, 0.125, 0.375, 0.625, 0.5, 0.625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.4375, 0.5, 0.4375, 0.5625, 1.375, 0.5625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.3125, 1.375, 0.3125, 0.6875, 1.4375, 0.6875), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.375, 1.75, 0.625, 0.625, 1.8125, 0.8125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.375, 1.75, 0.1875, 0.625, 1.8125, 0.375), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.1875, 1.75, 0.1875, 0.375, 1.8125, 0.8125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.625, 1.75, 0.1875, 0.8125, 1.8125, 0.8125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.25, 1.5625, 0.25, 0.75, 1.625, 0.75), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.40625, 1.15625, 0.46875, 0.46875, 1.84375, 0.53125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.46875, 1.15625, 0.53125, 0.53125, 1.84375, 0.59375), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.46875, 1.140625, 0.40625, 0.53125, 1.828125, 0.46875), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.53125, 1.15625, 0.46875, 0.59375, 1.84375, 0.53125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.4375, 1.875, 0.4375, 0.5625, 2, 0.5625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.4375, 2, 0.4375, 0.5625, 2.125, 0.5625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.484375, 1.921875, 0.46875, 0.859375, 1.984375, 0.53125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.484375, 1.984375, 0.46875, 0.859375, 2.046875, 0.53125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.484375, 2.046875, 0.46875, 0.859375, 2.109375, 0.53125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.484375, 2.109375, 0.46875, 0.859375, 2.171875, 0.53125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.421875, 2.109375, 0.46875, 0.921875, 2.171875, 0.53125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.421875, 2.109375, 0.46875, 0.984375, 2.171875, 0.53125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.421875, 2.109375, 0.46875, 1.046875, 2.171875, 0.53125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.140625, 1.921875, 0.46875, 0.515625, 1.984375, 0.53125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.140625, 1.984375, 0.46875, 0.515625, 2.046875, 0.53125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.140625, 2.046875, 0.46875, 0.515625, 2.109375, 0.53125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.140625, 2.109375, 0.46875, 0.515625, 2.171875, 0.53125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.078125, 2.109375, 0.46875, 0.578125, 2.171875, 0.53125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.015625, 2.109375, 0.46875, 0.578125, 2.171875, 0.53125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(-0.046875, 2.109375, 0.46875, 0.578125, 2.171875, 0.53125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.25, 2, 0.25, 0.75, 2.5, 0.75), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.3125, 1.96875, 0.3125, 0.6875, 2.03125, 0.6875), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.71875, 2.0625, 0.3125, 0.78125, 2.4375, 0.6875), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.21875, 2.0625, 0.3125, 0.28125, 2.4375, 0.6875), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.3125, 2.0625, 0.21875, 0.6875, 2.4375, 0.28125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.3125, 2.0625, 0.71875, 0.6875, 2.4375, 0.78125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.3125, 2.46875, 0.3125, 0.6875, 2.53125, 0.6875), BooleanOp.OR);
        return shape.optimize();
    }
}
