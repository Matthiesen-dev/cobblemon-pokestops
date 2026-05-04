package dev.matthiesen.fabric.cobblemon_pokestops.compat;

import dev.matthiesen.common.cobblemon_pokestops.Constants;
import dev.matthiesen.common.cobblemon_pokestops.templates.block.BaseStopTemplate;
import dev.matthiesen.common.cobblemon_pokestops.templates.block.DummyBlockTemplate;
import dev.matthiesen.common.cobblemon_pokestops.templates.entity.StopEntityTemplate;
import net.minecraft.resources.ResourceLocation;
import snownee.jade.api.*;

@WailaPlugin
public class CobblemonPokestopsJadePlugin implements IWailaPlugin {
    public static final ResourceLocation COOLDOWN = ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "cooldown");

    @Override
    public void register(IWailaCommonRegistration registration) {
        registration.registerBlockDataProvider(CooldownStopsJadeProvider.INSTANCE, StopEntityTemplate.class);
    }

    @Override
    public void registerClient(IWailaClientRegistration registration) {
        registration.addRayTraceCallback((hitResult, accessor, originalAccessor) -> {
            if (accessor instanceof BlockAccessor blockAccessor) {
                if (blockAccessor.getBlock() instanceof DummyBlockTemplate blockTemplate) {
                    return registration.blockAccessor()
                            .from(blockAccessor)
                            .blockState(blockTemplate.getParentBlockState(blockAccessor.getLevel(), blockAccessor.getPosition()))
                            .build();
                }
            }
            return accessor;
        });

        registration.registerBlockComponent(CooldownStopsJadeProvider.INSTANCE, BaseStopTemplate.class);
    }
}
