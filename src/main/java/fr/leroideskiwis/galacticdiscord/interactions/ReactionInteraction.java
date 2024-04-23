package fr.leroideskiwis.galacticdiscord.interactions;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.entities.emoji.Emoji;
import net.dv8tion.jda.api.events.message.GenericMessageEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public abstract class ReactionInteraction extends BasicInteraction{

    private final List<String> emotes;

    public ReactionInteraction(TextChannel textChannel, User user, List<String> emotes) {
        super(textChannel, user);
        this.emotes = emotes;
    }

    /**
     * Add the emotes to the message
     * @param message The message
     */
    public void applyEmotes(Message message){
        emotes.forEach(emote -> message.addReaction(Emoji.fromFormatted(emote)).queue());
    }

    @Override
    public boolean isApplicable(GenericMessageEvent event) {
        if(event instanceof MessageReactionAddEvent event1){
            return super.isApplicable(event) && event1.getUser().equals(super.user) && emotes.contains(event1.getReaction().getEmoji().getFormatted());
        }
        return false;
    }

    public static class ReactionInteractionBuilder{
        private TextChannel textChannel;
        private User user;
        private Function<MessageReactionAddEvent, Operation> function;
        private List<String> emotes = new ArrayList<>();

        public ReactionInteractionBuilder textChannel(TextChannel textChannel){
            this.textChannel = textChannel;
            return this;
        }

        public ReactionInteractionBuilder user(User user){
            this.user = user;
            return this;
        }

        public ReactionInteractionBuilder addEmote(String emote){
            this.emotes.add(emote);
            return this;
        }

        public ReactionInteractionBuilder function(Function<MessageReactionAddEvent, Operation> function){
            this.function = function;
            return this;
        }

        public ReactionInteraction build(Message message){
            ReactionInteraction reactionInteraction = new ReactionInteraction(textChannel, user, emotes) {
                @Override
                public Operation execute(GenericMessageEvent event) {
                    return function.apply((MessageReactionAddEvent) event);
                }
            };
            reactionInteraction.applyEmotes(message);
            return reactionInteraction;
        }
    }
}
