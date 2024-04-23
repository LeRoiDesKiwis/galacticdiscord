package fr.leroideskiwis.galacticdiscord;

public abstract class WorldEntity implements Viewable {

    protected Location location;

    public WorldEntity(Location location){
        this.location = location;
    }

    /**
     * Check if the entity can be viewed from a location
     * @param location the location
     * @param viewPower the view power, and not the radius because depending on the entity, the power can be handled differently
     * @return true if the entity can be viewed from the location
     */
    @Override
    public boolean canBeViewedFrom(Location location, int viewPower) {
        return location.distance(this.location) <= viewPower;
    }
}