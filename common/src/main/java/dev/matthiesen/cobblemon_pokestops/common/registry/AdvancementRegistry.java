package dev.matthiesen.cobblemon_pokestops.common.registry;

import dev.matthiesen.cobblemon_pokestops.common.CobblemonPokestopsCommon;
import dev.matthiesen.cobblemon_pokestops.common.advancements.score.HealingstopScoreTracker;
import dev.matthiesen.cobblemon_pokestops.common.advancements.score.PokeballstopScoreTracker;
import dev.matthiesen.cobblemon_pokestops.common.advancements.score.PokestopScoreTracker;
import dev.matthiesen.cobblemon_pokestops.common.advancements.score.WingedPokestopScoreTracker;
import dev.matthiesen.cobblemon_pokestops.common.advancements.use.UsedHealingstopCriterion;
import dev.matthiesen.cobblemon_pokestops.common.advancements.use.UsedPokeballstopCriterion;
import dev.matthiesen.cobblemon_pokestops.common.advancements.use.UsedPokestopCriterion;
import dev.matthiesen.cobblemon_pokestops.common.advancements.use.UsedWingedPokestopCriterion;
import net.minecraft.advancements.*;
import net.minecraft.advancements.critereon.PlayerTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

import java.util.Optional;
import java.util.function.Consumer;

public class AdvancementRegistry {
    @SuppressWarnings("unused")
    public static void generateAdvancement(HolderLookup.Provider registryLookup, Consumer<AdvancementHolder> consumer) {
        ItemStack pokestopDisplay = new ItemStack(BlockRegistry.POKESTOPS.get("pokestop").get());
        ItemStack wingedPokestopDisplay = new ItemStack(BlockRegistry.WINGEDSTOPS.get("wingedstop").get());
        ItemStack pokeballstopDisplay = new ItemStack(BlockRegistry.POKEBALLSTOPS.get("pokeballstop_parkball").get());

        ItemStack oneHundredPlusPokestopDisplay = new ItemStack(BlockRegistry.POKESTOPS.get("pokestop_green").get());
        ItemStack oneHundredPlusWingedPokestopDisplay = new ItemStack(BlockRegistry.WINGEDSTOPS.get("wingedstop_green").get());
        ItemStack oneHundredPlusPokeballstopDisplay = new ItemStack(BlockRegistry.POKEBALLSTOPS.get("pokeballstop_ultraball").get());

        ItemStack challengePokestopDisplay = new ItemStack(BlockRegistry.POKESTOPS.get("pokestop_gold").get());
        ItemStack challengeWingedPokestopDisplay = new ItemStack(BlockRegistry.WINGEDSTOPS.get("wingedstop_gold").get());
        ItemStack challengePokeballstopDisplay = new ItemStack(BlockRegistry.POKEBALLSTOPS.get("pokeballstop_masterball").get());

        AdvancementHolder root = createRootAdvancement(
                pokestopDisplay,
                "advancements.cobblemon_pokestops.root.title",
                "advancements.cobblemon_pokestops.root.description",
                AdvancementType.TASK,
                ResourceLocation.withDefaultNamespace("textures/gui/advancements/backgrounds/adventure.png"),
                "tick", CriteriaTriggers.TICK.createCriterion(new PlayerTrigger.TriggerInstance(Optional.empty())),
                consumer,
                "root"
        );

        // Used 1 (GOAL)

        AdvancementHolder usedOncePokestop = createChildAdvancement(
                pokestopDisplay,
                "advancements.cobblemon_pokestops.used_pokestop.title",
                "advancements.cobblemon_pokestops.used_pokestop.description",
                AdvancementType.GOAL,
                root,
                "used_1_pokestop", UsedPokestopCriterion.Conditions.usePokestop(),
                consumer,
                "pokestops/used_1_pokestop"
        );

        AdvancementHolder usedOnceWingedPokestop = createChildAdvancement(
                wingedPokestopDisplay,
                "advancements.cobblemon_pokestops.used_wingedstop.title",
                "advancements.cobblemon_pokestops.used_wingedstop.description",
                AdvancementType.GOAL,
                root,
                "used_1_winged_pokestop", UsedWingedPokestopCriterion.Conditions.useWingedPokestop(),
                consumer,
                "wingedstops/used_1_winged_pokestop"
        );

        AdvancementHolder usedOncePokeballStop = createChildAdvancement(
                pokeballstopDisplay,
                "advancements.cobblemon_pokestops.used_pokeballstop.title",
                "advancements.cobblemon_pokestops.used_pokeballstop.description",
                AdvancementType.GOAL,
                root,
                "used_1_pokeballstop", UsedPokeballstopCriterion.Conditions.usePokeballstop(),
                consumer,
                "pokeballstops/used_1_pokeballstop"
        );

        AdvancementHolder usedOnceHealingStop = createChildAdvancement(
                challengePokeballstopDisplay,
                "advancements.cobblemon_pokestops.used_healingstop.title",
                "advancements.cobblemon_pokestops.used_healingstop.description",
                AdvancementType.GOAL,
                root,
                "used_1_healingstop", UsedHealingstopCriterion.Conditions.useHealingstop(),
                consumer,
                "healingstops/used_1_healingstop"
        );

        // Used 25 (TASK)

        AdvancementHolder used25Pokestops = createChildAdvancement(
                pokestopDisplay,
                "advancements.cobblemon_pokestops.used_25_pokestops.title",
                "advancements.cobblemon_pokestops.used_25_pokestops.description",
                AdvancementType.TASK,
                usedOncePokestop,
                "used_25_pokestops", PokestopScoreTracker.Conditions.used(25),
                consumer,
                "pokestops/used_25_pokestops"
        );

        AdvancementHolder used25WingedPokestops = createChildAdvancement(
                wingedPokestopDisplay,
                "advancements.cobblemon_pokestops.used_25_winged_pokestops.title",
                "advancements.cobblemon_pokestops.used_25_winged_pokestops.description",
                AdvancementType.TASK,
                usedOnceWingedPokestop,
                "used_25_winged_pokestops", WingedPokestopScoreTracker.Conditions.used(25),
                consumer,
                "wingedstops/used_25_winged_pokestops"
        );

        AdvancementHolder used25Pokeballstops = createChildAdvancement(
                pokeballstopDisplay,
                "advancements.cobblemon_pokestops.used_25_pokeballstops.title",
                "advancements.cobblemon_pokestops.used_25_pokeballstops.description",
                AdvancementType.TASK,
                usedOncePokeballStop,
                "used_25_pokeballstops", PokeballstopScoreTracker.Conditions.used(25),
                consumer,
                "pokeballstops/used_25_pokeballstops"
        );

        AdvancementHolder used25Healingstops = createChildAdvancement(
                challengePokeballstopDisplay,
                "advancements.cobblemon_pokestops.used_25_healingstops.title",
                "advancements.cobblemon_pokestops.used_25_healingstops.description",
                AdvancementType.TASK,
                usedOnceHealingStop,
                "used_25_healingstops", HealingstopScoreTracker.Conditions.used(25),
                consumer,
                "healingstops/used_25_healingstops"
        );

        // Used 50 (TASK)

        AdvancementHolder used50Pokestops = createChildAdvancement(
                pokestopDisplay,
                "advancements.cobblemon_pokestops.used_50_pokestops.title",
                "advancements.cobblemon_pokestops.used_50_pokestops.description",
                AdvancementType.TASK,
                used25Pokestops,
                "used_50_pokestops", PokestopScoreTracker.Conditions.used(50),
                consumer,
                "pokestops/used_50_pokestops"
        );

        AdvancementHolder used50WingedPokestops = createChildAdvancement(
                wingedPokestopDisplay,
                "advancements.cobblemon_pokestops.used_50_winged_pokestops.title",
                "advancements.cobblemon_pokestops.used_50_winged_pokestops.description",
                AdvancementType.TASK,
                used25WingedPokestops,
                "used_50_winged_pokestops", WingedPokestopScoreTracker.Conditions.used(50),
                consumer,
                "wingedstops/used_50_winged_pokestops"
        );

        AdvancementHolder used50Pokeballstops = createChildAdvancement(
                pokeballstopDisplay,
                "advancements.cobblemon_pokestops.used_50_pokeballstops.title",
                "advancements.cobblemon_pokestops.used_50_pokeballstops.description",
                AdvancementType.TASK,
                used25Pokeballstops,
                "used_50_pokeballstops", PokeballstopScoreTracker.Conditions.used(50),
                consumer,
                "pokeballstops/used_50_pokeballstops"
        );

        AdvancementHolder used50Healingstops = createChildAdvancement(
                challengePokeballstopDisplay,
                "advancements.cobblemon_pokestops.used_50_healingstops.title",
                "advancements.cobblemon_pokestops.used_50_healingstops.description",
                AdvancementType.TASK,
                used25Healingstops,
                "used_50_healingstops", HealingstopScoreTracker.Conditions.used(50),
                consumer,
                "healingstops/used_50_healingstops"
        );

        // Used 100 (GOAL)

        AdvancementHolder used100Pokestops = createChildAdvancement(
                oneHundredPlusPokestopDisplay,
                "advancements.cobblemon_pokestops.used_100_pokestops.title",
                "advancements.cobblemon_pokestops.used_100_pokestops.description",
                AdvancementType.GOAL,
                used50Pokestops,
                "used_100_pokestops", PokestopScoreTracker.Conditions.used(100),
                consumer,
                "pokestops/used_100_pokestops"
        );

        AdvancementHolder used100WingedPokestops = createChildAdvancement(
                oneHundredPlusWingedPokestopDisplay,
                "advancements.cobblemon_pokestops.used_100_winged_pokestops.title",
                "advancements.cobblemon_pokestops.used_100_winged_pokestops.description",
                AdvancementType.GOAL,
                used50WingedPokestops,
                "used_100_winged_pokestops", WingedPokestopScoreTracker.Conditions.used(100),
                consumer,
                "wingedstops/used_100_winged_pokestops"
        );

        AdvancementHolder used100Pokeballstops = createChildAdvancement(
                oneHundredPlusPokeballstopDisplay,
                "advancements.cobblemon_pokestops.used_100_pokeballstops.title",
                "advancements.cobblemon_pokestops.used_100_pokeballstops.description",
                AdvancementType.GOAL,
                used50Pokeballstops,
                "used_100_pokeballstops", PokeballstopScoreTracker.Conditions.used(100),
                consumer,
                "pokeballstops/used_100_pokeballstops"
        );

        AdvancementHolder used100Healingstops = createChildAdvancement(
                challengePokeballstopDisplay,
                "advancements.cobblemon_pokestops.used_100_healingstops.title",
                "advancements.cobblemon_pokestops.used_100_healingstops.description",
                AdvancementType.GOAL,
                used50Healingstops,
                "used_100_healingstops", HealingstopScoreTracker.Conditions.used(100),
                consumer,
                "healingstops/used_100_healingstops"
        );

        // Used 200 (TASK)

        AdvancementHolder used200Pokestops = createChildAdvancement(
                oneHundredPlusPokestopDisplay,
                "advancements.cobblemon_pokestops.used_200_pokestops.title",
                "advancements.cobblemon_pokestops.used_200_pokestops.description",
                AdvancementType.TASK,
                used100Pokestops,
                "used_200_pokestops", PokestopScoreTracker.Conditions.used(200),
                consumer,
                "pokestops/used_200_pokestops"
        );

        AdvancementHolder used200WingedPokestops = createChildAdvancement(
                oneHundredPlusWingedPokestopDisplay,
                "advancements.cobblemon_pokestops.used_200_winged_pokestops.title",
                "advancements.cobblemon_pokestops.used_200_winged_pokestops.description",
                AdvancementType.TASK,
                used100WingedPokestops,
                "used_200_winged_pokestops", WingedPokestopScoreTracker.Conditions.used(200),
                consumer,
                "wingedstops/used_200_winged_pokestops"
        );

        AdvancementHolder used200Pokeballstops = createChildAdvancement(
                oneHundredPlusPokeballstopDisplay,
                "advancements.cobblemon_pokestops.used_200_pokeballstops.title",
                "advancements.cobblemon_pokestops.used_200_pokeballstops.description",
                AdvancementType.TASK,
                used100Pokeballstops,
                "used_200_pokeballstops", PokeballstopScoreTracker.Conditions.used(200),
                consumer,
                "pokeballstops/used_200_pokeballstops"
        );

        AdvancementHolder used200Healingstops = createChildAdvancement(
                challengePokeballstopDisplay,
                "advancements.cobblemon_pokestops.used_200_healingstops.title",
                "advancements.cobblemon_pokestops.used_200_healingstops.description",
                AdvancementType.TASK,
                used100Healingstops,
                "used_200_healingstops", HealingstopScoreTracker.Conditions.used(200),
                consumer,
                "healingstops/used_200_healingstops"
        );

        // Used 300 (TASK)

        AdvancementHolder used300Pokestops = createChildAdvancement(
                oneHundredPlusPokestopDisplay,
                "advancements.cobblemon_pokestops.used_300_pokestops.title",
                "advancements.cobblemon_pokestops.used_300_pokestops.description",
                AdvancementType.TASK,
                used200Pokestops,
                "used_300_pokestops", PokestopScoreTracker.Conditions.used(300),
                consumer,
                "pokestops/used_300_pokestops"
        );

        AdvancementHolder used300WingedPokestops = createChildAdvancement(
                oneHundredPlusWingedPokestopDisplay,
                "advancements.cobblemon_pokestops.used_300_winged_pokestops.title",
                "advancements.cobblemon_pokestops.used_300_winged_pokestops.description",
                AdvancementType.TASK,
                used200WingedPokestops,
                "used_300_winged_pokestops", WingedPokestopScoreTracker.Conditions.used(300),
                consumer,
                "wingedstops/used_300_winged_pokestops"
        );

        AdvancementHolder used300Pokeballstops = createChildAdvancement(
                oneHundredPlusPokeballstopDisplay,
                "advancements.cobblemon_pokestops.used_300_pokeballstops.title",
                "advancements.cobblemon_pokestops.used_300_pokeballstops.description",
                AdvancementType.TASK,
                used200Pokeballstops,
                "used_300_pokeballstops", PokeballstopScoreTracker.Conditions.used(300),
                consumer,
                "pokeballstops/used_300_pokeballstops"
        );

        AdvancementHolder used300Healingstops = createChildAdvancement(
                challengePokeballstopDisplay,
                "advancements.cobblemon_pokestops.used_300_healingstops.title",
                "advancements.cobblemon_pokestops.used_300_healingstops.description",
                AdvancementType.TASK,
                used200Healingstops,
                "used_300_healingstops", HealingstopScoreTracker.Conditions.used(300),
                consumer,
                "healingstops/used_300_healingstops"
        );

        // Used 400 (TASK)

        AdvancementHolder used400Pokestops = createChildAdvancement(
                oneHundredPlusPokestopDisplay,
                "advancements.cobblemon_pokestops.used_400_pokestops.title",
                "advancements.cobblemon_pokestops.used_400_pokestops.description",
                AdvancementType.TASK,
                used300Pokestops,
                "used_400_pokestops", PokestopScoreTracker.Conditions.used(400),
                consumer,
                "pokestops/used_400_pokestops"
        );

        AdvancementHolder used400WingedPokestops = createChildAdvancement(
                oneHundredPlusWingedPokestopDisplay,
                "advancements.cobblemon_pokestops.used_400_winged_pokestops.title",
                "advancements.cobblemon_pokestops.used_400_winged_pokestops.description",
                AdvancementType.TASK,
                used300WingedPokestops,
                "used_400_winged_pokestops", WingedPokestopScoreTracker.Conditions.used(400),
                consumer,
                "wingedstops/used_400_winged_pokestops"
        );

        AdvancementHolder used400Pokeballstops = createChildAdvancement(
                oneHundredPlusPokeballstopDisplay,
                "advancements.cobblemon_pokestops.used_400_pokeballstops.title",
                "advancements.cobblemon_pokestops.used_400_pokeballstops.description",
                AdvancementType.TASK,
                used300Pokeballstops,
                "used_400_pokeballstops", PokeballstopScoreTracker.Conditions.used(400),
                consumer,
                "pokeballstops/used_400_pokeballstops"
        );

        AdvancementHolder used400Healingstops = createChildAdvancement(
                challengePokeballstopDisplay,
                "advancements.cobblemon_pokestops.used_400_healingstops.title",
                "advancements.cobblemon_pokestops.used_400_healingstops.description",
                AdvancementType.TASK,
                used300Healingstops,
                "used_400_healingstops", HealingstopScoreTracker.Conditions.used(400),
                consumer,
                "healingstops/used_400_healingstops"
        );

        // Used 500 (CHALLENGE)

        AdvancementHolder used500Pokestops = createChildAdvancementWithRewards(
                challengePokestopDisplay,
                "advancements.cobblemon_pokestops.used_500_pokestops.title",
                "advancements.cobblemon_pokestops.used_500_pokestops.description",
                AdvancementType.CHALLENGE,
                used400Pokestops,
                "used_500_pokestops", PokestopScoreTracker.Conditions.used(500),
                AdvancementRewards.Builder.loot(ModLootTables.POKESTOP_TROPHY_LOOT),
                consumer,
                "pokestops/used_500_pokestops"
        );

        AdvancementHolder used500WingedPokestops = createChildAdvancementWithRewards(
                challengeWingedPokestopDisplay,
                "advancements.cobblemon_pokestops.used_500_winged_pokestops.title",
                "advancements.cobblemon_pokestops.used_500_winged_pokestops.description",
                AdvancementType.CHALLENGE,
                used400WingedPokestops,
                "used_500_winged_pokestops", WingedPokestopScoreTracker.Conditions.used(500),
                AdvancementRewards.Builder.loot(ModLootTables.WINGED_TROPHY_LOOT),
                consumer,
                "wingedstops/used_500_winged_pokestops"
        );

        AdvancementHolder used500Pokeballstops = createChildAdvancementWithRewards(
                challengePokeballstopDisplay,
                "advancements.cobblemon_pokestops.used_500_pokeballstops.title",
                "advancements.cobblemon_pokestops.used_500_pokeballstops.description",
                AdvancementType.CHALLENGE,
                used400Pokeballstops,
                "used_500_pokeballstops",
                PokeballstopScoreTracker.Conditions.used(500),
                AdvancementRewards.Builder.loot(ModLootTables.POKEBALL_TROPHY_LOOT),
                consumer,
                "pokeballstops/used_500_pokeballstops"
        );

        AdvancementHolder used500Healingstops =  createChildAdvancementWithRewards(
                challengePokeballstopDisplay,
                "advancements.cobblemon_pokestops.used_500_healingstops.title",
                "advancements.cobblemon_pokestops.used_500_healingstops.description",
                AdvancementType.CHALLENGE,
                used400Healingstops,
                "used_500_healingstops",
                HealingstopScoreTracker.Conditions.used(500),
                AdvancementRewards.Builder.loot(ModLootTables.HEALINGSTOP_TROPHY_LOOT),
                consumer,
                "healingstops/used_500_healingstops"
        );

    }

    @SuppressWarnings("SameParameterValue")
    private static AdvancementHolder createRootAdvancement(
            ItemStack displayItem, String title, String description, AdvancementType type, ResourceLocation background,
            String criterionString, Criterion<?> criterion,
            Consumer<AdvancementHolder> consumer, String modResourceLocation
    ) {
        return Advancement.Builder.advancement()
                .display(
                        displayItem,
                        Component.translatable(title),
                        Component.translatable(description),
                        background,
                        type,
                        false, // Show the toast when completing it
                        false, // Announce it to chat
                        false // Hide it in the advancement tab until it's achieved
                )
                .addCriterion(criterionString, criterion)
                .save(consumer, CobblemonPokestopsCommon.modResourceFile(modResourceLocation));
    }

    private static AdvancementHolder createChildAdvancement(
            ItemStack displayItem, String title, String description, AdvancementType type,
            AdvancementHolder parent,
            String criterionString, Criterion<?> criterion,
            Consumer<AdvancementHolder> consumer, String modResourceLocation
    ) {
        return Advancement.Builder.advancement()
                .display(
                        displayItem,
                        Component.translatable(title),
                        Component.translatable(description),
                        null,
                        type,
                        true, // Show the toast when completing it
                        true, // Announce it to chat
                        false // Hide it in the advancement tab until it's achieved
                )
                .parent(parent)
                .addCriterion(criterionString, criterion)
                .save(consumer, CobblemonPokestopsCommon.modResourceFile(modResourceLocation));
    }

    @SuppressWarnings("SameParameterValue")
    private static AdvancementHolder createChildAdvancementWithRewards(
            ItemStack displayItem, String title, String description, AdvancementType type,
            AdvancementHolder parent,
            String criterionString, Criterion<?> criterion,
            AdvancementRewards.Builder rewards,
            Consumer<AdvancementHolder> consumer, String modResourceLocation
    ) {
        return Advancement.Builder.advancement()
                .display(
                        displayItem,
                        Component.translatable(title),
                        Component.translatable(description),
                        null,
                        type,
                        true, // Show the toast when completing it
                        true, // Announce it to chat
                        false // Hide it in the advancement tab until it's achieved
                )
                .parent(parent)
                .addCriterion(criterionString, criterion)
                .rewards(rewards)
                .save(consumer, CobblemonPokestopsCommon.modResourceFile(modResourceLocation));
    }
}
