package dev.matthiesen.common.cobblemon_pokestops.block;

import dev.matthiesen.common.cobblemon_pokestops.registry.ModTags;
import dev.matthiesen.common.cobblemon_pokestops.templates.block.DummyBlockTemplate;

public class HealingstopDummyBlock extends DummyBlockTemplate {
    public HealingstopDummyBlock() {
        super(matchesRegistered(ModTags.Blocks.HEALINGSTOPS));
    }
}
