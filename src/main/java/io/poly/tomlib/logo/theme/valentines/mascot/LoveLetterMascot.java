package io.poly.tomlib.logo.theme.valentines.mascot;


import io.poly.tomlib.logo.AbstractMascot;

/// Valentine Mascot: Love Letter
public class LoveLetterMascot extends AbstractMascot {
    @Override
    public String[] getArt() {
        return new String[] {
            "  ____   ",
            " | \\/ |  ",
            " | /\\ |  ",
            " |____|  ",
            "         ",
            "         "
        };
    }

    @Override
    public int[] getColour(char c, int row, int col) {
        if (c == '\\' || c == '/') {
            return new int[]{255, 0, 0};   // Red lines
        }
        return new int[]{255, 105, 180};    // Hot Pink (envelope)
    }
}
