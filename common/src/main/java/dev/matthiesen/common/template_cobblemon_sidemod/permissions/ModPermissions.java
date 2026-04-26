package dev.matthiesen.common.template_cobblemon_sidemod.permissions;

import com.cobblemon.mod.common.Cobblemon;
import com.cobblemon.mod.common.api.permission.PermissionLevel;
import dev.matthiesen.common.template_cobblemon_sidemod.CommonModExample;
import dev.matthiesen.common.template_cobblemon_sidemod.Constants;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.server.level.ServerPlayer;

public class ModPermissions {
    public final ModPermission EXAMPLE_PERMISSION;
    public final ModPermission EXAMPLE_COOL_PERMISSION;

    public ModPermissions() {
        this.EXAMPLE_PERMISSION = new ModPermission(
                Constants.MOD_ID + ".command.example",
                toPermLevel(CommonModExample.config.permissionLevels.COMMAND_EXAMPLE_PERMISSION_LEVEL)
        );
        this.EXAMPLE_COOL_PERMISSION = new ModPermission(
                Constants.MOD_ID + ".command.example-cool",
                toPermLevel(CommonModExample.config.permissionLevels.COMMAND_EXAMPLE_COOL_PERMISSION_LEVEL)
        );
    }

    public PermissionLevel toPermLevel(int permLevel) {
        for (PermissionLevel value : PermissionLevel.values()) {
            if (value.ordinal() == permLevel) {
                return value;
            }
        }
        return PermissionLevel.CHEAT_COMMANDS_AND_COMMAND_BLOCKS;
    }

    public static boolean checkPermission(CommandSourceStack source, ModPermission permission) {
        return Cobblemon.INSTANCE.getPermissionValidator().hasPermission(source, permission);
    }

    public static boolean checkPlayerPermission(ServerPlayer player, ModPermission permission) {
        return Cobblemon.INSTANCE.getPermissionValidator().hasPermission(player, permission);
    }
}