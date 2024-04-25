package fr.leroideskiwis.galacticdiscord.utils.messengers;

import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;

public class ChannelAccumulatorMessenger extends ChannelMessenger {

    private StringBuilder stringBuilder = new StringBuilder();

    public ChannelAccumulatorMessenger(MessageChannel channel) {
        super(channel);
    }

    /**
     * Add the message to a stringBuilder, which can then be sent in the channel using {@link ChannelAccumulatorMessenger#send()}
     * @param message the message to append
     */
    @Override
    public void sendMessage(String message) {
        stringBuilder.append(message).append("\n");
    }

    /**
     * Send all the message that were appended with {@link ChannelAccumulatorMessenger#sendMessage(String)}
     */
    public void send(){
        super.sendMessage(stringBuilder.toString());
        stringBuilder = new StringBuilder();
    }
}
