package io.poly.tomlib.logo.theme.standard;

import io.poly.tomlib.logo.AbstractTheme;
import io.poly.tomlib.logo.theme.standard.mascot.CatMascot;

import java.time.LocalDate;

import static io.poly.tomlib.logo.theme.easter.EasterTheme.arrayOf;

/// Standard theme for LogoPrinter, providing the default ASCII font logo.
/// This theme exhibits distinct glitch behaviour, including shearing, corruption, and noise.
public class StandardLogoTheme extends AbstractTheme {

    /// Creates a new instance of StandardLogoTheme.
    public StandardLogoTheme() {
        super(
            "Standard",
            arrayOf(CatMascot.class),
            arrayOf()
        );
    }

    @Override
    public float getMascotProbability() {
        return 0.2f;
    }

    @Override
    public int[] getLogoColour(char c, int row, int col, boolean glitchMode) {
        if (glitchMode && rnd.nextInt(5) == 0) {
            // Intense red/white glitches for Standard theme
            return rnd.nextBoolean() ? new int[]{255, 0, 0} : new int[]{255, 255, 255};
        }
        return super.getLogoColour(c, row, col, glitchMode);
    }

    /// Gets the colour for a star character in the Standard theme.
    @Override
    public int[] getStarColour(char c, int row, int col, boolean glitchMode) {
        if (glitchMode && rnd.nextInt(3) == 0) {
            return new int[]{255, 0, 0}; // Glitch stars turn red
        }
        return super.getStarColour(c, row, col, glitchMode);
    }

    @Override
    public void addNoiseColour(StringBuilder colouredLine, int row, int col, char c, boolean glitchMode) {
        if (glitchMode && rnd.nextInt(4) == 0) {
            // Occasional red noise for extra corruption feel
            colouredLine.append(String.format("\u001B[38;2;%d;%d;%dm%c\u001B[0m", 255, 0, 0, c));
        } else {
            super.addNoiseColour(colouredLine, row, col, c, glitchMode);
        }
    }

    @Override
    public char glitchNoise() {
        return "░▒▓$@#%&*~!?".charAt(rnd.nextInt(12));
    }

    @Override
    public int noiseCount() {
        return rnd.nextInt(20) + 10; // Even more aggressive noise for Standard theme
    }

    @Override
    public String getGlitchMessage() {
        return "[!] SYSTEM CORRUPTION DETECTED";
    }

    @Override
    public boolean isActive(LocalDate date) {
        // Standard theme is always a fallback, but we can mark it as active
        // if no other seasonal theme matches.
        return true;
    }

    @Override
    public String getActivationRule() {
        return "Always active as a fallback theme.";
    }
}
