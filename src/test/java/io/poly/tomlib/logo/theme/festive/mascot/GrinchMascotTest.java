package io.poly.tomlib.logo.theme.festive.mascot;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/// Tests for the Grinch mascot.
class GrinchMascotTest {

    @Test
    void hasArt() {
        GrinchMascot mascot = new GrinchMascot();
        String[] art = mascot.getArt();
        assertNotNull(art);
        assertTrue(art.length > 0);
    }

    @Test
    void hasColour() {
        GrinchMascot mascot = new GrinchMascot();
        int[] eyeColour = mascot.getColour('>', 2, 3);
        assertArrayEquals(new int[]{255, 0, 0}, eyeColour);

        int[] bodyColour = mascot.getColour('(', 2, 1);
        assertArrayEquals(new int[]{50, 205, 50}, bodyColour);
    }

    @Test
    void hasQuote() {
        GrinchMascot mascot = new GrinchMascot();
        assertNotNull(mascot.getQuote());
    }

    @Test
    void printGrinch() {
        GrinchMascot mascot = new GrinchMascot();
        System.out.println("--- Grinch Mascot ---");
        mascot.print();
    }
}
