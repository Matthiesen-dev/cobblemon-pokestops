package dev.matthiesen.common.cobblemon_pokestops.registry;

import dev.matthiesen.common.cobblemon_pokestops.Constants;
import dev.matthiesen.common.cobblemon_pokestops.advancements.PokestopScoreTracker;
import dev.matthiesen.common.cobblemon_pokestops.advancements.UsedPokestopCriterion;
import dev.matthiesen.common.cobblemon_pokestops.advancements.UsedWingedPokestopCriterion;
import dev.matthiesen.common.cobblemon_pokestops.advancements.WingedPokestopScoreTracker;
import net.minecraft.advancements.*;
import net.minecraft.advancements.critereon.PlayerTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;

public class AdvancementRegistry {
    public static Map<String, String> ENGLISH_TRANSLATIONS = new HashMap<>();

    static {
        ENGLISH_TRANSLATIONS.put("advancements.cobblemon_pokestops.root.title", "PokéStops");
        ENGLISH_TRANSLATIONS.put("advancements.cobblemon_pokestops.root.description",
                "Discover the world of PokéStops and their unique features!");
        ENGLISH_TRANSLATIONS.put("advancements.cobblemon_pokestops.used_pokestop.title", "First Spin");
        ENGLISH_TRANSLATIONS.put("advancements.cobblemon_pokestops.used_pokestop.description",
                "Spin a PokéStop for the first time to receive items and experience the thrill of discovery!");
        ENGLISH_TRANSLATIONS.put("advancements.cobblemon_pokestops.used_wingedstop.title", "Winged Wonders");
        ENGLISH_TRANSLATIONS.put("advancements.cobblemon_pokestops.used_wingedstop.description",
                "Spin a Winged PokéStop for the first time to uncover its unique rewards and experience the thrill of discovery!");
        ENGLISH_TRANSLATIONS.put("advancements.cobblemon_pokestops.used_25_pokestops.title", "PokéStop Enthusiast");
        ENGLISH_TRANSLATIONS.put("advancements.cobblemon_pokestops.used_25_pokestops.description",
                "Spin 25 PokéStops to show your dedication to exploring the world of Cobblemon and uncovering its secrets!");
        ENGLISH_TRANSLATIONS.put("advancements.cobblemon_pokestops.used_25_winged_pokestops.title", "Winged PokéStop Enthusiast");
        ENGLISH_TRANSLATIONS.put("advancements.cobblemon_pokestops.used_25_winged_pokestops.description",
                "Spin 25 Winged PokéStops to show your dedication to exploring the world of Cobblemon and uncovering its secrets!");
        ENGLISH_TRANSLATIONS.put("advancements.cobblemon_pokestops.used_50_pokestops.title", "PokéStop Explorer");
        ENGLISH_TRANSLATIONS.put("advancements.cobblemon_pokestops.used_50_pokestops.description",
                "Spin 50 PokéStops to become a true explorer of the world of Cobblemon and uncover its hidden treasures!");
        ENGLISH_TRANSLATIONS.put("advancements.cobblemon_pokestops.used_50_winged_pokestops.title", "Winged PokéStop Explorer");
        ENGLISH_TRANSLATIONS.put("advancements.cobblemon_pokestops.used_50_winged_pokestops.description",
                "Spin 50 Winged PokéStops to become a true explorer of the world of Cobblemon and uncover its hidden treasures!");
        ENGLISH_TRANSLATIONS.put("advancements.cobblemon_pokestops.used_100_pokestops.title", "PokéStop Master");
        ENGLISH_TRANSLATIONS.put("advancements.cobblemon_pokestops.used_100_pokestops.description",
                "Spin 100 PokéStops to achieve mastery in the world of Cobblemon and unlock exclusive rewards!");
        ENGLISH_TRANSLATIONS.put("advancements.cobblemon_pokestops.used_100_winged_pokestops.title", "Winged PokéStop Master");
        ENGLISH_TRANSLATIONS.put("advancements.cobblemon_pokestops.used_100_winged_pokestops.description",
                "Spin 100 Winged PokéStops to achieve mastery in the world of Cobblemon and unlock exclusive rewards!");
        ENGLISH_TRANSLATIONS.put("advancements.cobblemon_pokestops.used_200_pokestops.title", "PokéStop Legend");
        ENGLISH_TRANSLATIONS.put("advancements.cobblemon_pokestops.used_200_pokestops.description",
                "Spin 200 PokéStops to become a legend in the world of Cobblemon and unlock legendary rewards!");
        ENGLISH_TRANSLATIONS.put("advancements.cobblemon_pokestops.used_200_winged_pokestops.title", "Winged PokéStop Legend");
        ENGLISH_TRANSLATIONS.put("advancements.cobblemon_pokestops.used_200_winged_pokestops.description",
                "Spin 200 Winged PokéStops to become a legend in the world of Cobblemon and unlock legendary rewards!");
        ENGLISH_TRANSLATIONS.put("advancements.cobblemon_pokestops.used_300_pokestops.title", "PokéStop Mythic");
        ENGLISH_TRANSLATIONS.put("advancements.cobblemon_pokestops.used_300_pokestops.description",
                "Spin 300 PokéStops to achieve mythic status in the world of Cobblemon and unlock mythic rewards!");
        ENGLISH_TRANSLATIONS.put("advancements.cobblemon_pokestops.used_300_winged_pokestops.title", "Winged PokéStop Mythic");
        ENGLISH_TRANSLATIONS.put("advancements.cobblemon_pokestops.used_300_winged_pokestops.description",
                "Spin 300 Winged PokéStops to achieve mythic status in the world of Cobblemon and unlock mythic rewards!");
        ENGLISH_TRANSLATIONS.put("advancements.cobblemon_pokestops.used_400_pokestops.title", "PokéStop Immortal");
        ENGLISH_TRANSLATIONS.put("advancements.cobblemon_pokestops.used_400_pokestops.description",
                "Spin 400 PokéStops to achieve immortal status in the world of Cobblemon and unlock immortal rewards!");
        ENGLISH_TRANSLATIONS.put("advancements.cobblemon_pokestops.used_400_winged_pokestops.title", "Winged PokéStop Immortal");
        ENGLISH_TRANSLATIONS.put("advancements.cobblemon_pokestops.used_400_winged_pokestops.description",
                "Spin 400 Winged PokéStops to achieve immortal status in the world of Cobblemon and unlock immortal rewards!");
        ENGLISH_TRANSLATIONS.put("advancements.cobblemon_pokestops.used_500_pokestops.title", "PokéStop Eternal");
        ENGLISH_TRANSLATIONS.put("advancements.cobblemon_pokestops.used_500_pokestops.description",
                "Spin 500 PokéStops to achieve eternal status in the world of Cobblemon and unlock eternal rewards!");
        ENGLISH_TRANSLATIONS.put("advancements.cobblemon_pokestops.used_500_winged_pokestops.title", "Winged PokéStop Eternal");
        ENGLISH_TRANSLATIONS.put("advancements.cobblemon_pokestops.used_500_winged_pokestops.description",
                "Spin 500 Winged PokéStops to achieve eternal status in the world of Cobblemon and unlock eternal rewards!");
    }

    @SuppressWarnings("unused")
    public static void generateAdvancement(HolderLookup.Provider registryLookup, Consumer<AdvancementHolder> consumer) {
        ItemStack pokestopDisplay = new ItemStack(BlockRegistry.POKESTOPS.get("pokestop").get());
        ItemStack wingedPokestopDisplay = new ItemStack(BlockRegistry.WINGEDSTOPS.get("wingedstop").get());

        ItemStack oneHundredPlusPokestopDisplay = new ItemStack(BlockRegistry.POKESTOPS.get("pokestop_green").get());
        ItemStack oneHundredPlusWingedPokestopDisplay = new ItemStack(BlockRegistry.WINGEDSTOPS.get("wingedstop_green").get());

        ItemStack challengePokestopDisplay = new ItemStack(BlockRegistry.POKESTOPS.get("pokestop_gold").get());
        ItemStack challengeWingedPokestopDisplay = new ItemStack(BlockRegistry.WINGEDSTOPS.get("wingedstop_gold").get());

        AdvancementHolder root = Advancement.Builder.advancement()
                .display(
                        pokestopDisplay,
                        Component.translatable("advancements.cobblemon_pokestops.root.title"),
                        Component.translatable("advancements.cobblemon_pokestops.root.description"),
                        ResourceLocation.withDefaultNamespace("textures/gui/advancements/backgrounds/adventure.png"),
                        AdvancementType.TASK,
                        false, // Show the toast when completing it
                        false, // Announce it to chat
                        false // Hide it in the advancement tab until it's achieved
                        )
                .addCriterion("tick", CriteriaTriggers.TICK.createCriterion(new PlayerTrigger.TriggerInstance(Optional.empty())))
                .save(consumer, Constants.modResourceFile("root"));

        // Used 1 (GOAL)

        AdvancementHolder usedOncePokestop = Advancement.Builder.advancement()
                .display(
                        pokestopDisplay,
                        Component.translatable("advancements.cobblemon_pokestops.used_pokestop.title"),
                        Component.translatable("advancements.cobblemon_pokestops.used_pokestop.description"),
                        null,
                        AdvancementType.GOAL,
                        true, // Show the toast when completing it
                        true, // Announce it to chat
                        false // Hide it in the advancement tab until it's achieved
                )
                .parent(root)
                .addCriterion("used_1_pokestop", UsedPokestopCriterion.Conditions.usePokestop())
                .save(consumer, Constants.modResourceFile("pokestops/used_1_pokestop"));

        AdvancementHolder usedOnceWingedPokestop = Advancement.Builder.advancement()
                .display(
                        wingedPokestopDisplay,
                        Component.translatable("advancements.cobblemon_pokestops.used_wingedstop.title"),
                        Component.translatable("advancements.cobblemon_pokestops.used_wingedstop.description"),
                        null,
                        AdvancementType.GOAL,
                        true, // Show the toast when completing it
                        true, // Announce it to chat
                        false // Hide it in the advancement tab until it's achieved
                )
                .parent(root)
                .addCriterion("used_1_winged_pokestop", UsedWingedPokestopCriterion.Conditions.useWingedPokestop())
                .save(consumer, Constants.modResourceFile("wingedstops/used_1_winged_pokestop"));

        // Used 25 (TASK)

        AdvancementHolder used25Pokestops = Advancement.Builder.advancement()
                .display(
                        pokestopDisplay,
                        Component.translatable("advancements.cobblemon_pokestops.used_25_pokestops.title"),
                        Component.translatable("advancements.cobblemon_pokestops.used_25_pokestops.description"),
                        null,
                        AdvancementType.TASK,
                        true, // Show the toast when completing it
                        true, // Announce it to chat
                        false // Hide it in the advancement tab until it's achieved
                )
                .parent(usedOncePokestop)
                .addCriterion("used_25_pokestops", PokestopScoreTracker.Conditions.used(25))
                .save(consumer, Constants.modResourceFile("pokestops/used_25_pokestops"));

        AdvancementHolder used25WingedPokestops = Advancement.Builder.advancement()
                .display(
                        wingedPokestopDisplay,
                        Component.translatable("advancements.cobblemon_pokestops.used_25_winged_pokestops.title"),
                        Component.translatable("advancements.cobblemon_pokestops.used_25_winged_pokestops.description"),
                        null,
                        AdvancementType.TASK,
                        true, // Show the toast when completing it
                        true, // Announce it to chat
                        false // Hide it in the advancement tab until it's achieved
                )
                .parent(usedOnceWingedPokestop)
                .addCriterion("used_25_winged_pokestops", WingedPokestopScoreTracker.Conditions.used(25))
                .save(consumer, Constants.modResourceFile("wingedstops/used_25_winged_pokestops"));

        // Used 50 (TASK)

        AdvancementHolder used50Pokestops = Advancement.Builder.advancement()
                .display(
                        pokestopDisplay,
                        Component.translatable("advancements.cobblemon_pokestops.used_50_pokestops.title"),
                        Component.translatable("advancements.cobblemon_pokestops.used_50_pokestops.description"),
                        null,
                        AdvancementType.TASK,
                        true, // Show the toast when completing it
                        true, // Announce it to chat
                        false // Hide it in the advancement tab until it's achieved
                )
                .parent(used25Pokestops)
                .addCriterion("used_50_pokestops", PokestopScoreTracker.Conditions.used(50))
                .save(consumer, Constants.modResourceFile("pokestops/used_50_pokestops"));

        AdvancementHolder used50WingedPokestops = Advancement.Builder.advancement()
                .display(
                        wingedPokestopDisplay,
                        Component.translatable("advancements.cobblemon_pokestops.used_50_winged_pokestops.title"),
                        Component.translatable("advancements.cobblemon_pokestops.used_50_winged_pokestops.description"),
                        null,
                        AdvancementType.TASK,
                        true, // Show the toast when completing it
                        true, // Announce it to chat
                        false // Hide it in the advancement tab until it's achieved
                )
                .parent(used25WingedPokestops)
                .addCriterion("used_50_winged_pokestops", WingedPokestopScoreTracker.Conditions.used(50))
                .save(consumer, Constants.modResourceFile("wingedstops/used_50_winged_pokestops"));

        // Used 100 (GOAL)

        AdvancementHolder used100Pokestops = Advancement.Builder.advancement()
                .display(
                        oneHundredPlusPokestopDisplay,
                        Component.translatable("advancements.cobblemon_pokestops.used_100_pokestops.title"),
                        Component.translatable("advancements.cobblemon_pokestops.used_100_pokestops.description"),
                        null,
                        AdvancementType.GOAL,
                        true, // Show the toast when completing it
                        true, // Announce it to chat
                        false // Hide it in the advancement tab until it's achieved
                )
                .parent(used50Pokestops)
                .addCriterion("used_100_pokestops", PokestopScoreTracker.Conditions.used(100))
                .save(consumer, Constants.modResourceFile("pokestops/used_100_pokestops"));

        AdvancementHolder used100WingedPokestops = Advancement.Builder.advancement()
                .display(
                        oneHundredPlusWingedPokestopDisplay,
                        Component.translatable("advancements.cobblemon_pokestops.used_100_winged_pokestops.title"),
                        Component.translatable("advancements.cobblemon_pokestops.used_100_winged_pokestops.description"),
                        null,
                        AdvancementType.GOAL,
                        true, // Show the toast when completing it
                        true, // Announce it to chat
                        false // Hide it in the advancement tab until it's achieved
                )
                .parent(used50WingedPokestops)
                .addCriterion("used_100_winged_pokestops", WingedPokestopScoreTracker.Conditions.used(100))
                .save(consumer, Constants.modResourceFile("wingedstops/used_100_winged_pokestops"));

        // Used 200 (TASK)

        AdvancementHolder used200Pokestops = Advancement.Builder.advancement()
                .display(
                        oneHundredPlusPokestopDisplay,
                        Component.translatable("advancements.cobblemon_pokestops.used_200_pokestops.title"),
                        Component.translatable("advancements.cobblemon_pokestops.used_200_pokestops.description"),
                        null,
                        AdvancementType.TASK,
                        true, // Show the toast when completing it
                        true, // Announce it to chat
                        false // Hide it in the advancement tab until it's achieved
                )
                .parent(used100Pokestops)
                .addCriterion("used_200_pokestops", PokestopScoreTracker.Conditions.used(200))
                .save(consumer, Constants.modResourceFile("pokestops/used_200_pokestops"));

        AdvancementHolder used200WingedPokestops = Advancement.Builder.advancement()
                .display(
                        oneHundredPlusWingedPokestopDisplay,
                        Component.translatable("advancements.cobblemon_pokestops.used_200_winged_pokestops.title"),
                        Component.translatable("advancements.cobblemon_pokestops.used_200_winged_pokestops.description"),
                        null,
                        AdvancementType.TASK,
                        true, // Show the toast when completing it
                        true, // Announce it to chat
                        false // Hide it in the advancement tab until it's achieved
                )
                .parent(used100WingedPokestops)
                .addCriterion("used_200_winged_pokestops", WingedPokestopScoreTracker.Conditions.used(200))
                .save(consumer, Constants.modResourceFile("wingedstops/used_200_winged_pokestops"));

        // Used 300 (TASK)

        AdvancementHolder used300Pokestops = Advancement.Builder.advancement()
                .display(
                        oneHundredPlusPokestopDisplay,
                        Component.translatable("advancements.cobblemon_pokestops.used_300_pokestops.title"),
                        Component.translatable("advancements.cobblemon_pokestops.used_300_pokestops.description"),
                        null,
                        AdvancementType.TASK,
                        true, // Show the toast when completing it
                        true, // Announce it to chat
                        false // Hide it in the advancement tab until it's achieved
                )
                .parent(used200Pokestops)
                .addCriterion("used_300_pokestops", PokestopScoreTracker.Conditions.used(300))
                .save(consumer, Constants.modResourceFile("pokestops/used_300_pokestops"));

        AdvancementHolder used300WingedPokestops = Advancement.Builder.advancement()
                .display(
                        oneHundredPlusWingedPokestopDisplay,
                        Component.translatable("advancements.cobblemon_pokestops.used_300_winged_pokestops.title"),
                        Component.translatable("advancements.cobblemon_pokestops.used_300_winged_pokestops.description"),
                        null,
                        AdvancementType.TASK,
                        true, // Show the toast when completing it
                        true, // Announce it to chat
                        false // Hide it in the advancement tab until it's achieved
                )
                .parent(used200WingedPokestops)
                .addCriterion("used_300_winged_pokestops", WingedPokestopScoreTracker.Conditions.used(300))
                .save(consumer, Constants.modResourceFile("wingedstops/used_300_winged_pokestops"));

        // Used 400 (TASK)

        AdvancementHolder used400Pokestops = Advancement.Builder.advancement()
                .display(
                        oneHundredPlusPokestopDisplay,
                        Component.translatable("advancements.cobblemon_pokestops.used_400_pokestops.title"),
                        Component.translatable("advancements.cobblemon_pokestops.used_400_pokestops.description"),
                        null,
                        AdvancementType.TASK,
                        true, // Show the toast when completing it
                        true, // Announce it to chat
                        false // Hide it in the advancement tab until it's achieved
                )
                .parent(used300Pokestops)
                .addCriterion("used_400_pokestops", PokestopScoreTracker.Conditions.used(400))
                .save(consumer, Constants.modResourceFile("pokestops/used_400_pokestops"));

        AdvancementHolder used400WingedPokestops = Advancement.Builder.advancement()
                .display(
                        oneHundredPlusWingedPokestopDisplay,
                        Component.translatable("advancements.cobblemon_pokestops.used_400_winged_pokestops.title"),
                        Component.translatable("advancements.cobblemon_pokestops.used_400_winged_pokestops.description"),
                        null,
                        AdvancementType.TASK,
                        true, // Show the toast when completing it
                        true, // Announce it to chat
                        false // Hide it in the advancement tab until it's achieved
                )
                .parent(used300WingedPokestops)
                .addCriterion("used_400_winged_pokestops", WingedPokestopScoreTracker.Conditions.used(400))
                .save(consumer, Constants.modResourceFile("wingedstops/used_400_winged_pokestops"));

        // Used 500 (CHALLENGE)

        @SuppressWarnings("unused")
        AdvancementHolder used500Pokestops = Advancement.Builder.advancement()
                .display(
                        challengePokestopDisplay,
                        Component.translatable("advancements.cobblemon_pokestops.used_500_pokestops.title"),
                        Component.translatable("advancements.cobblemon_pokestops.used_500_pokestops.description"),
                        null,
                        AdvancementType.CHALLENGE,
                        true, // Show the toast when completing it
                        true, // Announce it to chat
                        false // Hide it in the advancement tab until it's achieved
                )
                .parent(used400Pokestops)
                .addCriterion("used_500_pokestops", PokestopScoreTracker.Conditions.used(500))
                .save(consumer, Constants.modResourceFile("pokestops/used_500_pokestops"));

        @SuppressWarnings("unused")
        AdvancementHolder used500WingedPokestops = Advancement.Builder.advancement()
                .display(
                        challengeWingedPokestopDisplay,
                        Component.translatable("advancements.cobblemon_pokestops.used_500_winged_pokestops.title"),
                        Component.translatable("advancements.cobblemon_pokestops.used_500_winged_pokestops.description"),
                        null,
                        AdvancementType.CHALLENGE,
                        true, // Show the toast when completing it
                        true, // Announce it to chat
                        false // Hide it in the advancement tab until it's achieved
                )
                .parent(used400WingedPokestops)
                .addCriterion("used_500_winged_pokestops", WingedPokestopScoreTracker.Conditions.used(500))
                .save(consumer, Constants.modResourceFile("wingedstops/used_500_winged_pokestops"));

    }
}
