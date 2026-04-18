package io.poly.tomlib.logo.theme.startrek.mascot;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/// Unit tests for SpockMascot.
public class SpockMascotTest {

    @Test
    void hasArt() {
        SpockMascot mascot = new SpockMascot();
        assertNotNull(mascot.getArt());
        assertTrue(mascot.getArt().length > 0);
    }

    @Test
    void hasQuote() {
        SpockMascot mascot = new SpockMascot();
        List<String> expectedQuotes = Arrays.asList(
            "Live long and prosper.",
            "Fascinating.",
            "Logic is the beginning of wisdom, not the end.",
            "Highly illogical.",
            "The needs of the many outweigh the needs of the few."
        );
        assertTrue(expectedQuotes.contains(mascot.getQuote()));
    }

    @Test
    void hasColour() {
        SpockMascot mascot = new SpockMascot();
        int[] skin = mascot.getColour('/', 1, 1);
        assertArrayEquals(new int[]{255, 220, 180}, skin);

        int[] ears = mascot.getColour('<', 0, 1);
        assertArrayEquals(new int[]{255, 220, 180}, ears);

        int[] eyes = mascot.getColour('o', 2, 2);
        assertArrayEquals(new int[]{150, 0, 255}, eyes);

        int[] uniform = mascot.getColour('|', 4, 1);
        assertArrayEquals(new int[]{0, 100, 255}, uniform);
    }

    @Test
    void printSpock() {
        new SpockMascot().print();
    }
}
