package io.poly.tomlib.logo.theme.newyear.mascot;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/// Tests for the PartyHatMascot mascot.
class PartyHatMascotTest {

    @Test
    void hasArt() {
        PartyHatMascot mascot = new PartyHatMascot();
        String[] art = mascot.getArt();
        assertNotNull(art);
        assertTrue(art.length > 0);
    }

    @Test
    void printPartyHat() {
        PartyHatMascot mascot = new PartyHatMascot();
        System.out.println("--- PartyHatMascot ---");
        mascot.print();
    }
}
