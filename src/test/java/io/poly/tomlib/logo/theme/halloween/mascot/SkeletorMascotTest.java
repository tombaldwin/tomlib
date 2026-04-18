package io.poly.tomlib.logo.theme.halloween.mascot;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/// Tests for the SkeletorMascot mascot.
class SkeletorMascotTest {

    @Test
    void hasArt() {
        SkeletorMascot mascot = new SkeletorMascot();
        String[] art = mascot.getArt();
        assertNotNull(art);
        assertTrue(art.length > 0);
    }

    @Test
    void printSkeletor() {
        SkeletorMascot mascot = new SkeletorMascot();
        System.out.println("--- SkeletorMascot ---");
        mascot.print();
    }
}
