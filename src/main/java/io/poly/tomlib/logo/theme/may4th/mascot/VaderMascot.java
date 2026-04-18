package io.poly.tomlib.logo.theme.may4th.mascot;


import io.poly.tomlib.logo.AbstractMascot;

/// Star Wars Mascot: Vader
public class VaderMascot extends AbstractMascot {
    @Override
    public String[] getArt() {
        return new String[] {
            "   ___   ",
            "  / v \\  ",
            " | > < | ",
            " |  V  | ",
            "  \\___/  ",
            "         "
        };
    }

    @Override
    public int[] getColour(char c, int row, int col) {
        int[] rgb = {50, 50, 50};
        if (c == '>') rgb = new int[]{255, 0, 0};
        return rgb;
    }
}
