package dev.matthiesen.common.cobblemon_pokestops.client.model.block;

import dev.matthiesen.common.cobblemon_pokestops.block.entity.HealingstopTrophyEntity;
import dev.matthiesen.common.cobblemon_pokestops.templates.block.TrophyModelTemplate;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public class HealingstopTrophyModel extends TrophyModelTemplate<HealingstopTrophyEntity> {
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
