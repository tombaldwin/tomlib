package io.poly.tomlib.logo.theme.valentines;

import io.poly.tomlib.logo.LogoPrinter;
import io.poly.tomlib.logo.ThemeRegistry;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

/// Tests for the Valentines theme.
class ValentinesThemeTest {

    @Test
    void hasCorrectProperties() {
        ValentinesTheme theme = ThemeRegistry.getTheme(ValentinesTheme.class).orElseThrow();
        assertEquals("Valentines", theme.getName());
        assertEquals(5, theme.getPriority());
    }

    @Test
    void isActiveOnValentinesDay() {
        ValentinesTheme theme = new ValentinesTheme();
        assertTrue(theme.isActive(LocalDate.of(2024, 2, 14)));
        assertFalse(theme.isActive(LocalDate.of(2024, 2, 13)));
        assertFalse(theme.isActive(LocalDate.of(2024, 2, 15)));
    }

    @Test
    void printValentinesTheme() {
        ValentinesTheme theme = new ValentinesTheme();
        TestLogoPrinter printer = new TestLogoPrinter("LOVE");

        System.out.println("--- Normal Valentines Theme ---");
        printer.printWithTheme(false, theme);
    }

    @Test
    void printValentinesThemeGlitch() {
        ValentinesTheme theme = new ValentinesTheme();
        TestLogoPrinter printer = new TestLogoPrinter("LOVE");

        System.out.println("--- Glitch Valentines Theme ---");
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
