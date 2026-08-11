package dev.matthiesen.cobblemon_pokestops.common.client.model.block.trophies;

import dev.matthiesen.cobblemon_pokestops.common.block.entity.trophies.PokeballstopTrophyEntity;
import dev.matthiesen.cobblemon_pokestops.common.templates.block.TrophyModelTemplate;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public final class PokeballstopTrophyModel extends TrophyModelTemplate<PokeballstopTrophyEntity> {
    @Override
    protected String getModelName() {
        return "pokeballstop_trophy";
    }

    @Override
    protected String getAnimationName() {
        return "pokeballstop_trophy";
    }

    @Override
    public @NotNull ResourceLocation getTextureResource(PokeballstopTrophyEntity animatable) {
        return getMainTexture(animatable);
    }
}
