package io.poly.tomlib.logo.theme.easter;

import io.poly.tomlib.logo.AbstractTheme;
import io.poly.tomlib.logo.MascotRegistry;
import io.poly.tomlib.logo.theme.easter.mascot.*;

import io.poly.tomlib.util.DateUtils;

import java.util.Random;

/// Easter theme for the Easter weekend.
public class EasterTheme extends AbstractTheme {

    /// Creates a new EasterTheme.
    public EasterTheme() {
        super(
            "Easter",
            arrayOf(EggMascot.class, BunnyMascot.class, ChickMascot.class, BasketMascot.class),
            arrayOf(BrokenEggMascot.class)
        );
    }

    @SafeVarargs
    public static <T, V extends T> T[] arrayOf(V... array) {
        return array;
    }

    @Override
    public String[] getStarsLeft(boolean glitchMode) {
        return new String[]{"  ~  ", " o . ", "  ~  ", " . o ", "  ~  ", "  o  "};
    }

    @Override
    public String[] getStarsRight(boolean glitchMode) {
        return new String[]{"  ~  ", " . o ", "  ~  ", " o . ", "  ~  ", " . o "};
    }

    @Override
    public int[] getLogoColour(char c, int row, int col, boolean glitchMode) {
        if (glitchMode) {
            if (new Random().nextInt(20) == 0) {
                return new int[]{255, 255, 0}; // Yellow yolk splash
            } else {
                return new int[]{200, 200, 200}; // Grey shell
            }
        } else {
            double factor = (row * 15.0 + col * 5.0) / 360.0;
            int colourIndex = (int) (factor * 50) % 5;

            return switch (colourIndex) {
                case 0 -> new int[]{173, 216, 230}; // Baby Blue
                case 1 -> new int[]{144, 238, 144}; // Mint Green
                case 2 -> new int[]{255, 182, 193}; // Light Pink
                case 3 -> new int[]{230, 230, 250}; // Lavender
                case 4 -> new int[]{255, 255, 224}; // Pale Yellow
                default -> new int[]{255, 255, 255};
            };
        }
    }

    @Override
    public int[] getStarColour(char c, int row, int col, boolean glitchMode) {
        if (c == '~' || c == 'o' || c == '.') {
            // Pastel colours for Easter stars
            return switch (new Random().nextInt(3)) {
                case 0 -> new int[]{173, 216, 230}; // Blue
                case 1 -> new int[]{255, 182, 193}; // Pink
                default -> new int[]{144, 238, 144}; // Green
            };
        }
        return super.getStarColour(c, row, col, glitchMode);
    }

    @Override
    public boolean isActive(java.time.LocalDate date) {
        return DateUtils.isEasterWeekend(date);
    }

    @Override
    public int getPriority() {
        return 5;
    }

    @Override
    public String getGlitchMessage() {
        return "[!] GLITCH DET-EGG-TED: " + MascotRegistry.getMascot(BunnyMascot.class).getQuote();
    }

    @Override
    public boolean glitchDistortion() {
        return false;
    }

    @Override
    public boolean glitchCorruption() {
        return false;
    }
}
