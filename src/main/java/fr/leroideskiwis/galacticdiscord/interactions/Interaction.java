package fr.leroideskiwis.galacticdiscord.interactions;

import net.dv8tion.jda.api.events.Event;
import net.dv8tion.jda.api.events.message.GenericMessageEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public interface Interaction {

    Operation execute(GenericMessageEvent event);
    boolean isApplicable(GenericMessageEvent event);

}
