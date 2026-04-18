package io.poly.tomlib.logo.theme.festive.mascot;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/// Tests for the ReindeerMascot mascot.
class ReindeerMascotTest {

    @Test
    void hasArt() {
        ReindeerMascot mascot = new ReindeerMascot();
        String[] art = mascot.getArt();
        assertNotNull(art);
        assertTrue(art.length > 0);
    }

    @Test
    void printReindeer() {
        ReindeerMascot mascot = new ReindeerMascot();
        System.out.println("--- ReindeerMascot ---");
        mascot.print();
    }
}
