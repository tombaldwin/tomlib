package io.poly.tomlib.logo.theme.festive;

import io.poly.tomlib.logo.ThemeRegistry;
import io.poly.tomlib.logo.theme.ThemeTestUtils;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

/// Tests for the Festive theme.
class FestiveThemeTest {

    @Test
    void hasCorrectProperties() {
        FestiveTheme theme = ThemeRegistry.getTheme(FestiveTheme.class).orElseThrow();
        assertEquals("Festive", theme.getName());
        assertEquals(5, theme.getPriority());
    }

    @Test
    void isActiveInDecember() {
        FestiveTheme theme = new FestiveTheme();
        assertTrue(theme.isActive(LocalDate.of(2024, 12, 1)));
        assertTrue(theme.isActive(LocalDate.of(2024, 12, 25)));
        assertTrue(theme.isActive(LocalDate.of(2024, 12, 31)));
        assertFalse(theme.isActive(LocalDate.of(2024, 11, 30)));
        assertFalse(theme.isActive(LocalDate.of(2024, 1, 1)));
    }

    @Test
    void printFestiveTheme() {
        FestiveTheme theme = new FestiveTheme();
        ThemeTestUtils.printTheme(theme, "FESTIVE");
    }
}
