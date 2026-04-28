package dev.matthiesen.fabric.cobblemon_pokestops;

import dev.matthiesen.fabric.cobblemon_pokestops.datagen.ModBlockTagProviderClass;
import dev.matthiesen.fabric.cobblemon_pokestops.datagen.ModLootTableProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class CobblemonPokestopsDataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
        pack.addProvider(ModBlockTagProviderClass::new);
        pack.addProvider(ModLootTableProvider::new);
    }
}
