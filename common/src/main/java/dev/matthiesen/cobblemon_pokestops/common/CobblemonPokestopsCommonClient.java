package dev.matthiesen.cobblemon_pokestops.common;

import dev.matthiesen.cobblemon_pokestops.common.client.ClientRendererRegistration;
import dev.matthiesen.common.matthiesen_lib.abstracts.AbstractCommonClientMod;

public final class CobblemonPokestopsCommonClient extends AbstractCommonClientMod {
    public static final CobblemonPokestopsCommonClient INSTANCE = new CobblemonPokestopsCommonClient();

    public CobblemonPokestopsCommonClient() {
        super(CobblemonPokestopsCommon.INSTANCE);
    }

    @Override
    public void initialize() {
        ClientRendererRegistration.initializeRenderers();
    }
}
