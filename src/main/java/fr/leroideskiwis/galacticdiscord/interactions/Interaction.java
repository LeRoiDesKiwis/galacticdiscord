package fr.leroideskiwis.galacticdiscord.interactions;

import net.dv8tion.jda.api.events.Event;
import net.dv8tion.jda.api.events.message.GenericMessageEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public interface Interaction {

    /**
     * Execute the interaction
     * @param event The event
     * @return COMPLETED if the interaction is completed and need to be removed
     */
    Operation execute(GenericMessageEvent event);

    /**
     * Check if the event is applicable
     * @param event The event
     * @return If the event is applicable
     */
    boolean isApplicable(GenericMessageEvent event);

}
