package dev.matthiesen.cobblemon_pokestops.common.advancements;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import dev.matthiesen.cobblemon_pokestops.common.registry.CriterionTriggerRegistry;
import dev.matthiesen.cobblemon_pokestops.common.registry.StatsRegistry;
import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.critereon.ContextAwarePredicate;
import net.minecraft.advancements.critereon.MinMaxBounds;
import net.minecraft.advancements.critereon.SimpleCriterionTrigger;
import net.minecraft.server.level.ServerPlayer;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

public final class StopScoreTrackingCriterion extends SimpleCriterionTrigger<StopScoreTrackingCriterion.Conditions> {

    @Override
    public @NotNull Codec<StopScoreTrackingCriterion.Conditions> codec() {
        return StopScoreTrackingCriterion.Conditions.CODEC;
    }

    public void trigger(ServerPlayer player) {
        trigger(player, (conditions -> conditions.requirementsMet(player)));
    }

    public record Conditions(Optional<ContextAwarePredicate> player, MinMaxBounds.Ints score) implements SimpleInstance {
        public static Codec<StopScoreTrackingCriterion.Conditions> CODEC = RecordCodecBuilder.create(codec ->
                codec.group(ContextAwarePredicate.CODEC.optionalFieldOf("player")
                                .forGetter(StopScoreTrackingCriterion.Conditions::player), MinMaxBounds.Ints.CODEC.optionalFieldOf("score", MinMaxBounds.Ints.ANY)
                                .forGetter(StopScoreTrackingCriterion.Conditions::score))
                        .apply(codec, StopScoreTrackingCriterion.Conditions::new));

        @Override
        public @NotNull Optional<ContextAwarePredicate> player() {
            return player;
        }

        public boolean requirementsMet(ServerPlayer player) {
            return this.score.matches(player.getStats().getValue(StatsRegistry.getPokeballstopTimesSpunStat()));
        }

        public static Criterion<Conditions> usedHealingstop(int count) {
            return CriterionTriggerRegistry.HEALINGSTOP_SCORE.get().createCriterion(new Conditions(Optional.empty(), MinMaxBounds.Ints.exactly(count)));
        }

        public static Criterion<Conditions> usedPokeballstop(int count) {
            return CriterionTriggerRegistry.POKEBALLSTOP_SCORE.get().createCriterion(new Conditions(Optional.empty(), MinMaxBounds.Ints.exactly(count)));
        }

        public static Criterion<Conditions> usedPokestop(int count) {
            return CriterionTriggerRegistry.POKESTOP_SCORE.get().createCriterion(new Conditions(Optional.empty(), MinMaxBounds.Ints.exactly(count)));
        }

        public static Criterion<Conditions> usedWingedPokestop(int count) {
            return CriterionTriggerRegistry.WINGED_POKESTOP_SCORE.get().createCriterion(new Conditions(Optional.empty(), MinMaxBounds.Ints.exactly(count)));
        }
    }
}
