package dev.matthiesen.cobblemon_pokestops.common.block.dummy;

import dev.matthiesen.cobblemon_pokestops.common.templates.block.DummyBlockTemplate;
import dev.matthiesen.cobblemon_pokestops.common.registry.ModTags;

public class HealingstopDummyBlock extends DummyBlockTemplate {
    public HealingstopDummyBlock() {
        super(matchesRegistered(ModTags.Blocks.HEALINGSTOPS));
    }
}
