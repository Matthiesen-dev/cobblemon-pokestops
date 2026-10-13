package dev.matthiesen.cobblemon_pokestops.common.client.renderer.util;

import net.minecraft.world.level.block.entity.BlockEntity;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class CustomBlockRenderer<T extends BlockEntity & GeoAnimatable> extends GeoBlockRenderer<T> {
    public CustomBlockRenderer(GeoModel<T> model) {
        super(model);
    }

    @Override
    public int getViewDistance() {
        return 256;
    }
}
