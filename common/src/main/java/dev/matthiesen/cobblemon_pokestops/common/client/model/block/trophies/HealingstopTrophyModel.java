package dev.matthiesen.cobblemon_pokestops.common.client.model.block.trophies;

import dev.matthiesen.cobblemon_pokestops.common.block.entity.trophies.HealingstopTrophyEntity;
import dev.matthiesen.cobblemon_pokestops.common.templates.block.TrophyModelTemplate;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public final class HealingstopTrophyModel extends TrophyModelTemplate<HealingstopTrophyEntity> {
    @Override
    protected String getModelName() {
        return "healingstop_trophy";
    }

    @Override
    protected String getAnimationName() {
        return "healingstop_trophy";
    }

    @Override
    public @NotNull ResourceLocation getTextureResource(HealingstopTrophyEntity animatable) {
        return getMainTexture(animatable);
    }
}
