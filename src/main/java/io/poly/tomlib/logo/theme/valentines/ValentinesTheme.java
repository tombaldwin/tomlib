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
            arrayOf(LoveLetterMascot.class, ArrowMascot.class, HeartMascot.class),
            arrayOf(SkeletorMascot.class)
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
            return new String[]{"  *  ", "  D  ", "  I  ", "  E  ", "  !  ", "  +  "};
        }
        return new String[]{"  x  ", " o . ", "  v  ", " . e ", "  x  ", "  o  "};
    }

    @Override
    public String[] getStarsRight(boolean glitchMode) {
        if (glitchMode) {
            return new String[]{"  +  ", "  D  ", "  O  ", "  O  ", "  M  ", "  *  "};
        }
        return new String[]{"  x  ", " . o ", "  v  ", " e . ", "  x  ", " . o "};
    }

    @Override
    public int[] getLogoColour(char c, int row, int col, boolean glitchMode) {
        double factor = (row * 15.0 + col * 5.0) / 360.0;
        if (glitchMode) {
            int colourIndex = (int) (factor * 40) % 4;
            return switch (colourIndex) {
                case 0 -> new int[]{160, 0, 0};     // Blood Red
                case 1 -> new int[]{100, 0, 150};   // Deep Purple
                case 2 -> new int[]{200, 0, 0};     // Dark Red
                case 3 -> new int[]{255, 50, 50};   // Vivid Red
                default -> new int[]{255, 50, 50};
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
        if (glitchMode && !Character.isWhitespace(c)) {
            return new int[]{200, 0, 0}; // Dark Red for glitch stars
        }
        if (c == 'x' || c == 'o' || c == 'v' || c == 'e' || c == '.') {
            return new int[]{255, 105, 180}; // Hot Pink for Valentine
        }
        return super.getStarColour(c, row, col, glitchMode);
    }

    @Override
    public int noiseCount() {
        return glitchCorruption() ? rnd.nextInt(8) : super.noiseCount();
    }

    @Override
    public char glitchNoise() {
        return "X+#!?&^%$*".charAt(rnd.nextInt(10));
    }

    @Override
    public String[] getLogo(String logoText, boolean glitchMode) {
        String[] normalLogo = super.getLogo(logoText, glitchMode);
        if (!glitchMode) {
            return normalLogo;
        }

        // Corrupt the logo for Valentines glitch
        String[] corruptedLogo = new String[normalLogo.length];
        for (int i = 0; i < normalLogo.length; i++) {
            StringBuilder sb = new StringBuilder(normalLogo[i]);
            for (int j = 0; j < sb.length(); j++) {
                char c = sb.charAt(j);
                if (!Character.isWhitespace(c)) {
                    // 1 in 4 chance to corrupt a logo character with a thematic symbol
                    if (rnd.nextInt(4) == 0) {
                        sb.setCharAt(j, "X+#!?&^%$*".charAt(rnd.nextInt(10)));
                    }
                    // 1 in 10 chance to shift a character's case or slightly distort it
                    else if (rnd.nextInt(10) == 0) {
                        if (Character.isUpperCase(c)) sb.setCharAt(j, Character.toLowerCase(c));
                        else if (Character.isLowerCase(c)) sb.setCharAt(j, Character.toUpperCase(c));
                    }
                }
            }
            corruptedLogo[i] = sb.toString();
        }
        return corruptedLogo;
    }

    @Override
    public String getGlitchMessage() {
        return "[!] SKELETOR SAYS: " + MascotRegistry.getMascot(SkeletorMascot.class).getQuote();
    }

    @Override
    public void addNoiseColour(StringBuilder colouredLine, int row, int col, char c, boolean glitchMode) {
        if (glitchMode) {
            // Evil but readable colours for Valentine glitch
            int[] rgb = switch (rnd.nextInt(5)) {
                case 0 -> new int[]{180, 50, 50};   // Lightened Dark Red
                case 1 -> new int[]{150, 50, 200};  // Lightened Indigo
                case 2 -> new int[]{200, 50, 200};  // Lightened Magenta
                case 3 -> new int[]{150, 0, 0};     // Medium Red
                default -> new int[]{255, 0, 0};    // Pure Red
            };
            colouredLine.append(String.format("\u001B[38;2;%d;%d;%dm%c\u001B[0m", rgb[0], rgb[1], rgb[2], c));
        }
    }

}
