package io.poly.tomlib.logo.theme.easter.mascot;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/// Tests for the ChickMascot mascot.
class ChickMascotTest {

    @Test
    void hasArt() {
        ChickMascot mascot = new ChickMascot();
        String[] art = mascot.getArt();
        assertNotNull(art);
        assertTrue(art.length > 0);
    }

    @Test
    void printChick() {
        ChickMascot mascot = new ChickMascot();
        System.out.println("--- ChickMascot ---");
        mascot.print();
    }
}
