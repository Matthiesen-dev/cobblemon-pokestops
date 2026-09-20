package dev.matthiesen.cobblemon_pokestops.common.config;

import net.neoforged.neoforge.common.ModConfigSpec;

public final class ClientConfig {
    public ModConfigSpec.BooleanValue pokestopBeaconBeamsEnabled;
    public ModConfigSpec.DoubleValue pokestopBeaconHideDistance;

    public ClientConfig(ModConfigSpec.Builder builder) {
        builder.comment("Client Settings").push("client");
        pokestopBeaconBeamsEnabled = builder.comment("Whether Pokestops should have beacon beams. Default is true.")
                .define("pokestopBeaconBeamsEnabled", true);
        pokestopBeaconHideDistance = builder.comment("The distance in blocks when a beacon beam from a Pokestop should be hidden when approaching. Default is 12.0 blocks.")
                .defineInRange("pokestopBeaconHideDistance", 12.0, 1.0, 256.0);
        builder.pop();
    }
}
