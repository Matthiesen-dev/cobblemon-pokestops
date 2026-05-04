package dev.matthiesen.fabric.cobblemon_pokestops.compat;

import dev.matthiesen.common.cobblemon_pokestops.Constants;
import dev.matthiesen.common.cobblemon_pokestops.block.entity.DummyBlockEntity;
import dev.matthiesen.common.cobblemon_pokestops.templates.block.BaseStopTemplate;
import dev.matthiesen.common.cobblemon_pokestops.templates.block.DummyBlockTemplate;
import dev.matthiesen.common.cobblemon_pokestops.templates.entity.StopEntityTemplate;
import dev.matthiesen.fabric.cobblemon_pokestops.compat.jade.CooldownDummyJadeProvider;
import dev.matthiesen.fabric.cobblemon_pokestops.compat.jade.CooldownStopsJadeProvider;
import net.minecraft.resources.ResourceLocation;
import snownee.jade.api.*;

@WailaPlugin
public class CobblemonPokestopsJadePlugin implements IWailaPlugin {
    public static final ResourceLocation COOLDOWN = ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "cooldown");
    public static final ResourceLocation COOLDOWN_DUMMY = ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "cooldown_dummy");

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
