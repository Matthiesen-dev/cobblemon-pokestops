package dev.matthiesen.cobblemon_pokestops.common.config;

import net.neoforged.neoforge.common.ModConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

public final class PokestopsConfig {
    public static final CommonConfig COMMON_CONFIG;
    public static final ModConfigSpec COMMON_SPEC;

    public static final ClientConfig CLIENT_CONFIG;
    public static final ModConfigSpec CLIENT_SPEC;

    static {
        Pair<CommonConfig, ModConfigSpec> serverPair = new ModConfigSpec.Builder().configure(CommonConfig::new);
        COMMON_CONFIG = serverPair.getLeft();
        COMMON_SPEC = serverPair.getRight();

        Pair<ClientConfig, ModConfigSpec> clientPair = new ModConfigSpec.Builder().configure(ClientConfig::new);
        CLIENT_CONFIG = clientPair.getLeft();
        CLIENT_SPEC = clientPair.getRight();
    }
}
