package io.poly.tomlib.logo.theme.festive.mascot;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/// Tests for the ElfMascot mascot.
class ElfMascotTest {

    @Test
    void hasArt() {
        ElfMascot mascot = new ElfMascot();
        String[] art = mascot.getArt();
        assertNotNull(art);
        assertTrue(art.length > 0);
    }

    @Test
    void printElf() {
        ElfMascot mascot = new ElfMascot();
        System.out.println("--- ElfMascot ---");
        mascot.print();
    }
}
