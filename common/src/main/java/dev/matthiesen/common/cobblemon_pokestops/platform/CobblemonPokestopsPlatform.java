package dev.matthiesen.common.cobblemon_pokestops.platform;

import net.minecraft.advancements.CriterionTrigger;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.function.Supplier;

public interface CobblemonPokestopsPlatform {
    // Registry Helpers
    <T extends BlockEntity> Supplier<BlockEntityType<T>> registerBlockEntity(String id, Supplier<BlockEntityType<T>> blockEntityType);
    <T extends Block> Supplier<T> registerBlock(String id, Supplier<T> block);
    <T extends Item> Supplier<T> registerItem(String id, Supplier<T> item);
    <T extends SoundEvent> Supplier<T> registerSound(String id, Supplier<T> sound);
    <T extends CreativeModeTab> Supplier<T> registerCreativeModeTab(String id, Supplier<T> tab);
    <T extends CriterionTrigger<?>> Supplier<T> registerCriteriaTriggers(String id, Supplier<T> criterionTrigger);
    <T extends ResourceLocation> Supplier<T> registerStats(String id, Supplier<T> stats);

    // General Utilities
    MinecraftServer server();

    // Loader Specific Utilities
    boolean isModLoaded(String modId);
    boolean isDevelopmentEnvironment();
    CreativeModeTab.Builder newCreativeTabBuilder();
}
