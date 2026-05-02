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

public class Pokeballstop extends LootStopTemplate {
    @Override
    protected Supplier<? extends net.minecraft.world.level.block.entity.BlockEntityType<?>> getEntityType() {
        return BlockEntityRegistry.POKEBALLSTOP_BE;
    }

    @Override
    protected int getCooldownSeconds() {
        return CobblemonPokestops.config.pokeballstopCooldownSeconds;
    }

    @Override
    @NotNull
    protected ResourceKey<LootTable> getLootTableKey() {
        return ModLootTables.POKEBALLSTOP_LOOT;
    }

    @Override
    protected String getSpinMessageKey() {
        return "message.cobblemon_pokestops.pokeballstop_spin";
    }

    @Override
    protected String getCooldownMessageKey() {
        return "message.cobblemon_pokestops.pokeballstop_cooldown";
    }

    @Override
    protected Stat<ResourceLocation> getStats() {
        return StatsRegistry.getPokeballstopTimesSpunStat();
    }

    @Override
    protected void criterionTrigger(ServerPlayer player) {
        CriterionTriggerRegistry.POKEBALLSTOP_SCORE.get().trigger(player);
        CriterionTriggerRegistry.USE_POKEBALLSTOP.get().trigger(player);
    }

    @Override
    protected String getBroadcastPrefix() {
        return "Pokeball Stop";
    }

    @Override
    @SuppressWarnings("override")
    protected Supplier<? extends Block> getDummyBlock() {
        return BlockRegistry.POKEBALLSTOP_DUMMY;
    }

    @Override
    protected @NotNull VoxelShape createShape() {
        VoxelShape shape = Shapes.empty();
        shape = Shapes.join(shape, Shapes.box(0.125, 0, 0.125, 0.875, 0.0625, 0.875), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.1875, 0.0625, 0.1875, 0.8125, 0.125, 0.8125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.25, 0.125, 0.25, 0.75, 0.25, 0.75), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.3125, 0.25, 0.3125, 0.6875, 0.5, 0.6875), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.375, 0.5, 0.375, 0.625, 0.9375, 0.625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.4375, 0.9375, 0.4375, 0.5625, 1.8125, 0.5625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.1875, 0.125, 0.1875, 0.25, 1.9375, 0.25), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.75, 0.125, 0.1875, 0.8125, 1.9375, 0.25), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.75, 0.125, 0.75, 0.8125, 1.9375, 0.8125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.1875, 0.125, 0.75, 0.25, 1.9375, 0.8125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.375, 1.8125, 0.375, 0.625, 1.875, 0.625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.3125, 1.875, 0.3125, 0.6875, 1.9375, 0.6875), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.125, 1.9375, 0.125, 0.875, 2, 0.875), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.75, 1.96875, 0.1875, 0.8125, 2.03125, 0.8125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.1875, 1.96875, 0.1875, 0.25, 2.03125, 0.8125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.25, 1.96875, 0.1875, 0.75, 2.03125, 0.25), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.25, 1.96875, 0.75, 0.75, 2.03125, 0.8125), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.25, 2.1875, 0.25, 0.75, 2.4375, 0.75), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.25, 2.1875, 0.25, 0.75, 2.4375, 0.75), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.25, 2.4375, 0.25, 0.75, 2.6875, 0.75), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.4375, 2.375, 0.2340625, 0.5625, 2.5, 0.2340625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.25, 2.4375, 0.25, 0.75, 2.6875, 0.75), BooleanOp.OR);
        return shape.optimize();
    }
}
