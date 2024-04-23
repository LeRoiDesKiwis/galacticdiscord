package fr.leroideskiwis.galacticdiscord.utils.displayers;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.channel.Channel;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;
import net.dv8tion.jda.api.entities.channel.unions.MessageChannelUnion;

import java.awt.*;

public class EmbedDisplayer extends ChannelDisplayer{

    private EmbedBuilder builder;

    public EmbedDisplayer(MessageChannel channel, String title, Color color) {
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
