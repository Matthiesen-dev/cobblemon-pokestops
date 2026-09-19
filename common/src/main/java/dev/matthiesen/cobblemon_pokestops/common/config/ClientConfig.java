package dev.matthiesen.cobblemon_pokestops.common.config;

import net.neoforged.neoforge.common.ModConfigSpec;

public final class ClientConfig {
    public ModConfigSpec.BooleanValue pokestopBeaconBeamsEnabled;

    public ClientConfig(ModConfigSpec.Builder builder) {
        builder.comment("Client Settings").push("client");
        pokestopBeaconBeamsEnabled = builder.comment("Whether Pokestops should have beacon beams. Default is true.")
                .define("pokestopBeaconBeamsEnabled", true);
        builder.pop();
    }
}
