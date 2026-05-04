package dev.matthiesen.neoforge.cobblemon_pokestops.compat;

import dev.matthiesen.common.cobblemon_pokestops.Constants;
import dev.matthiesen.common.cobblemon_pokestops.templates.block.BaseStopTemplate;
import dev.matthiesen.common.cobblemon_pokestops.templates.block.DummyBlockTemplate;
import dev.matthiesen.common.cobblemon_pokestops.templates.entity.StopEntityTemplate;
import dev.matthiesen.neoforge.cobblemon_pokestops.compat.jade.CooldownStopsJadeProvider;
import net.minecraft.resources.ResourceLocation;
import snownee.jade.api.*;

@SuppressWarnings("unused")
@WailaPlugin
public class CobblemonPokestopsJadePlugin implements IWailaPlugin {
    public static final ResourceLocation COOLDOWN = ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "cooldown");

    @Override
    public void register(IWailaCommonRegistration registration) {
        registration.registerBlockDataProvider(CooldownStopsJadeProvider.INSTANCE, StopEntityTemplate.class);
    }

    @Override
    public void registerClient(IWailaClientRegistration registration) {
        registration.registerBlockComponent(CooldownStopsJadeProvider.INSTANCE, BaseStopTemplate.class);

        // Temporary hack to replace dummy blocks with the Pokestop brain their attached to...
        // Need to figure out a better way to do this, that can also include the current server data for the
        // Pokestop such as Cooldowns included by Jade
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