package fr.leroideskiwis.galacticdiscord.player;

import fr.leroideskiwis.galacticdiscord.Location;
import fr.leroideskiwis.galacticdiscord.WorldEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
     * Get a list of the names of the buildings
     * @return the list of the names of the buildings
     */
    public List<String> getBuildings(boolean details){
        return buildings.stream()
                .map(homeBuilding -> details ? homeBuilding.toStringWithDetails(player) : homeBuilding.toString())
                .collect(Collectors.toList());
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
