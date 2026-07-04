package dev.matthiesen.cobblemon_pokestops.fabric.datagen;

import dev.matthiesen.cobblemon_pokestops.common.translations.GlobalTranslations;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class DataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
        pack.addProvider(BlockTagProvider::new);
        pack.addProvider(LootTableProvider::new);
        pack.addProvider(ModelProvider::new);
        pack.addProvider(RegistryDataGenerator::new);
        pack.addProvider(AdvancementProvider::new);
        pack.addProvider(BlockLootTableProvider::new);

        GlobalTranslations.init();

        for (var entry : GlobalTranslations.TRANSLATIONS.entrySet()) {
            var locale = entry.getKey();
            pack.addProvider((dataOutput, registryLookup) ->
                    new UniversalLanguageProvider(dataOutput, registryLookup, locale));
        }
    }
}
