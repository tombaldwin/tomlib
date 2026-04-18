package io.poly.tomlib.logo.theme.newyear.mascot;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/// Tests for the FireworksMascot mascot.
class FireworksMascotTest {

    @Test
    void hasArt() {
        FireworksMascot mascot = new FireworksMascot();
        String[] art = mascot.getArt();
        assertNotNull(art);
        assertTrue(art.length > 0);
    }

    @Test
    void printFireworks() {
        FireworksMascot mascot = new FireworksMascot();
        System.out.println("--- FireworksMascot ---");
        mascot.print();
    }
}
