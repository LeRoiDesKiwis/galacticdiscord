package fr.leroideskiwis.galacticdiscord;

import fr.leroideskiwis.galacticdiscord.player.Home;
import fr.leroideskiwis.galacticdiscord.player.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class World {

    private final List<WorldEntity> entities = new ArrayList<>();

    public void createHome(Player player){
        entities.add(new Home(new Location(0, 0), player));
    }

    public void createHomeFrom(Player player){
        entities.add(player.createHomeFrom(player));
    }

    /**
     * Get entities around a location in a radius
     * @param location the location
     * @param radius the radius
     * @return the entities around the location
     */
    public List<WorldEntity> viewAround(Location location, int radius){
        return entities.stream()
                .filter(viewable -> viewable.canBeViewedFrom(location, radius))
                .collect(Collectors.toList());
    }

}
