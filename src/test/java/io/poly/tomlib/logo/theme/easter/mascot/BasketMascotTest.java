package io.poly.tomlib.logo.theme.easter.mascot;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/// Tests for the BasketMascot mascot.
class BasketMascotTest {

    @Test
    void hasArt() {
        BasketMascot mascot = new BasketMascot();
        String[] art = mascot.getArt();
        assertNotNull(art);
        assertTrue(art.length > 0);
    }

    @Test
    void printBasket() {
        BasketMascot mascot = new BasketMascot();
        System.out.println("--- BasketMascot ---");
        mascot.print();
    }
}
