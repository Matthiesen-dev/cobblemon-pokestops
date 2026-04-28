package dev.matthiesen.common.cobblemon_pokestops.client;

import dev.matthiesen.common.cobblemon_pokestops.client.renderer.block.PokestopRenderer;
import dev.matthiesen.common.cobblemon_pokestops.client.renderer.block.WingedstopRenderer;
import dev.matthiesen.common.cobblemon_pokestops.registry.BlockEntityRegistry;
import dev.matthiesen.common.cobblemon_pokestops.registry.BlockRegistry;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class CobblemonPokestopsClient {
    private static final int DUMMY_BASE_SEARCH_DEPTH = 2;
    private static final List<BlockEntityRendererMapping> BLOCK_ENTITY_RENDERER_MAPPINGS = List.of(
            new BlockEntityRendererMapping(BlockEntityRegistry.POKESTOP_BE, context -> new PokestopRenderer()),
            new BlockEntityRendererMapping(BlockEntityRegistry.WINGEDSTOP_BE, context -> new WingedstopRenderer())
    );
    private static final List<StopMapping> BASE_POS_MAPPINGS = List.of(
            new StopMapping(
                    state -> state.is(BlockRegistry.POKESTOP_DUMMY.get()),
                    matchesRegistered(BlockRegistry.POKESTOPS)
            ),
            new StopMapping(
                    state -> state.is(BlockRegistry.WINGEDSTOP_DUMMY.get()),
                    matchesRegistered(BlockRegistry.WINGEDSTOPS)
            )
    );

    @SuppressWarnings({"rawtypes", "unused"})
    public static void registerRenderers(BiConsumer<EntityType<? extends Entity>, EntityRendererProvider> entityRenderers,
                                         BiConsumer<BlockEntityType<? extends BlockEntity>, BlockEntityRendererProvider> blockEntityRenderers) {
        for (BlockEntityRendererMapping mapping : BLOCK_ENTITY_RENDERER_MAPPINGS) {
            blockEntityRenderers.accept(mapping.blockEntityType().get(), mapping.rendererProvider());
        }
    }

    public static @Nullable BlockPos getBasePos(Level level, BlockPos hitPos) {
        BlockState hitState = level.getBlockState(hitPos);

        for (StopMapping mapping : BASE_POS_MAPPINGS) {
            if (mapping.dummyMatcher.test(hitState)) {
                return findBasePos(level, hitPos, mapping.baseMatcher);
            }
        }

        return null;
    }

    private static Predicate<BlockState> matchesRegistered(Map<String, ? extends Supplier<? extends Block>> registeredBlocks) {
        return state -> registeredBlocks.values().stream().anyMatch(supplier -> state.is(supplier.get()));
    }

    private static @Nullable BlockPos findBasePos(Level level, BlockPos originPos, Predicate<BlockState> baseMatcher) {
        for (int offset = 1; offset <= DUMMY_BASE_SEARCH_DEPTH; offset++) {
            BlockPos checkPos = originPos.below(offset);
            if (baseMatcher.test(level.getBlockState(checkPos))) {
                return checkPos;
            }
        }

        return null;
    }

    private record StopMapping(Predicate<BlockState> dummyMatcher, Predicate<BlockState> baseMatcher) {
    }

    @SuppressWarnings("rawtypes")
    private record BlockEntityRendererMapping(
            Supplier<? extends BlockEntityType<? extends BlockEntity>> blockEntityType,
            BlockEntityRendererProvider rendererProvider
    ) {
    }
}
