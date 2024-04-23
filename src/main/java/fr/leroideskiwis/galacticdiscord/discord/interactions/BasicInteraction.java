package fr.leroideskiwis.galacticdiscord.discord.interactions;

import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.events.message.GenericMessageEvent;

/**
 * A basic interaction
 */
public abstract class BasicInteraction implements Interaction{

    private TextChannel textChannel;
    protected User user;

    public BasicInteraction(TextChannel textChannel, User user) {
        this.textChannel = textChannel;
        this.user = user;
    }

    @Override
    public abstract Operation execute(GenericMessageEvent event);

    /**
     * Check if the event is applicable (if the channel is the same)
     * @param event The event
     * @return If the event is applicable
     */
    @Override
    public boolean isApplicable(GenericMessageEvent event) {
        return event.getChannel().equals(textChannel);
    }
}
