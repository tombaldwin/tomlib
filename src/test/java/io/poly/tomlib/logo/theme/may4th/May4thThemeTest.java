package io.poly.tomlib.logo.theme.may4th;

import io.poly.tomlib.logo.LogoPrinter;
import io.poly.tomlib.logo.ThemeRegistry;
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
        LogoPrinter printer = new LogoPrinter("STAR WARS");

        System.out.println("--- Normal May 4th Theme ---");
        // We use a protected method or just use LogoPrinter to print with this theme
        // Since printLogoWithTheme is protected, we can't call it directly from here unless we are in the same package
        // or we use a subclass of LogoPrinter.

        TestLogoPrinter testPrinter = new TestLogoPrinter("STAR WARS");
        testPrinter.printWithTheme(false, theme);
    }

    @Test
    void printMay4thThemeGlitch() {
        May4thTheme theme = new May4thTheme();
        TestLogoPrinter testPrinter = new TestLogoPrinter("STAR WARS");

        System.out.println("--- Glitch May 4th Theme ---");
        testPrinter.printWithTheme(true, theme);
    }

    private static class TestLogoPrinter extends LogoPrinter {
        TestLogoPrinter(String text) {
            super(text);
        }

        void printWithTheme(boolean glitchMode, io.poly.tomlib.logo.Theme theme) {
            super.printLogoWithTheme(glitchMode, theme);
        }
    }
}
