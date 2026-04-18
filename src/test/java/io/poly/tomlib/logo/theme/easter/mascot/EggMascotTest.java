package io.poly.tomlib.logo.theme.easter.mascot;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/// Tests for the EggMascot mascot.
class EggMascotTest {

    @Test
    void hasArt() {
        EggMascot mascot = new EggMascot();
        String[] art = mascot.getArt();
        assertNotNull(art);
        assertTrue(art.length > 0);
    }

    @Test
    void printEgg() {
        EggMascot mascot = new EggMascot();
        System.out.println("--- EggMascot ---");
        mascot.print();
    }
}
