package fr.leroideskiwis.galacticdiscord.utils.displayers;

public class SysoutDisplayer implements Displayer{

    @Override
    public void display(String message) {
        System.out.println(message);
    }
}
