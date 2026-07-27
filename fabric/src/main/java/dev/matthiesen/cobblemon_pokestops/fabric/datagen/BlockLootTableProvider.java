package dev.matthiesen.cobblemon_pokestops.fabric.datagen;

import dev.matthiesen.cobblemon_pokestops.common.registry.BlockRegistry;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.core.HolderLookup;

import java.util.concurrent.CompletableFuture;

public final class BlockLootTableProvider extends FabricBlockLootTableProvider {
    public BlockLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        for (var entry : BlockRegistry.ALL_TROPHIES.entrySet()) {
            dropSelf(entry.getValue().get());
        }
    }
}
