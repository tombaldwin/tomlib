package io.poly.tomlib.logo.theme.birthday;

import io.poly.tomlib.logo.LogoPrinter;
import io.poly.tomlib.logo.ThemeRegistry;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.MonthDay;

import static org.junit.jupiter.api.Assertions.*;

/// Tests for the Birthday theme.
class BirthdayThemeTest {

    @Test
    void hasCorrectProperties() {
        BirthdayTheme theme = ThemeRegistry.getTheme(BirthdayTheme.class).orElseThrow();
        assertEquals("Birthday", theme.getName());
        assertEquals(30, theme.getPriority());
    }

    @Test
    void isActiveOnBirthday() {
        // Since isActive depends on inferred birthday, we'll mock it via subclass if possible,
        // but let's see if we can just test with a custom date if we can control the inference.
        // Actually, let's just test that it returns true when dates match.

        BirthdayTheme theme = new BirthdayTheme() {
            @Override
            protected MonthDay getInferredBirthday() {
                return MonthDay.of(4, 18);
            }
        };

        assertTrue(theme.isActive(LocalDate.of(2026, 4, 18)));
        assertFalse(theme.isActive(LocalDate.of(2026, 4, 17)));
    }

    @Test
    void printBirthdayTheme() {
        BirthdayTheme theme = new BirthdayTheme() {
            @Override
            protected String getInferredName() { return "Tom"; }
            @Override
            protected MonthDay getInferredBirthday() { return MonthDay.of(4, 18); }
        };
        TestLogoPrinter printer = new TestLogoPrinter("HAPPY BIRTHDAY");

        System.out.println("--- Normal Birthday Theme ---");
        printer.printWithTheme(false, theme);
    }

    @Test
    void printBirthdayThemeGlitch() {
        BirthdayTheme theme = new BirthdayTheme() {
            @Override
            protected String getInferredName() { return "Tom"; }
            @Override
            protected MonthDay getInferredBirthday() { return MonthDay.of(4, 18); }
        };
        TestLogoPrinter printer = new TestLogoPrinter("HAPPY BIRTHDAY");

        System.out.println("--- Glitch Birthday Theme ---");
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
