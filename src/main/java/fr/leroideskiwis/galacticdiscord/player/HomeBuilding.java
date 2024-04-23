package fr.leroideskiwis.galacticdiscord.player;

import fr.leroideskiwis.galacticdiscord.buildings.Building;
import fr.leroideskiwis.galacticdiscord.utils.Utils;

public abstract class HomeBuilding implements Building {

    @Override
    public boolean canBeBuilt() {
        return true;
    }

    @Override
    public abstract void use(Player player);

    @Override
    public boolean canBeUsed(Player player) {
        return true;
    }

    @Override
    public String toString() {
        return Utils.toFirstLetterLowerCase(getClass().getSimpleName());
    }

    /**
     * Get the string representation of the building with details (toString() + canBeUsed())
     * @param player the player using the building
     * @return the string representation of the building with details
     */
    public String toStringWithDetails(Player player){
        return String.format("%s (usable: %b)", this, canBeUsed(player));
    }
}
