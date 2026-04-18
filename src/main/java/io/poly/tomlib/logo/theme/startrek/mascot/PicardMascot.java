package io.poly.tomlib.logo.theme.startrek.mascot;

import io.poly.tomlib.logo.AbstractMascot;

/// Mascot representing Captain Picard.
public class PicardMascot extends AbstractMascot {

    @Override
    public String[] getArt() {
        return new String[]{
            "  ---  ",
            " / . \\ ",
            "| o o |",
            " \\ - / ",
            " /| |\\ ",
            " /   \\ "
        };
    }

    @Override
    public int[] getColour(char c, int row, int col) {
        if (row <= 3) {
            if (c == 'o') return new int[]{0, 100, 0}; // Green eyes
            return new int[]{255, 220, 180}; // Skin tone
        }
        return new int[]{255, 0, 0}; // Command Red
    }

    private static final java.util.List<String> QUOTES = java.util.List.of(
        "Make it so.",
        "Engage!",
        "Tea, Earl Grey, hot.",
        "There are four lights!",
        "Things are only impossible until they're not."
    );

    @Override
    public java.util.List<String> getQuotes() {
        return QUOTES;
    }
}
