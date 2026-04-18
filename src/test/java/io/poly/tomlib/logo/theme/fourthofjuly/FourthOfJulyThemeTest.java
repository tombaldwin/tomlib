package io.poly.tomlib.logo.theme.fourthofjuly;

import io.poly.tomlib.logo.LogoPrinter;
import io.poly.tomlib.logo.ThemeRegistry;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

/// Tests for the 4th of July theme.
class FourthOfJulyThemeTest {

    @Test
    void hasCorrectProperties() {
        FourthOfJulyTheme theme = ThemeRegistry.getTheme(FourthOfJulyTheme.class).orElseThrow();
        assertEquals("4th of July", theme.getName());
        assertEquals(30, theme.getPriority());
    }

    @Test
    void isActiveOnFourthOfJuly() {
        FourthOfJulyTheme theme = new FourthOfJulyTheme();
        assertTrue(theme.isActive(LocalDate.of(2024, 7, 4)));
        assertFalse(theme.isActive(LocalDate.of(2024, 7, 3)));
        assertFalse(theme.isActive(LocalDate.of(2024, 7, 5)));
    }

    @Test
    void printFourthOfJulyTheme() {
        FourthOfJulyTheme theme = new FourthOfJulyTheme();
        TestLogoPrinter printer = new TestLogoPrinter("USA");

        System.out.println("--- Normal 4th of July Theme ---");
        printer.printWithTheme(false, theme);
    }

    @Test
    void printFourthOfJulyThemeGlitch() {
        FourthOfJulyTheme theme = new FourthOfJulyTheme();
        TestLogoPrinter printer = new TestLogoPrinter("USA");

        System.out.println("--- Glitch 4th of July Theme ---");
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
