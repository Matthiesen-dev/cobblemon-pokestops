package dev.matthiesen.cobblemon_pokestops.common.advancements;

import com.mojang.serialization.Codec;
import dev.matthiesen.cobblemon_pokestops.common.registry.CriterionTriggerRegistry;
import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.critereon.ContextAwarePredicate;
import net.minecraft.advancements.critereon.SimpleCriterionTrigger;
import net.minecraft.server.level.ServerPlayer;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

public final class UsedStopCriterion extends SimpleCriterionTrigger<UsedStopCriterion.Conditions> {

    @Override
    public @NotNull Codec<UsedStopCriterion.Conditions> codec() {
        return UsedStopCriterion.Conditions.CODEC;
    }

    public void trigger(ServerPlayer player) {
        trigger(player, UsedStopCriterion.Conditions::requirementsMet);
    }

    public record Conditions(Optional<ContextAwarePredicate> playerPredicate) implements SimpleInstance {
        public static Codec<UsedStopCriterion.Conditions> CODEC = ContextAwarePredicate.CODEC.optionalFieldOf("player")
                .xmap(UsedStopCriterion.Conditions::new, UsedStopCriterion.Conditions::player).codec();

        @Override
        public @NotNull Optional<ContextAwarePredicate> player() {
            return playerPredicate;
        }

        public boolean requirementsMet() {
            return true;
        }

        public static Criterion<Conditions> usePokestop() {
            return CriterionTriggerRegistry.USE_POKESTOP.get().createCriterion(new Conditions(Optional.empty()));
        }

        public static Criterion<Conditions> useHealingstop() {
            return CriterionTriggerRegistry.USE_HEALINGSTOP.get().createCriterion(new Conditions(Optional.empty()));
        }

        public static Criterion<Conditions> usePokeballstop() {
            return CriterionTriggerRegistry.USE_POKEBALLSTOP.get().createCriterion(new Conditions(Optional.empty()));
        }

        public static Criterion<Conditions> useWingedPokestop() {
            return CriterionTriggerRegistry.USE_WINGED_POKESTOP.get().createCriterion(new Conditions(Optional.empty()));
        }
    }
}
