package dev.matthiesen.fabric.cobblemon_pokestops.datagen;

import dev.matthiesen.common.cobblemon_pokestops.registry.BlockRegistry;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.data.models.ItemModelGenerators;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockStateModelGenerator) {
        blockStateModelGenerator.createNonTemplateModelBlock(BlockRegistry.POKESTOP_DUMMY.get());
        blockStateModelGenerator.createNonTemplateModelBlock(BlockRegistry.WINGEDSTOP_DUMMY.get());
        for (var entry : BlockRegistry.getAllTemplates().values()) {
            blockStateModelGenerator.createNonTemplateModelBlock(entry.get());
        }
    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerator) {
    }
}
