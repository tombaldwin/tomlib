package io.poly.tomlib.logo.theme.easter;

import io.poly.tomlib.logo.ThemeRegistry;
import io.poly.tomlib.logo.theme.ThemeTestUtils;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

/// Tests for the Easter theme.
class EasterThemeTest {

    @Test
    void hasCorrectProperties() {
        EasterTheme theme = ThemeRegistry.getTheme(EasterTheme.class).orElseThrow();
        assertEquals("Easter", theme.getName());
        assertEquals(5, theme.getPriority());
    }

    @Test
    void isActiveOnEaster() {
        EasterTheme theme = new EasterTheme();
        // Easter 2024 was March 31. Good Friday March 29, Easter Monday April 1.
        assertTrue(theme.isActive(LocalDate.of(2024, 3, 31)));
        assertTrue(theme.isActive(LocalDate.of(2024, 3, 29)));
        assertTrue(theme.isActive(LocalDate.of(2024, 4, 1)));
        assertFalse(theme.isActive(LocalDate.of(2024, 3, 28)));
    }

    @Test
    void printEasterTheme() {
        EasterTheme theme = new EasterTheme();
        ThemeTestUtils.printTheme(theme, "EASTER");
    }
}
