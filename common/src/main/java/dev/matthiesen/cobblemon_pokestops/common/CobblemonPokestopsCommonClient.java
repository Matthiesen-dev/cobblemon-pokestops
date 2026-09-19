package dev.matthiesen.cobblemon_pokestops.common;

import dev.matthiesen.cobblemon_pokestops.common.client.ClientRendererRegistration;
import dev.matthiesen.cobblemon_pokestops.common.config.PokestopsConfig;
import dev.matthiesen.matthiesen_core.common.AbstractCommonClientMod;
import dev.matthiesen.matthiesen_core.common.api.platform.loader.ModConfigType;

public final class CobblemonPokestopsCommonClient extends AbstractCommonClientMod {
    public static final CobblemonPokestopsCommonClient INSTANCE = new CobblemonPokestopsCommonClient();

    public CobblemonPokestopsCommonClient() {
        super(CobblemonPokestopsCommon.INSTANCE);
    }

    @Override
    public void initialize() {
        registerModConfig(CobblemonPokestopsCommon.MOD_ID, ModConfigType.CLIENT, PokestopsConfig.CLIENT_SPEC, CobblemonPokestopsCommon.modConfig("client"));
    }

    public void initializeRenderers() {
        ClientRendererRegistration.initializeRenderers();
    }
}
