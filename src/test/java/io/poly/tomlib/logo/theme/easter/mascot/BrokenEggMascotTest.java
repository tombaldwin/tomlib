package io.poly.tomlib.logo.theme.easter.mascot;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/// Tests for the BrokenEggMascot mascot.
class BrokenEggMascotTest {

    @Test
    void hasArt() {
        BrokenEggMascot mascot = new BrokenEggMascot();
        String[] art = mascot.getArt();
        assertNotNull(art);
        assertTrue(art.length > 0);
    }

    @Test
    void printBrokenEgg() {
        BrokenEggMascot mascot = new BrokenEggMascot();
        System.out.println("--- BrokenEggMascot ---");
        mascot.print();
    }
}
