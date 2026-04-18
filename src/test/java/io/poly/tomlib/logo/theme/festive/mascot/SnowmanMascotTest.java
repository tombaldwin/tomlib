package io.poly.tomlib.logo.theme.festive.mascot;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/// Tests for the SnowmanMascot mascot.
class SnowmanMascotTest {

    @Test
    void hasArt() {
        SnowmanMascot mascot = new SnowmanMascot();
        String[] art = mascot.getArt();
        assertNotNull(art);
        assertTrue(art.length > 0);
    }

    @Test
    void printSnowman() {
        SnowmanMascot mascot = new SnowmanMascot();
        System.out.println("--- SnowmanMascot ---");
        mascot.print();
    }
}
