package fr.leroideskiwis.galacticdiscord.utils.messengers;

public class SysoutMessenger implements Messenger {

    @Override
    public void sendMessage(String message) {
        System.out.println(message);
    }
}
