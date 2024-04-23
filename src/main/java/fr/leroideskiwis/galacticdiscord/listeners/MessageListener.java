package fr.leroideskiwis.galacticdiscord.listeners;

import fr.leroideskiwis.galacticdiscord.interactions.Interactions;
import fr.leroideskiwis.galacticdiscord.interactions.MessageInteraction;
import fr.leroideskiwis.galacticdiscord.interactions.Operation;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
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
        if(message.equals("test1")){
            interactions.create(event, MessageInteraction.createInteraction(event.getChannel().asTextChannel(), event.getAuthor(), event1 -> {
                event1.getChannel().sendMessage("Tu as envoyé "+event1.getMessage().getContentDisplay()+" !").queue();
                if(Math.random() > 0.8){
                    event1.getChannel().sendMessage("C'est finit !").queue();
                    return Operation.COMPLETED;
                }
                return Operation.IGNORED;
            }));
        } else interactions.apply(event);
    }
}
