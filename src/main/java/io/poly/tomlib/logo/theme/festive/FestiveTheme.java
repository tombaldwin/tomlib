package io.poly.tomlib.logo.theme.festive;

import io.poly.tomlib.logo.AbstractMascot;
import io.poly.tomlib.logo.AbstractTheme;
import io.poly.tomlib.logo.MascotRegistry;
import io.poly.tomlib.logo.theme.festive.mascot.*;

import java.util.Random;

import static io.poly.tomlib.logo.theme.easter.EasterTheme.arrayOf;

/// Festive theme for the Christmas period.
public class FestiveTheme extends AbstractTheme {

    /// Creates a new FestiveTheme.
    public FestiveTheme() {
        super(
            "Festive",
            arrayOf(ReindeerMascot.class, TreeMascot.class, ElfMascot.class, GiftMascot.class, HappyGrinchMascot.class, SnowmanMascot.class),
            arrayOf(GrinchMascot.class));
    }

    @Override
    public String[] getStarsLeft(boolean glitchMode) {
        return new String[]{"  *  ", " * . ", "  .  ", " . * ", "  *  ", "  .  "};
    }

    @Override
    public String[] getStarsRight(boolean glitchMode) {
        return new String[]{"  *  ", " . * ", "  .  ", " * . ", "  *  ", " . * "};
    }

    @Override
    public int[] getLogoColour(char c, int row, int col, boolean glitchMode) {
        // Christmassy colours: Red, Green, White, Gold
        double factor = (row * 15.0 + col * 5.0) / 360.0;
        int colourIndex = (int) (factor * 40) % 4; // Cycles through 4 colours

        return switch (colourIndex) {
            case 0 -> new int[]{255, 0, 0};     // Red
            case 1 -> new int[]{0, 200, 0};     // Green
            case 2 -> new int[]{255, 255, 255}; // White
            case 3 -> new int[]{255, 215, 0};   // Gold
            default -> new int[]{255, 255, 255};
        };
    }

    @Override
    public int[] getStarColour(char c, int row, int col, boolean glitchMode) {
        if (c == '#' || c == '*' || c == '.') {
            return new int[]{220, 220, 220}; // Light Grey/White for snow
        }
        return super.getStarColour(c, row, col, glitchMode);
    }

    @Override
    public boolean isActive(java.time.LocalDate date) {
        return date.getMonthValue() == 12;
    }

    @Override
    public String getActivationRule() {
        return "Active throughout the month of December.";
    }

    @Override
    public int getPriority() {
        return 5;
    }

    @Override
    public String getGlitchMessage() {
        return "[!] GRINCH DETECTED: " + MascotRegistry.getMascot(GrinchMascot.class).getQuote();
    }

}
