package io.poly.tomlib.logo.theme.festive.mascot;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/// Tests for the HappyGrinchMascot mascot.
class HappyGrinchMascotTest {

    @Test
    void hasArt() {
        HappyGrinchMascot mascot = new HappyGrinchMascot();
        String[] art = mascot.getArt();
        assertNotNull(art);
        assertTrue(art.length > 0);
    }

    @Test
    void printHappyGrinch() {
        HappyGrinchMascot mascot = new HappyGrinchMascot();
        System.out.println("--- HappyGrinchMascot ---");
        mascot.print();
    }
}
