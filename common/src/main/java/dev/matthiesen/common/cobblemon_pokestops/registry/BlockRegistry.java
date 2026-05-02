package dev.matthiesen.common.cobblemon_pokestops.registry;

import dev.matthiesen.common.cobblemon_pokestops.CobblemonPokestops;
import dev.matthiesen.common.cobblemon_pokestops.block.*;
import dev.matthiesen.common.cobblemon_pokestops.templates.block.TrophyTemplate;
import net.minecraft.world.level.block.Block;

import java.util.*;
import java.util.function.Supplier;

public class BlockRegistry {
    public static void init() {}

    public static final String[] POKESTOP_VARIANTS = {"gold", "black", "green"};
    public static final String[] WINGEDSTOP_VARIANTS = {"gold", "green"};
    public static final String[] POKEBALLSTOP_VARIANTS = {"masterball", "ultraball", "premierball", "parkball"};

    public static final Map<String, Supplier<Pokestop>> POKESTOPS = new HashMap<>();
    public static final Map<String, Supplier<Wingedstop>> WINGEDSTOPS = new HashMap<>();
    public static final Map<String, Supplier<Pokeballstop>> POKEBALLSTOPS = new HashMap<>();
    public static final Map<String, Supplier<Healingstop>> HEALINGSTOPS = new HashMap<>();

    public static final Map<String, Supplier<PokestopTrophy>> POKESTOP_TROPHIES = new HashMap<>();
    public static final Map<String, Supplier<WingedstopTrophy>> WINGEDSTOP_TROPHIES = new HashMap<>();
    public static final Map<String, Supplier<TrophyTemplate>> POKEBALLSTOP_TROPHIES = new HashMap<>();
    public static final Map<String, Supplier<HealingstopTrophy>> HEALINGSTOP_TROPHIES = new HashMap<>();

    public static final Map<String, Supplier<? extends TrophyTemplate>> ALL_TROPHIES = new HashMap<>();

    static {
        // Register Pokestops
        registerFamilyWithVariants(POKESTOPS, "pokestop", POKESTOP_VARIANTS, Pokestop::new);
        registerFamilyWithVariants(WINGEDSTOPS, "wingedstop", WINGEDSTOP_VARIANTS, Wingedstop::new);
        registerVariantBlock(POKEBALLSTOPS, "pokeballstop", POKEBALLSTOP_VARIANTS, Pokeballstop::new);
        HEALINGSTOPS.put("healingstop", registerBlock("healingstop", Healingstop::new));

        // Register Trophies
        POKESTOP_TROPHIES.put("pokestop_trophy", registerBlock("pokestop_trophy", PokestopTrophy::new));
        WINGEDSTOP_TROPHIES.put("wingedstop_trophy", registerBlock("wingedstop_trophy", WingedstopTrophy::new));
        POKEBALLSTOP_TROPHIES.put("pokeballstop_trophy", registerBlock("pokeballstop_trophy", PokeballstopTrophy::new));
        HEALINGSTOP_TROPHIES.put("healingstop_trophy", registerBlock("healingstop_trophy", HealingstopTrophy::new));

        // Store Trophy collection data for datagen
        ALL_TROPHIES.putAll(POKESTOP_TROPHIES);
        ALL_TROPHIES.putAll(WINGEDSTOP_TROPHIES);
        ALL_TROPHIES.putAll(POKEBALLSTOP_TROPHIES);
        ALL_TROPHIES.putAll(HEALINGSTOP_TROPHIES);
    }

    /**
     * Registers a family of blocks that share a base ID and have multiple variants. The base block is registered with the base ID,
     * and each variant is registered with an ID formed by appending the variant name to the base ID (e.g., "pokestop_gold").
     */
    private static <T extends Block> void registerFamilyWithVariants(
            Map<String, Supplier<T>> target,
            String baseId,
            String[] variants,
            Supplier<T> factory
    ) {
        target.put(baseId, registerBlock(baseId, factory));
        Arrays.stream(variants)
                .map(variant -> baseId + "_" + variant)
                .forEach(id -> target.put(id, registerBlock(id, factory)));
    }

    /**
     * Registers a block with multiple variants, but does not register a base block with the base ID.
     * Each variant is registered with an ID formed by appending the variant name to the base ID (e.g., "pokestop_gold").
     */
    @SuppressWarnings("SameParameterValue")
    private static <T extends Block> void registerVariantBlock(
            Map<String, Supplier<T>> target,
            String baseId,
            String[] variants,
            Supplier<T> factory
    ) {
        Arrays.stream(variants)
                .map(variant -> baseId + "_" + variant)
                .forEach(id -> target.put(id, registerBlock(id, factory)));
    }

    // Utility block
    public static final Supplier<PokestopDummyBlock> POKESTOP_DUMMY = registerBlock("pokestop_dummy", PokestopDummyBlock::new);
    public static final Supplier<WingedstopDummyBlock> WINGEDSTOP_DUMMY = registerBlock("wingedstop_dummy", WingedstopDummyBlock::new);
    public static final Supplier<PokeballstopDummyBlock> POKEBALLSTOP_DUMMY = registerBlock("pokeballstop_dummy", PokeballstopDummyBlock::new);
    public static final Supplier<HealingstopDummyBlock> HEALINGSTOP_DUMMY = registerBlock("healingstop_dummy", HealingstopDummyBlock::new);

    // Registration
    private static <T extends Block> Supplier<T> registerBlock(String id, Supplier<T> block) {
        return CobblemonPokestops.COMMON_PLATFORM.registerBlock(id, block);
    }

    // --- Datagen ---

    public static Collection<Supplier<? extends Block>> getAllTemplates() {
        List<Supplier<? extends Block>> templates = new ArrayList<>();
        POKESTOPS.forEach((id, block) -> templates.add(block));
        WINGEDSTOPS.forEach((id, block) -> templates.add(block));
        POKEBALLSTOPS.forEach((id, block) -> templates.add(block));
        HEALINGSTOPS.forEach((id, block) -> templates.add(block));
        ALL_TROPHIES.forEach((id, block) -> templates.add(block));
        templates.add(POKESTOP_DUMMY);
        templates.add(WINGEDSTOP_DUMMY);
        templates.add(POKEBALLSTOP_DUMMY);
        templates.add(HEALINGSTOP_DUMMY);
        return templates;
    }
}
