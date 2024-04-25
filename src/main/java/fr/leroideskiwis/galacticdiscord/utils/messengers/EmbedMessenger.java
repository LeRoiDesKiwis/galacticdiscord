package fr.leroideskiwis.galacticdiscord.utils.messengers;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;

import java.awt.*;

public class EmbedMessenger extends ChannelMessenger {

    private EmbedBuilder builder;

    public EmbedMessenger(MessageChannel channel, String title, Color color) {
        super(channel);
        this.builder = new EmbedBuilder().setTitle(title).setColor(color);
    }

    public void show(String message){
        builder.setDescription(builder.getDescriptionBuilder().append(message).append("\n"));
    }

    public void send(){
        channel.sendMessageEmbeds(builder.build()).queue();
    }
}
