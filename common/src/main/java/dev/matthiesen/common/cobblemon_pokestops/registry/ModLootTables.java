package dev.matthiesen.common.cobblemon_pokestops.registry;

import dev.matthiesen.common.cobblemon_pokestops.Constants;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.storage.loot.LootTable;

public class ModLootTables {
    public static final ResourceKey<LootTable> POKESTOP_LOOT = ResourceKey.create(
            Registries.LOOT_TABLE,
            Constants.modResource("gameplay/pokestop_loot")
    );
}
