package dev.matthiesen.common.cobblemon_pokestops.mixin;

import net.minecraft.core.NonNullList;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(targets = "net.minecraft.client.gui.screens.inventory.CreativeModeInventoryScreen$ItemPickerMenu")
public interface ItemPickerMenuAccessor {
    @Accessor("items")
    NonNullList<ItemStack> getItemsList();

    @Invoker("scrollTo")
    void invokeScrollTo(float scroll);
}
