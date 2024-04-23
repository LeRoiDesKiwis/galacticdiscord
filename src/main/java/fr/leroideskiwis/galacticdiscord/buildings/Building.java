package fr.leroideskiwis.galacticdiscord.buildings;

import fr.leroideskiwis.galacticdiscord.player.Player;

/**
 * Represents a building
 */
public interface Building {

    /**
     * Check if the building can be built
     * @return true if the building can be built
     */
    boolean canBeBuilt();

    /**
     * Use the building
     * @param player the player using the building
     */
    void use(Player player);

    /**
     * Check if the building can be used
     * @param player the player using the building
     * @return true if the building can be used by the player
     */
    boolean canBeUsed(Player player);
}
