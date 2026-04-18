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

    @Override
    public String getQuote() {
        String[] quotes = {
            "Booo!",
            "Did I scare you?",
            "I'm just a classic ghost.",
            "Spooky season is here!",
            "I'm transparently friendly."
        };
        return quotes[new java.util.Random().nextInt(quotes.length)];
    }
}
