package fr.leroideskiwis.galacticdiscord.listeners;

import fr.leroideskiwis.galacticdiscord.interactions.EmoteInteractions;
import fr.leroideskiwis.galacticdiscord.interactions.MessageInteractions;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.message.guild.react.GuildMessageReactionAddEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;

public class InteractionsListener extends ListenerAdapter {
    private final JDA jda;

    public InteractionsListener(JDA jda) {
        this.jda = jda;
    }

    @Override
    public void onMessageReceived(@Nonnull MessageReceivedEvent event) {
        MessageInteractions.test(event);
    }

    @Override
    public void onGuildMessageReactionAdd(@Nonnull GuildMessageReactionAddEvent event) {
        EmoteInteractions.test(event);
    }
}
