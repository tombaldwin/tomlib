package io.poly.tomlib.logo.theme.may4th.mascot;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/// Tests for the StormtrooperMascot mascot.
class StormtrooperMascotTest {

    @Test
    void hasArt() {
        StormtrooperMascot mascot = new StormtrooperMascot();
        String[] art = mascot.getArt();
        assertNotNull(art);
        assertTrue(art.length > 0);
    }

    @Test
    void printStormtrooper() {
        StormtrooperMascot mascot = new StormtrooperMascot();
        System.out.println("--- StormtrooperMascot ---");
        mascot.print();
    }
}
