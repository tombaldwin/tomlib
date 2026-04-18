package io.poly.tomlib.logo.theme.may4th.mascot;


import io.poly.tomlib.logo.AbstractMascot;

/// Star Wars Mascot: Stormtrooper
public class StormtrooperMascot extends AbstractMascot {
    @Override
    public String[] getArt() {
        return new String[] {
            "   ___   ",
            "  / o \\  ",
            " |(o o)| ",
            " |  -  | ",
            "  \\___/  ",
            "         "
        };
    }

    @Override
    public int[] getColour(char c, int row, int col) {
        int[] rgb = {255, 255, 255};
        if (c == 'o') rgb = new int[]{0, 0, 0};
        return rgb;
    }
}
