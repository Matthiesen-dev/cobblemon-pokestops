package dev.matthiesen.cobblemon_pokestops.common.block.dummy;

import dev.matthiesen.cobblemon_pokestops.common.templates.block.DummyBlockTemplate;
import dev.matthiesen.cobblemon_pokestops.common.registry.ModTags;

public final class PokeballstopDummyBlock extends DummyBlockTemplate {
    public PokeballstopDummyBlock() {
        super(matchesRegistered(ModTags.Blocks.POKEBALLSTOPS));
    }
}
