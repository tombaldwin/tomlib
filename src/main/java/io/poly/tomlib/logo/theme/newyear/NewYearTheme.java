package io.poly.tomlib.logo.theme.newyear;

import io.poly.tomlib.logo.AbstractTheme;
import io.poly.tomlib.logo.theme.newyear.mascot.ChampagneBottleMascot;
import io.poly.tomlib.logo.theme.newyear.mascot.ChampagneGlassMascot;
import io.poly.tomlib.logo.theme.newyear.mascot.FireworksMascot;
import io.poly.tomlib.logo.theme.newyear.mascot.PartyHatMascot;

import java.time.LocalDate;

import static io.poly.tomlib.logo.theme.easter.EasterTheme.arrayOf;

/// Theme for New Year's celebrations (31st Dec - 1st Jan).
public class NewYearTheme extends AbstractTheme {

    /// Default constructor.
    public NewYearTheme() {
        super(
            "New Year",
            arrayOf(ChampagneGlassMascot.class, FireworksMascot.class, PartyHatMascot.class, ChampagneBottleMascot.class),
            arrayOf(ChampagneGlassMascot.class, FireworksMascot.class, PartyHatMascot.class, ChampagneBottleMascot.class)
        );
    }

    @Override
    public boolean isActive(LocalDate date) {
        return (date.getMonthValue() == 12 && date.getDayOfMonth() == 31) ||
               (date.getMonthValue() == 1 && date.getDayOfMonth() == 1);
    }

    @Override
    public String getActivationRule() {
        return "Active on New Year's Eve and New Year's Day (31st December - 1st January).";
    }

    @Override
    public int getPriority() {
        return 20;
    }

    @Override
    public String[] getStarsLeft(boolean glitchMode) {
        if (glitchMode) {
            return new String[]{" \\ / ", "- * -", " / \\ ", "  |  ", "  |  ", "     "};
        }
        return super.getStarsLeft(glitchMode);
    }

    @Override
    public String[] getStarsRight(boolean glitchMode) {
        if (glitchMode) {
            return new String[]{" \\ / ", "- * -", " / \\ ", "  |  ", "  |  ", "     "};
        }
        return super.getStarsRight(glitchMode);
    }

    @Override
    public int[] getLogoColour(char c, int row, int col, boolean glitchMode) {
        // New Year colours: Gold, Silver, White
        double factor = (row * 15.0 + col * 5.0) / 360.0;
        int colourIndex = (int) (factor * 30) % 3; // Cycles through 3 colours

        return switch (colourIndex) {
            case 0 -> new int[]{255, 215, 0};   // Gold
            case 1 -> new int[]{192, 192, 192}; // Silver
            case 2 -> new int[]{255, 255, 255}; // White
            default -> new int[]{255, 215, 0};
        };
    }

    @Override
    public int[] getStarColour(char c, int row, int col, boolean glitchMode) {
        if (c == '*' || c == '+' || c == '.' || c == '\\' || c == '/' || c == '-' || c == '|') {
            if (glitchMode) {
                // Multi-colour fireworks for glitch mode
                return switch (rnd.nextInt(4)) {
                    case 0 -> new int[]{255, 255, 0};   // Yellow
                    case 1 -> new int[]{0, 255, 255};   // Cyan
                    case 2 -> new int[]{255, 0, 255};   // Magenta
                    default -> new int[]{255, 255, 255}; // White
                };
            } else if (c == '*' || c == '+' || c == '.') {
                // Gold or Silver for New Year "sparkles"
                return rnd.nextBoolean() ? new int[]{255, 215, 0} : new int[]{192, 192, 192};
            }
        }
        return super.getStarColour(c, row, col, glitchMode);
    }

    @Override
    public char glitchNoise() {
        return "\\|/-*+x.o".charAt(rnd.nextInt(9));
    }

    @Override
    public int noiseCount() {
        return rnd.nextInt(10) + 5;
    }

    @Override
    public void addNoiseColour(StringBuilder colouredLine, int row, int col, char c, boolean glitchMode) {
        if (glitchMode) {
            // Multi-colour noise for New Year fireworks
            int[] rgb = getStarColour('*', row, col, true);
            colouredLine.append(String.format("\u001B[38;2;%d;%d;%dm%c\u001B[0m", rgb[0], rgb[1], rgb[2], c));
        }
    }

    @Override
    public boolean glitchCorruption() {
        return false;
    }
}
