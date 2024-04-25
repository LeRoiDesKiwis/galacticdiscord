package fr.leroideskiwis.galacticdiscord.utils.messengers;

import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;

public class ChannelMessenger implements Messenger {

    protected MessageChannel channel;

    public ChannelMessenger(MessageChannel channel){
        this.channel = channel;
    }

    @Override
    public void sendMessage(String message) {
        channel.sendMessage(message).queue();
    }

    public void send(){};
}
