package dev.matthiesen.cobblemon_pokestops.common.client.model.block.trophies;

import dev.matthiesen.cobblemon_pokestops.common.block.entity.trophies.WingedstopTrophyEntity;
import dev.matthiesen.cobblemon_pokestops.common.templates.block.TrophyModelTemplate;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public final class WingedstopTrophyModel extends TrophyModelTemplate<WingedstopTrophyEntity> {
    @Override
    protected String getModelName() {
        return "wingedstop_trophy";
    }

    @Override
    protected String getAnimationName() {
        return "wingedstop_trophy";
    }

    @Override
    public @NotNull ResourceLocation getTextureResource(WingedstopTrophyEntity animatable) {
        return getMainTexture(animatable);
    }
}
