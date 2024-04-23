package fr.leroideskiwis.galacticdiscord.core;

import fr.leroideskiwis.galacticdiscord.core.player.Home;
import fr.leroideskiwis.galacticdiscord.core.player.Player;

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
    public List<WorldEntity> getAround(Location location, int radius){
        return entities.stream()
                .filter(viewable -> viewable.canBeViewedFrom(location, radius))
                .collect(Collectors.toList());
    }

    public void viewAround(Displayer displayer, Location location, int radius){
        getAround(location, radius).forEach(entity -> displayer.display(entity.toString()));
    }

}
