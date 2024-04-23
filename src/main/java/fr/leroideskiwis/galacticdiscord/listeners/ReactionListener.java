package fr.leroideskiwis.galacticdiscord.listeners;

import fr.leroideskiwis.galacticdiscord.interactions.Operation;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class ReactionListener extends ListenerAdapter {

    @Override
    public void onMessageReactionAdd(MessageReactionAddEvent event) {
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        /*if(message.equals("test2")){
            EmoteInteractions.create(event.getMessage(), new String[]{"✅", "❌"},event.getAuthor(), event1 -> {
                event1.getChannel().sendMessage("Tu as réagit avec "+event1.getEmoji()).queue();
                if(Math.random() > 0.8){
                    event1.getChannel().sendMessage("C'est finit !").queue();
                    return Operation.COMPLETED;
                }
                return Operation.IGNORED;
            });
        }*/
    }
}
