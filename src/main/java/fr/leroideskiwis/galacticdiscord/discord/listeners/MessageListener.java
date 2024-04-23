package fr.leroideskiwis.galacticdiscord.discord.listeners;

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

    public MessageListener(JDA jda, Interactions interactions) {
        this.jda = jda;
        this.interactions = interactions;
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        String message = event.getMessage().getContentDisplay();
        if (message.equals("test1")) {
            interactions.create(event, new MessageInteraction.MessageInteractionBuilder()
                    .user(event.getAuthor())
                    .textChannel(event.getChannel().asTextChannel())
                    .function(event1 -> {
                        event1.getChannel().sendMessage("Tu as envoyé " + event1.getMessage().getContentDisplay() + " !").queue();
                        if (Math.random() > 0.8){
                            event1.getChannel().sendMessage("C'est finit !").queue();
                            return Operation.COMPLETED;
                        }
                        return Operation.IGNORED;
                    })
                    .build());
        }  else if(message.equals("test2")){
            interactions.create(event, new ReactionInteraction.ReactionInteractionBuilder()
                    .user(event.getAuthor())
                    .textChannel(event.getChannel().asTextChannel())
                    .addEmote("✅").addEmote("❌")
                    .function(event1 -> {
                        event1.getChannel().sendMessage("Tu as réagit avec "+event1.getEmoji()).queue();
                        if(Math.random() > 0.8){
                            event1.getChannel().sendMessage("C'est finit !").queue();
                            return Operation.COMPLETED;
                        }
                        return Operation.IGNORED;
                    })
                    .build(event.getMessage()));
        } else interactions.apply(event);
    }

    @Override
    public void onMessageReactionAdd(MessageReactionAddEvent event) {
        interactions.apply(event);
    }
}
