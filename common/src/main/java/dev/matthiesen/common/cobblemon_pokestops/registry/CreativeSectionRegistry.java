package dev.matthiesen.common.cobblemon_pokestops.registry;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

import java.util.*;
import java.util.function.Consumer;

public class CreativeSectionRegistry {
    public static final Map<ResourceLocation, List<ItemStack>> SECTIONS = new LinkedHashMap<>();
    public static final Map<ResourceLocation, SectionData> METADATA = new HashMap<>();

    public static class SectionDataMeta {
        private int sectionTitleColor;
        private int sectionTitleAccentColor;
        private int sectionBackgroundColor;

        public SectionDataMeta(int sectionTitleColor, int sectionTitleAccentColor, int sectionBackgroundColor) {
            this.sectionTitleColor = sectionTitleColor;
            this.sectionTitleAccentColor = sectionTitleAccentColor;
            this.sectionBackgroundColor = sectionBackgroundColor;
        }

        public SectionDataMeta setSectionTitleColor(int value) {
            this.sectionTitleColor = value;
            return this;
        }

        public SectionDataMeta setSectionTitleAccentColor(int value) {
            this.sectionTitleAccentColor = value;
            return this;
        }

        public SectionDataMeta setSectionBackgroundColor(int value) {
            this.sectionBackgroundColor = value;
            return this;
        }

        public int getSectionTitleColor() {
            return sectionTitleColor;
        }

        public int getSectionTitleAccentColor() {
            return sectionTitleAccentColor;
        }

        public int getSectionBackgroundColor() {
            return sectionBackgroundColor;
        }

        public static SectionDataMeta defaults() {
            return new SectionDataMeta(0xFFFFFF, 0xFF5050B8, 0xCC1A1A1A);
        }
    }

    public record SectionData(Component title, int priority, SectionDataMeta meta) {}

    public static void registerSection(ResourceLocation id, Component title, int priority) {
        METADATA.put(id, new SectionData(title, priority, SectionDataMeta.defaults()));
        SECTIONS.put(id, new ArrayList<>());
    }

    public static void registerSection(ResourceLocation id, Component title, int priority, Consumer<SectionDataMeta> meta) {
        SectionDataMeta sectionMeta = SectionDataMeta.defaults();
        meta.accept(sectionMeta);
        METADATA.put(id, new SectionData(title, priority, sectionMeta));
        SECTIONS.put(id, new ArrayList<>());
    }

    public static void addItemToSection(ResourceLocation sectionId, ItemStack stack) {
        if (SECTIONS.containsKey(sectionId)) {
            SECTIONS.get(sectionId).add(stack);
        }
    }
}
