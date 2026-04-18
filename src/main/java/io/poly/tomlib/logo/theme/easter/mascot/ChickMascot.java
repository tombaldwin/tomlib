package io.poly.tomlib.logo.theme.easter.mascot;


import io.poly.tomlib.logo.AbstractMascot;

/// Easter Mascot: Chick
public class ChickMascot extends AbstractMascot {
    @Override
    public String[] getArt() {
        return new String[] {
            "   ___   ",
            "  ( o )  ",
            "  ( > )  ",
            " / ( ) \\ ",
            "  '---'  ",
            "   m m   "
        };
    }

    @Override
    public int[] getColour(char c, int row, int col) {
        if (c == '>') return new int[]{255, 165, 0};
        if (c == 'o') return new int[]{0, 0, 0};
        return new int[]{255, 255, 0};
    }
}
