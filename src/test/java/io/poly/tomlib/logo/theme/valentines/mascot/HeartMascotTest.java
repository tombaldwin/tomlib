package io.poly.tomlib.logo.theme.valentines.mascot;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/// Tests for the HeartMascot mascot.
class HeartMascotTest {

    @Test
    void hasArt() {
        HeartMascot mascot = new HeartMascot();
        String[] art = mascot.getArt();
        assertNotNull(art);
        assertTrue(art.length > 0);
    }

    @Test
    void printHeart() {
        HeartMascot mascot = new HeartMascot();
        System.out.println("--- HeartMascot ---");
        mascot.print();
    }
}
