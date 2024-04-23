package fr.leroideskiwis.galacticdiscord.interactions;

import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.events.message.GenericMessageEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.util.function.Function;

public abstract class MessageInteraction extends BasicInteraction{

    public MessageInteraction(TextChannel textChannel, User user) {
        super(textChannel, user);
    }

    @Override
    public abstract Operation execute(GenericMessageEvent event);

    @Override
    public boolean isApplicable(GenericMessageEvent event) {
        if(event instanceof MessageReceivedEvent event1){
            return super.isApplicable(event) && event1.getAuthor().equals(super.user);
        }
        return false;
    }

    public static class MessageInteractionBuilder{
        private TextChannel textChannel;
        private User user;
        private Function<MessageReceivedEvent, Operation> function;

        public MessageInteractionBuilder textChannel(TextChannel textChannel){
            this.textChannel = textChannel;
            return this;
        }

        public MessageInteractionBuilder user(User user){
            this.user = user;
            return this;
        }

        public MessageInteractionBuilder function(Function<MessageReceivedEvent, Operation> function){
            this.function = function;
            return this;
        }

        public MessageInteraction build(){
            return new MessageInteraction(textChannel, user) {
                @Override
                public Operation execute(GenericMessageEvent event) {
                    return function.apply((MessageReceivedEvent)event);
                }
            };
        }
    }
}
