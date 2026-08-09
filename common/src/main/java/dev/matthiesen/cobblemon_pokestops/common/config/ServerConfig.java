package dev.matthiesen.cobblemon_pokestops.common.config;

import dev.matthiesen.matthiesen_core.common.api.permissions.PermissionLevel;
import net.neoforged.neoforge.common.ModConfigSpec;

import java.util.List;

public final class ServerConfig {
    public static final List<String> DEFAULT_RARITIES = List.of(
            "cobblemon:master_ball",
            "cobblemon:ancient_origin_ball",
            "cobblemon:ability_capsule",
            "cobblemon:max_revive",
            "cobblemon:hyper_potion",
            "cobblemon:ultra_ball",
            "cobblemon:master_rod"
    );

    // General Settings
    public ModConfigSpec.ConfigValue<List<? extends String>> extraRarities;

    // Broadcast Settings
    public ModConfigSpec.BooleanValue broadcast_enableGlobal;
    public ModConfigSpec.DoubleValue broadcast_localRadius;

    // Cooldowns
    public ModConfigSpec.IntValue cooldown_pokestops;
    public ModConfigSpec.IntValue cooldown_wingedstops;
    public ModConfigSpec.IntValue cooldown_pokeballstops;
    public ModConfigSpec.IntValue cooldown_healingstops;

    // Stop Remover Config
    public ModConfigSpec.BooleanValue stopRemover_requireOp;
    public ModConfigSpec.EnumValue<PermissionLevel> stopRemover_permissionLevel;
    public ModConfigSpec.BooleanValue stopRemover_dropsStopItem;
    public ModConfigSpec.IntValue stopRemover_confirmWindowSeconds;

    public ServerConfig(ModConfigSpec.Builder builder) {
        builder.comment("Pokestops Configuration").push("pokestopsConfig");
        extraRarities = builder.comment("List of extra rarities to be used in the Pokestops mod. Default is an empty list.")
                .defineListAllowEmpty("extraRarities", DEFAULT_RARITIES, () -> "minecraft:dirt", o -> o instanceof String);
        builder.pop();

        builder.comment("Broadcast Settings").push("broadcastSettings");
        broadcast_enableGlobal = builder.comment("Whether to enable global broadcast for Pokestops. Default is false.")
                .define("enableGlobalBroadcast", false);
        broadcast_localRadius = builder.comment("The radius in blocks for local broadcast of Pokestops. Default is 50.0 blocks.")
                .defineInRange("localBroadcastRadius", 50.0, 1.0, Double.MAX_VALUE);
        builder.pop();

        builder.comment("Cooldown Settings").push("cooldownSettings");
        cooldown_pokestops = builder.comment("The cooldown in seconds for Pokestops. Default is 300 seconds.")
                .defineInRange("pokestops", 300, 1, Integer.MAX_VALUE);
        cooldown_wingedstops = builder.comment("The cooldown in seconds for Winged Stops. Default is 300 seconds.")
                .defineInRange("wingedstops", 300, 1, Integer.MAX_VALUE);
        cooldown_pokeballstops = builder.comment("The cooldown in seconds for Pokeball Stops. Default is 300 seconds.")
                .defineInRange("pokeballstops", 300, 1, Integer.MAX_VALUE);
        cooldown_healingstops = builder.comment("The cooldown in seconds for Healing Stops. Default is 600 seconds.")
                .defineInRange("healingstops", 600, 1, Integer.MAX_VALUE);
        builder.pop();

        builder.comment("Stop Remover Configuration").push("stopRemoverConfig");
        stopRemover_requireOp = builder.comment("Whether the Stop Remover requires OP privileges to use. Default is false.")
                .define("requireOp", false);
        stopRemover_permissionLevel = builder.comment("The permission level required to use the Stop Remover. Default is NONE.")
                .defineEnum("permissionLevel", PermissionLevel.NONE);
        stopRemover_dropsStopItem = builder.comment("Whether the Stop Remover drops the stop item when used. Default is false.")
                .define("dropsStopItem", false);
        stopRemover_confirmWindowSeconds = builder.comment("The number of seconds for the confirmation window when using the Stop Remover. Default is 5 seconds.")
                .defineInRange("confirmWindowSeconds", 5, 1, Integer.MAX_VALUE);
        builder.pop();
    }
}
