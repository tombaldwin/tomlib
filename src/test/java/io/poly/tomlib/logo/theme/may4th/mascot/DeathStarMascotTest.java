package io.poly.tomlib.logo.theme.may4th.mascot;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/// Tests for the DeathStarMascot mascot.
class DeathStarMascotTest {

    @Test
    void hasArt() {
        DeathStarMascot mascot = new DeathStarMascot();
        String[] art = mascot.getArt();
        assertNotNull(art);
        assertTrue(art.length > 0);
    }

    @Test
    void printDeathStar() {
        DeathStarMascot mascot = new DeathStarMascot();
        System.out.println("--- DeathStarMascot ---");
        mascot.print();
    }
}
