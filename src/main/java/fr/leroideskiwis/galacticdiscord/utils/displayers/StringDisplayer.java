package fr.leroideskiwis.galacticdiscord.utils.displayers;

public class StringDisplayer implements Displayer{

    private StringBuilder stringBuilder = new StringBuilder();

    @Override
    public void display(String message) {
        stringBuilder.append(message).append("\n");
    }

    @Override
    public String toString() {
        return stringBuilder.toString();
    }
}
