package fr.leroideskiwis.galacticdiscord.listeners;

import fr.leroideskiwis.galacticdiscord.interactions.EmoteInteractions;
import fr.leroideskiwis.galacticdiscord.interactions.MessageInteractions;
import fr.leroideskiwis.galacticdiscord.interactions.Operation;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Emote;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;

public class TestListener extends ListenerAdapter {
    private final JDA jda;

    public TestListener(JDA jda) {
        this.jda = jda;
    }

    @Override
    public void onMessageReceived(@Nonnull MessageReceivedEvent event) {
        String message = event.getMessage().getContentDisplay();
        if(message.equals("test1")){
            MessageInteractions.create(event.getTextChannel(), event.getAuthor(), event1 -> {
                event1.getTextChannel().sendMessage("Tu as envoyé "+event1.getMessage().getContentDisplay()+" !").queue();
                if(Math.random() > 0.8){
                    event1.getTextChannel().sendMessage("C'est finit !").queue();
                    return Operation.COMPLETED;
                }
                return Operation.IGNORED;
            });
        }
        else if(message.equals("test2")){
            EmoteInteractions.create(event.getMessage(), new String[]{"✅", "❌"},event.getAuthor(), event1 -> {
                event1.getChannel().sendMessage("Tu as réagit avec "+event1.getReactionEmote().getEmoji()).queue();
                if(Math.random() > 0.8){
                    event1.getChannel().sendMessage("C'est finit !").queue();
                    return Operation.COMPLETED;
                }
                return Operation.IGNORED;
            });
        }
    }
}
