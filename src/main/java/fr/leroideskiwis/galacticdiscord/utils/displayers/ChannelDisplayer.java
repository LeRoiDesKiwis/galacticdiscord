package fr.leroideskiwis.galacticdiscord.utils.displayers;

import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;

public class ChannelDisplayer implements Displayer{

    protected MessageChannel channel;

    public ChannelDisplayer(MessageChannel channel){
        this.channel = channel;
    }

    @Override
    public void display(String message) {
        channel.sendMessage(message).queue();
    }

    public void send(){};
}
