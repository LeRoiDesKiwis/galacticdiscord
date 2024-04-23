package fr.leroideskiwis.galacticdiscord.core;

import fr.leroideskiwis.galacticdiscord.core.Location;

public interface Viewable {

    boolean canBeViewedFrom(Location location, int viewPower);

}
