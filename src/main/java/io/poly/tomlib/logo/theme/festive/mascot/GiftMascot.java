package io.poly.tomlib.logo.theme.festive.mascot;


import io.poly.tomlib.logo.AbstractMascot;

/// Christmas Mascot: Gift
public class GiftMascot extends AbstractMascot {
    @Override
    public String[] getArt() {
        return new String[] {
            "  ___  ",
            " |_|_| ",
            " | | | ",
            " |___| ",
            "       ",
            "       "
        };
    }

    @Override
    public int[] getColour(char c, int row, int col) {
        if (c == '_') return new int[]{255, 215, 0}; // Gold ribbon
        return new int[]{255, 0, 0};                 // Red box
    }
}
