package io.poly.tomlib.logo.theme.halloween.mascot;

import io.poly.tomlib.logo.AbstractMascot;

/// Halloween Mascot: Classic Ghost
public class ClassicGhostMascot extends AbstractMascot {
    @Override
    public String[] getArt() {
        return new String[] {
            " .-.  ",
            "( o o )",
            "|  V  |",
            "'VVVVV'"
        };
    }

    @Override
    public int[] getColour(char c, int row, int col) {
        return new int[]{255, 255, 255}; // White ghost
    }

    private static final java.util.List<String> QUOTES = java.util.List.of(
        "Booo!",
        "Did I scare you?",
        "I'm just a classic ghost.",
        "Spooky season is here!",
        "I'm transparently friendly."
    );

    @Override
    public java.util.List<String> getQuotes() {
        return QUOTES;
    }
}
