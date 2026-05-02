package dev.matthiesen.common.cobblemon_pokestops.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ModConfig {
    @SerializedName("enableGlobalBroadcast")
    public boolean enableGlobalBroadcast = false;

    @SerializedName("localBroadcastRadius")
    public double localBroadcastRadius = 50.0;

    @SerializedName("pokestopCooldownSeconds")
    public int pokestopCooldownSeconds = 300; // 5 minute cooldown

    @SerializedName("wingedstopCooldownSeconds")
    public int wingedstopCooldownSeconds = 300;

    @SerializedName("pokeballstopCooldownSeconds")
    public int pokeballstopCooldownSeconds = 300;

    @SerializedName("healingstopCooldownSeconds")
    public int healingstopCooldownSeconds = 600;

    @SerializedName("extraRarities")
    public List<String> extraRarities = List.of(
            "cobblemon:master_ball",
            "cobblemon:acient_origin_ball",
            "cobblemon:ability_capsule",
            "cobblemon:max_revive",
            "cobblemon:hyper_potion",
            "cobblemon:ultra_ball",
            "cobblemon:master_rod"
    );

    public static final Gson GSON = new GsonBuilder()
            .disableHtmlEscaping()
            .setPrettyPrinting()
            .create();
}
