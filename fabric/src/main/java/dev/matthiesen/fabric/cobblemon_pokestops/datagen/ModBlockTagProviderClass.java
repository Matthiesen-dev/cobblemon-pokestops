package dev.matthiesen.fabric.cobblemon_pokestops.datagen;

import dev.matthiesen.common.cobblemon_pokestops.registry.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalBlockTags;
import net.minecraft.core.HolderLookup;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProviderClass extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProviderClass(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider wrapperLookup) {
        for (var entry : ModTags.ALL_TAGS.entrySet()) {
            getOrCreateTagBuilder(entry.getKey()).add(entry.getValue());
        }

        var builder = getOrCreateTagBuilder(ConventionalBlockTags.RELOCATION_NOT_SUPPORTED);

        for (var entry : ModTags.ALL_TAG_KEYS) {
            builder.addTag(entry);
        }
    }
}
