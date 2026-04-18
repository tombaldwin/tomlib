package io.poly.tomlib.logo.font;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/// Unit tests for StarTrekAsciiFont.
public class StarTrekAsciiFontTest {

    @Test
    void hasCorrectHeight() {
        StarTrekAsciiFont font = new StarTrekAsciiFont();
        assertEquals(6, font.getHeight());
    }

    @Test
    void rendersA() {
        StarTrekAsciiFont font = new StarTrekAsciiFont();
        String[] rendered = font.render("A");
        assertEquals(6, rendered.length);
        // Printing for debug:
        for (String line : rendered) {
            System.out.println("[DEBUG_LOG] '" + line + "'");
        }
        assertTrue(rendered[0].contains("/"));
    }

    @Test
    void printStarTrekFont() {
        new StarTrekAsciiFont().printAllCharacters(120);
    }
}
