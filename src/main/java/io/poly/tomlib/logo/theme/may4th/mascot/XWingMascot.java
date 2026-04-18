package io.poly.tomlib.logo.theme.may4th.mascot;


import io.poly.tomlib.logo.AbstractMascot;

/// Star Wars Mascot: X-Wing
public class XWingMascot extends AbstractMascot {
    @Override
    public String[] getArt() {
        return new String[] {
            "  \\   /  ",
            "   \\ /   ",
            "  --X--  ",
            "   / \\   ",
            "  /   \\  ",
            "         "
        };
    }

    @Override
    public int[] getColour(char c, int row, int col) {
        int[] rgb = {220, 220, 220};
        if (c == 'X') rgb = new int[]{255, 0, 0};
        return rgb;
    }
}
