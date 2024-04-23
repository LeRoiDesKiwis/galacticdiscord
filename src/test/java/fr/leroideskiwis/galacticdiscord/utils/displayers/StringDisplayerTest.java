package fr.leroideskiwis.galacticdiscord.utils.displayers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringDisplayerTest {

    @Test
    void display() {
        StringDisplayer stringDisplayer = new StringDisplayer();
        stringDisplayer.display("Hello");
        assertEquals("Hello\n", stringDisplayer.toString());
        stringDisplayer.display("World");
        assertEquals("Hello\nWorld\n", stringDisplayer.toString());
    }
}