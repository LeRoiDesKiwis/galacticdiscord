package fr.leroideskiwis.galacticdiscord.interactions;

import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.guild.react.GuildMessageReactionAddEvent;
import net.dv8tion.jda.internal.utils.PermissionUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class EmoteInteractions {

    private static Map<Long, EmoteInteraction> emoteInteractions = new HashMap<>();

    public static void create(Message message, String[] emotes, User user, Function<GuildMessageReactionAddEvent, Operation> function){
        for (String emote : emotes) {
            message.addReaction(emote).queue();
        }
        emoteInteractions.put(message.getIdLong(), new EmoteInteraction(user, message, function));
    }

    public static void test(GuildMessageReactionAddEvent event){
        long messageId = event.getMessageIdLong();
        if(!emoteInteractions.containsKey(messageId)) return;
        EmoteInteraction emoteInteraction = emoteInteractions.get(messageId);
        if(!emoteInteraction.user.equals(event.getUser())) return;
        if(PermissionUtil.checkPermission(event.getGuild().getSelfMember(), Permission.MESSAGE_MANAGE)) emoteInteraction.message.removeReaction(event.getReactionEmote().getEmote(), emoteInteraction.user).queue();
        emoteInteraction.message.removeReaction(event.getReactionEmote().getEmote(), event.getUser()).queue();
        if(emoteInteractions.get(messageId).consumer.apply(event) != Operation.COMPLETED) return;
        emoteInteractions.remove(messageId, emoteInteraction);
    }

    static class EmoteInteraction{
        private final User user;
        private final Message message;
        private final Function<GuildMessageReactionAddEvent, Operation> consumer;

        public EmoteInteraction(User user, Message message, Function<GuildMessageReactionAddEvent, Operation> function) {
            this.user = user;
            this.message = message;
            this.consumer = function;
        }
    }

}
