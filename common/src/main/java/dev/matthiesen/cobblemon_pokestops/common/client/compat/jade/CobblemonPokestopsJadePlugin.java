package dev.matthiesen.cobblemon_pokestops.common.client.compat.jade;

import dev.matthiesen.cobblemon_pokestops.common.CobblemonPokestopsCommon;
import dev.matthiesen.cobblemon_pokestops.common.block.entity.DummyBlockEntity;
import dev.matthiesen.cobblemon_pokestops.common.templates.block.*;
import dev.matthiesen.cobblemon_pokestops.common.templates.entity.StopEntityTemplate;
import net.minecraft.resources.ResourceLocation;
import snownee.jade.api.*;

@WailaPlugin
public final class CobblemonPokestopsJadePlugin implements IWailaPlugin {
    public static final ResourceLocation COOLDOWN = CobblemonPokestopsCommon.modResource("cooldown");
    public static final ResourceLocation COOLDOWN_DUMMY = CobblemonPokestopsCommon.modResource("cooldown_dummy");

    @Override
    public void register(IWailaCommonRegistration registration) {
        registration.registerBlockDataProvider(CooldownStopsJadeProvider.INSTANCE, StopEntityTemplate.class);
        registration.registerBlockDataProvider(CooldownDummyJadeProvider.INSTANCE, DummyBlockEntity.class);
    }

    @Override
    public void registerClient(IWailaClientRegistration registration) {
        registration.registerBlockComponent(CooldownStopsJadeProvider.INSTANCE, BaseStopTemplate.class);
        registration.registerBlockComponent(CooldownDummyJadeProvider.INSTANCE, DummyBlockTemplate.class);
        registration.registerBlockIcon(CooldownDummyJadeProvider.INSTANCE, DummyBlockTemplate.class);
        registration.addRayTraceCallback((hitResult, accessor, originalAccessor) -> {
            if (accessor instanceof BlockAccessor blockAccessor
                    && blockAccessor.getBlock() instanceof DummyBlockTemplate blockTemplate) {
                return registration.blockAccessor()
                        .from(blockAccessor)
                        .blockState(blockTemplate.getParentBlockState(blockAccessor.getLevel(), blockAccessor.getPosition()))
                        .build();
            }
            return accessor;
        });
    }
}
