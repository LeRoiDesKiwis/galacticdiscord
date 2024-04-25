package fr.leroideskiwis.galacticdiscord.utils.messengers;

public class StringMessenger implements Messenger {

    private StringBuilder stringBuilder = new StringBuilder();

    @Override
    public void sendMessage(String message) {
        stringBuilder.append(message).append("\n");
    }

    @Override
    public String toString() {
        return stringBuilder.toString();
    }
}
