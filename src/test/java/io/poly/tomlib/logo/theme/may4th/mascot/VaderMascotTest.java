package io.poly.tomlib.logo.theme.may4th.mascot;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/// Tests for the VaderMascot mascot.
class VaderMascotTest {

    @Test
    void hasArt() {
        VaderMascot mascot = new VaderMascot();
        String[] art = mascot.getArt();
        assertNotNull(art);
        assertTrue(art.length > 0);
    }

    @Test
    void printVader() {
        VaderMascot mascot = new VaderMascot();
        System.out.println("--- VaderMascot ---");
        mascot.print();
    }
}
