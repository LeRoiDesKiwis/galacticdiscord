package fr.leroideskiwis.galacticdiscord.core;

import java.util.Objects;
import java.util.Random;

/**
 * Represents a location in the world
 */
public class Location {

    private final int x, y;

    public Location(int x, int y){
        this.x = x;
        this.y = y;
    }

    public String toString(){
        return String.format("[%d;%d]", x, y);
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

    /**
     * Create a new location distance away from the current location
     * @param distance the distance from the current location
     * @return the new location
     */
    public Location createAway(int distance) {
        if(distance < 0) throw new IllegalArgumentException("Distance must be positive");
        Random random = new Random();

        double angle = random.nextDouble() * 2 * Math.PI;

        int newX = (int)(x + (distance+1) * Math.cos(angle));
        int newY = (int)(y + (distance+1) * Math.sin(angle));

        return new Location(newX, newY);
    }

    public double distance(Location location) {
        return Math.sqrt(Math.pow(x - location.x, 2) + Math.pow(y - location.y, 2));
    }
}
