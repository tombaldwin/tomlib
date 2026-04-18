package io.poly.tomlib.logo.theme.startrek.mascot;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/// Unit tests for KirkMascot.
public class KirkMascotTest {

    @Test
    void hasArt() {
        KirkMascot mascot = new KirkMascot();
        assertNotNull(mascot.getArt());
        assertTrue(mascot.getArt().length > 0);
    }

    @Test
    void hasQuote() {
        KirkMascot mascot = new KirkMascot();
        List<String> expectedQuotes = Arrays.asList(
            "Space: the final frontier.",
            "Set phasers to stun.",
            "Beam me up, Scotty.",
            "Boldly go where no man has gone before.",
            "KHAAAN!"
        );
        assertTrue(expectedQuotes.contains(mascot.getQuote()));
    }

    @Test
    void hasColour() {
        KirkMascot mascot = new KirkMascot();
        int[] skin = mascot.getColour('/', 1, 1);
        assertArrayEquals(new int[]{255, 220, 180}, skin);

        int[] eyes = mascot.getColour('o', 2, 2);
        assertArrayEquals(new int[]{0, 0, 255}, eyes);

        int[] uniform = mascot.getColour('|', 4, 1);
        assertArrayEquals(new int[]{255, 215, 0}, uniform);
    }

    @Test
    void printKirk() {
        new KirkMascot().print();
    }
}
