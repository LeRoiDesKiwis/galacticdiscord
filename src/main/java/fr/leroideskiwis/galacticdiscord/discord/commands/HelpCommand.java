package fr.leroideskiwis.galacticdiscord.discord.commands;

import fr.leroideskiwis.galacticdiscord.utils.messengers.ChannelAccumulatorMessenger;
import fr.leroideskiwis.galacticdiscord.utils.messengers.ChannelMessenger;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.util.List;
import java.util.Map;

public class HelpCommand implements Command {

    private CommandManager commandManager;

    public HelpCommand(CommandManager commandManager) {
        this.commandManager = commandManager;
    }

    @Override
    public String description() {
        return "Display the help message";
    }

    @Override
    public List<CommandArgument> arguments() {
        return List.of(new CommandArgument("command", CommandArgument.ArgumentType.OPTIONAL));
    }

    @Override
    public String example() {
        return "";
    }

    @Override
    public boolean hasPermission(MessageReceivedEvent event) {
        return true;
    }

    private String formatExample(Command command) {
        if(command.example().isBlank()) return "";
        return "\t- EXAMPLE: "+command.example()+"\n";
    }
    //Print command name and arguments
    private String formatUsage(String commandName, Command command){
        if(command.arguments().isEmpty()) return "";
        StringBuilder stringBuilder = new StringBuilder();
        for (CommandArgument argument : command.arguments()) {
            stringBuilder.append(argument).append(" ");
        }
        stringBuilder.deleteCharAt(stringBuilder.length()-1);
        return "\t- USAGE: " + commandName + " " + stringBuilder.append("\n");
    }

    private String strikeIfNoPermission(Command command, MessageReceivedEvent event, String string){
        return command.hasPermission(event) ? string : "~~"+string+"~~ (permission denied)";
    }

    //Print description of CommandHelp
    private String formatCommand(MessageReceivedEvent event, String commandName, Command command){
        StringBuilder builder = new StringBuilder();
        builder.append("- ").append(commandName).append(": ").append(command.description()).append("\n");
        builder.append(formatUsage(commandName, command));
        builder.append(formatExample(command));
        return strikeIfNoPermission(command, event, builder.toString());
    }

    @Override
    public boolean execute(MessageReceivedEvent event, String[] args) {
        List<Map.Entry<String, Command>> commands = args.length == 0
                ? commandManager.stream().toList()
                : commandManager.getCommands(args[0]);

        ChannelMessenger messenger = new ChannelAccumulatorMessenger(event.getChannel());
        if(commands.isEmpty()) messenger.sendMessage("Command not found !");
        else {
            StringBuilder builder = new StringBuilder("NOTE: in usage, ");
            for (CommandArgument.ArgumentType argumentType : CommandArgument.ArgumentType.values()) {
                builder.append(argumentType.start).append(argumentType.end).append(" = ").append(argumentType.toString().toLowerCase()).append(", ");
            }
            messenger.sendMessage(builder.append("\n").toString());
        }

        commands.forEach(entry -> messenger.sendMessage(formatCommand(event, entry.getKey(), entry.getValue())));
        messenger.send();
        return !commands.isEmpty();
    }

}
