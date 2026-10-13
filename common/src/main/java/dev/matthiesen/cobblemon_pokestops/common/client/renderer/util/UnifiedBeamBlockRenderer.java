package dev.matthiesen.cobblemon_pokestops.common.client.renderer.util;

import dev.matthiesen.cobblemon_pokestops.common.templates.block.StopItemModelTemplate;
import dev.matthiesen.cobblemon_pokestops.common.templates.block.StopModelTemplate;
import dev.matthiesen.cobblemon_pokestops.common.templates.entity.StopEntityTemplate;
import dev.matthiesen.cobblemon_pokestops.common.templates.item.StopItemTemplate;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class UnifiedBeamBlockRenderer<T extends StopEntityTemplate & GeoAnimatable & BeamRenderer.BeamEntity, I extends StopItemTemplate> {
    private final String modelName;
    private final boolean isEmissive;

    public UnifiedBeamBlockRenderer(String modelName, boolean isEmissive) {
        this.modelName = modelName;
        this.isEmissive = isEmissive;
    }

    public UnifiedBeamBlockRenderer(String modelName) {
        this(modelName, false);
    }

    public BlockEntityRendererProvider<T> createBlockRendererContext() {
        return context1 -> new BlockRenderer();
    }

    public GeoItemRenderer<I> createItemRenderer() {
        return new ItemRenderer();
    }

    public class BlockRenderer extends CustomBeamBlockRenderer<T> {
        public BlockRenderer() {
            super(new StopModelTemplate<>(modelName));
            if (isEmissive) {
                addRenderLayer(new EmissiveLayer<>(this));
            }
        }
    }

    public class ItemRenderer extends GeoItemRenderer<I> {
        public ItemRenderer() {
            super(new StopItemModelTemplate<>(modelName));
            if (isEmissive) {
                addRenderLayer(new EmissiveLayer<>(this));
            }
        }
    }
}
