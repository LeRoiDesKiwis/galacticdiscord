package fr.leroideskiwis.galacticdiscord.interactions;

import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.GenericMessageEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Interactions {

    private List<Interaction> interactions = new ArrayList<>();

    /**
     * Create a new interaction
     * @param event The event
     * @param interaction The interaction
     */
    public void create(GenericMessageEvent event, Interaction interaction){
        if(!anyApplicable(event)) this.interactions.add(interaction);
    }

    /**
     * Check if any interaction is applicable for the event
     * @param event The event
     * @return If any interaction is applicable
     */
    public boolean anyApplicable(GenericMessageEvent event){
        return interactions.stream().anyMatch(interaction -> interaction.isApplicable(event));
    }

    /**
     * Apply the interaction for the event if applicable, and remove it if completed
     * @param event The event
     */
    public void apply(GenericMessageEvent event){
        interactions.removeIf(interaction -> interaction.isApplicable(event) && interaction.execute(event) == Operation.COMPLETED);
    }

}
