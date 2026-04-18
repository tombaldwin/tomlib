package io.poly.tomlib.logo.theme.halloween.mascot;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/// Tests for the ClassicGhostMascot mascot.
class ClassicGhostMascotTest {

    @Test
    void hasArt() {
        ClassicGhostMascot mascot = new ClassicGhostMascot();
        String[] art = mascot.getArt();
        assertNotNull(art);
        assertTrue(art.length > 0);
    }

    @Test
    void printClassicGhost() {
        ClassicGhostMascot mascot = new ClassicGhostMascot();
        System.out.println("--- ClassicGhostMascot ---");
        mascot.print();
    }
}
