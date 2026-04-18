package io.poly.tomlib.logo.theme.may4th.mascot;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/// Tests for the YodaMascot mascot.
class YodaMascotTest {

    @Test
    void hasArt() {
        YodaMascot mascot = new YodaMascot();
        String[] art = mascot.getArt();
        assertNotNull(art);
        assertTrue(art.length > 0);
    }

    @Test
    void printYoda() {
        YodaMascot mascot = new YodaMascot();
        System.out.println("--- YodaMascot ---");
        mascot.print();
    }
}
