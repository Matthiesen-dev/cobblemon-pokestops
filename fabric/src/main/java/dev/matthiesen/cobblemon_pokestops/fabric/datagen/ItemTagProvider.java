package dev.matthiesen.cobblemon_pokestops.fabric.datagen;

import dev.matthiesen.cobblemon_pokestops.common.registry.ItemRegistry;
import dev.matthiesen.cobblemon_pokestops.common.registry.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;

import java.util.concurrent.CompletableFuture;

public class ItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ItemTagProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider wrapperLookup) {
        getOrCreateTagBuilder(ModTags.Items.STOP_INTERACTION_TOOLS)
                .add(ItemRegistry.STOP_REMOVER.get());
    }
}


