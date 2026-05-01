package dev.matthiesen.common.cobblemon_pokestops.registry;

import dev.matthiesen.common.cobblemon_pokestops.client.renderer.item.*;
import dev.matthiesen.common.cobblemon_pokestops.templates.item.StopItemTemplate;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.animatable.client.GeoRenderProvider;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class ItemGeoRendererClientRegistry {
    public static void initClient() {
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
