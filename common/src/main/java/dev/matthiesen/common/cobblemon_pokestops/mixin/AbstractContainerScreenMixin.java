package dev.matthiesen.common.cobblemon_pokestops.mixin;

import dev.matthiesen.common.cobblemon_pokestops.item.SectionHeaderItem;
import dev.matthiesen.common.cobblemon_pokestops.registry.CreativeSectionRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.screens.inventory.CreativeModeInventoryScreen;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.Slot;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@SuppressWarnings("ConstantConditions")
@Mixin(AbstractContainerScreen.class)
public abstract class AbstractContainerScreenMixin {
    @Shadow protected Slot hoveredSlot;

    @Redirect(
            method = "render",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/gui/screens/inventory/AbstractContainerScreen;renderSlotHighlight(Lnet/minecraft/client/gui/GuiGraphics;III)V"
            )
    )
    private void skipSectionHeaderHoverHighlight(GuiGraphics arg, int i, int j, int k) {
        if (hoveredSlot != null && hoveredSlot.getItem().getItem() instanceof SectionHeaderItem) {
            return;
        }
        AbstractContainerScreen.renderSlotHighlight(arg, i, j, k);
    }

    @Inject(method = "renderSlot", at = @At("HEAD"), cancellable = true)
    private void drawSectionBanner(GuiGraphics guiGraphics, Slot slot, CallbackInfo info) {
        if ((Object) this instanceof CreativeModeInventoryScreen && slot.getItem().getItem() instanceof SectionHeaderItem) {
            info.cancel();

            if (SectionHeaderItem.isPlaceholder(slot.getItem())) {
                return;
            }

            int x = slot.x;
            int y = slot.y;

            ResourceLocation sectionId = SectionHeaderItem.getSectionId(slot.getItem());
            CreativeSectionRegistry.SectionData meta = CreativeSectionRegistry.METADATA.get(sectionId);

            if (meta != null) {
                // Draw a simple 9-slot-wide header bar so section headers work even without external textures.
                int barWidth = 160;
                int barHeight = 16;
                guiGraphics.fill(x, y, x + barWidth, y + barHeight, 0xCC1A1A1A);
                guiGraphics.fill(x, y, x + barWidth, y + 2, 0xFF5050B8);
                guiGraphics.drawString(
                        Minecraft.getInstance().font,
                        meta.title(),
                        x + 5,
                        y + 4,
                        0xFFFFFF,
                        true
                );
            }
        }
    }

    @Inject(method = "renderTooltip", at = @At("HEAD"), cancellable = true)
    private void hideSectionHeaderTooltip(GuiGraphics guiGraphics, int i, int j, CallbackInfo ci) {
        if ((Object) this instanceof CreativeModeInventoryScreen
                && hoveredSlot != null
                && hoveredSlot.getItem().getItem() instanceof SectionHeaderItem) {
            ci.cancel();
        }
    }
}
