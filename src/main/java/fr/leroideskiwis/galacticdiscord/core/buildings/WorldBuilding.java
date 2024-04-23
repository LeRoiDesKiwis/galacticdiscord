package fr.leroideskiwis.galacticdiscord.core.buildings;

import fr.leroideskiwis.galacticdiscord.core.Location;
import fr.leroideskiwis.galacticdiscord.core.WorldEntity;
import fr.leroideskiwis.galacticdiscord.core.player.Player;

public abstract class WorldBuilding extends WorldEntity implements Building{
    public WorldBuilding(Location location) {
        super(location);
    }

    @Override
    public boolean canBeBuilt() {
        return true;
    }

    @Override
    public abstract void use(Player player);

    @Override
    public boolean canBeUsed(Player player) {
        return false;
    }
}
