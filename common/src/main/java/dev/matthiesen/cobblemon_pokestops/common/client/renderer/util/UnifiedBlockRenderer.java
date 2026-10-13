package dev.matthiesen.cobblemon_pokestops.common.client.renderer.util;

import dev.matthiesen.cobblemon_pokestops.common.templates.block.StopItemModelTemplate;
import dev.matthiesen.cobblemon_pokestops.common.templates.block.TrophyModelTemplate;
import dev.matthiesen.cobblemon_pokestops.common.templates.entity.TrophyEntityTemplate;
import dev.matthiesen.cobblemon_pokestops.common.templates.item.StopItemTemplate;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class UnifiedBlockRenderer<T extends TrophyEntityTemplate, I extends StopItemTemplate> {
    private final String modelName;
    private final boolean isEmissive;

    public UnifiedBlockRenderer(String modelName, boolean isEmissive) {
        this.modelName = modelName;
        this.isEmissive = isEmissive;
    }

    public UnifiedBlockRenderer(String modelName) {
        this(modelName, false);
    }

    public BlockEntityRendererProvider<T> createBlockRendererContext() {
        return context1 -> new BlockRenderer();
    }

    public GeoItemRenderer<I> createItemRenderer() {
        return new ItemRenderer();
    }

    public class BlockRenderer extends CustomBlockRenderer<T> {
        public BlockRenderer() {
            super(new TrophyModelTemplate<>(modelName));
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
