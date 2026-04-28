package dev.matthiesen.fabric.cobblemon_pokestops.datagen;

import dev.matthiesen.common.cobblemon_pokestops.registry.BlockRegistry;
import dev.matthiesen.common.cobblemon_pokestops.registry.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalBlockTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.level.block.Block;

import java.util.Collection;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

public class ModBlockTagProviderClass extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProviderClass(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    public Block[] supplierToBlock(Collection<? extends Supplier<? extends Block>> items) {
        return items.stream().map(Supplier::get).toArray(Block[]::new);
    }

    @Override
    protected void addTags(HolderLookup.Provider wrapperLookup) {
        getOrCreateTagBuilder(ModTags.Blocks.POKESTOPS)
                .add(supplierToBlock(BlockRegistry.POKESTOPS.values()));

        getOrCreateTagBuilder(ModTags.Blocks.WINGEDSTOPS)
                .add(supplierToBlock(BlockRegistry.WINGEDSTOPS.values()));

        getOrCreateTagBuilder(ModTags.Blocks.DUMMYBLOCKS)
                .add(BlockRegistry.POKESTOP_DUMMY.get())
                .add(BlockRegistry.WINGEDSTOP_DUMMY.get());

        getOrCreateTagBuilder(ConventionalBlockTags.RELOCATION_NOT_SUPPORTED)
                .addTag(ModTags.Blocks.POKESTOPS)
                .addTag(ModTags.Blocks.WINGEDSTOPS)
                .addTag(ModTags.Blocks.DUMMYBLOCKS);
    }
}
