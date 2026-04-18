package io.poly.tomlib.logo.theme.fourthofjuly.mascot;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/// Tests for the EagleMascot mascot.
class EagleMascotTest {

    @Test
    void hasArt() {
        EagleMascot mascot = new EagleMascot();
        String[] art = mascot.getArt();
        assertNotNull(art);
        assertTrue(art.length > 0);
    }

    @Test
    void printEagle() {
        EagleMascot mascot = new EagleMascot();
        System.out.println("--- EagleMascot ---");
        mascot.print();
    }
}
