package dev.matthiesen.cobblemon_pokestops.common.translations.locale;

import dev.matthiesen.cobblemon_pokestops.common.translations.GlobalTranslations;
import dev.matthiesen.cobblemon_pokestops.common.translations.util.TranslationBuilder;
import dev.matthiesen.cobblemon_pokestops.common.registry.BlockRegistry;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class EnUsTranslations {
    private static final TranslationBuilder TRANSLATIONS = new TranslationBuilder("en_us");

    private static final Map<String, String> SPINNER_MESSAGE_VARIANTS = Map.of(
            "pokestop", "Pokestop",
            "wingedstop", "Winged Pokestop",
            "pokeballstop", "Pokeball Stop",
            "healingstop", "Healing Stop"
    );

    private static final Map<String, String> TROPHY_MESSAGE_VARIANTS = Map.of(
            "pokestop_trophy", "§bPokestop Trophy",
            "wingedstop_trophy", "§bWinged Pokestop Trophy",
            "pokeballstop_trophy", "§bPokeball Stop Trophy",
            "healingstop_trophy", "§bHealing Stop Trophy"
    );

    private static final Map<String, String> COLORMAP = Map.of(
            "blue", "Blue",
            "gold", "Gold",
            "black", "Black",
            "green", "Green"
    );

    private static final Map<String, String> POKEBALL_VARIANTS = Map.of(
            "masterball", "Master",
            "premierball", "Premier",
            "ultraball",  "Ultra",
            "parkball", "Park"
    );

    private static final List<Map<String, String>> BLOCKS_LIST = List.of(
            new VariantBlocks("pokestop", BlockRegistry.POKESTOP_VARIANTS).getTranslations(),
            new VariantBlocks("wingedstop", BlockRegistry.WINGEDSTOP_VARIANTS).getTranslations(),
            new VariantOnlyBlocks("pokeballstop", BlockRegistry.POKEBALLSTOP_VARIANTS, POKEBALL_VARIANTS).getTranslations(),
            Map.of("block.cobblemon_pokestops.healingstop", "Healing Stop")
    );

    private static final List<TrophyBlocks> TROPHY_BLOCKS_LIST = List.of(
            new TrophyBlocks("pokestop_trophy"),
            new TrophyBlocks("wingedstop_trophy"),
            new TrophyBlocks("pokeballstop_trophy"),
            new TrophyBlocks("healingstop_trophy")
    );

    static {
        // Add translations here
        TRANSLATIONS.addTranslation("itemGroup.cobblemon_pokestops.cobblemon_pokestops_tab_title", "Cobblemon Pokestops");
        TRANSLATIONS.addTranslation("itemGroup.cobblemon_pokestops.cobblemon_pokestops_tab_pokestops_section", "Pokestops");
        TRANSLATIONS.addTranslation("itemGroup.cobblemon_pokestops.cobblemon_pokestops_tab_trophies_section", "Trophies");
        TRANSLATIONS.addTranslation("item.cobblemon_pokestops.stop_remover", "Stop Remover");
        TRANSLATIONS.addTranslation("stat.cobblemon_pokestops.pokestop_times_spun", "Times Spun Pokestops");
        TRANSLATIONS.addTranslation("stat.cobblemon_pokestops.wingedstop_times_spun", "Times Spun Winged Pokestops");
        TRANSLATIONS.addTranslation("stat.cobblemon_pokestops.pokeballstop_times_spun", "Times Spun Pokeball Stops");
        TRANSLATIONS.addTranslation("stat.cobblemon_pokestops.healingstop_times_spun", "Times Spun Healing Stops");
        TRANSLATIONS.addTranslation("sound.cobblemon_pokestops.pokestop_spin", "Pokestop Spin");
        TRANSLATIONS.addTranslation("tooltip.cobblemon_pokestops.cooldown", "Cooldown: %s");
        TRANSLATIONS.addTranslation("config.jade.plugin_cobblemon_pokestops.cooldown", "Cooldown");
        TRANSLATIONS.addTranslation("config.jade.plugin_cobblemon_pokestops.cooldown_dummy", "Cooldown");
        TRANSLATIONS.addTranslation("advancements.cobblemon_pokestops.root.title", "PokeStops");
        TRANSLATIONS.addTranslation("advancements.cobblemon_pokestops.root.description",
                "Discover the world of PokeStops and their unique features!");
        TRANSLATIONS.addTranslation("message.cobblemon_pokestops.stop_remover_invalid_target", "Stop Remover only works on Pokestops.");
        TRANSLATIONS.addTranslation("message.cobblemon_pokestops.stop_remover_adventure_denied", "You cannot use the Stop Remover in Adventure mode.");
        TRANSLATIONS.addTranslation("message.cobblemon_pokestops.stop_remover_no_permission", "You do not have permission to use the Stop Remover.");
        TRANSLATIONS.addTranslation("message.cobblemon_pokestops.stop_remover_armed", "Removal armed. Sneak and right-click the same stop again to confirm.");
        TRANSLATIONS.addTranslation("message.cobblemon_pokestops.stop_remover_need_crouch", "Sneak and right-click the same stop to confirm removal.");
        TRANSLATIONS.addTranslation("message.cobblemon_pokestops.stop_remover_mismatch", "That is not the same stop. Removal confirmation has been reset.");
        TRANSLATIONS.addTranslation("message.cobblemon_pokestops.stop_remover_timeout", "Removal confirmation timed out.");
        TRANSLATIONS.addTranslation("message.cobblemon_pokestops.stop_remover_inventory_full", "You need a free inventory slot to recover this stop.");
        TRANSLATIONS.addTranslation("message.cobblemon_pokestops.stop_remover_confirmed", "Pokestop removed.");

        TRANSLATIONS.addTranslation("advancements.cobblemon_pokestops.used_pokestop.title", "First Spin");
        TRANSLATIONS.addTranslation("advancements.cobblemon_pokestops.used_pokestop.description",
                "Spin a PokeStop for the first time to receive items and experience the thrill of discovery!");
        TRANSLATIONS.addTranslation("advancements.cobblemon_pokestops.used_25_pokestops.title", "PokeStop Enthusiast");
        TRANSLATIONS.addTranslation("advancements.cobblemon_pokestops.used_25_pokestops.description",
                "Spin 25 PokeStops to show your dedication to exploring the world of Cobblemon and uncovering its secrets!");
        TRANSLATIONS.addTranslation("advancements.cobblemon_pokestops.used_50_pokestops.title", "PokeStop Explorer");
        TRANSLATIONS.addTranslation("advancements.cobblemon_pokestops.used_50_pokestops.description",
                "Spin 50 PokeStops to become a true explorer of the world of Cobblemon and uncover its hidden treasures!");
        TRANSLATIONS.addTranslation("advancements.cobblemon_pokestops.used_100_pokestops.title", "PokeStop Master");
        TRANSLATIONS.addTranslation("advancements.cobblemon_pokestops.used_100_pokestops.description",
                "Spin 100 PokeStops to achieve mastery in the world of Cobblemon and unlock exclusive rewards!");
        TRANSLATIONS.addTranslation("advancements.cobblemon_pokestops.used_200_pokestops.title", "PokeStop Legend");
        TRANSLATIONS.addTranslation("advancements.cobblemon_pokestops.used_200_pokestops.description",
                "Spin 200 PokeStops to become a legend in the world of Cobblemon and unlock legendary rewards!");
        TRANSLATIONS.addTranslation("advancements.cobblemon_pokestops.used_300_pokestops.title", "PokeStop Mythic");
        TRANSLATIONS.addTranslation("advancements.cobblemon_pokestops.used_300_pokestops.description",
                "Spin 300 PokeStops to achieve mythic status in the world of Cobblemon and unlock mythic rewards!");
        TRANSLATIONS.addTranslation("advancements.cobblemon_pokestops.used_400_pokestops.title", "PokeStop Immortal");
        TRANSLATIONS.addTranslation("advancements.cobblemon_pokestops.used_400_pokestops.description",
                "Spin 400 PokeStops to achieve immortal status in the world of Cobblemon and unlock immortal rewards!");
        TRANSLATIONS.addTranslation("advancements.cobblemon_pokestops.used_500_pokestops.title", "PokeStop Eternal");
        TRANSLATIONS.addTranslation("advancements.cobblemon_pokestops.used_500_pokestops.description",
                "Spin 500 PokeStops to achieve eternal status in the world of Cobblemon and unlock eternal rewards!");

        TRANSLATIONS.addTranslation("advancements.cobblemon_pokestops.used_wingedstop.title", "Winged Wonders");
        TRANSLATIONS.addTranslation("advancements.cobblemon_pokestops.used_wingedstop.description",
                "Spin a Winged PokeStop for the first time to uncover its unique rewards and experience the thrill of discovery!");
        TRANSLATIONS.addTranslation("advancements.cobblemon_pokestops.used_25_winged_pokestops.title", "Winged PokeStop Enthusiast");
        TRANSLATIONS.addTranslation("advancements.cobblemon_pokestops.used_25_winged_pokestops.description",
                "Spin 25 Winged PokeStops to show your dedication to exploring the world of Cobblemon and uncovering its secrets!");
        TRANSLATIONS.addTranslation("advancements.cobblemon_pokestops.used_50_winged_pokestops.title", "Winged PokeStop Explorer");
        TRANSLATIONS.addTranslation("advancements.cobblemon_pokestops.used_50_winged_pokestops.description",
                "Spin 50 Winged PokeStops to become a true explorer of the world of Cobblemon and uncover its hidden treasures!");
        TRANSLATIONS.addTranslation("advancements.cobblemon_pokestops.used_100_winged_pokestops.title", "Winged PokeStop Master");
        TRANSLATIONS.addTranslation("advancements.cobblemon_pokestops.used_100_winged_pokestops.description",
                "Spin 100 Winged PokeStops to achieve mastery in the world of Cobblemon and unlock exclusive rewards!");
        TRANSLATIONS.addTranslation("advancements.cobblemon_pokestops.used_200_winged_pokestops.title", "Winged PokeStop Legend");
        TRANSLATIONS.addTranslation("advancements.cobblemon_pokestops.used_200_winged_pokestops.description",
                "Spin 200 Winged PokeStops to become a legend in the world of Cobblemon and unlock legendary rewards!");
        TRANSLATIONS.addTranslation("advancements.cobblemon_pokestops.used_300_winged_pokestops.title", "Winged PokeStop Mythic");
        TRANSLATIONS.addTranslation("advancements.cobblemon_pokestops.used_300_winged_pokestops.description",
                "Spin 300 Winged PokeStops to achieve mythic status in the world of Cobblemon and unlock mythic rewards!");
        TRANSLATIONS.addTranslation("advancements.cobblemon_pokestops.used_400_winged_pokestops.title", "Winged PokeStop Immortal");
        TRANSLATIONS.addTranslation("advancements.cobblemon_pokestops.used_400_winged_pokestops.description",
                "Spin 400 Winged PokeStops to achieve immortal status in the world of Cobblemon and unlock immortal rewards!");
        TRANSLATIONS.addTranslation("advancements.cobblemon_pokestops.used_500_winged_pokestops.title", "Winged PokeStop Eternal");
        TRANSLATIONS.addTranslation("advancements.cobblemon_pokestops.used_500_winged_pokestops.description",
                "Spin 500 Winged PokeStops to achieve eternal status in the world of Cobblemon and unlock eternal rewards!");

        TRANSLATIONS.addTranslation("advancements.cobblemon_pokestops.used_pokeballstop.title", "Pokeballstop Power");
        TRANSLATIONS.addTranslation("advancements.cobblemon_pokestops.used_pokeballstop.description",
                "Spin a Pokeballstop for the first time to uncover its unique rewards and experience the thrill of discovery!");
        TRANSLATIONS.addTranslation("advancements.cobblemon_pokestops.used_25_pokeballstops.title", "Pokeballstop Enthusiast");
        TRANSLATIONS.addTranslation("advancements.cobblemon_pokestops.used_25_pokeballstops.description",
                "Spin 25 Pokeballstops to show your dedication to exploring the world of Cobblemon and uncovering its secrets!");
        TRANSLATIONS.addTranslation("advancements.cobblemon_pokestops.used_50_pokeballstops.title", "Pokeballstop Explorer");
        TRANSLATIONS.addTranslation("advancements.cobblemon_pokestops.used_50_pokeballstops.description",
                "Spin 50 Pokeballstops to become a true explorer of the world of Cobblemon and uncover its hidden treasures!");
        TRANSLATIONS.addTranslation("advancements.cobblemon_pokestops.used_100_pokeballstops.title", "Pokeballstop Master");
        TRANSLATIONS.addTranslation("advancements.cobblemon_pokestops.used_100_pokeballstops.description",
                "Spin 100 Pokeballstops to achieve mastery in the world of Cobblemon and unlock exclusive rewards!");
        TRANSLATIONS.addTranslation("advancements.cobblemon_pokestops.used_200_pokeballstops.title", "Pokeballstop Legend");
        TRANSLATIONS.addTranslation("advancements.cobblemon_pokestops.used_200_pokeballstops.description",
                "Spin 200 Pokeballstops to become a legend in the world of Cobblemon and unlock legendary rewards!");
        TRANSLATIONS.addTranslation("advancements.cobblemon_pokestops.used_300_pokeballstops.title", "Pokeballstop Mythic");
        TRANSLATIONS.addTranslation("advancements.cobblemon_pokestops.used_300_pokeballstops.description",
                "Spin 300 Pokeballstops to achieve mythic status in the world of Cobblemon and unlock mythic rewards!");
        TRANSLATIONS.addTranslation("advancements.cobblemon_pokestops.used_400_pokeballstops.title", "Pokeballstop Immortal");
        TRANSLATIONS.addTranslation("advancements.cobblemon_pokestops.used_400_pokeballstops.description",
                "Spin 400 Pokeballstops to achieve immortal status in the world of Cobblemon and unlock immortal rewards!");
        TRANSLATIONS.addTranslation("advancements.cobblemon_pokestops.used_500_pokeballstops.title", "Pokeballstop Eternal");
        TRANSLATIONS.addTranslation("advancements.cobblemon_pokestops.used_500_pokeballstops.description",
                "Spin 500 Pokeballstops to achieve eternal status in the world of Cobblemon and unlock eternal rewards!");

        TRANSLATIONS.addTranslation("advancements.cobblemon_pokestops.used_healingstop.title", "Healingstop Harmony");
        TRANSLATIONS.addTranslation("advancements.cobblemon_pokestops.used_healingstop.description",
                "Spin a Healingstop for the first time to uncover its unique rewards and experience the thrill of discovery!");
        TRANSLATIONS.addTranslation("advancements.cobblemon_pokestops.used_25_healingstops.title", "Healingstop Enthusiast");
        TRANSLATIONS.addTranslation("advancements.cobblemon_pokestops.used_25_healingstops.description",
                "Spin 25 Healingstops to show your dedication to exploring the world of Cobblemon and uncovering its secrets!");
        TRANSLATIONS.addTranslation("advancements.cobblemon_pokestops.used_50_healingstops.title", "Healingstop Explorer");
        TRANSLATIONS.addTranslation("advancements.cobblemon_pokestops.used_50_healingstops.description",
                "Spin 50 Healingstops to become a true explorer of the world of Cobblemon and uncover its hidden treasures!");
        TRANSLATIONS.addTranslation("advancements.cobblemon_pokestops.used_100_healingstops.title", "Healingstop Master");
        TRANSLATIONS.addTranslation("advancements.cobblemon_pokestops.used_100_healingstops.description",
                "Spin 100 Healingstops to achieve mastery in the world of Cobblemon and unlock exclusive rewards!");
        TRANSLATIONS.addTranslation("advancements.cobblemon_pokestops.used_200_healingstops.title", "Healingstop Legend");
        TRANSLATIONS.addTranslation("advancements.cobblemon_pokestops.used_200_healingstops.description",
                "Spin 200 Healingstops to become a legend in the world of Cobblemon and unlock legendary rewards!");
        TRANSLATIONS.addTranslation("advancements.cobblemon_pokestops.used_300_healingstops.title", "Healingstop Mythic");
        TRANSLATIONS.addTranslation("advancements.cobblemon_pokestops.used_300_healingstops.description",
                "Spin 300 Healingstops to achieve mythic status in the world of Cobblemon and unlock mythic rewards!");
        TRANSLATIONS.addTranslation("advancements.cobblemon_pokestops.used_400_healingstops.title", "Healingstop Immortal");
        TRANSLATIONS.addTranslation("advancements.cobblemon_pokestops.used_400_healingstops.description",
                "Spin 400 Healingstops to achieve immortal status in the world of Cobblemon and unlock immortal rewards!");
        TRANSLATIONS.addTranslation("advancements.cobblemon_pokestops.used_500_healingstops.title", "Healingstop Eternal");
        TRANSLATIONS.addTranslation("advancements.cobblemon_pokestops.used_500_healingstops.description",
                "Spin 500 Healingstops to achieve eternal status in the world of Cobblemon and unlock eternal rewards!");

        for (var key : SPINNER_MESSAGE_VARIANTS.entrySet()) {
            TRANSLATIONS.addTranslation("message.cobblemon_pokestops." + key.getKey() + "_spin", "You spun the " + key.getValue() + "!");
            TRANSLATIONS.addTranslation("message.cobblemon_pokestops." + key.getKey() + "_cooldown", "You can't spin the " + key.getValue() + " for another %s!");
        }

        for (var key : BLOCKS_LIST) {
            TRANSLATIONS.addTranslations(key);
        }

        for (var key : TROPHY_BLOCKS_LIST) {
            var translations = key.getTranslations();
            TRANSLATIONS.addTranslations(translations);
        }

        // Mod Config
        TRANSLATIONS.addTranslation(newConfigTranslation("title"), "Cobblemon Pokestops Configuration");
        TRANSLATIONS.addTranslation(newConfigTranslation("section.cobblemon.pokestops.server.toml"), "Server Configuration");
        TRANSLATIONS.addTranslation(newConfigTranslation("section.cobblemon.pokestops.server.toml.title"), "Server Configuration");

        TRANSLATIONS.addTranslation(newConfigTranslation("pokestopsConfig"), "Pokestops Config");
        TRANSLATIONS.addTranslation(newConfigTranslation("pokestopsConfig.button"), "Edit");
        TRANSLATIONS.addTranslation(newConfigTranslation("pokestopsConfig.tooltip"), "Edit the Pokestops configuration.");
        TRANSLATIONS.addTranslation(newConfigTranslation("extraRarities"), "Extra Rarities");
        TRANSLATIONS.addTranslation(newConfigTranslation("extraRarities.tooltip"), "List of extra rarities to be used in the Pokestops mod.");
        TRANSLATIONS.addTranslation(newConfigTranslation("extraRarities.button"), "Edit");

        TRANSLATIONS.addTranslation(newConfigTranslation("broadcastSettings"), "Broadcast Settings");
        TRANSLATIONS.addTranslation(newConfigTranslation("broadcastSettings.button"), "Edit");
        TRANSLATIONS.addTranslation(newConfigTranslation("broadcastSettings.tooltip"), "Edit the broadcast settings for Pokestops.");
        TRANSLATIONS.addTranslation(newConfigTranslation("enableGlobalBroadcast"), "Enable Global Broadcast");
        TRANSLATIONS.addTranslation(newConfigTranslation("enableGlobalBroadcast.tooltip"), "Whether to enable global broadcast for Pokestops.");
        TRANSLATIONS.addTranslation(newConfigTranslation("localBroadcastRadius"), "Local Broadcast Radius");
        TRANSLATIONS.addTranslation(newConfigTranslation("localBroadcastRadius.tooltip"), "The radius for local broadcast in blocks.");

        TRANSLATIONS.addTranslation(newConfigTranslation("cooldownSettings"), "Cooldown Settings");
        TRANSLATIONS.addTranslation(newConfigTranslation("cooldownSettings.button"), "Edit");
        TRANSLATIONS.addTranslation(newConfigTranslation("cooldownSettings.tooltip"), "Edit the cooldown settings for Pokestops, Winged Stops, Pokeball Stops, and Healing Stops.");
        TRANSLATIONS.addTranslation(newConfigTranslation("pokestops"), "Pokestops");
        TRANSLATIONS.addTranslation(newConfigTranslation("pokestops.tooltip"), "The cooldown in seconds for Pokestops.");
        TRANSLATIONS.addTranslation(newConfigTranslation("wingedstops"), "Winged Stops");
        TRANSLATIONS.addTranslation(newConfigTranslation("wingedstops.tooltip"), "The cooldown in seconds for Winged Stops.");
        TRANSLATIONS.addTranslation(newConfigTranslation("pokeballstops"), "Pokeball Stops");
        TRANSLATIONS.addTranslation(newConfigTranslation("pokeballstops.tooltip"), "The cooldown in seconds for Pokeball Stops.");
        TRANSLATIONS.addTranslation(newConfigTranslation("healingstops"), "Healing Stops");
        TRANSLATIONS.addTranslation(newConfigTranslation("healingstops.tooltip"), "The cooldown in seconds for Healing Stops.");

        TRANSLATIONS.addTranslation(newConfigTranslation("stopRemoverConfig"), "Stop Remover Config");
        TRANSLATIONS.addTranslation(newConfigTranslation("stopRemoverConfig.button"), "Edit");
        TRANSLATIONS.addTranslation(newConfigTranslation("stopRemoverConfig.tooltip"), "Edit the Stop Remover configuration.");
        TRANSLATIONS.addTranslation(newConfigTranslation("requireOp"), "Require OP");
        TRANSLATIONS.addTranslation(newConfigTranslation("requireOp.tooltip"), "Whether the Stop Remover requires OP privileges to use.");
        TRANSLATIONS.addTranslation(newConfigTranslation("permissionLevel"), "Permission Level");
        TRANSLATIONS.addTranslation(newConfigTranslation("permissionLevel.tooltip"), "The permission level required to use the Stop Remover.");
        TRANSLATIONS.addTranslation(newConfigTranslation("dropsStopItem"), "Drops Stop Item");
        TRANSLATIONS.addTranslation(newConfigTranslation("dropsStopItem.tooltip"), "Whether the Stop Remover drops the stop item when used.");
        TRANSLATIONS.addTranslation(newConfigTranslation("confirmWindowSeconds"), "Confirm Window Seconds");
        TRANSLATIONS.addTranslation(newConfigTranslation("confirmWindowSeconds.tooltip"), "The number of seconds for the confirmation window when using the Stop Remover.");
    }

    public static String newConfigTranslation(String name) {
        return "cobblemon_pokestops.configuration." + name;
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

    private static class VariantOnlyBlocks {
        public String baseId;
        public String[] variants;
        public Map<String, String> variantMap;
        public VariantOnlyBlocks(String baseId, String[] variants, Map<String, String> variantMap) {
            this.baseId = baseId;
            this.variants = variants;
            this.variantMap = variantMap;
        }

        public Map<String, String> getTranslations() {
            Map<String, String> translations = new HashMap<>();

            for (String variant : variants) {
                String key = "block.cobblemon_pokestops." + baseId + "_" + variant;
                String value = variantMap.getOrDefault(variant, variant) + " " + SPINNER_MESSAGE_VARIANTS.getOrDefault(baseId, baseId);
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

    public static void registerTranslations() {
        GlobalTranslations.addTranslations(TRANSLATIONS);
    }
}
