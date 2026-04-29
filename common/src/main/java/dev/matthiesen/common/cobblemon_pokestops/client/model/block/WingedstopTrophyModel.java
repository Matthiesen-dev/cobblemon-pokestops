package dev.matthiesen.common.cobblemon_pokestops.client.model.block;

import dev.matthiesen.common.cobblemon_pokestops.block.entity.WingedstopEntity;
import dev.matthiesen.common.cobblemon_pokestops.block.entity.WingedstopTrophyEntity;
import dev.matthiesen.common.cobblemon_pokestops.templates.block.StopModelTemplate;
import dev.matthiesen.common.cobblemon_pokestops.templates.block.TrophyModelTemplate;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import org.jetbrains.annotations.NotNull;

public class WingedstopTrophyModel extends TrophyModelTemplate<WingedstopTrophyEntity> {
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
