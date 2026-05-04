package dev.matthiesen.neoforge.cobblemon_pokestops.compat.jade;

import dev.matthiesen.common.cobblemon_pokestops.block.entity.DummyBlockEntity;
import dev.matthiesen.common.cobblemon_pokestops.templates.block.DummyBlockTemplate;
import dev.matthiesen.common.cobblemon_pokestops.templates.entity.StopEntityTemplate;
import dev.matthiesen.neoforge.cobblemon_pokestops.compat.CobblemonPokestopsJadePlugin;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.Nullable;
import snownee.jade.api.*;
import snownee.jade.api.config.IPluginConfig;
import snownee.jade.api.ui.IElement;
import snownee.jade.impl.ui.ItemStackElement;

public enum CooldownDummyJadeProvider implements IBlockComponentProvider, IServerDataProvider<BlockAccessor>, IComponentProvider<BlockAccessor> {
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
        DummyBlockEntity dummyBlockEntity = (DummyBlockEntity) blockAccessor.getBlockEntity();
        StopEntityTemplate stopBlockEntity = dummyBlockEntity.getParentEntity(blockAccessor.getLevel(), blockAccessor.getPosition());
        compoundTag.putString("Cooldown", stopBlockEntity.getPlayerCooldown(blockAccessor.getPlayer()));
    }

    @Override
    public @Nullable IElement getIcon(BlockAccessor accessor, IPluginConfig config, IElement currentIcon) {
        DummyBlockTemplate currentBlock = (DummyBlockTemplate) accessor.getBlock();
        Block parentBlock = currentBlock.getParentBlock(accessor.getLevel(), accessor.getPosition());
        if (parentBlock != null) {
            return ItemStackElement.of(parentBlock.asItem().getDefaultInstance());
        }
        return currentIcon;
    }

    @Override
    public ResourceLocation getUid() {
        return CobblemonPokestopsJadePlugin.COOLDOWN_DUMMY;
    }
}
