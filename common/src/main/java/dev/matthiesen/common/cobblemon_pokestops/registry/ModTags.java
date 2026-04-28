package dev.matthiesen.common.cobblemon_pokestops.registry;

import dev.matthiesen.common.cobblemon_pokestops.Constants;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> POKESTOPS = createTag("pokestops");
        public static final TagKey<Block> WINGEDSTOPS = createTag("wingedstops");

        private static TagKey<Block> createTag(String name) {
            return TagKey.create(Registries.BLOCK, Constants.modResource(name));
        }
    }

    @SuppressWarnings("unused")
    public static class Items {
        private static TagKey<Item> createTag(String name) {
            return TagKey.create(Registries.ITEM, Constants.modResource(name));
        }
    }
}
