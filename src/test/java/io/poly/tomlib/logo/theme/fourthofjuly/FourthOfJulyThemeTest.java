package io.poly.tomlib.logo.theme.fourthofjuly;

import io.poly.tomlib.logo.ThemeRegistry;
import io.poly.tomlib.logo.theme.ThemeTestUtils;
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
        ThemeTestUtils.printTheme(theme, "USA");
    }
}
