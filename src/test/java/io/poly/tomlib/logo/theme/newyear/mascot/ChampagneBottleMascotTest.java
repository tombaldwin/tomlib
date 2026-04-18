package io.poly.tomlib.logo.theme.newyear.mascot;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/// Tests for the ChampagneBottleMascot mascot.
class ChampagneBottleMascotTest {

    @Test
    void hasArt() {
        ChampagneBottleMascot mascot = new ChampagneBottleMascot();
        String[] art = mascot.getArt();
        assertNotNull(art);
        assertTrue(art.length > 0);
    }

    @Test
    void printChampagneBottle() {
        ChampagneBottleMascot mascot = new ChampagneBottleMascot();
        System.out.println("--- ChampagneBottleMascot ---");
        mascot.print();
    }
}
