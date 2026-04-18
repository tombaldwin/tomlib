package io.poly.tomlib.logo.theme.festive.mascot;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/// Tests for the GiftMascot mascot.
class GiftMascotTest {

    @Test
    void hasArt() {
        GiftMascot mascot = new GiftMascot();
        String[] art = mascot.getArt();
        assertNotNull(art);
        assertTrue(art.length > 0);
    }

    @Test
    void printGift() {
        GiftMascot mascot = new GiftMascot();
        System.out.println("--- GiftMascot ---");
        mascot.print();
    }
}
