package io.poly.tomlib.logo.theme.may4th.mascot;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/// Tests for the XWingMascot mascot.
class XWingMascotTest {

    @Test
    void hasArt() {
        XWingMascot mascot = new XWingMascot();
        String[] art = mascot.getArt();
        assertNotNull(art);
        assertTrue(art.length > 0);
    }

    @Test
    void printXWing() {
        XWingMascot mascot = new XWingMascot();
        System.out.println("--- XWingMascot ---");
        mascot.print();
    }
}
