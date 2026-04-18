package io.poly.tomlib.logo.theme.may4th.mascot;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/// Tests for the R2D2Mascot mascot.
class R2D2MascotTest {

    @Test
    void hasArt() {
        R2D2Mascot mascot = new R2D2Mascot();
        String[] art = mascot.getArt();
        assertNotNull(art);
        assertTrue(art.length > 0);
    }

    @Test
    void printR2D2() {
        R2D2Mascot mascot = new R2D2Mascot();
        System.out.println("--- R2D2Mascot ---");
        mascot.print();
    }
}
