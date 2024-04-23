package fr.leroideskiwis.galacticdiscord.player;

import fr.leroideskiwis.galacticdiscord.Location;

public class Home {

    private Location location;

    public Home(Location location) {
        this.location = location;
    }

    public Home createNewHomeFromHere(){
        return new Home(location.createAway(500000));
    }

}
