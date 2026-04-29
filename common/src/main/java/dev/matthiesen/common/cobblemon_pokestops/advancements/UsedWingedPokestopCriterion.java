package dev.matthiesen.common.cobblemon_pokestops.advancements;

import com.mojang.serialization.Codec;
import dev.matthiesen.common.cobblemon_pokestops.registry.CriterionTriggerRegistry;
import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.critereon.ContextAwarePredicate;
import net.minecraft.advancements.critereon.SimpleCriterionTrigger;
import net.minecraft.server.level.ServerPlayer;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

public class UsedWingedPokestopCriterion extends SimpleCriterionTrigger<UsedWingedPokestopCriterion.Conditions> {

    @Override
    public @NotNull Codec<Conditions> codec() {
        return Conditions.CODEC;
    }

    public void trigger(ServerPlayer player) {
        trigger(player, Conditions::requirementsMet);
    }

    public record Conditions(
            Optional<ContextAwarePredicate> playerPredicate) implements SimpleInstance {
        public static Codec<UsedWingedPokestopCriterion.Conditions> CODEC = ContextAwarePredicate.CODEC.optionalFieldOf("player")
                .xmap(Conditions::new, Conditions::player).codec();

        @Override
        public @NotNull Optional<ContextAwarePredicate> player() {
            return playerPredicate;
        }

        public boolean requirementsMet() {
            return true;
        }

        public static Criterion<Conditions> useWingedPokestop() {
            return CriterionTriggerRegistry.USE_WINGED_POKESTOP.get().createCriterion(new Conditions(Optional.empty()));
        }
    }
}
