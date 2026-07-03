package dev.matthiesen.common.cobblemon_pokestops.registry;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

import java.util.*;

public class CreativeSectionRegistry {
    public static final Map<ResourceLocation, List<ItemStack>> SECTIONS = new LinkedHashMap<>();
    public static final Map<ResourceLocation, SectionData> METADATA = new HashMap<>();

    public record SectionData(Component title, int priority) {}

    public static void registerSection(ResourceLocation id, Component title, int priority) {
        METADATA.put(id, new SectionData(title, priority));
        SECTIONS.put(id, new ArrayList<>());
    }

    public static void addItemToSection(ResourceLocation sectionId, ItemStack stack) {
        if (SECTIONS.containsKey(sectionId)) {
            SECTIONS.get(sectionId).add(stack);
        }
    }
}
