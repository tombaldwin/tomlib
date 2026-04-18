package io.poly.tomlib.logo.theme.easter.mascot;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/// Tests for the BunnyMascot mascot.
class BunnyMascotTest {

    @Test
    void hasArt() {
        BunnyMascot mascot = new BunnyMascot();
        String[] art = mascot.getArt();
        assertNotNull(art);
        assertTrue(art.length > 0);
    }

    @Test
    void printBunny() {
        BunnyMascot mascot = new BunnyMascot();
        System.out.println("--- BunnyMascot ---");
        mascot.print();
    }
}
