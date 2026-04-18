package io.poly.tomlib.logo.theme.festive.mascot;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/// Tests for the TreeMascot mascot.
class TreeMascotTest {

    @Test
    void hasArt() {
        TreeMascot mascot = new TreeMascot();
        String[] art = mascot.getArt();
        assertNotNull(art);
        assertTrue(art.length > 0);
    }

    @Test
    void printTree() {
        TreeMascot mascot = new TreeMascot();
        System.out.println("--- TreeMascot ---");
        mascot.print();
    }
}
