package dev.matthiesen.common.cobblemon_pokestops.advancements;

import com.mojang.serialization.Codec;
import dev.matthiesen.common.cobblemon_pokestops.registry.CriterionTriggerRegistry;
import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.critereon.ContextAwarePredicate;
import net.minecraft.advancements.critereon.SimpleCriterionTrigger;
import net.minecraft.server.level.ServerPlayer;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

public class UsedPokestopCriterion extends SimpleCriterionTrigger<UsedPokestopCriterion.Conditions> {

    @Override
    public @NotNull Codec<Conditions> codec() {
        return Conditions.CODEC;
    }

    public void trigger(ServerPlayer player) {
        trigger(player, Conditions::requirementsMet);
    }

    public record Conditions(
            Optional<ContextAwarePredicate> playerPredicate) implements SimpleCriterionTrigger.SimpleInstance {
        public static Codec<UsedPokestopCriterion.Conditions> CODEC = ContextAwarePredicate.CODEC.optionalFieldOf("player")
                .xmap(Conditions::new, Conditions::player).codec();

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
    }
}
