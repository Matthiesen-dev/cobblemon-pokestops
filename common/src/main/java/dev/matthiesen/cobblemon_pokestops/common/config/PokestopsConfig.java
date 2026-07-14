package dev.matthiesen.cobblemon_pokestops.common.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public final class PokestopsConfig {
    @SerializedName("broadcastSettings")
    public BroadcastSettings broadcastSettings = new BroadcastSettings();

    @SerializedName("cooldowns")
    public CooldownsConfig cooldowns = new CooldownsConfig();

    @SerializedName("stopRemoverConfig")
    public StopRemoverConfig stopRemoverConfig = new StopRemoverConfig();

    @SerializedName("extraRarities")
    public List<String> extraRarities = List.of(
            "cobblemon:master_ball",
            "cobblemon:ancient_origin_ball",
            "cobblemon:ability_capsule",
            "cobblemon:max_revive",
            "cobblemon:hyper_potion",
            "cobblemon:ultra_ball",
            "cobblemon:master_rod"
    );

    public static class BroadcastSettings {
        @SerializedName("enableGlobalBroadcast")
        public boolean enableGlobalBroadcast = false;

        @SerializedName("localBroadcastRadius")
        public double localBroadcastRadius = 50.0;
    }

    public static class CooldownsConfig {
        @SerializedName("pokestops")
        public int pokestops = 300;

        @SerializedName("wingedstops")
        public int wingedstops = 300;

        @SerializedName("pokeballstops")
        public int pokeballstops = 300;

        @SerializedName("healingstops")
        public int healingstops = 600;
    }

    public static class StopRemoverConfig {
        @SerializedName("requireOp")
        public boolean requireOp = false;

        @SerializedName("permissionLevel")
        public int permissionLevel = 2;

        @SerializedName("dropsStopItem")
        public boolean dropsStopItem = false;

        @SerializedName("confirmWindowSeconds")
        public int confirmWindowSeconds = 5;
    }

    @SuppressWarnings("unused")
    public static final Gson GSON = new GsonBuilder()
            .disableHtmlEscaping()
            .setPrettyPrinting()
            .create();
}
