package io.poly.tomlib.logo.theme.valentines.mascot;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/// Tests for the LoveLetterMascot mascot.
class LoveLetterMascotTest {

    @Test
    void hasArt() {
        LoveLetterMascot mascot = new LoveLetterMascot();
        String[] art = mascot.getArt();
        assertNotNull(art);
        assertTrue(art.length > 0);
    }

    @Test
    void printLoveLetter() {
        LoveLetterMascot mascot = new LoveLetterMascot();
        System.out.println("--- LoveLetterMascot ---");
        mascot.print();
    }
}
