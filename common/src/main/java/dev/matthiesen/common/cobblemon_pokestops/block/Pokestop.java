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

public class Pokestop extends LootStopTemplate {
    @Override
    protected Supplier<? extends net.minecraft.world.level.block.entity.BlockEntityType<?>> getEntityType() {
        return BlockEntityRegistry.POKESTOP_BE;
    }

    @Override
    protected int getCooldownSeconds() {
        return CobblemonPokestops.config.pokestopCooldownSeconds;
    }

    @Override
    @NotNull
    protected ResourceKey<LootTable> getLootTableKey() {
        return ModLootTables.POKESTOP_LOOT;
    }

    @Override
    protected String getSpinMessageKey() {
        return "message.cobblemon_pokestops.pokestop_spin";
    }

    @Override
    protected String getCooldownMessageKey() {
        return "message.cobblemon_pokestops.pokestop_cooldown";
    }

    @Override
    protected Stat<ResourceLocation> getStats() {
        return StatsRegistry.getPokestopTimesSpunStat();
    }

    @Override
    protected void criterionTrigger(ServerPlayer player) {
        CriterionTriggerRegistry.POKESTOP_SCORE.get().trigger(player);
        CriterionTriggerRegistry.USE_POKESTOP.get().trigger(player);
    }

    @Override
    protected String getBroadcastPrefix() {
        return "PokeStop";
    }

    @Override
    @SuppressWarnings("override")
    protected Supplier<? extends Block> getDummyBlock() {
        return BlockRegistry.POKESTOP_DUMMY;
    }

    @Override
    protected @NotNull VoxelShape createShape() {
        VoxelShape shape = Shapes.empty();
        shape = Shapes.join(shape, Shapes.box(0.1875, 0, 0.1875, 0.8125, 0.0625, 0.8125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.3125, 0.0625, 0.3125, 0.6875, 0.6875, 0.6875), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.375, 0.6875, 0.375, 0.625, 2.0625, 0.625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.3125, 2.0625, 0.3125, 0.6875, 2.1875, 0.6875), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.25, 2.1875, 0.25, 0.75, 2.25, 0.75), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.1875, 2.25, 0.1875, 0.8125, 2.375, 0.8125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.125, 2.625, 0.125, 0.875, 3.375, 0.875), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.375, 2.625, 0.125, 0.625, 2.8125, 0.875), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.375, 2.8125, 0.125, 0.625, 2.9375, 0.25), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.375, 2.8125, 0.75, 0.625, 2.9375, 0.875), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.375, 3, 0.125, 0.625, 3.1875, 0.875), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.375, 3.1875, 0.125, 0.625, 3.3125, 0.25), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.375, 3.1875, 0.75, 0.625, 3.3125, 0.875), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.375, 2.875, 0.375, 0.625, 3.125, 0.625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.4375, 2.4375, 0.0625, 0.5625, 2.5625, 0.9375), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.4375, 3.4375, 0.0625, 0.5625, 3.5625, 0.9375), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.4375, 2.5625, 0.9375, 0.5625, 3.4375, 1.0625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.4375, 2.5625, -0.0625, 0.5625, 3.4375, 0.0625), BooleanOp.OR);
        return shape.optimize();
    }
}
