package dev.matthiesen.common.cobblemon_pokestops.client.model.block;

import dev.matthiesen.common.cobblemon_pokestops.block.entity.PokestopTrophyEntity;
import dev.matthiesen.common.cobblemon_pokestops.templates.block.TrophyModelTemplate;
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
