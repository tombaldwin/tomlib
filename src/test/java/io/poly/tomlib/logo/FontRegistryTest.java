package io.poly.tomlib.logo;

import io.poly.tomlib.logo.font.AsciiFont;
import io.poly.tomlib.logo.font.DefaultAsciiFont;
import io.poly.tomlib.logo.font.StarWarsAsciiFont;
import io.poly.tomlib.logo.font.StarTrekAsciiFont;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/// Tests for the FontRegistry class.
public class FontRegistryTest {

    @BeforeEach
    public void setUp() {
        FontRegistry.clearCache();
    }

    @Test
    void discoverFontsViaServiceLoader() {
        Map<Class<? extends AsciiFont>, AsciiFont> fonts = FontRegistry.getFonts();
        assertFalse(fonts.isEmpty(), "FontRegistry should discover fonts via ServiceLoader");
        assertTrue(fonts.containsKey(DefaultAsciiFont.class), "DefaultAsciiFont should be discovered");
        assertTrue(fonts.containsKey(StarWarsAsciiFont.class), "StarWarsAsciiFont should be discovered");
        assertTrue(fonts.containsKey(StarTrekAsciiFont.class), "StarTrekAsciiFont should be discovered");
    }

    @Test
    void cacheFontInstancesForPerformance() {
        AsciiFont font1 = FontRegistry.getFont(DefaultAsciiFont.class).orElseThrow();
        AsciiFont font2 = FontRegistry.getFont(DefaultAsciiFont.class).orElseThrow();
        assertSame(font1, font2, "FontRegistry should cache font instances");
    }

    @Test
    void retrieveSpecificFontByType() {
        Optional<StarWarsAsciiFont> font = FontRegistry.getFont(StarWarsAsciiFont.class);
        assertTrue(font.isPresent(), "Should be able to get StarWarsAsciiFont");
        assertInstanceOf(StarWarsAsciiFont.class, font.get());
    }

    @Test
    void provideDefaultFontWhenRequested() {
        AsciiFont defaultFont = FontRegistry.getDefaultFont();
        assertNotNull(defaultFont, "Should provide a default font");
        assertInstanceOf(DefaultAsciiFont.class, defaultFont);
    }
}
