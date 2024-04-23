package fr.leroideskiwis.galacticdiscord.listeners;

import fr.leroideskiwis.galacticdiscord.interactions.EmoteInteractions;
import fr.leroideskiwis.galacticdiscord.interactions.MessageInteractions;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class InteractionsListener extends ListenerAdapter {
    private final JDA jda;

    public InteractionsListener(JDA jda) {
        this.jda = jda;
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        MessageInteractions.test(event);
    }

    @Override
    public void onMessageReactionAdd(MessageReactionAddEvent event) {
        EmoteInteractions.test(event);
    }
}
