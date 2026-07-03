package dev.matthiesen.common.cobblemon_pokestops.mixin;

import dev.matthiesen.common.cobblemon_pokestops.Constants;
import dev.matthiesen.common.cobblemon_pokestops.item.SectionHeaderItem;
import dev.matthiesen.common.cobblemon_pokestops.registry.CreativeSectionRegistry;
import dev.matthiesen.common.cobblemon_pokestops.registry.ItemRegistry;
import net.minecraft.client.gui.screens.inventory.CreativeModeInventoryScreen;
import net.minecraft.core.NonNullList;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.ClickType;
import net.minecraft.world.inventory.Slot;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Comparator;

@Mixin(CreativeModeInventoryScreen.class)
public class CreativeModeInventoryScreenMixin {
    @Inject(method = "slotClicked", at = @At("HEAD"), cancellable = true)
    private void blockSectionHeaderSlotClicks(Slot slot, int i, int j, ClickType clickType, CallbackInfo ci) {
        if (slot != null && slot.getItem().getItem() instanceof SectionHeaderItem) {
            ci.cancel();
        }
    }

    @Inject(method = "selectTab", at = @At("TAIL"))
    private void injectSectionHeaders$selectTab(CreativeModeTab creativeModeTab, CallbackInfo ci) {
        if (creativeModeTab == null) return;

        ResourceLocation selectedTabId = BuiltInRegistries.CREATIVE_MODE_TAB.getKey(creativeModeTab);
        ResourceLocation pokestopsTabId = ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "cobblemon_pokestops_pokestops");
        if (!pokestopsTabId.equals(selectedTabId)) return;

        NonNullList<ItemStack> structuredItems = NonNullList.create();
        CreativeSectionRegistry.SECTIONS.entrySet().stream()
                .sorted(Comparator.comparingInt((java.util.Map.Entry<ResourceLocation, java.util.List<ItemStack>> e) -> CreativeSectionRegistry.METADATA.get(e.getKey()).priority()).reversed())
                .forEach(entry -> {
                    ResourceLocation sectionId = entry.getKey();

                    ItemStack headerStack = SectionHeaderItem.createHeaderStack(ItemRegistry.SECTION_HEADER.get(), sectionId);

                    structuredItems.add(headerStack);
                    for (int i = 0; i < 8; i++) {
                        structuredItems.add(SectionHeaderItem.createPlaceholderStack(ItemRegistry.SECTION_HEADER.get()));
                    }

                    structuredItems.addAll(entry.getValue());

                    // Realign to the next 9-wide row so the next section header always starts at column 0.
                    while (structuredItems.size() % 9 != 0) {
                        structuredItems.add(SectionHeaderItem.createPlaceholderStack(ItemRegistry.SECTION_HEADER.get()));
                    }
                });

        if (((CreativeModeInventoryScreen) (Object) this).getMenu() instanceof ItemPickerMenuAccessor menuAccessor) {
            var menuItems = menuAccessor.getItemsList();
            menuItems.clear();
            menuItems.addAll(structuredItems);
            menuAccessor.invokeScrollTo(0.0f);
        }
    }
}
