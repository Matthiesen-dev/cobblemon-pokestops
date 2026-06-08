package dev.matthiesen.common.cobblemon_pokestops.block.dummy;

import dev.matthiesen.common.cobblemon_pokestops.registry.ModTags;
import dev.matthiesen.common.cobblemon_pokestops.templates.block.DummyBlockTemplate;

public class PokeballstopDummyBlock extends DummyBlockTemplate {
    public PokeballstopDummyBlock() {
        super(matchesRegistered(ModTags.Blocks.POKEBALLSTOPS));
    }
}
