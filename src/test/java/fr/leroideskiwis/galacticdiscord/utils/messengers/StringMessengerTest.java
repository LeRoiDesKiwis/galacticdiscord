package fr.leroideskiwis.galacticdiscord.utils.messengers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringMessengerTest {

    @Test
    void display() {
        StringMessenger stringMessager = new StringMessenger();
        stringMessager.sendMessage("Hello");
        assertEquals("Hello\n", stringMessager.toString());
        stringMessager.sendMessage("World");
        assertEquals("Hello\nWorld\n", stringMessager.toString());
    }
}