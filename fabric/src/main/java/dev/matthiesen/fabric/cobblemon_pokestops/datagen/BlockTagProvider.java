package dev.matthiesen.fabric.cobblemon_pokestops.datagen;

import dev.matthiesen.common.cobblemon_pokestops.registry.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalBlockTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;

import java.util.concurrent.CompletableFuture;

public class BlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public BlockTagProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider wrapperLookup) {
        for (var entry : ModTags.ALL_TAGS.entrySet()) {
            getOrCreateTagBuilder(entry.getKey()).add(entry.getValue());
        }

        var builder = getOrCreateTagBuilder(ConventionalBlockTags.RELOCATION_NOT_SUPPORTED);

        for (var entry : ModTags.RELOCATION_NOT_SUPPORTED_TAGS) {
            builder.addTag(entry);
        }

        var mineable = getOrCreateTagBuilder(
                TagKey.create(
                        Registries.BLOCK,
                        ResourceLocation.withDefaultNamespace("mineable/pickaxe")
                )
        );
        var needsIronTool = getOrCreateTagBuilder(
                TagKey.create(
                        Registries.BLOCK,
                        ResourceLocation.withDefaultNamespace("needs_iron_tool")
                )
        );
        for (var entry : ModTags.IRON_TOOL_MINEABLE_BLOCKS) {
            mineable.addTag(entry);
            needsIronTool.addTag(entry);
        }
    }
}
