package io.poly.tomlib.logo.theme.fourthofjuly.mascot;


import io.poly.tomlib.logo.AbstractMascot;

/// 4th of July Mascot: Flag
public class USFlagMascot extends AbstractMascot {
    @Override
    public String[] getArt() {
        return new String[] {
            "  * * *  ",
            "  * * *  ",
            "  -----  ",
            "  -----  ",
            "  -----  ",
            "         "
        };
    }

    @Override
    public int[] getColour(char c, int row, int col) {
        if (c == '*') return new int[]{0, 0, 255}; // Blue canton
        return new int[]{255, 0, 0};               // Red stripes
    }
}
