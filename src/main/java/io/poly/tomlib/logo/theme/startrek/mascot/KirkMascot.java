package io.poly.tomlib.logo.theme.startrek.mascot;

import io.poly.tomlib.logo.AbstractMascot;

/// Mascot representing Captain Kirk.
public class KirkMascot extends AbstractMascot {

    @Override
    public String[] getArt() {
        return new String[]{
            "  ___  ",
            " / _ \\ ",
            "| o o |",
            " \\_-_/ ",
            " /| |\\ ",
            " /   \\ "
        };
    }

    @Override
    public int[] getColour(char c, int row, int col) {
        if (row <= 3) {
            if (c == 'o') return new int[]{0, 0, 255}; // Blue eyes
            return new int[]{255, 220, 180}; // Skin tone
        }
        return new int[]{255, 215, 0}; // Command Yellow
    }

    private static final java.util.List<String> QUOTES = java.util.List.of(
        "Space: the final frontier.",
        "Set phasers to stun.",
        "Beam me up, Scotty.",
        "Boldly go where no man has gone before.",
        "KHAAAN!"
    );

    @Override
    public java.util.List<String> getQuotes() {
        return QUOTES;
    }
}
