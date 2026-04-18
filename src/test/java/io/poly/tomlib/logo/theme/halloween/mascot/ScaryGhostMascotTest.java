package io.poly.tomlib.logo.theme.halloween.mascot;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/// Tests for the ScaryGhostMascot mascot.
class ScaryGhostMascotTest {

    @Test
    void hasArt() {
        ScaryGhostMascot mascot = new ScaryGhostMascot();
        String[] art = mascot.getArt();
        assertNotNull(art);
        assertTrue(art.length > 0);
    }

    @Test
    void printScaryGhost() {
        ScaryGhostMascot mascot = new ScaryGhostMascot();
        System.out.println("--- ScaryGhostMascot ---");
        mascot.print();
    }
}
