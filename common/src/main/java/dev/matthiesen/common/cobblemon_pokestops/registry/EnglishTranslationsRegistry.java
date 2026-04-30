package dev.matthiesen.common.cobblemon_pokestops.registry;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EnglishTranslationsRegistry {
    public static Map<String, String> TRANSLATIONS = new HashMap<>();

    private static final Map<String, String> SPINNER_MESSAGE_VARIANTS = Map.of(
            "pokestop", "Pokestop",
            "wingedstop", "Winged Pokestop"
    );

    private static final Map<String, String> TROPHY_MESSAGE_VARIANTS = Map.of(
            "pokestop_trophy", "§bPokestop Trophy",
            "wingedstop_trophy", "§bWinged Pokestop Trophy"
    );

    private static final Map<String, String> COLORMAP = Map.of(
            "blue", "Blue",
            "gold", "Gold",
            "black", "Black",
            "green", "Green"
    );

    private static final List<VariantBlocks> BLOCKS_LIST = List.of(
            new VariantBlocks("pokestop", BlockRegistry.POKESTOP_VARIANTS),
            new VariantBlocks("wingedstop", BlockRegistry.WINGEDSTOP_VARIANTS)
    );

    private static final List<TrophyBlocks> TROPHY_BLOCKS_LIST = List.of(
            new TrophyBlocks("pokestop_trophy"),
            new TrophyBlocks("wingedstop_trophy")
    );

    static {
        TRANSLATIONS.put("itemGroup.cobblemon_pokestops.cobblemon_pokestops_pokestops", "Pokestops");
        TRANSLATIONS.put("itemGroup.cobblemon_pokestops.cobblemon_pokestops_trophies", "Pokestop Trophies");
        TRANSLATIONS.put("stat.cobblemon_pokestops.pokestop_times_spun", "Times Spun Pokestops");
        TRANSLATIONS.put("stat.cobblemon_pokestops.wingedstop_times_spun", "Times Spun Winged Pokestops");
        TRANSLATIONS.put("sound.cobblemon_pokestops.pokestop_spin", "Pokestop Spin");

        for (var key : SPINNER_MESSAGE_VARIANTS.entrySet()) {
            TRANSLATIONS.put("message.cobblemon_pokestops." + key.getKey() + "_spin", "You spun the " + key.getValue() + "!");
            TRANSLATIONS.put("message.cobblemon_pokestops." + key.getKey() + "_cooldown", "You can't spin the " + key.getValue() + " for another %s!");
        }

        for (var key : BLOCKS_LIST) {
            var translations = key.getTranslations();
            TRANSLATIONS.putAll(translations);
        }

        for (var key : TROPHY_BLOCKS_LIST) {
            var translations = key.getTranslations();
            TRANSLATIONS.putAll(translations);
        }

        TRANSLATIONS.putAll(AdvancementRegistry.ENGLISH_TRANSLATIONS);
    }

    private static class VariantBlocks {
        public String baseId;
        public String[] variants;
        public VariantBlocks(String baseId, String[] variants) {
            this.baseId = baseId;
            this.variants = variants;
        }

        public Map<String, String> getTranslations() {
            Map<String, String> translations = new HashMap<>();

            // BaseID is always Blue
            translations.put("block.cobblemon_pokestops." + baseId, COLORMAP.get("blue") + " " + SPINNER_MESSAGE_VARIANTS.getOrDefault(baseId, baseId));

            for (String variant : variants) {
                String key = "block.cobblemon_pokestops." + baseId + "_" + variant;
                String value = COLORMAP.getOrDefault(variant, variant) + " " + SPINNER_MESSAGE_VARIANTS.getOrDefault(baseId, baseId);
                translations.put(key, value);
            }
            return translations;
        }
    }

    private static class TrophyBlocks {
        public String baseId;

        public TrophyBlocks(String baseId) {
            this.baseId = baseId;
        }

        public Map<String, String> getTranslations() {
            Map<String, String> translations = new HashMap<>();

            translations.put("block.cobblemon_pokestops." + baseId, TROPHY_MESSAGE_VARIANTS.getOrDefault(baseId, baseId));

            return translations;
        }
    }
}
