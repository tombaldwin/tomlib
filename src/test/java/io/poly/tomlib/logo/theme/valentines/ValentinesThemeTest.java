package io.poly.tomlib.logo.theme.valentines;

import io.poly.tomlib.logo.AbstractMascot;
import io.poly.tomlib.logo.ThemeRegistry;
import io.poly.tomlib.logo.theme.ThemeTestUtils;
import io.poly.tomlib.logo.theme.halloween.mascot.SkeletorMascot;
import io.poly.tomlib.logo.theme.valentines.mascot.ArrowMascot;
import io.poly.tomlib.logo.theme.valentines.mascot.HeartMascot;
import io.poly.tomlib.logo.theme.valentines.mascot.LoveLetterMascot;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

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
    void hasCorrectMascots() {
        ValentinesTheme theme = new ValentinesTheme();

        List<AbstractMascot> normalMascots = theme.getMascots(false);
        assertEquals(3, normalMascots.size());
        assertTrue(normalMascots.stream().anyMatch(m -> m instanceof LoveLetterMascot));
        assertTrue(normalMascots.stream().anyMatch(m -> m instanceof ArrowMascot));
        assertTrue(normalMascots.stream().anyMatch(m -> m instanceof HeartMascot));

        List<AbstractMascot> glitchMascots = theme.getMascots(true);
        assertEquals(1, glitchMascots.size());
        assertTrue(glitchMascots.stream().anyMatch(m -> m instanceof SkeletorMascot));
    }

    @Test
    void printValentinesTheme() {
        ValentinesTheme theme = new ValentinesTheme();
        ThemeTestUtils.printTheme(theme, "LOVE");
    }

    @Test
    void printValentinesThemeAllMascots() {
        ValentinesTheme theme = new ValentinesTheme();
        ThemeTestUtils.printThemeAllMascots(theme, "VALENTINES");
    }
}
