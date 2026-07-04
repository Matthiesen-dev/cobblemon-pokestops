package dev.matthiesen.cobblemon_pokestops.common.client.model.block.trophies;

import dev.matthiesen.cobblemon_pokestops.common.block.entity.trophies.PokestopTrophyEntity;
import dev.matthiesen.cobblemon_pokestops.common.templates.block.TrophyModelTemplate;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public class PokestopTrophyModel extends TrophyModelTemplate<PokestopTrophyEntity> {
    @Override
    protected String getModelName() {
        return "pokestop_trophy";
    }

    @Override
    protected String getAnimationName() {
        return "pokestop_trophy";
    }

    @Override
    public @NotNull ResourceLocation getTextureResource(PokestopTrophyEntity animatable) {
        return getMainTexture(animatable);
    }
}
