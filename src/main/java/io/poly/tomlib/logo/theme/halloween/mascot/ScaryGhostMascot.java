package io.poly.tomlib.logo.theme.halloween.mascot;

import io.poly.tomlib.logo.AbstractMascot;

/// Halloween Mascot: Scary Ghost
public class ScaryGhostMascot extends AbstractMascot {
    @Override
    public String[] getArt() {
        return new String[] {
            " ,.  ",
            "(0  0)",
            " ) { (",
            " \"\"\" "
        };
    }

    @Override
    public int[] getColour(char c, int row, int col) {
        return new int[]{255, 255, 255}; // White ghost
    }

    private static final java.util.List<String> QUOTES = java.util.List.of(
        "I'm watching you...",
        "Run if you can!",
        "I'm a tall shadow in the dark.",
        "You can't escape the spooky!",
        "Did you hear that noise?"
    );

    @Override
    public java.util.List<String> getQuotes() {
        return QUOTES;
    }
}
