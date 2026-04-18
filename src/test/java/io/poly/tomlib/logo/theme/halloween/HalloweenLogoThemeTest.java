package io.poly.tomlib.logo.theme.halloween;

import io.poly.tomlib.logo.LogoPrinter;
import io.poly.tomlib.logo.ThemeRegistry;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

/// Tests for the Halloween theme.
class HalloweenLogoThemeTest {

    @Test
    void hasCorrectProperties() {
        HalloweenLogoTheme theme = ThemeRegistry.getTheme(HalloweenLogoTheme.class).orElseThrow();
        assertEquals("Halloween", theme.getName());
        assertEquals(10, theme.getPriority());
    }

    @Test
    void isActiveOnHalloween() {
        HalloweenLogoTheme theme = new HalloweenLogoTheme();
        assertTrue(theme.isActive(LocalDate.of(2024, 10, 31)));
        assertFalse(theme.isActive(LocalDate.of(2024, 10, 30)));
        assertFalse(theme.isActive(LocalDate.of(2024, 11, 1)));
    }

    @Test
    void printHalloweenTheme() {
        HalloweenLogoTheme theme = new HalloweenLogoTheme();
        TestLogoPrinter printer = new TestLogoPrinter("BOO!");

        System.out.println("--- Normal Halloween Theme (Variant 0) ---");
        theme.setVariant(0);
        printer.printWithTheme(false, theme);

        System.out.println("--- Normal Halloween Theme (Variant 1) ---");
        theme.setVariant(1);
        printer.printWithTheme(false, theme);
    }

    @Test
    void printHalloweenThemeGlitch() {
        HalloweenLogoTheme theme = new HalloweenLogoTheme();
        TestLogoPrinter printer = new TestLogoPrinter("BOO!");

        System.out.println("--- Glitch Halloween Theme ---");
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
