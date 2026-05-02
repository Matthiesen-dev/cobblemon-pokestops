package dev.matthiesen.common.cobblemon_pokestops.client;

import dev.matthiesen.common.cobblemon_pokestops.Constants;
import dev.matthiesen.common.cobblemon_pokestops.client.renderer.block.*;
import dev.matthiesen.common.cobblemon_pokestops.client.renderer.item.*;
import dev.matthiesen.common.cobblemon_pokestops.registry.BlockEntityRegistry;
import dev.matthiesen.common.cobblemon_pokestops.registry.BlockRegistry;
import dev.matthiesen.common.cobblemon_pokestops.registry.ItemRegistry;
import dev.matthiesen.common.cobblemon_pokestops.templates.item.StopItemTemplate;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
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
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.client.GeoRenderProvider;
import software.bernie.geckolib.renderer.GeoItemRenderer;

import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class CobblemonPokestopsClient {
    private static final int DUMMY_BASE_SEARCH_DEPTH = 2;
    private static final List<BlockEntityRendererMapping> BLOCK_ENTITY_RENDERER_MAPPINGS = List.of(
            new BlockEntityRendererMapping(BlockEntityRegistry.POKESTOP_BE, context -> new PokestopRenderer()),
            new BlockEntityRendererMapping(BlockEntityRegistry.WINGEDSTOP_BE, context -> new WingedstopRenderer()),
            new BlockEntityRendererMapping(BlockEntityRegistry.POKEBALLSTOP_BE, context -> new PokeballstopRenderer()),
            new BlockEntityRendererMapping(BlockEntityRegistry.HEALINGSTOP_BE, context -> new HealingstopRenderer()),

            new BlockEntityRendererMapping(BlockEntityRegistry.POKESTOP_TROPHY_BE, context -> new PokestopTrophyRenderer()),
            new BlockEntityRendererMapping(BlockEntityRegistry.WINGEDSTOP_TROPHY_BE, context -> new WingedstopTrophyRenderer()),
            new BlockEntityRendererMapping(BlockEntityRegistry.POKEBALLSTOP_TROPHY_BE, context -> new PokeballstopTrophyRenderer()),
            new BlockEntityRendererMapping(BlockEntityRegistry.HEALINGSTOP_TROPHY_BE, context -> new HealingstopTrophyRenderer())
    );
    private static final List<StopMapping> BASE_POS_MAPPINGS = List.of(
            new StopMapping(
                    state -> state.is(BlockRegistry.POKESTOP_DUMMY.get()),
                    matchesRegistered(BlockRegistry.POKESTOPS)
            ),
            new StopMapping(
                    state -> state.is(BlockRegistry.WINGEDSTOP_DUMMY.get()),
                    matchesRegistered(BlockRegistry.WINGEDSTOPS)
            ),
            new StopMapping(
                    state -> state.is(BlockRegistry.POKEBALLSTOP_DUMMY.get()),
                    matchesRegistered(BlockRegistry.POKEBALLSTOPS)
            ),
            new StopMapping(
                    state -> state.is(BlockRegistry.HEALINGSTOP_DUMMY.get()),
                    matchesRegistered(BlockRegistry.HEALINGSTOPS)
            )
    );

    @SuppressWarnings({"rawtypes", "unused"})
    public static void initialize(BiConsumer<EntityType<? extends Entity>, EntityRendererProvider> entityRenderers,
                                  BiConsumer<BlockEntityType<? extends BlockEntity>, BlockEntityRendererProvider> blockEntityRenderers) {
        Constants.createInfoLog("Registering Client Resources");

        // Register GeckoLib Renderers
        ItemRegistry.POKESTOP_ITEMS.forEach((key, item) ->
                item.get().renderProviderHolder.setValue(makeRendererProvider(new PokestopItemRenderer())));
        ItemRegistry.POKESTOP_TROPHY_ITEMS.forEach((key, item) ->
                item.get().renderProviderHolder.setValue(makeRendererProvider(new PokestopTrophyItemRenderer())));
        ItemRegistry.WINGEDSTOP_ITEMS.forEach((key, item) ->
                item.get().renderProviderHolder.setValue(makeRendererProvider(new WingedstopItemRenderer())));
        ItemRegistry.WINGEDSTOP_TROPHY_ITEMS.forEach((key, item) ->
                item.get().renderProviderHolder.setValue(makeRendererProvider(new WingedstopTrophyItemRenderer())));
        ItemRegistry.POKEBALLSTOP_ITEMS.forEach((key, item) ->
                item.get().renderProviderHolder.setValue(makeRendererProvider(new PokeballstopItemRenderer())));
        ItemRegistry.POKEBALLSTOP_TROPHY_ITEMS.forEach((key, item) ->
                item.get().renderProviderHolder.setValue(makeRendererProvider(new PokeballstopTrophyItemRenderer())));
        ItemRegistry.HEALINGSTOP_ITEMS.forEach((key, item) ->
                item.get().renderProviderHolder.setValue(makeRendererProvider(new HealingstopItemRenderer())));
        ItemRegistry.HEALINGSTOP_TROPHY_ITEMS.forEach((key, item) ->
                item.get().renderProviderHolder.setValue(makeRendererProvider(new HealingstopTrophyItemRenderer())));

        registerBlockEntityRenderers(entityRenderers, blockEntityRenderers);
    }

    @SuppressWarnings({"rawtypes", "unused"})
    public static void registerBlockEntityRenderers(BiConsumer<EntityType<? extends Entity>, EntityRendererProvider> entityRenderers,
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

    private static <T extends StopItemTemplate> GeoRenderProvider makeRendererProvider(GeoItemRenderer<T> renderer) {
        return new GeoRenderProvider() {
            private BlockEntityWithoutLevelRenderer itemRenderer;

            @Override
            public @NotNull BlockEntityWithoutLevelRenderer getGeoItemRenderer() {
                if (this.itemRenderer == null) {
                    this.itemRenderer = renderer;
                }
                return this.itemRenderer;
            }
        };
    }
}
