package fr.leroideskiwis.galacticdiscord.interactions;

import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class MessageInteractions {

    private static Map<TextChannel, MessageInteraction> messageInteractions = new HashMap<>();

    public static void create(TextChannel textChannel, User user, Function<MessageReceivedEvent, Operation> function){
        messageInteractions.put(textChannel, new MessageInteraction(user, function));
    }

    public static void test(MessageReceivedEvent messageReceivedEvent){
        TextChannel textChannel = messageReceivedEvent.getTextChannel();
        if(!messageInteractions.containsKey(textChannel)) return;
        MessageInteraction messageInteraction = messageInteractions.get(textChannel);
        if(messageInteraction.user.getIdLong() != messageReceivedEvent.getAuthor().getIdLong()) return;
        if(messageInteraction.function.apply(messageReceivedEvent) != Operation.COMPLETED) return;
        messageInteractions.remove(textChannel, messageInteraction);
    }

    private static class MessageInteraction {
        private User user;
        private Function<MessageReceivedEvent, Operation> function;

        public MessageInteraction(User user, Function<MessageReceivedEvent, Operation> function) {
            this.user = user;
            this.function = function;
        }
    }
}