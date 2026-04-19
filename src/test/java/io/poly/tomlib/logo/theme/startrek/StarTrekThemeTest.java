package io.poly.tomlib.logo.theme.startrek;

import io.poly.tomlib.logo.theme.ThemeTestUtils;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

/// Unit tests for StarTrekTheme.
public class StarTrekThemeTest {

    @Test
    void isActiveOnStarTrekDay() {
        StarTrekTheme theme = new StarTrekTheme();
        assertTrue(theme.isActive(LocalDate.of(2024, 9, 8)));
    }

    @Test
    void isNotActiveOnOtherDays() {
        StarTrekTheme theme = new StarTrekTheme();
        assertFalse(theme.isActive(LocalDate.of(2024, 9, 7)));
        assertFalse(theme.isActive(LocalDate.of(2024, 5, 4)));
    }

    @Test
    void hasCorrectPriority() {
        StarTrekTheme theme = new StarTrekTheme();
        assertEquals(25, theme.getPriority());
    }

    @Test
    void printStarTrekTheme() {
        ThemeTestUtils.printTheme(new StarTrekTheme(), "STAR TREK");
    }

    @Test
    void hasStarWarsGlitchMascotsButNotJarJar() {
        StarTrekTheme theme = new StarTrekTheme();
        java.util.List<io.poly.tomlib.logo.AbstractMascot> glitchMascots = theme.getMascots(true);
        assertFalse(glitchMascots.isEmpty(), "Star Trek theme should have glitch mascots");

        boolean hasStarWarsMascot = glitchMascots.stream()
            .anyMatch(m -> m.getClass().getName().contains("may4th.mascot"));
        assertTrue(hasStarWarsMascot, "Star Trek theme should have Star Wars glitch mascots");

        boolean hasJarJar = glitchMascots.stream()
            .anyMatch(m -> m.getClass().getSimpleName().equals("JarJarMascot"));
        assertFalse(hasJarJar, "Star Trek theme should not have JarJar glitch mascot");
    }

    @Test
    void hasCorrectGlitchMessage() {
        StarTrekTheme theme = new StarTrekTheme();
        assertEquals("[!] SUBSPACE INTERFERENCE DETECTED", theme.getGlitchMessage());
    }

}
