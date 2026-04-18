package io.poly.tomlib.logo.font;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AsciiFontCharacterTest {

    @Test
    void createCharacterWithConsistentLineLengths() {
        AsciiFontCharacter character = new AsciiFontCharacter("###", "###", "###");
        assertEquals(3, character.getWidth());
        assertEquals(3, character.getHeight());
        assertArrayEquals(new String[]{"###", "###", "###"}, character.getLines());
    }

    @Test
    void throwExceptionForInconsistentLineLengths() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new AsciiFontCharacter("###", "##", "###"));
        assertTrue(exception.getMessage().contains("All lines in a character must have the same length"));
    }

    @Test
    void throwExceptionForNullLines() {
        assertThrows(IllegalArgumentException.class, () -> new AsciiFontCharacter((String[]) null));
    }

    @Test
    void throwExceptionForEmptyLines() {
        assertThrows(IllegalArgumentException.class, () -> new AsciiFontCharacter(new String[0]));
    }

    @Test
    void getLinesReturnsCopy() {
        String[] lines = {"###"};
        AsciiFontCharacter character = new AsciiFontCharacter(lines);
        String[] retrievedLines = character.getLines();
        retrievedLines[0] = "@@@";
        assertNotEquals(retrievedLines[0], character.getLine(0));
    }
}
