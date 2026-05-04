package dev.matthiesen.fabric.cobblemon_pokestops.compat;

import dev.matthiesen.common.cobblemon_pokestops.templates.entity.StopEntityTemplate;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import snownee.jade.api.BlockAccessor;
import snownee.jade.api.IBlockComponentProvider;
import snownee.jade.api.IServerDataProvider;
import snownee.jade.api.ITooltip;
import snownee.jade.api.config.IPluginConfig;

public enum CooldownStopsJadeProvider implements IBlockComponentProvider, IServerDataProvider<BlockAccessor> {
    INSTANCE;

    @Override
    public void appendTooltip(ITooltip iTooltip, BlockAccessor blockAccessor, IPluginConfig iPluginConfig) {
        if (blockAccessor.getServerData().contains("Cooldown")) {
            iTooltip.add(
                    Component.translatable(
                            "tooltip.cobblemon_pokestops.cooldown",
                            blockAccessor.getServerData().getString("Cooldown")
                    )
            );
        }
    }

    @Override
    public void appendServerData(CompoundTag compoundTag, BlockAccessor blockAccessor) {
        StopEntityTemplate stopBlockEntity = (StopEntityTemplate) blockAccessor.getBlockEntity();
        compoundTag.putString("Cooldown", stopBlockEntity.getPlayerCooldown(blockAccessor.getPlayer()));
    }

    @Override
    public ResourceLocation getUid() {
        return CobblemonPokestopsJadePlugin.COOLDOWN;
    }
}
