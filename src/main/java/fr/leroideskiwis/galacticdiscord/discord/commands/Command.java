package fr.leroideskiwis.galacticdiscord.discord.commands;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.util.List;

//Description of our abstract Command class, with a command description, a command argument and an example
public interface Command {

    String description();
    List<CommandArgument> arguments();
    String example();

    /**
     * Check if the user has the permission to execute the command
     * @param event the event
     * @return true if the user has the permission
     */
    boolean hasPermission(MessageReceivedEvent event);

    /**
     * Execute the command
     * @param args list of command argument, without the command name
     * @return true if the command was executed successfully
     */
    boolean execute(MessageReceivedEvent event, String[] args);
}
