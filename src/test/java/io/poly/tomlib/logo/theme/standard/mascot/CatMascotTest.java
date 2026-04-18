package io.poly.tomlib.logo.theme.standard.mascot;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/// Tests for the CatMascot mascot.
class CatMascotTest {

    @Test
    void hasArt() {
        CatMascot mascot = new CatMascot();
        String[] art = mascot.getArt();
        assertNotNull(art);
        assertTrue(art.length > 0);
    }

    @Test
    void printCat() {
        CatMascot mascot = new CatMascot();
        System.out.println("--- CatMascot ---");
        mascot.print();
    }
}
