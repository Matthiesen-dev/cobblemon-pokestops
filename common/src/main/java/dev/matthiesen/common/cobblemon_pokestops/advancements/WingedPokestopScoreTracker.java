package dev.matthiesen.common.cobblemon_pokestops.advancements;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import dev.matthiesen.common.cobblemon_pokestops.registry.CriterionTriggerRegistry;
import dev.matthiesen.common.cobblemon_pokestops.registry.StatsRegistry;
import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.critereon.ContextAwarePredicate;
import net.minecraft.advancements.critereon.MinMaxBounds;
import net.minecraft.advancements.critereon.SimpleCriterionTrigger;
import net.minecraft.server.level.ServerPlayer;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

public class WingedPokestopScoreTracker extends SimpleCriterionTrigger<WingedPokestopScoreTracker.Conditions> {

    @Override
    public @NotNull Codec<Conditions> codec() {
        return Conditions.CODEC;
    }

    public void trigger(ServerPlayer player) {
        trigger(player, (conditions -> conditions.requirementsMet(player)));
    }

    public record Conditions(Optional<ContextAwarePredicate> player,
                             MinMaxBounds.Ints score) implements SimpleInstance {
        public static Codec<WingedPokestopScoreTracker.Conditions> CODEC = RecordCodecBuilder.create(codec ->
                codec.group(ContextAwarePredicate.CODEC.optionalFieldOf("player")
                                .forGetter(WingedPokestopScoreTracker.Conditions::player), MinMaxBounds.Ints.CODEC.optionalFieldOf("score", MinMaxBounds.Ints.ANY)
                                .forGetter(WingedPokestopScoreTracker.Conditions::score))
                        .apply(codec, WingedPokestopScoreTracker.Conditions::new));

        @Override
        public @NotNull Optional<ContextAwarePredicate> player() {
            return player;
        }

        public boolean requirementsMet(ServerPlayer player) {
            return this.score.matches(player.getStats().getValue(StatsRegistry.getWingedstopTimesSpunStat()));
        }

        public static Criterion<Conditions> used(int count) {
            return CriterionTriggerRegistry.WINGED_POKESTOP_SCORE.get().createCriterion(new Conditions(Optional.empty(), MinMaxBounds.Ints.exactly(count)));
        }
    }
}
