package io.poly.tomlib.logo.theme.may4th.mascot;


import io.poly.tomlib.logo.AbstractMascot;

/// Star Wars Mascot: Death Star
public class DeathStarMascot extends AbstractMascot {
    @Override
    public String[] getArt() {
        return new String[] {
            "   ___   ",
            "  / o \\  ",
            " | --- | ",
            " |     | ",
            "  \\___/  ",
            "         "
        };
    }

    @Override
    public int[] getColour(char c, int row, int col) {
        int[] rgb = {169, 169, 169};
        if (c == 'o' || c == '-') rgb = new int[]{105, 105, 105};
        return rgb;
    }
}
