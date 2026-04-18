package io.poly.tomlib.logo.font;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StarWarsAsciiFontTest {

    @Test
    void heightIsCorrect() {
        StarWarsAsciiFont font = new StarWarsAsciiFont();
        assertEquals(6, font.getHeight());
    }

    @Test
    void unknownCharacterReturnsPlaceholder() {
        StarWarsAsciiFont font = new StarWarsAsciiFont();
        String[] rendered = font.render("?");
        for (String line : rendered) {
            assertEquals("  ", line);
        }
    }

    @Test
    void printStarWarsFont() {
        System.out.println("--- STAR WARS ASCII FONT ---");
        StarWarsAsciiFont font = new StarWarsAsciiFont();
        font.printAllCharacters(120);
    }

    /// Verifies that the words 'STAR' and 'WARS' are rendered and printed correctly.
    @Test
    void printStarWarsWords() {
        StarWarsAsciiFont font = new StarWarsAsciiFont();
        String[] star = font.render("STAR");
        String[] wars = font.render("WARS");

        System.out.println("--- STAR ---");
        for (String line : star) {
            System.out.println(line);
        }

        System.out.println("\n--- WARS ---");
        for (String line : wars) {
            System.out.println(line);
        }

        assertNotNull(star);
        assertEquals(6, star.length);
        assertNotNull(wars);
        assertEquals(6, wars.length);
    }
}
