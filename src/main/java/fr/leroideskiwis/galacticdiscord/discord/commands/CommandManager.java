package fr.leroideskiwis.galacticdiscord.discord.commands;

import fr.leroideskiwis.galacticdiscord.utils.displayers.ChannelDisplayer;
import fr.leroideskiwis.galacticdiscord.utils.displayers.Displayer;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
//Definition of our CommandManager class
public class CommandManager {

    private final Map<String, Command> commands = new HashMap<>();
    //Initialize CommandManager with all of our commands
    public CommandManager(){
    }

    public Stream<Map.Entry<String, Command>> stream(){
        return commands.entrySet().stream();
    }

    /**
     * Execute a command
     * @param event the event
     * @param input the command input
     * @return true if the command was executed successfully
     */
    public boolean execute(MessageReceivedEvent event, String input){
        Displayer displayer = new ChannelDisplayer(event.getChannel());
        if(input.isBlank()) return false;
        String[] split = input.split(" ");
        String commandName = split[0].toLowerCase();
        List<String> possibleCommands = getCommand(commandName);
        switch (possibleCommands.size()) {
            case 0 -> {
                displayer.display(String.format("Command %s not found !\n", commandName));
                return false;
            }
            case 1 -> {
                Command command = commands.get(possibleCommands.getFirst());
                String[] args = new String[split.length - 1];
                System.arraycopy(split, 1, args, 0, args.length);
                return command.execute(event, args);
            }
            default -> {
                System.out.println("Commands starting with \"" + commandName + "\":");
                StringBuilder stringBuilder = new StringBuilder();
                possibleCommands.forEach(string -> stringBuilder.append("- ").append(string).append("\n"));
                displayer.display(stringBuilder.toString());
                return true;
            }
        }
    }

    /**
     * return a list of commands starting with a name
     * @param name the name
     * @return the list of commands
     */
    public List<String> getCommand(String name){
        return commands.keySet().stream().filter(command -> command.startsWith(name)).collect(Collectors.toList());
    }

}