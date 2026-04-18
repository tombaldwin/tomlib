package io.poly.tomlib.logo.theme.may4th.mascot;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/// Tests for the FalconMascot mascot.
class FalconMascotTest {

    @Test
    void hasArt() {
        FalconMascot mascot = new FalconMascot();
        String[] art = mascot.getArt();
        assertNotNull(art);
        assertTrue(art.length > 0);
    }

    @Test
    void printFalcon() {
        FalconMascot mascot = new FalconMascot();
        System.out.println("--- FalconMascot ---");
        mascot.print();
    }
}
