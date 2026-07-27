package dev.matthiesen.cobblemon_pokestops.common.templates.block;

import dev.matthiesen.matthiesen_core.common.utility.commands.RunSlashCommand;
import net.minecraft.server.level.ServerPlayer;
import org.jetbrains.annotations.NotNull;

public abstract class CommandStopTemplate extends BaseStopTemplate {
    public CommandStopTemplate() {
        super();
    }

    /**
     * Subclasses must provide the reward command
     * <br>
     * Available Placeholders:<br>
     * - %player%
     */
    @NotNull
    protected abstract String getRewardCommand();

    @Override
    protected void grantReward(ServerPlayer player) {
        String command = getRewardCommand().replace("%player%", player.getName().getString());
        RunSlashCommand.asServer(command);
    }
}
