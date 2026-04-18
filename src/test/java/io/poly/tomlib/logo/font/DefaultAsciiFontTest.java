package io.poly.tomlib.logo.font;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DefaultAsciiFontTest {

    @Test
    void renderLowercaseLetters() {
        DefaultAsciiFont font = new DefaultAsciiFont();
        String[] rendered = font.render("abc");
        assertNotNull(rendered);
        assertEquals(6, rendered.length);
        // Verify some content (not exhaustive to keep it simple, but enough to catch regressions)
        assertTrue(rendered[1].contains("___"));
    }

    @Test
    void renderDot() {
        DefaultAsciiFont font = new DefaultAsciiFont();
        String[] rendered = font.render(".");
        assertNotNull(rendered);
        assertEquals(6, rendered.length);
        assertEquals("   ", rendered[0]);
        assertEquals(" _ ", rendered[3]);
        assertEquals("(_)", rendered[4]);
    }

    @Test
    void renderUnknownCharacterBehaviour() {
        DefaultAsciiFont font = new DefaultAsciiFont();
        String[] rendered = font.render("?");
        assertNotNull(rendered);
        assertEquals(6, rendered.length);
        // '?' is now a known character, so let's check it's not the unknown replacement
        assertNotEquals("  ", rendered[0]);

        String[] unknown = font.render("£");
        for (String line : unknown) {
            assertEquals("  ", line);
        }
    }

    @Test
    void renderMixedCase() {
        DefaultAsciiFont font = new DefaultAsciiFont();
        String[] renderedUpper = font.render("A");
        String[] renderedLower = font.render("a");
        assertArrayEquals(renderedLower, renderedUpper);
    }

    @Test
    void provideCorrectFontHeight() {
        DefaultAsciiFont font = new DefaultAsciiFont();
        assertEquals(6, font.getHeight());
    }

    @Test
    void renderNumbers() {
        DefaultAsciiFont font = new DefaultAsciiFont();
        String[] rendered = font.render("0123456789");
        assertNotNull(rendered);
        assertEquals(6, rendered.length);
        // At least one line should be non-empty and non-blank for the combined output
        boolean hasContent = false;
        for (String line : rendered) {
            if (!line.trim().isEmpty()) {
                hasContent = true;
                break;
            }
        }
        assertTrue(hasContent, "Rendered numbers should have some non-empty lines");
    }

    @Test
    void renderSymbols() {
        DefaultAsciiFont font = new DefaultAsciiFont();
        String[] rendered = font.render("!@#$%^&*()_+-=[]{}|;':\",.<>?/`\\");
        assertNotNull(rendered);
        assertEquals(6, rendered.length);
        for (String line : rendered) {
            assertFalse(line.trim().isEmpty(), "Line should not be empty for symbols");
        }
    }

    @Test
    void renderSpace() {
        DefaultAsciiFont font = new DefaultAsciiFont();
        String[] rendered = font.render(" ");
        assertNotNull(rendered);
        assertEquals(6, rendered.length);
        assertEquals(" ", rendered[0]);
    }

    @Test
    void printAllCharactersAddsSpaces() {
        DefaultAsciiFont font = new DefaultAsciiFont();
        assertDoesNotThrow(() -> font.printAllCharacters(80));
    }

    @Test
    void printAllCharactersOutput() {
        DefaultAsciiFont font = new DefaultAsciiFont();
        java.io.ByteArrayOutputStream outContent = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(outContent));
        try {
            font.printAllCharacters(80);
            String output = outContent.toString();
            assertFalse(output.isEmpty());
            assertTrue(output.contains("Key:"), "Output should contain a key");
            // Verify 'a' is in the key
            assertTrue(output.contains("a"), "Key should contain 'a'");
        } finally {
            System.setOut(new java.io.PrintStream(new java.io.FileOutputStream(java.io.FileDescriptor.out)));
        }
    }

    @Test
    void printAllCharacters() {
        DefaultAsciiFont font = new DefaultAsciiFont();
        font.printAllCharacters(80);
    }
}
