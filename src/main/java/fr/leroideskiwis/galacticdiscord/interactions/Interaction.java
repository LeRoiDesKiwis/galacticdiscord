package fr.leroideskiwis.galacticdiscord.interactions;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public interface Interaction {

    Operation execute(MessageReceivedEvent event);
    boolean isApplicable(MessageReceivedEvent event);

}
