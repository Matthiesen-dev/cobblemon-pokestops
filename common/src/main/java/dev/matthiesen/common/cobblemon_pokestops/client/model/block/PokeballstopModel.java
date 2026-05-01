package dev.matthiesen.common.cobblemon_pokestops.client.model.block;

import dev.matthiesen.common.cobblemon_pokestops.block.entity.PokeballstopEntity;
import dev.matthiesen.common.cobblemon_pokestops.templates.block.StopModelTemplate;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import org.jetbrains.annotations.NotNull;

public class PokeballstopModel extends StopModelTemplate<PokeballstopEntity> {
    @Override
    protected String getModelName() {
        return "pokeballstop";
    }

    @Override
    protected String getAnimationName() {
        return "pokeballstop";
    }

    @Override
    public @NotNull ResourceLocation getTextureResource(PokeballstopEntity animatable) {
        Player player = Minecraft.getInstance().player;
        if (player != null && !animatable.canPlayerSpin(player)) {
            return getCooldownTexture(animatable);
        }
        return getMainTexture(animatable);
    }
}
