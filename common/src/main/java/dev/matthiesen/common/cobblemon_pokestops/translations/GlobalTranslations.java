package dev.matthiesen.common.cobblemon_pokestops.translations;


import dev.matthiesen.common.cobblemon_pokestops.translations.locale.EnUsTranslations;
import dev.matthiesen.common.cobblemon_pokestops.translations.util.TranslationBuilder;

import java.util.HashMap;
import java.util.Map;

public class GlobalTranslations {
    public static final Map<String, TranslationBuilder> TRANSLATIONS = new HashMap<>();
    public static boolean initialized;

    public static void init() {
        if (initialized) return;

        EnUsTranslations.registerTranslations();
        initialized = true;
    }

    public static void addTranslations(TranslationBuilder translations) {
        TRANSLATIONS.put(translations.getLocale(), translations);
    }

    public static Map<String, String> getLocale(String locale) {
        return TRANSLATIONS.get(locale).build();
    }
}
