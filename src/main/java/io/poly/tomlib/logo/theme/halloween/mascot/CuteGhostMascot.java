package io.poly.tomlib.logo.theme.halloween.mascot;

import io.poly.tomlib.logo.AbstractMascot;

/// Halloween Mascot: Cute Ghost
public class CuteGhostMascot extends AbstractMascot {
    @Override
    public String[] getArt() {
        return new String[] {
            " .-''-. ",
            "(/ o o \\)",
            "|  ^  |",
            "'u---u'"
        };
    }

    @Override
    public int[] getColour(char c, int row, int col) {
        return new int[]{255, 255, 255}; // White ghost
    }

    @Override
    public String getQuote() {
        String[] quotes = {
            "I'm too cute to be spooky!",
            "Treats over tricks, please!",
            "Wanna be my friend?",
            "I'm just a little ghost.",
            "Peek-a-boo!"
        };
        return quotes[new java.util.Random().nextInt(quotes.length)];
    }
}
