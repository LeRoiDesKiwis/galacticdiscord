package fr.leroideskiwis.galacticdiscord.discord.commands;

import fr.leroideskiwis.galacticdiscord.utils.displayers.ChannelAccumulatorDisplayer;
import fr.leroideskiwis.galacticdiscord.utils.displayers.ChannelDisplayer;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HelpCommand extends Command {

    private CommandManager commandManager;

    public HelpCommand(CommandManager commandManager) {
        super("Display the help message", "help", new CommandArgument("command", CommandArgument.ArgumentType.OPTIONAL));
        this.commandManager = commandManager;
    }

    private String formatExample(Command command) {
        if(command.example.isBlank()) return "";
        return "\t- EXAMPLE: "+command.example;
    }
    //Print command name and arguments
    private String formatUsage(String commandName, Command command){
        if(command.arguments.length == 0) return "";
        StringBuilder stringBuilder = new StringBuilder();
        for (CommandArgument argument : command.arguments) {
            stringBuilder.append(argument).append(" ");
        }
        stringBuilder.deleteCharAt(stringBuilder.length()-1);
        return "\t- USAGE: " + commandName + " " + stringBuilder;
    }

    private String strikeIfNoPermission(Command command, MessageReceivedEvent event, String string){
        return command.hasPermission(event) ? string : "~~"+string+"~~ (permission denied)";
    }

    //Print description of CommandHelp
    private String formatCommand(MessageReceivedEvent event, String commandName, Command command){
        StringBuilder builder = new StringBuilder();
        builder.append("- ").append(commandName).append(": ").append(command.description).append("\n");
        builder.append(formatUsage(commandName, command)).append("\n");
        builder.append(formatExample(command)).append("\n");
        return strikeIfNoPermission(command, event, builder.toString());
    }

    @Override
    public boolean execute(MessageReceivedEvent event, String[] args) {
        List<Map.Entry<String, Command>> commands = args.length == 0
                ? commandManager.stream().toList()
                : commandManager.getCommands(args[0]);

        ChannelDisplayer displayer = new ChannelAccumulatorDisplayer(event.getChannel());
        if(commands.isEmpty()) displayer.display("Command not found !");
        commands.forEach(entry -> displayer.display(formatCommand(event, entry.getKey(), entry.getValue())));
        displayer.send();
        return true;
    }
}