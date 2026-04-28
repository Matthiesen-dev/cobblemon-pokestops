package dev.matthiesen.common.cobblemon_pokestops.templates.entity;

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
import net.minecraft.world.level.block.entity.BlockEntityType;
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
import java.util.function.Supplier;

public abstract class StopEntityTemplate extends BlockEntity implements GeoBlockEntity {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    private final Map<UUID, Long> playerCooldowns = new HashMap<>();
    private boolean isSpinning = false;
    private int cleanupTimer = 0;

    public StopEntityTemplate(BlockPos pos, BlockState state, Supplier<? extends BlockEntityType<?>> type) {
        super(type.get(), pos, state);
    }

    /**
     * Subclasses must provide the idle-closed animation for when the stop is available.
     */
    protected abstract RawAnimation getIdleAnimation();

    /**
     * Subclasses must provide the idle-open animation for when the stop is on cooldown.
     */
    protected abstract RawAnimation getIdleCooldownAnimation();

    /**
     * Subclasses must provide the spin/open animation triggered by player interaction.
     */
    protected abstract RawAnimation getSpinAnimation();

    public static void tick(Level level, StopEntityTemplate entity) {
        if (level.isClientSide) return;

        // Run cleanup every 200 ticks (10 seconds)
        if (++entity.cleanupTimer >= 200) {
            entity.cleanupTimer = 0;
            entity.performCleanup(level.getGameTime());
        }
    }

    private void performCleanup(long currentGameTime) {
        boolean removed = playerCooldowns.entrySet().removeIf(entry -> entry.getValue() <= currentGameTime);
        if (removed) {
            setChanged();
        }
    }

    public boolean canPlayerSpin(Player player) {
        long currentTime = player.level().getGameTime();
        return currentTime >= playerCooldowns.getOrDefault(player.getUUID(), 0L);
    }

    public void setPlayerCooldown(Player player, int seconds) {
        long wakeupTime = player.level().getGameTime() + (seconds * 20L);
        playerCooldowns.put(player.getUUID(), wakeupTime);
        setChanged();
    }

    public String getPlayerCooldown(Player player) {
        long currentTime = player.level().getGameTime();
        long cooldownEnd = playerCooldowns.getOrDefault(player.getUUID(), 0L);
        if (currentTime >= cooldownEnd) {
            return "Ready!";
        }
        long remainingTicks = cooldownEnd - currentTime;
        long minutes = remainingTicks / 1200;
        long seconds = (remainingTicks / 20) % 60;
        return String.format(Locale.ROOT, "%d:%02d", minutes, seconds);
    }

    public void triggerSpin() {
        this.isSpinning = true;
        if (this.level != null && !this.level.isClientSide) {
            this.level.sendBlockUpdated(this.worldPosition, getBlockState(), getBlockState(), 3);
        }
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, "idle", 0, this::predicate));
        controllers.add(new AnimationController<>(this, "cooldown-spinner", 1, this::spinPredicate)
                .triggerableAnim("spin_trigger", getSpinAnimation())
        );
    }

    private PlayState predicate(AnimationState<? extends StopEntityTemplate> event) {
        if (Minecraft.getInstance().player != null && !this.canPlayerSpin(Minecraft.getInstance().player)) {
            event.getController().setAnimation(getIdleCooldownAnimation());
        } else {
            event.getController().setAnimation(getIdleAnimation());
        }
        return PlayState.CONTINUE;
    }

    private PlayState spinPredicate(AnimationState<? extends StopEntityTemplate> event) {
        if (this.isSpinning) {
            this.isSpinning = false;
            event.getController().setAnimation(getSpinAnimation());
        }
        return PlayState.CONTINUE;
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }

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
        return ClientboundBlockEntityDataPacket.create(this);
    }
}
