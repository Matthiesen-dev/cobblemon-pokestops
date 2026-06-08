package dev.matthiesen.common.cobblemon_pokestops.block.dummy;

import dev.matthiesen.common.cobblemon_pokestops.registry.ModTags;
import dev.matthiesen.common.cobblemon_pokestops.templates.block.DummyBlockTemplate;

public class PokestopDummyBlock extends DummyBlockTemplate {
    public PokestopDummyBlock() {
        super(matchesRegistered(ModTags.Blocks.POKESTOPS));
    }
}
