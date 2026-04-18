package io.poly.tomlib.logo.theme.may4th.mascot;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/// Tests for the TieFighterMascot mascot.
class TieFighterMascotTest {

    @Test
    void hasArt() {
        TieFighterMascot mascot = new TieFighterMascot();
        String[] art = mascot.getArt();
        assertNotNull(art);
        assertTrue(art.length > 0);
    }

    @Test
    void printTieFighter() {
        TieFighterMascot mascot = new TieFighterMascot();
        System.out.println("--- TieFighterMascot ---");
        mascot.print();
    }
}
