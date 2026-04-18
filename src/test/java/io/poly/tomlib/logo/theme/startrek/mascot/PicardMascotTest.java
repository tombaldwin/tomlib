package io.poly.tomlib.logo.theme.startrek.mascot;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/// Unit tests for PicardMascot.
public class PicardMascotTest {

    @Test
    void hasArt() {
        PicardMascot mascot = new PicardMascot();
        assertNotNull(mascot.getArt());
        assertTrue(mascot.getArt().length > 0);
    }

    @Test
    void hasQuote() {
        PicardMascot mascot = new PicardMascot();
        List<String> expectedQuotes = Arrays.asList(
            "Make it so.",
            "Engage!",
            "Tea, Earl Grey, hot.",
            "There are four lights!",
            "Things are only impossible until they're not."
        );
        assertTrue(expectedQuotes.contains(mascot.getQuote()));
    }

    @Test
    void hasColour() {
        PicardMascot mascot = new PicardMascot();
        int[] skin = mascot.getColour('/', 1, 1);
        assertArrayEquals(new int[]{255, 220, 180}, skin);

        int[] eyes = mascot.getColour('o', 2, 2);
        assertArrayEquals(new int[]{0, 100, 0}, eyes);

        int[] uniform = mascot.getColour('|', 4, 1);
        assertArrayEquals(new int[]{255, 0, 0}, uniform);
    }

    @Test
    void printPicard() {
        new PicardMascot().print();
    }
}
