package dev.matthiesen.common.cobblemon_pokestops.registry;

import dev.matthiesen.common.cobblemon_pokestops.Constants;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> POKESTOPS = createTag("pokestops");
        public static final TagKey<Block> WINGEDSTOPS = createTag("wingedstops");
        public static final TagKey<Block> DUMMYBLOCKS = createTag("dummyblocks");

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

    public static final Map<TagKey<Block>, Block[]> ALL_TAGS = new HashMap<>();
    public static final List<TagKey<Block>> RELOCATION_NOT_SUPPORTED_TAGS = List.of(Blocks.POKESTOPS, Blocks.WINGEDSTOPS, Blocks.DUMMYBLOCKS);

    static {
        ALL_TAGS.put(Blocks.POKESTOPS, supplierToBlock(BlockRegistry.POKESTOPS.values()));
        ALL_TAGS.put(Blocks.WINGEDSTOPS, supplierToBlock(BlockRegistry.WINGEDSTOPS.values()));
        ALL_TAGS.put(Blocks.DUMMYBLOCKS, new Block[]{
                BlockRegistry.POKESTOP_DUMMY.get(),
                BlockRegistry.WINGEDSTOP_DUMMY.get()
        });
    }

    private static Block[] supplierToBlock(Collection<? extends Supplier<? extends Block>> items) {
        return items.stream().map(Supplier::get).toArray(Block[]::new);
    }
}
