package io.poly.tomlib.logo.theme.valentines.mascot;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/// Tests for the ArrowMascot mascot.
class ArrowMascotTest {

    @Test
    void hasArt() {
        ArrowMascot mascot = new ArrowMascot();
        String[] art = mascot.getArt();
        assertNotNull(art);
        assertTrue(art.length > 0);
    }

    @Test
    void printArrow() {
        ArrowMascot mascot = new ArrowMascot();
        System.out.println("--- ArrowMascot ---");
        mascot.print();
    }
}
