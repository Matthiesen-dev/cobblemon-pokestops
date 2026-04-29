package dev.matthiesen.fabric.cobblemon_pokestops.datagen;

import dev.matthiesen.fabric.cobblemon_pokestops.worldgen.ModConfiguredFeatures;
import dev.matthiesen.fabric.cobblemon_pokestops.worldgen.ModPlacedFeatures;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;

public class DataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
        pack.addProvider(BlockTagProvider::new);
        pack.addProvider(LootTableProvider::new);
        pack.addProvider(ModelProvider::new);
        pack.addProvider(RegistryDataGenerator::new);
        pack.addProvider(EnglishLanguageProvider::new);
        pack.addProvider(AdvancementProvider::new);
        pack.addProvider(BlockLootTableProvider::new);
    }

    @Override
    public void buildRegistry(RegistrySetBuilder registryBuilder) {
        registryBuilder.add(Registries.CONFIGURED_FEATURE, ModConfiguredFeatures::bootstrap);
        registryBuilder.add(Registries.PLACED_FEATURE, ModPlacedFeatures::bootstrap);
    }
}
