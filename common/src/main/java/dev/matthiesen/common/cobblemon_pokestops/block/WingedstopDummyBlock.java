package dev.matthiesen.common.cobblemon_pokestops.block;

import dev.matthiesen.common.cobblemon_pokestops.templates.block.DummyBlockTemplate;
import dev.matthiesen.common.cobblemon_pokestops.registry.BlockRegistry;

public class WingedstopDummyBlock extends DummyBlockTemplate {
    public WingedstopDummyBlock() {
        super(matchesRegistered(BlockRegistry.WINGEDSTOPS));
    }
}
