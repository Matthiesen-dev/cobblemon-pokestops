package dev.matthiesen.cobblemon_pokestops.common.config;

import net.neoforged.neoforge.common.ModConfigSpec;

public final class StartupConfig {
    public ModConfigSpec.BooleanValue pokestopsBlockCollision;

    public StartupConfig(ModConfigSpec.Builder builder) {
        builder.comment("Startup Settings").push("startupSettings");
        pokestopsBlockCollision = builder.comment("Whether Pokestops should have block collision. Default is true.")
                .define("pokestopsBlockCollision", true);
        builder.pop();
    }
}
