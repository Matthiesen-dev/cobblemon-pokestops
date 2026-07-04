package dev.matthiesen.cobblemon_pokestops.common.client.model.block.stops;

import dev.matthiesen.cobblemon_pokestops.common.block.entity.stops.HealingstopEntity;
import dev.matthiesen.cobblemon_pokestops.common.templates.block.StopModelTemplate;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import org.jetbrains.annotations.NotNull;

public class HealingstopModel extends StopModelTemplate<HealingstopEntity> {
    @Override
    protected String getModelName() {
        return "healingstop";
    }

    @Override
    protected String getAnimationName() {
        return "healingstop";
    }

    @Override
    public @NotNull ResourceLocation getTextureResource(HealingstopEntity animatable) {
        Player player = Minecraft.getInstance().player;
        if (player != null && !animatable.canPlayerSpin(player)) {
            return getCooldownTexture(animatable);
        }
        return getMainTexture(animatable);
    }
}
