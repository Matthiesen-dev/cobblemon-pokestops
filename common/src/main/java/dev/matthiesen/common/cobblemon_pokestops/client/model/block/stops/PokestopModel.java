package dev.matthiesen.common.cobblemon_pokestops.client.model.block.stops;

import dev.matthiesen.common.cobblemon_pokestops.block.entity.stops.PokestopEntity;
import dev.matthiesen.common.cobblemon_pokestops.templates.block.StopModelTemplate;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import org.jetbrains.annotations.NotNull;

public class PokestopModel extends StopModelTemplate<PokestopEntity> {
    @Override
    protected String getModelName() {
        return "pokestop";
    }

    @Override
    protected String getAnimationName() {
        return "pokestop";
    }

    @Override
    public @NotNull ResourceLocation getTextureResource(PokestopEntity animatable) {
        Player player = Minecraft.getInstance().player;
        if (player != null && !animatable.canPlayerSpin(player)) {
            return getCooldownTexture(animatable);
        }
        return getMainTexture(animatable);
    }
}
