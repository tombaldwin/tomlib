package io.poly.tomlib.logo.theme.may4th;

import io.poly.tomlib.logo.ThemeRegistry;
import io.poly.tomlib.logo.theme.ThemeTestUtils;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

/// Tests for the May 4th (Star Wars) theme.
class May4thThemeTest {

    @Test
    void hasCorrectProperties() {
        May4thTheme theme = ThemeRegistry.getTheme(May4thTheme.class).orElseThrow();
        assertEquals("May 4th", theme.getName());
        assertEquals(30, theme.getPriority());
    }

    @Test
    void isActiveOnMay4th() {
        May4thTheme theme = new May4thTheme();
        assertTrue(theme.isActive(LocalDate.of(2024, 5, 4)));
        assertFalse(theme.isActive(LocalDate.of(2024, 5, 3)));
        assertFalse(theme.isActive(LocalDate.of(2024, 5, 5)));
        assertFalse(theme.isActive(LocalDate.of(2024, 6, 4)));
    }

    @Test
    void printMay4thTheme() {
        May4thTheme theme = new May4thTheme();
        ThemeTestUtils.printTheme(theme, "STAR WARS");
    }

    @Test
    void printMay4thThemeAllMascots() {
        May4thTheme theme = new May4thTheme();
        ThemeTestUtils.printThemeAllMascots(theme, "STAR WARS");
    }

}
