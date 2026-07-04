package dev.matthiesen.cobblemon_pokestops.common.block.dummy;

import dev.matthiesen.cobblemon_pokestops.common.templates.block.DummyBlockTemplate;
import dev.matthiesen.cobblemon_pokestops.common.registry.ModTags;

public class PokestopDummyBlock extends DummyBlockTemplate {
    public PokestopDummyBlock() {
        super(matchesRegistered(ModTags.Blocks.POKESTOPS));
    }
}
