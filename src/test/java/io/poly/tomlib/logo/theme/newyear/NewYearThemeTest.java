package io.poly.tomlib.logo.theme.newyear;

import io.poly.tomlib.logo.LogoPrinter;
import io.poly.tomlib.logo.ThemeRegistry;
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
        TestLogoPrinter printer = new TestLogoPrinter("HAPPY 2025");

        System.out.println("--- Normal New Year Theme ---");
        printer.printWithTheme(false, theme);
    }

    @Test
    void printNewYearThemeGlitch() {
        NewYearTheme theme = new NewYearTheme();
        TestLogoPrinter printer = new TestLogoPrinter("HAPPY 2025");

        System.out.println("--- Glitch New Year Theme ---");
        printer.printWithTheme(true, theme);
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
