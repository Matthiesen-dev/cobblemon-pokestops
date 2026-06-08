package dev.matthiesen.common.cobblemon_pokestops.translations.util;

import java.util.HashMap;
import java.util.Map;

public class TranslationBuilder {
    private final String locale;
    private final Map<String, String> translations;

    public TranslationBuilder(String locale) {
        this.locale = locale;
        this.translations = new HashMap<>();
    }

    public void addTranslation(String key, String value) {
        translations.put(key, value);
    }

    public void addTranslations(Map<String, String> newTranslations) {
        translations.putAll(newTranslations);
    }

    public Map<String, String> build() {
        return translations;
    }

    public String getLocale() {
        return locale;
    }
}
