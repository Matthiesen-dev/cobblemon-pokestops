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
        public static final TagKey<Block> POKEBALLSTOPS = createTag("pokeballstops");
        public static final TagKey<Block> DUMMYBLOCKS = createTag("dummyblocks");
        public static final TagKey<Block> POKESTOP_TROPHY_BLOCKS = createTag("pokestop_trophy_blocks");
        public static final TagKey<Block> WINGEDSTOP_TROPHY_BLOCKS = createTag("winged_pokestop_trophy_blocks");
        public static final TagKey<Block> POKEBALLSTOP_TROPHY_BLOCKS = createTag("pokeballstop_trophy_blocks");

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

    // --- Datagen ---

    public static final Map<TagKey<Block>, Block[]> ALL_TAGS = new HashMap<>();
    public static final List<TagKey<Block>> RELOCATION_NOT_SUPPORTED_TAGS = List.of(
            Blocks.POKESTOPS,
            Blocks.WINGEDSTOPS,
            Blocks.POKEBALLSTOPS,
            Blocks.DUMMYBLOCKS
    );
    public static final List<TagKey<Block>> IRON_TOOL_MINEABLE_BLOCKS = List.of(
            Blocks.POKESTOP_TROPHY_BLOCKS,
            Blocks.WINGEDSTOP_TROPHY_BLOCKS,
            Blocks.POKEBALLSTOP_TROPHY_BLOCKS
    );

    static {
        ALL_TAGS.put(Blocks.POKESTOPS, supplierToBlock(BlockRegistry.POKESTOPS.values()));
        ALL_TAGS.put(Blocks.WINGEDSTOPS, supplierToBlock(BlockRegistry.WINGEDSTOPS.values()));
        ALL_TAGS.put(Blocks.POKEBALLSTOPS, supplierToBlock(BlockRegistry.POKEBALLSTOPS.values()));
        ALL_TAGS.put(Blocks.DUMMYBLOCKS, new Block[]{
                BlockRegistry.POKESTOP_DUMMY.get(),
                BlockRegistry.WINGEDSTOP_DUMMY.get(),
                BlockRegistry.POKEBALLSTOP_DUMMY.get()
        });
        ALL_TAGS.put(Blocks.POKESTOP_TROPHY_BLOCKS, supplierToBlock(BlockRegistry.POKESTOP_TROPHIES.values()));
        ALL_TAGS.put(Blocks.WINGEDSTOP_TROPHY_BLOCKS, supplierToBlock(BlockRegistry.WINGEDSTOP_TROPHIES.values()));
        ALL_TAGS.put(Blocks.POKEBALLSTOP_TROPHY_BLOCKS, supplierToBlock(BlockRegistry.POKEBALLSTOP_TROPHIES.values()));
    }

    private static Block[] supplierToBlock(Collection<? extends Supplier<? extends Block>> items) {
        return items.stream().map(Supplier::get).toArray(Block[]::new);
    }
}
