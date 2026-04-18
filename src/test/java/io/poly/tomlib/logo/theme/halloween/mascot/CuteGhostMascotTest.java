package io.poly.tomlib.logo.theme.halloween.mascot;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/// Tests for the CuteGhostMascot mascot.
class CuteGhostMascotTest {

    @Test
    void hasArt() {
        CuteGhostMascot mascot = new CuteGhostMascot();
        String[] art = mascot.getArt();
        assertNotNull(art);
        assertTrue(art.length > 0);
    }

    @Test
    void printCuteGhost() {
        CuteGhostMascot mascot = new CuteGhostMascot();
        System.out.println("--- CuteGhostMascot ---");
        mascot.print();
    }
}
