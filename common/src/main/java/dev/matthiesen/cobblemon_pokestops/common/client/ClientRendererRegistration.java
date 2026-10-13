package dev.matthiesen.cobblemon_pokestops.common.client;

import com.mojang.blaze3d.vertex.PoseStack;
import dev.matthiesen.cobblemon_pokestops.common.CobblemonPokestopsCommon;
import dev.matthiesen.cobblemon_pokestops.common.CobblemonPokestopsCommonClient;
import dev.matthiesen.cobblemon_pokestops.common.client.renderer.stops.*;
import dev.matthiesen.cobblemon_pokestops.common.client.renderer.trophies.*;
import dev.matthiesen.cobblemon_pokestops.common.registry.*;
import dev.matthiesen.cobblemon_pokestops.common.templates.item.StopItemTemplate;
import dev.matthiesen.matthiesen_core.common.api.events.PlatformClientEvents;
import net.minecraft.client.Camera;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.client.GeoRenderProvider;
import software.bernie.geckolib.renderer.GeoItemRenderer;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.function.Supplier;

public final class ClientRendererRegistration {
    private static final int DUMMY_BASE_SEARCH_DEPTH = 2;
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

    public static void initializeRenderers() {
        CobblemonPokestopsCommon.INSTANCE.createInfoLog("Registering Client Resources");

        // Register GeckoLib Renderers
        var healingStop = HealingStopRenderer.INSTANCE;
        var pokeballStop = PokeballStopRenderer.INSTANCE;
        var pokestop = PokeStopRenderer.INSTANCE;
        var wingedStop = WingedStopRenderer.INSTANCE;

        var healingStopTrophy = HealingStopTrophyRenderer.INSTANCE;
        var pokeballStopTrophy = PokeballStopTrophyRenderer.INSTANCE;
        var pokestopTrophy = PokeStopTrophyRenderer.INSTANCE;
        var wingedStopTrophy = WingedStopTrophyRenderer.INSTANCE;

        // Register Item Renderers
        ItemRegistry.POKESTOP_ITEMS.forEach((key, item) ->
                item.get().renderProviderHolder.setValue(makeRendererProvider(pokestop.createItemRenderer())));
        ItemRegistry.POKESTOP_TROPHY_ITEMS.forEach((key, item) ->
                item.get().renderProviderHolder.setValue(makeRendererProvider(pokestopTrophy.createItemRenderer())));
        ItemRegistry.WINGEDSTOP_ITEMS.forEach((key, item) ->
                item.get().renderProviderHolder.setValue(makeRendererProvider(wingedStop.createItemRenderer())));
        ItemRegistry.WINGEDSTOP_TROPHY_ITEMS.forEach((key, item) ->
                item.get().renderProviderHolder.setValue(makeRendererProvider(wingedStopTrophy.createItemRenderer())));
        ItemRegistry.POKEBALLSTOP_ITEMS.forEach((key, item) ->
                item.get().renderProviderHolder.setValue(makeRendererProvider(pokeballStop.createItemRenderer())));
        ItemRegistry.POKEBALLSTOP_TROPHY_ITEMS.forEach((key, item) ->
                item.get().renderProviderHolder.setValue(makeRendererProvider(pokeballStopTrophy.createItemRenderer())));
        ItemRegistry.HEALINGSTOP_ITEMS.forEach((key, item) ->
                item.get().renderProviderHolder.setValue(makeRendererProvider(healingStop.createItemRenderer())));
        ItemRegistry.HEALINGSTOP_TROPHY_ITEMS.forEach((key, item) ->
                item.get().renderProviderHolder.setValue(makeRendererProvider(healingStopTrophy.createItemRenderer())));

        // Register Block Entity Renderers
        CobblemonPokestopsCommonClient.INSTANCE.getEntityRendererManager().registerEntityRenderers(registry -> {
            registry.registerBlockEntityRenderer(BlockEntityRegistry.POKESTOP_BE.get(), pokestop.createBlockRendererContext());
            registry.registerBlockEntityRenderer(BlockEntityRegistry.WINGEDSTOP_BE.get(), wingedStop.createBlockRendererContext());
            registry.registerBlockEntityRenderer(BlockEntityRegistry.POKEBALLSTOP_BE.get(), pokeballStop.createBlockRendererContext());
            registry.registerBlockEntityRenderer(BlockEntityRegistry.HEALINGSTOP_BE.get(), healingStop.createBlockRendererContext());

            registry.registerBlockEntityRenderer(BlockEntityRegistry.POKESTOP_TROPHY_BE.get(), pokestopTrophy.createBlockRendererContext());
            registry.registerBlockEntityRenderer(BlockEntityRegistry.WINGEDSTOP_TROPHY_BE.get(), wingedStopTrophy.createBlockRendererContext());
            registry.registerBlockEntityRenderer(BlockEntityRegistry.POKEBALLSTOP_TROPHY_BE.get(), pokeballStopTrophy.createBlockRendererContext());
            registry.registerBlockEntityRenderer(BlockEntityRegistry.HEALINGSTOP_TROPHY_BE.get(), healingStopTrophy.createBlockRendererContext());
        });

        // Register Block Outline Listener
        PlatformClientEvents.BLOCK_HIGHLIGHT.subscribe(event -> {
            var context = event.context();
            ClientLevel level = context.level();
            BlockPos basePos = getBasePos(level, context.blockHitResult().getBlockPos());

            if (basePos == null) return InteractionResult.PASS;

            PoseStack poseStack = context.poseStack();
            MultiBufferSource bufferSource = context.multiBufferSource();
            Camera camera = context.camera();
            VoxelShape shape = level.getBlockState(basePos).getShape(level, basePos);

            double x = basePos.getX() - camera.getPosition().x();
            double y = basePos.getY() - camera.getPosition().y();
            double z = basePos.getZ() - camera.getPosition().z();

            LevelRenderer.renderVoxelShape(
                    poseStack,
                    bufferSource.getBuffer(RenderType.lines()),
                    shape,
                    x, y, z,
                    0.0F, 0.0F, 0.0F, 0.4F, false
            );
            return InteractionResult.FAIL;
        });
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
