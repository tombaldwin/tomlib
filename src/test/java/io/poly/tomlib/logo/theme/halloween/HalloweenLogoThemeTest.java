package io.poly.tomlib.logo.theme.halloween;

import io.poly.tomlib.logo.ThemeRegistry;
import io.poly.tomlib.logo.theme.ThemeTestUtils;
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
        System.out.println("--- Halloween Theme (Variant 0) ---");
        theme.setVariant(0);
        ThemeTestUtils.printTheme(theme, "BOO!");

        System.out.println("\n--- Halloween Theme (Variant 1) ---");
        theme.setVariant(1);
        ThemeTestUtils.printTheme(theme, "BOO!");
    }
}
