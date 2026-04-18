package io.poly.tomlib.logo.theme.fourthofjuly.mascot;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/// Tests for the USFlagMascot mascot.
class USFlagMascotTest {

    @Test
    void hasArt() {
        USFlagMascot mascot = new USFlagMascot();
        String[] art = mascot.getArt();
        assertNotNull(art);
        assertTrue(art.length > 0);
    }

    @Test
    void printUSFlag() {
        USFlagMascot mascot = new USFlagMascot();
        System.out.println("--- USFlagMascot ---");
        mascot.print();
    }
}
