package io.poly.tomlib.logo.theme.easter.mascot;


import io.poly.tomlib.logo.AbstractMascot;

/// Easter Mascot: Broken Egg (Glitch)
public class BrokenEggMascot extends AbstractMascot {
    @Override
    public String[] getArt() {
        return new String[] {
            "   _ _   ",
            "  /   \\  ",
            " / v v \\ ",
            " < v v > ",
            "  \\_|_/  ",
            "  /   \\  "
        };
    }

    @Override
    public int[] getColour(char c, int row, int col) {
        if (c == 'v') return new int[]{255, 255, 0};
        return new int[]{220, 220, 220};
    }
}
