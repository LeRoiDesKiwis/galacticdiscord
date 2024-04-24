package fr.leroideskiwis.galacticdiscord.utils.displayers;

import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;

public class ChannelAccumulatorDisplayer extends ChannelDisplayer{

    private StringBuilder stringBuilder = new StringBuilder();

    public ChannelAccumulatorDisplayer(MessageChannel channel) {
        super(channel);
    }

    @Override
    public void display(String message) {
        stringBuilder.append(message).append("\n");
    }

    public void send(){
        super.display(stringBuilder.toString());
        stringBuilder = new StringBuilder();
    }
}
