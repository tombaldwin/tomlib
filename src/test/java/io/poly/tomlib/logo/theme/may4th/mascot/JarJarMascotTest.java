package io.poly.tomlib.logo.theme.may4th.mascot;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/// Tests for the JarJarMascot mascot.
class JarJarMascotTest {

    @Test
    void hasArt() {
        JarJarMascot mascot = new JarJarMascot();
        String[] art = mascot.getArt();
        assertNotNull(art);
        assertTrue(art.length > 0);
    }

    @Test
    void printJarJar() {
        JarJarMascot mascot = new JarJarMascot();
        System.out.println("--- JarJarMascot ---");
        mascot.print();
    }
}
