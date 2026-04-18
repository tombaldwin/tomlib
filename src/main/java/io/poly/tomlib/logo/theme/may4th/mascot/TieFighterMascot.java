package io.poly.tomlib.logo.theme.may4th.mascot;


import io.poly.tomlib.logo.AbstractMascot;

/// Star Wars Mascot: TIE Fighter
public class TieFighterMascot extends AbstractMascot {
    @Override
    public String[] getArt() {
        return new String[] {
            " |-[ ]-| ",
            " |-[ ]-| ",
            " |-[ ]-| ",
            " |-[ ]-| ",
            " |-[ ]-| ",
            "         "
        };
    }

    @Override
    public int[] getColour(char c, int row, int col) {
        int[] rgb = {40, 40, 40};
        if (c == '[') rgb = new int[]{105, 105, 105};
        return rgb;
    }
}
