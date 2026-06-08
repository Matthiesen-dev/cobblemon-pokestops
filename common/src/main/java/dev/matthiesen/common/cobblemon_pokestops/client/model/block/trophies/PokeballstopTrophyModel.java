package dev.matthiesen.common.cobblemon_pokestops.client.model.block.trophies;

import dev.matthiesen.common.cobblemon_pokestops.block.entity.trophies.PokeballstopTrophyEntity;
import dev.matthiesen.common.cobblemon_pokestops.templates.block.TrophyModelTemplate;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public class PokeballstopTrophyModel extends TrophyModelTemplate<PokeballstopTrophyEntity> {
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
