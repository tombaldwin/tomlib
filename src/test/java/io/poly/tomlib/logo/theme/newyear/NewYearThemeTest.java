package io.poly.tomlib.logo.theme.newyear;

import io.poly.tomlib.logo.ThemeRegistry;
import io.poly.tomlib.logo.theme.ThemeTestUtils;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

/// Tests for the New Year theme.
class NewYearThemeTest {

    @Test
    void hasCorrectProperties() {
        NewYearTheme theme = ThemeRegistry.getTheme(NewYearTheme.class).orElseThrow();
        assertEquals("New Year", theme.getName());
        assertEquals(20, theme.getPriority());
    }

    @Test
    void isActiveOnNewYear() {
        NewYearTheme theme = new NewYearTheme();
        assertTrue(theme.isActive(LocalDate.of(2024, 12, 31)));
        assertTrue(theme.isActive(LocalDate.of(2025, 1, 1)));
        assertFalse(theme.isActive(LocalDate.of(2024, 1, 2)));
        assertFalse(theme.isActive(LocalDate.of(2024, 12, 30)));
    }

    @Test
    void printNewYearTheme() {
        NewYearTheme theme = new NewYearTheme();
        ThemeTestUtils.printTheme(theme, "HAPPY 2025");
    }
}
