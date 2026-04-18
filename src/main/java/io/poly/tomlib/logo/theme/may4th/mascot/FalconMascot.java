package io.poly.tomlib.logo.theme.may4th.mascot;


import io.poly.tomlib.logo.AbstractMascot;

/// Star Wars Mascot: Millennium Falcon
public class FalconMascot extends AbstractMascot {
    @Override
    public String[] getArt() {
        return new String[] {
            "   ___   ",
            "  /   \\  ",
            " (_____) ",
            " | | | | ",
            " (_____) ",
            "  \\___/  "
        };
    }

    /// Star Wars Mascot: Millennium Falcon
    @Override
    public int[] getColour(char c, int row, int col) {
        int[] rgb = {211, 211, 211}; // Light Grey
        if (c == '_') rgb = new int[]{0, 191, 255}; // Blue
        else if (c == '|') rgb = new int[]{255, 0, 0}; // Red
        return rgb;
    }
}
