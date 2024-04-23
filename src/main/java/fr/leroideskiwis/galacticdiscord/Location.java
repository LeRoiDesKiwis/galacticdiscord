package fr.leroideskiwis.galacticdiscord;

import fr.leroideskiwis.galacticdiscord.player.Home;

import java.util.Objects;
import java.util.Random;

public class Location {

    private final int x, y;

    public Location(int x, int y){
        this.x = x;
        this.y = y;
    }

    public String toString(){
        return String.format("%d;%d", x, y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return x == location.x && y == location.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    public Location createAway(int distance) {
        Random random = new Random();

        double angle = random.nextDouble() * 2 * Math.PI;

        int newX = (int)(x + distance * Math.cos(angle));
        int newY = (int)(y + distance * Math.sin(angle));

        return new Location(newX, newY);
    }
}
