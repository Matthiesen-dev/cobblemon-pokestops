package dev.matthiesen.common.cobblemon_pokestops.block.entity;

import dev.matthiesen.common.cobblemon_pokestops.registry.BlockEntityRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.animatable.GeoBlockEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.*;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;

public class PokestopEntity extends BlockEntity implements GeoBlockEntity {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    private final Map<UUID, Long> playerCooldowns = new HashMap<>();
    private static final RawAnimation IDLE_ANIM = RawAnimation.begin()
            .thenLoop("animation.pokestop.idle_closed");
    private static final RawAnimation IDLE_COOLDOWN_ANIM = RawAnimation.begin()
            .thenLoop("animation.pokestop.idle_open");
    private static final RawAnimation SPIN_ANIM = RawAnimation.begin()
            .thenPlay("animation.pokestop.open");
    private boolean isSpinning = false;
    private int cleanupTimer = 0;

    public PokestopEntity(BlockPos pos, BlockState state) {
        super(BlockEntityRegistry.POKESTOP_BE.get(), pos, state);
    }

    public static void tick(Level level, PokestopEntity be) {
        if (level.isClientSide) return;

        // Run cleanup every 200 ticks (10 seconds)
        if (++be.cleanupTimer >= 200) {
            be.cleanupTimer = 0;
            be.performCleanup(level.getGameTime());
        }
    }

    private void performCleanup(long currentGameTime) {
        // Remove players whose cooldown has expired
        boolean removed = playerCooldowns.entrySet().removeIf(entry -> entry.getValue() <= currentGameTime);

        if (removed) {
            setChanged(); // Only mark as changed/dirty if we actually removed something
        }
    }

    public boolean canPlayerSpin(Player player) {
        long currentTime = player.level().getGameTime();
        return currentTime >= playerCooldowns.getOrDefault(player.getUUID(), 0L);
    }

    public void setPlayerCooldown(Player player, int seconds) {
        long wakeupTime = player.level().getGameTime() + (seconds * 20L);
        playerCooldowns.put(player.getUUID(), wakeupTime);
        setChanged(); // Mark for saving
    }

    public String getPlayerCooldown(Player player) {
        long currentTime = player.level().getGameTime();
        long cooldownEnd = playerCooldowns.getOrDefault(player.getUUID(), 0L);
        if (currentTime >= cooldownEnd) {
            return "Ready!";
        }
        long remainingTicks = cooldownEnd - currentTime;
        long minutes = remainingTicks / 1200; // 20 ticks per second * 60 seconds
        long seconds = (remainingTicks / 20) % 60;
        return String.format(Locale.ROOT, "%d:%02d", minutes, seconds);
    }

    // Call this from your Block class when the player interacts successfully
    public void triggerSpin() {
        this.isSpinning = true;
        // On server, we don't need the anim, but we need to sync this to client
        if (this.level != null && !this.level.isClientSide) {
            this.level.sendBlockUpdated(this.worldPosition, getBlockState(), getBlockState(), 3);
        }
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, "idle", 0, this::predicate));
        controllers.add(new AnimationController<>(this, "cooldown-spinner", 1, this::spinPredicate)
                .triggerableAnim("spin_trigger", SPIN_ANIM)
        );
    }

    private PlayState predicate(AnimationState<PokestopEntity> event) {
        if (Minecraft.getInstance().player != null && !this.canPlayerSpin(Minecraft.getInstance().player)) {
            event.getController().setAnimation(IDLE_COOLDOWN_ANIM);
        } else {
            event.getController().setAnimation(IDLE_ANIM);
        }
        return PlayState.CONTINUE;
    }

    private PlayState spinPredicate(AnimationState<PokestopEntity> event) {
        if (this.isSpinning) {
            this.isSpinning = false;
            event.getController().setAnimation(SPIN_ANIM);
        }
        return PlayState.CONTINUE;
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }

    // IMPORTANT: Save/Load the data so it persists after server restarts
    @Override
    protected void saveAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.saveAdditional(tag, registries);
        ListTag list = new ListTag();
        playerCooldowns.forEach((uuid, time) -> {
            CompoundTag entry = new CompoundTag();
            entry.putUUID("UUID", uuid);
            entry.putLong("Time", time);
            list.add(entry);
        });
        tag.put("Cooldowns", list);
    }

    @Override
    protected void loadAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.loadAdditional(tag, registries);
        if (tag.contains("Cooldowns")) {
            ListTag list = tag.getList("Cooldowns", Tag.TAG_COMPOUND);
            for (int i = 0; i < list.size(); i++) {
                CompoundTag entry = list.getCompound(i);
                playerCooldowns.put(entry.getUUID("UUID"), entry.getLong("Time"));
            }
        }
    }

    @Override
    public @NotNull CompoundTag getUpdateTag(HolderLookup.Provider registries) {
        CompoundTag tag = new CompoundTag();
        this.saveAdditional(tag, registries);
        return tag;
    }

    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        // This creates the actual packet that travels from server to client
        return ClientboundBlockEntityDataPacket.create(this);
    }
}