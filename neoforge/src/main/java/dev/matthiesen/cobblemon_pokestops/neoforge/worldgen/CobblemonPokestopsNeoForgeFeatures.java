package dev.matthiesen.cobblemon_pokestops.neoforge.worldgen;

import dev.matthiesen.cobblemon_pokestops.common.CobblemonPokestopsCommon;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class CobblemonPokestopsNeoForgeFeatures {
    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(Registries.FEATURE, CobblemonPokestopsCommon.MOD_ID);

    public static void init(IEventBus modBus) {
        FEATURES.register(modBus);
    }

    private static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, CobblemonPokestopsCommon.modResource(name));
    }
}
