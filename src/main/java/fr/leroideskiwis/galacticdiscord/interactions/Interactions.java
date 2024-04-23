package fr.leroideskiwis.galacticdiscord.interactions;

import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.GenericMessageEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Interactions {

    private List<Interaction> interactions = new ArrayList<>();

    public void create(MessageReceivedEvent event, Interaction interaction){
        if(!anyApplicable(event)) this.interactions.add(interaction);
    }

    public boolean anyApplicable(MessageReceivedEvent event){
        return interactions.stream().anyMatch(interaction -> interaction.isApplicable(event));
    }

    public void apply(GenericMessageEvent event){
        interactions.removeIf(interaction -> interaction.isApplicable(event) && interaction.execute(event) == Operation.COMPLETED);
    }

}
