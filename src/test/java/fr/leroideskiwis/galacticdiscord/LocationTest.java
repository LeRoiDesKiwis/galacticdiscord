package fr.leroideskiwis.galacticdiscord;

import fr.leroideskiwis.galacticdiscord.core.Location;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LocationTest {

    @Test
    void testToString() {
        Location location = new Location(1, 2);
        assertEquals("[1;2]", location.toString());
    }

    @Test
    void testEquals() {
        Location location1 = new Location(1, 2);
        Location location2 = new Location(1, 2);
        Location location3 = new Location(2, 1);
        assertEquals(location1, location2);
        assertNotEquals(location1, location3);
    }

    @Test
    void distance(){
        Location location = new Location(1, 0);
        Location location2 = new Location(0, 0);
        Location location3 = new Location(0, 2);

        assertEquals(1, location.distance(location2));
        assertEquals(2, location2.distance(location3));
        assertEquals(2, location3.distance(location2));
        assertEquals(Math.sqrt(5), location.distance(location3));
    }

    @Test
    void createAway() {
        Location location = new Location(0, 0);
        assertEquals(location, location.createAway(0));
        assertThrows(IllegalArgumentException.class, () -> location.createAway(-1));

        Location away = location.createAway(5000);
        assertNotEquals(location, away);
        assertNotEquals(away, location.createAway(5000));
        assertTrue(away.distance(location) >= 5000);
    }
}