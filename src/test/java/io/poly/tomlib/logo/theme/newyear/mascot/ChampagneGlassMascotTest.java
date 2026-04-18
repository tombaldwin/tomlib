package io.poly.tomlib.logo.theme.newyear.mascot;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/// Tests for the ChampagneGlassMascot mascot.
class ChampagneGlassMascotTest {

    @Test
    void hasArt() {
        ChampagneGlassMascot mascot = new ChampagneGlassMascot();
        String[] art = mascot.getArt();
        assertNotNull(art);
        assertTrue(art.length > 0);
    }

    @Test
    void printChampagneGlass() {
        ChampagneGlassMascot mascot = new ChampagneGlassMascot();
        System.out.println("--- ChampagneGlassMascot ---");
        mascot.print();
    }
}
