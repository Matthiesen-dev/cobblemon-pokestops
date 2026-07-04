package dev.matthiesen.cobblemon_pokestops.common.translations;


import dev.matthiesen.cobblemon_pokestops.common.translations.locale.EnUsTranslations;
import dev.matthiesen.cobblemon_pokestops.common.translations.util.TranslationBuilder;

import java.util.HashMap;
import java.util.Map;

public class GlobalTranslations {
    public static final Map<String, TranslationBuilder> TRANSLATIONS = new HashMap<>();
    public static boolean initialized;

    public static void init() {
        if (initialized) return;

        // Register Translations here
        EnUsTranslations.registerTranslations();

        // Set initialized to true to prevent re-initialization
        initialized = true;
    }

    public static void addTranslations(TranslationBuilder translations) {
        TRANSLATIONS.put(translations.getLocale(), translations);
    }

    public static Map<String, String> getLocale(String locale) {
        return TRANSLATIONS.get(locale).build();
    }
}
