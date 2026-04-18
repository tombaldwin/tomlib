package io.poly.tomlib.logo.font;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AbstractAsciiFontTest {

    private static class TestFont extends AbstractAsciiFont {
        public TestFont(AsciiFontCharacter unknownCharacter, AsciiFontCharacter... characters) {
            super(unknownCharacter, characters);
            for (int i = 0; i < characters.length; i++) {
                registerCharacter((char)('a' + i), characters[i]);
            }
        }
    }

    @Test
    void enforceConsistentHeight() {
        AsciiFontCharacter char1 = new AsciiFontCharacter("###", "###");
        AsciiFontCharacter char2 = new AsciiFontCharacter("@@@", "@@@", "@@@");
        AsciiFontCharacter unknown = new AsciiFontCharacter("??", "??");

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new TestFont(unknown, char1, char2));
        assertTrue(exception.getMessage().contains("All characters in a font must have the same height"));
    }

    @Test
    void enforceUnknownCharacterHeight() {
        AsciiFontCharacter char1 = new AsciiFontCharacter("###", "###");
        AsciiFontCharacter unknown = new AsciiFontCharacter("???", "???", "???");

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new TestFont(unknown, char1));
        assertTrue(exception.getMessage().contains("Unknown character must have the same height"));
    }

    @Test
    void renderText() {
        AsciiFontCharacter charA = new AsciiFontCharacter("A", "A");
        AsciiFontCharacter charB = new AsciiFontCharacter("B", "B");
        AsciiFontCharacter unknown = new AsciiFontCharacter("?", "?");
        TestFont font = new TestFont(unknown, charA, charB);

        String[] rendered = font.render("ab!");
        assertEquals(2, rendered.length);
        assertEquals("AB?", rendered[0]);
        assertEquals("AB?", rendered[1]);
    }

    @Test
    void throwExceptionForEmptyCharacters() {
        AsciiFontCharacter unknown = new AsciiFontCharacter("?", "?");
        assertThrows(IllegalArgumentException.class, () -> new TestFont(unknown));
    }
}
