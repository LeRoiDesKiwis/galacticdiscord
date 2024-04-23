package fr.leroideskiwis.galacticdiscord.player;

import fr.leroideskiwis.galacticdiscord.Location;

/**
 * Represents the player's home
 */
public class Home {

    private Location location;

    public Home(Location location) {
        this.location = location;
    }

    /**
     * Create a new home 500000 units away from the current home
     * @return the new home
     */
    public Home createNewHomeFromHere(){
        return new Home(location.createAway(500000));
    }

}
