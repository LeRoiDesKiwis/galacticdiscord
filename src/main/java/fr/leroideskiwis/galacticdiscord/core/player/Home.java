package fr.leroideskiwis.galacticdiscord.core.player;

import fr.leroideskiwis.galacticdiscord.utils.messengers.Messenger;
import fr.leroideskiwis.galacticdiscord.core.Location;
import fr.leroideskiwis.galacticdiscord.core.WorldEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents the player's home
 */
public class Home extends WorldEntity {

    private final List<HomeBuilding> buildings = new ArrayList<>();
    private final Player player;

    public Home(Location location, Player player) {
        super(location);
        this.player = player;
    }

    /**
     * Build a new building. Do nothing if the building can't be built
     * @param building the building to build
     */
    public void build(HomeBuilding building){
        if(building.canBeBuilt()) buildings.add(building);
    }

    /**
     * Show the buildings
     * @param messenger the messenger
     */
    public void showBuildings(Messenger messenger){
        buildings.forEach(building -> messenger.sendMessage(building.toString()));
    }

    /**
     * Create a new home 500000 units away from the current home
     * @param player the player of the new home
     * @return the new home
     */
    public Home createNewHomeFromHere(Player player){
        return new Home(location.createAway(500000), player);
    }

}
