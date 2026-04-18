package io.poly.tomlib.logo.theme.birthday.mascot;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/// Tests for the BirthdayCakeMascot mascot.
class BirthdayCakeMascotTest {

    @Test
    void hasArt() {
        BirthdayCakeMascot mascot = new BirthdayCakeMascot();
        String[] art = mascot.getArt();
        assertNotNull(art);
        assertTrue(art.length > 0);
    }

    @Test
    void printBirthdayCake() {
        BirthdayCakeMascot mascot = new BirthdayCakeMascot();
        System.out.println("--- BirthdayCakeMascot ---");
        mascot.print();
    }
}
