package io.poly.tomlib.logo.theme.fourthofjuly.mascot;


import io.poly.tomlib.logo.AbstractMascot;

/// 4th of July Mascot: Fireworks
public class USFireworksMascot extends AbstractMascot {
    @Override
    public String[] getArt() {
        return new String[] {
            "    *    ",
            "  * * *  ",
            " * * * * ",
            "  * * *  ",
            "    *    ",
            "         "
        };
    }

    @Override
    public int[] getColour(char c, int row, int col) {
        if (col % 3 == 0) return new int[]{255, 0, 0};   // Red
        if (col % 3 == 1) return new int[]{255, 255, 255}; // White
        return new int[]{0, 0, 255};                     // Blue
    }
}
