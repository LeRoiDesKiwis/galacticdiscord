package fr.leroideskiwis.galacticdiscord.discord.listeners;

import fr.leroideskiwis.galacticdiscord.discord.commands.CommandManager;
import fr.leroideskiwis.galacticdiscord.discord.interactions.Interactions;
import fr.leroideskiwis.galacticdiscord.discord.interactions.MessageInteraction;
import fr.leroideskiwis.galacticdiscord.discord.interactions.Operation;
import fr.leroideskiwis.galacticdiscord.discord.interactions.ReactionInteraction;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class MessageListener extends ListenerAdapter {
    private final JDA jda;
    private Interactions interactions;
    private CommandManager commandManager = new CommandManager();

    public MessageListener(JDA jda, Interactions interactions) {
        this.jda = jda;
        this.interactions = interactions;
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        String message = event.getMessage().getContentDisplay();
        if (message.startsWith(";")) {
            String input = message.substring(1);
            commandManager.execute(event, input);
        }
    }

    @Override
    public void onMessageReactionAdd(MessageReactionAddEvent event) {
        interactions.apply(event);
    }
}
