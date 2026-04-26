package dev.matthiesen.common.cobblemon_pokestops.commands;

import com.mojang.brigadier.CommandDispatcher;
import dev.matthiesen.common.cobblemon_pokestops.interfaces.ICommand;
import net.minecraft.commands.CommandBuildContext;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;

import java.util.List;

public class CommandRegistry {
    public static final List<ICommand> COMMANDS = List.of(
            new Example()
    );

    public static void init(CommandDispatcher<CommandSourceStack> dispatcher, CommandBuildContext registry, Commands.CommandSelection context) {
        for (ICommand command : COMMANDS) {
            command.register(dispatcher, registry, context);
        }
    }
}
