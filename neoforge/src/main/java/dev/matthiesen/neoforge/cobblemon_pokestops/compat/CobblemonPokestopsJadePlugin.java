package dev.matthiesen.neoforge.cobblemon_pokestops.compat;

import dev.matthiesen.common.cobblemon_pokestops.templates.block.DummyBlockTemplate;
import snownee.jade.api.*;

@SuppressWarnings("unused")
@WailaPlugin
public class CobblemonPokestopsJadePlugin implements IWailaPlugin {
    @Override
    public void register(IWailaCommonRegistration registration) {
    }

    @Override
    public void registerClient(IWailaClientRegistration registration) {
        registration.addRayTraceCallback((hitResult, accessor, originalAccessor) -> {
            if (accessor instanceof BlockAccessor blockAccessor) {
                if (blockAccessor.getBlock() instanceof DummyBlockTemplate blockTemplate) {
                    return registration.blockAccessor()
                            .from(blockAccessor)
                            .blockState(blockTemplate.getParentBlock(blockAccessor.getLevel(), blockAccessor.getPosition()))
                            .build();
                }
            }
            return accessor;
        });
    }
}
