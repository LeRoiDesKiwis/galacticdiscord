package fr.leroideskiwis.galacticdiscord.discord.commands;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

//Description of our abstract Command class, with a command description, a command argument and an example
public abstract class Command {
    protected final String description;
    protected final CommandArgument[] arguments;
    protected String example;
    //Command constructor with example and arguments
    public Command(String description, String example, CommandArgument... arguments) {
        this.description = description;
        this.arguments = arguments;
        this.example = example;
    }
    //Command constructor with arguments
    public Command(String description, CommandArgument... arguments){
        this(description, "", arguments);
    }
    //Command constructor with only description
    public Command(String description){
        this(description, "");
    }

    /**
     * Execute the command
     * @param args list of command argument, without the command name
     * @return true if the command was executed successfully
     */
    public abstract boolean execute(MessageReceivedEvent event, String[] args);
}
