package dev.matthiesen.neoforge.cobblemon_pokestops;

import dev.matthiesen.common.cobblemon_pokestops.CobblemonPokestops;
import dev.matthiesen.common.cobblemon_pokestops.Constants;
import dev.matthiesen.neoforge.cobblemon_pokestops.worldgen.NeoForgeFeatures;
import net.minecraft.advancements.CriterionTrigger;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.neoforged.neoforge.event.server.ServerStoppingEvent;
import net.neoforged.neoforge.registries.DeferredRegister;

@Mod(Constants.MOD_ID)
public class CobblemonPokestopsNeoForge {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(Registries.SOUND_EVENT, Constants.MOD_ID);
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(Registries.BLOCK, Constants.MOD_ID);
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, Constants.MOD_ID);
    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Constants.MOD_ID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(Registries.ITEM, Constants.MOD_ID);
    public static final DeferredRegister<CriterionTrigger<?>> ADVANCEMENT_TRIGGERS = DeferredRegister.create(Registries.TRIGGER_TYPE, Constants.MOD_ID);
    public static final DeferredRegister<ResourceLocation> STATS = DeferredRegister.create(Registries.CUSTOM_STAT, Constants.MOD_ID);

    public CobblemonPokestopsNeoForge(IEventBus modBus) {
        Constants.createInfoLog("Loading for NeoForge Mod Loader");
        STATS.register(modBus);
        SOUND_EVENTS.register(modBus);
        BLOCKS.register(modBus);
        BLOCK_ENTITIES.register(modBus);
        CREATIVE_TABS.register(modBus);
        ITEMS.register(modBus);
        ADVANCEMENT_TRIGGERS.register(modBus);
        CobblemonPokestops.preinitialize();
        NeoForgeFeatures.init();
        CobblemonPokestops.initialize();
        NeoForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        MinecraftServer server = event.getServer();
        CobblemonPokestops.onStartup(server);
    }

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public void onServerStopping(ServerStoppingEvent event) {
        CobblemonPokestops.onShutdown();
    }
}
