package io.poly.tomlib.logo.theme.standard;

import io.poly.tomlib.logo.ThemeRegistry;
import io.poly.tomlib.logo.theme.ThemeTestUtils;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

/// Tests for the Standard theme.
class StandardLogoThemeTest {

    @Test
    void hasCorrectProperties() {
        StandardLogoTheme theme = ThemeRegistry.getTheme(StandardLogoTheme.class).orElseThrow();
        assertEquals("Standard", theme.getName());
        assertEquals(0, theme.getPriority());
        assertEquals(0.2f, theme.getMascotProbability(), 0.001f);
    }

    @Test
    void isActiveAlways() {
        StandardLogoTheme theme = new StandardLogoTheme();
        assertTrue(theme.isActive(LocalDate.now()));
        assertTrue(theme.isActive(LocalDate.of(2024, 1, 1)));
    }

    @Test
    void printStandardTheme() {
        StandardLogoTheme theme = new StandardLogoTheme();
        ThemeTestUtils.printTheme(theme, "TOMLIB");
    }
}
