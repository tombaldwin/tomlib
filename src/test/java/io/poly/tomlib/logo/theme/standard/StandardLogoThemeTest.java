package io.poly.tomlib.logo.theme.standard;

import io.poly.tomlib.logo.LogoPrinter;
import io.poly.tomlib.logo.ThemeRegistry;
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
        TestLogoPrinter printer = new TestLogoPrinter("TOMLIB");

        System.out.println("--- Normal Standard Theme ---");
        printer.printWithTheme(false, theme);
    }

    @Test
    void printStandardThemeGlitch() {
        StandardLogoTheme theme = new StandardLogoTheme();
        TestLogoPrinter printer = new TestLogoPrinter("TOMLIB");

        System.out.println("--- Glitch Standard Theme ---");
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
