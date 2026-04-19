package io.poly.tomlib.logo.theme.limmy;

import io.poly.tomlib.logo.AbstractMascot;
import io.poly.tomlib.logo.AbstractTheme;
import io.poly.tomlib.logo.theme.limmy.mascot.*;
import java.time.LocalDate;

import static io.poly.tomlib.logo.theme.easter.EasterTheme.arrayOf;

/// Theme for Limmy, featuring his characters and memes.
public class LimmyTheme extends AbstractTheme {

    private final ThreadLocal<AbstractMascot> currentMascot = new ThreadLocal<>();
    private final ThreadLocal<Boolean> currentGlitchMode = new ThreadLocal<>();

    public LimmyTheme() {
        super(
            "Limmy",
            arrayOf(LimmyMascot.class, SteelMascot.class, AdventureCallMascot.class, JacquelineMcCaffertyMascot.class, RaymondDayMascot.class),
            arrayOf(DeeDeeMascot.class)
        );
    }

    @Override
    public int[] getLogoColour(char c, int row, int col, boolean glitchMode) {
        if (glitchMode) {
            // Drug-addled DeeDee colours: chaotic and trippy
            int r = (int) (Math.sin(row * 0.5 + col * 0.3) * 127 + 128);
            int g = (int) (Math.cos(row * 0.2 + col * 0.4) * 127 + 128);
            int b = (int) (Math.sin(row * 0.1 - col * 0.5) * 127 + 128);
            return new int[]{r, g, b};
        }

        // Symmetric tartan pattern for Limmy
        int sett = 4;
        int r = row % sett;
        int cl = col % sett;

        // P P W G pattern in both directions
        boolean hPurple = (r == 0 || r == 1);
        boolean hWhite = (r == 2);
        boolean vPurple = (cl == 0 || cl == 1);
        boolean vWhite = (cl == 2);

        if (hPurple && vPurple) {
            return new int[]{80, 0, 80}; // Dark Purple intersection
        }
        if (hWhite && vWhite) {
            return new int[]{255, 255, 255}; // White intersection
        }
        if ((hPurple && vWhite) || (hWhite && vPurple)) {
            return new int[]{192, 128, 192}; // Light Purple intersection
        }
        if (hPurple || vPurple) {
            return new int[]{128, 0, 128}; // Purple stripe
        }
        if (hWhite || vWhite) {
            return new int[]{255, 255, 255}; // White stripe
        }
        return new int[]{100, 100, 100}; // Grey background
    }

    @Override
    public int noiseCount() {
        // More noise for a drug-addled state
        return super.noiseCount() + 3;
    }

    @Override
    public char glitchNoise() {
        // Trippy noise characters (using single-char symbols)
        return "§±¶†‡∞◊○◌".charAt(new java.util.Random().nextInt(9));
    }

    @Override
    public int[] getStarColour(char c, int row, int col, boolean glitchMode) {
        if (glitchMode) {
            // Stars also get trippy colours in drug-addled state
            return getLogoColour(c, row, col, true);
        }
        return super.getStarColour(c, row, col, false);
    }

    @Override
    public io.poly.tomlib.logo.AbstractMascot getMascot(boolean glitchMode) {
        if (currentMascot.get() == null || currentGlitchMode.get() == null || currentGlitchMode.get() != glitchMode) {
            currentMascot.set(super.getMascot(glitchMode));
            currentGlitchMode.set(glitchMode);
        }
        return currentMascot.get();
    }

    @Override
    public String getGlitchMessage() {
        return getMascot(true).getQuote();
    }

    @Override
    public String getTagLine(boolean glitchMode) {
        if (glitchMode) {
            return "\u001B[31m" + getGlitchMessage() + "\u001B[0m";
        }
        return "\u001B[38;2;128;0;128m" + getMascot(false).getQuote() + "\u001B[0m";
    }

    @Override
    public boolean isActive(LocalDate date) {
        // Limmy theme is for when you want a laugh, not tied to a date
        return false;
    }

    @Override
    public String getActivationRule() {
        return "Manual activation only.";
    }

    @Override
    public int getPriority() {
        return 10;
    }
}
