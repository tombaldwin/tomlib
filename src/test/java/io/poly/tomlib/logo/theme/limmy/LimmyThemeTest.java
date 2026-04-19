package io.poly.tomlib.logo.theme.limmy;

import io.poly.tomlib.logo.Theme;
import io.poly.tomlib.logo.ThemeRegistry;
import io.poly.tomlib.logo.AbstractMascot;
import io.poly.tomlib.logo.theme.limmy.LimmyTheme;
import io.poly.tomlib.logo.theme.limmy.mascot.LimmyMascot;
import io.poly.tomlib.logo.theme.limmy.mascot.DeeDeeMascot;
import io.poly.tomlib.logo.theme.limmy.mascot.JacquelineMcCaffertyMascot;
import io.poly.tomlib.logo.theme.limmy.mascot.RaymondDayMascot;
import io.poly.tomlib.logo.theme.limmy.mascot.AdventureCallMascot;
import io.poly.tomlib.logo.theme.limmy.mascot.SteelMascot;
import io.poly.tomlib.logo.theme.ThemeTestUtils;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/// Tests for the Limmy theme.
class LimmyThemeTest {

    @Test
    void themeHasCorrectName() {
        LimmyTheme theme = new LimmyTheme();
        assertEquals("Limmy", theme.getName());
    }

    @Test
    void printLimmyTheme() {
        LimmyTheme theme = new LimmyTheme();
        ThemeTestUtils.printTheme(theme, "LIMMY");
    }

    @Test
    void printLimmyThemeAllMascots() {
        LimmyTheme theme = new LimmyTheme();
        ThemeTestUtils.printThemeAllMascots(theme, "LIMMY");
    }

    @Test
    void themeHasMascots() {
        LimmyTheme theme = new LimmyTheme();
        List<AbstractMascot> normalMascots = theme.getMascots(false);
        assertFalse(normalMascots.isEmpty(), "Limmy theme should have mascots");
        assertTrue(normalMascots.stream().anyMatch(m -> m instanceof LimmyMascot), "Should contain Limmy mascot in normal mode");
        assertTrue(normalMascots.stream().anyMatch(m -> m instanceof JacquelineMcCaffertyMascot), "Should contain Jacqueline McCafferty mascot in normal mode");
        assertTrue(normalMascots.stream().anyMatch(m -> m instanceof RaymondDayMascot), "Should contain Raymond Day mascot in normal mode");
        assertTrue(normalMascots.stream().anyMatch(m -> m instanceof AdventureCallMascot), "Should contain Adventure Call (Falconhoof) mascot in normal mode");
        assertTrue(normalMascots.stream().anyMatch(m -> m instanceof SteelMascot), "Should contain Steel vs Feathers mascot in normal mode");

        List<AbstractMascot> glitchMascots = theme.getMascots(true);
        assertEquals(1, glitchMascots.size(), "Limmy theme should have exactly one mascot in glitch mode");
        assertTrue(glitchMascots.get(0) instanceof DeeDeeMascot, "DeeDee should be the exclusive glitch mascot");
    }

    @Test
    void mascotHasQuotes() {
        AbstractMascot mascot = new LimmyMascot();
        List<String> quotes = mascot.getQuotes();
        assertFalse(quotes.isEmpty(), "Mascot should have quotes");
        assertTrue(quotes.contains("Requiem!"), "Should contain signature quote");
    }

    @Test
    void logoColourIsConsistent() {
        Theme theme = new LimmyTheme();
        int[] darkPurple = theme.getLogoColour('A', 0, 0, false);
        int[] lightPurple = theme.getLogoColour('A', 0, 2, false);
        int[] purple = theme.getLogoColour('A', 0, 3, false);
        int[] white = theme.getLogoColour('A', 2, 2, false);
        int[] background = theme.getLogoColour('A', 3, 3, false);

        assertArrayEquals(new int[]{80, 0, 80}, darkPurple, "Row 0, Col 0 should be dark purple intersection");
        assertArrayEquals(new int[]{192, 128, 192}, lightPurple, "Row 0, Col 2 should be light purple intersection");
        assertArrayEquals(new int[]{128, 0, 128}, purple, "Row 0, Col 3 should be purple stripe");
        assertArrayEquals(new int[]{255, 255, 255}, white, "Row 2, Col 2 should be white intersection");
        assertArrayEquals(new int[]{100, 100, 100}, background, "Row 3, Col 3 should be grey background");
    }

    @Test
    void glitchColourIsTrippy() {
        Theme theme = new LimmyTheme();
        int[] colourNormal = theme.getLogoColour('A', 0, 0, false);
        int[] colourGlitch = theme.getLogoColour('A', 0, 0, true);

        assertArrayEquals(new int[]{80, 0, 80}, colourNormal, "Normal colour should be dark purple intersection");
        assertFalse(java.util.Arrays.equals(colourNormal, colourGlitch), "Glitch colour should be different from normal colour");

        // Check another position to ensure it's shifting
        int[] colourGlitch2 = theme.getLogoColour('A', 1, 1, true);
        assertFalse(java.util.Arrays.equals(colourGlitch, colourGlitch2), "Glitch colours should shift with position");
    }

    @Test
    void glitchNoiseIsTrippy() {
        Theme theme = new LimmyTheme();
        assertTrue(((io.poly.tomlib.logo.AbstractTheme)theme).noiseCount() > 0, "Should have noise in glitch mode");
        char noise = ((io.poly.tomlib.logo.AbstractTheme)theme).glitchNoise();
        assertTrue("§±¶†‡∞◊○◌".indexOf(noise) >= 0, "Should use trippy noise characters");
    }

    @Test
    void themeIsRegistered() {
        ThemeRegistry.clearCache();
        java.util.Collection<Theme> themes = ThemeRegistry.getThemes().values();
        boolean found = themes.stream()
                .anyMatch(t -> "Limmy".equals(t.getName()));
        assertTrue(found, "LimmyTheme should be registered in ThemeRegistry");
    }

    @Test
    void themeHasTagline() {
        Theme theme = new LimmyTheme();
        String normalTagline = theme.getTagLine(false);
        String glitchTagline = theme.getTagLine(true);

        assertNotNull(normalTagline, "Normal tagline should not be null");
        assertNotNull(glitchTagline, "Glitch tagline should not be null");
        assertTrue(normalTagline.contains("\u001B[38;2;128;0;128m"), "Normal tagline should have purple colour");
        assertTrue(glitchTagline.contains("\u001B[31m"), "Glitch tagline should have red colour");
    }
}
