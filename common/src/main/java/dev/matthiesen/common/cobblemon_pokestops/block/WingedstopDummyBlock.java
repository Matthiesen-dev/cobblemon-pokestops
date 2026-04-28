package dev.matthiesen.common.cobblemon_pokestops.block;

import dev.matthiesen.common.cobblemon_pokestops.registry.ModTags;
import dev.matthiesen.common.cobblemon_pokestops.templates.block.DummyBlockTemplate;

public class WingedstopDummyBlock extends DummyBlockTemplate {
    public WingedstopDummyBlock() {
        super(matchesRegistered(ModTags.Blocks.WINGEDSTOPS));
    }
}
