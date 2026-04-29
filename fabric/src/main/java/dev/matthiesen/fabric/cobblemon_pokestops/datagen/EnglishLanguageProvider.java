package dev.matthiesen.fabric.cobblemon_pokestops.datagen;

import dev.matthiesen.common.cobblemon_pokestops.registry.EnglishTranslationsRegistry;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.core.HolderLookup;

import java.util.concurrent.CompletableFuture;

public class EnglishLanguageProvider extends FabricLanguageProvider {
    protected EnglishLanguageProvider(FabricDataOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(dataOutput, "en_us", registryLookup);
    }

    @Override
    public void generateTranslations(HolderLookup.Provider registryLookup, TranslationBuilder translationBuilder) {
        for (var entry : EnglishTranslationsRegistry.TRANSLATIONS.entrySet()) {
            translationBuilder.add(entry.getKey(), entry.getValue());
        }
    }
}
