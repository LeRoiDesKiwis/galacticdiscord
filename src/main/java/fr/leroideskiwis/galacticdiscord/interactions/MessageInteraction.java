package fr.leroideskiwis.galacticdiscord.interactions;

import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.entities.channel.ChannelType;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.events.message.GenericMessageEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.util.function.Function;

public abstract class MessageInteraction implements Interaction{

    private TextChannel textChannel;
    private User user;

    public static MessageInteraction createInteraction(TextChannel textChannel, User user, Function<MessageReceivedEvent, Operation> function){
        return new MessageInteraction(textChannel, user) {
            @Override
            public Operation execute(MessageReceivedEvent event) {
                return function.apply(event);
            }
        };
    }

    public MessageInteraction(TextChannel textChannel, User user) {
        this.textChannel = textChannel;
        this.user = user;
    }

    @Override
    public abstract Operation execute(MessageReceivedEvent event);

    @Override
    public boolean isApplicable(GenericMessageEvent event) {
        if(event instanceof MessageReceivedEvent event1){
            return super.isApplicable(event) && event1.getAuthor().equals(super.user);
        }
        return false;
    }
}
