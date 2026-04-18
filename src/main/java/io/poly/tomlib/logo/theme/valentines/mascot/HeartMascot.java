package io.poly.tomlib.logo.theme.valentines.mascot;


import io.poly.tomlib.logo.AbstractMascot;

/// Valentine Mascot: Heart
public class HeartMascot extends AbstractMascot {
    @Override
    public String[] getArt() {
        return new String[] {
            "  _   _  ",
            " ( \\_/ ) ",
            "  \\   /  ",
            "   \\ /   ",
            "    V    ",
            "         "
        };
    }

    @Override
    public int[] getColour(char c, int row, int col) {
        if (c == 'V' || c == '\\' || c == '/') {
            return new int[]{255, 0, 0}; // Red heart outline/shape
        }
        return new int[]{255, 105, 180}; // Hot Pink (fill/other)
    }
}
