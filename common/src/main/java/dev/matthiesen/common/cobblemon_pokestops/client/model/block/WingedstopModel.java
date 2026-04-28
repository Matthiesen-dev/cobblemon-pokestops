package dev.matthiesen.common.cobblemon_pokestops.client.model.block;

import dev.matthiesen.common.cobblemon_pokestops.block.entity.WingedstopEntity;
import dev.matthiesen.common.cobblemon_pokestops.templates.block.StopModelTemplate;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import org.jetbrains.annotations.NotNull;

public class WingedstopModel extends StopModelTemplate<WingedstopEntity> {
    @Override
    protected String getModelName() {
        return "wingedstop";
    }

    @Override
    protected String getAnimationName() {
        return "wingedstop";
    }

    @Override
    public @NotNull ResourceLocation getTextureResource(WingedstopEntity animatable) {
        Player player = Minecraft.getInstance().player;
        if (player != null && !animatable.canPlayerSpin(player)) {
            return getCooldownTexture(animatable);
        }
        return getMainTexture(animatable);
    }
}
