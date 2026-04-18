package io.poly.tomlib.logo.theme.fourthofjuly.mascot;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/// Tests for the USFireworksMascot mascot.
class USFireworksMascotTest {

    @Test
    void hasArt() {
        USFireworksMascot mascot = new USFireworksMascot();
        String[] art = mascot.getArt();
        assertNotNull(art);
        assertTrue(art.length > 0);
    }

    @Test
    void printUSFireworks() {
        USFireworksMascot mascot = new USFireworksMascot();
        System.out.println("--- USFireworksMascot ---");
        mascot.print();
    }
}
