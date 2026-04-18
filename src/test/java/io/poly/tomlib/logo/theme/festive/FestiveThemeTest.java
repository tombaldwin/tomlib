package io.poly.tomlib.logo.theme.festive;

import io.poly.tomlib.logo.LogoPrinter;
import io.poly.tomlib.logo.ThemeRegistry;
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
        TestLogoPrinter printer = new TestLogoPrinter("FESTIVE");

        System.out.println("--- Normal Festive Theme ---");
        printer.printWithTheme(false, theme);
    }

    @Test
    void printFestiveThemeGlitch() {
        FestiveTheme theme = new FestiveTheme();
        TestLogoPrinter printer = new TestLogoPrinter("FESTIVE");

        System.out.println("--- Glitch Festive Theme ---");
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
