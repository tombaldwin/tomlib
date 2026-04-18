package io.poly.tomlib.logo.theme.startrek.mascot;

import io.poly.tomlib.logo.AbstractMascot;

/// Mascot representing Spock.
public class SpockMascot extends AbstractMascot {

    @Override
    public String[] getArt() {
        return new String[]{
            "   ___  ",
            ". / _ \\ . ",
            "'| o o |'",
            "  \\_-_/ ",
            "  /| |\\ ",
            "  /   \\ "
        };
    }

    @Override
    public int[] getColour(char c, int row, int col) {
        if (row <= 3) {
            if (c == 'o') return new int[]{150, 0, 255}; // Blu-ish purple eyes
            if (c == '<' || c == '>') return new int[]{255, 220, 180}; // Pointy ears
            return new int[]{255, 220, 180}; // Skin tone
        }
        return new int[]{0, 100, 255}; // Science Blue
    }

    private static final java.util.List<String> QUOTES = java.util.List.of(
        "Live long and prosper.",
        "Fascinating.",
        "Logic is the beginning of wisdom, not the end.",
        "Highly illogical.",
        "The needs of the many outweigh the needs of the few."
    );

    @Override
    public java.util.List<String> getQuotes() {
        return QUOTES;
    }
}
