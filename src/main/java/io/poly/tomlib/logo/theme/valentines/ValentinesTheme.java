package io.poly.tomlib.logo.theme.valentines;

import io.poly.tomlib.logo.AbstractTheme;
import io.poly.tomlib.logo.MascotRegistry;
import io.poly.tomlib.logo.theme.halloween.mascot.SkeletorMascot;
import io.poly.tomlib.logo.theme.valentines.mascot.ArrowMascot;
import io.poly.tomlib.logo.theme.valentines.mascot.HeartMascot;
import io.poly.tomlib.logo.theme.valentines.mascot.LoveLetterMascot;

import java.time.LocalDate;

import static io.poly.tomlib.logo.theme.easter.EasterTheme.arrayOf;

/// Theme for Valentine's Day.
public class ValentinesTheme extends AbstractTheme {

    /// Default constructor.
    public ValentinesTheme() {
        super("Valentines",
            arrayOf(SkeletorMascot.class),
            arrayOf(LoveLetterMascot.class, ArrowMascot.class, HeartMascot.class)
        );
    }

    @Override
    public boolean isActive(LocalDate date) {
        return date.getMonthValue() == 2 && date.getDayOfMonth() == 14;
    }

    @Override
    public String getActivationRule() {
        return "Active on Valentine's Day (14th February).";
    }

    @Override
    public int getPriority() {
        return 5;
    }

    @Override
    public String[] getStarsLeft(boolean glitchMode) {
        if (glitchMode) {
            return new String[]{"  !  ", " h # ", "  A  ", " # t ", "  e  ", "  X  "};
        }
        return new String[]{"  x  ", " o . ", "  v  ", " . e ", "  x  ", "  o  "};
    }

    @Override
    public String[] getStarsRight(boolean glitchMode) {
        if (glitchMode) {
            return new String[]{"  !  ", " # h ", "  X  ", " t # ", "  e  ", " # ? "};
        }
        return new String[]{"  x  ", " . o ", "  v  ", " e . ", "  x  ", " . o "};
    }

    @Override
    public int[] getLogoColour(char c, int row, int col, boolean glitchMode) {
        double factor = (row * 15.0 + col * 5.0) / 360.0;
        if (glitchMode) {
            int colourIndex = (int) (factor * 40) % 4;
            return switch (colourIndex) {
                case 0 -> new int[]{100, 0, 0};     // Dark Red
                case 1 -> new int[]{75, 0, 130};    // Indigo/Deep Purple
                case 2 -> new int[]{20, 0, 20};     // Near Black Purple
                case 3 -> new int[]{139, 0, 0};     // Blood Red
                default -> new int[]{139, 0, 0};
            };
        } else {
            int colourIndex = (int) (factor * 30) % 3;
            return switch (colourIndex) {
                case 0 -> new int[]{255, 0, 0};     // Red
                case 1 -> new int[]{255, 20, 147};  // Deep Pink
                case 2 -> new int[]{255, 182, 193}; // Light Pink
                default -> new int[]{255, 0, 0};
            };
        }
    }

    @Override
    public int[] getStarColour(char c, int row, int col, boolean glitchMode) {
        if (c == 'x' || c == 'o' || c == 'v' || c == 'e' || c == '.') {
            return glitchMode ? new int[]{255, 0, 0} : new int[]{255, 105, 180}; // Red if glitchy, Hot Pink for Valentine
        }
        return super.getStarColour(c, row, col, glitchMode);
    }

    @Override
    public String getGlitchMessage() {
        return "[!] SKELETOR SAYS: " + MascotRegistry.getMascot(SkeletorMascot.class).getQuote();
    }

    @Override
    public void addNoiseColour(StringBuilder colouredLine, int row, int col, char c, boolean glitchMode) {
        if (!glitchMode) {
            // Evil colours for Valentine glitch: Dark reds, purples, and deep blacks
            int[] rgb = switch (rnd.nextInt(5)) {
                case 0 -> new int[]{100, 0, 0};     // Dark Red
                case 1 -> new int[]{75, 0, 130};    // Indigo/Deep Purple
                case 2 -> new int[]{40, 0, 40};     // Deep Dark Purple/Black
                case 3 -> new int[]{60, 0, 0};      // Even Darker Red
                default -> new int[]{139, 0, 0};    // Blood Red
            };
            colouredLine.append(String.format("\u001B[38;2;%d;%d;%dm%c\u001B[0m", rgb[0], rgb[1], rgb[2], c));
        }
    }

    @Override
    public boolean glitchCorruption() {
        return false;
    }
}
