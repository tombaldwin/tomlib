package io.poly.tomlib.logo.theme.festive.mascot;


import io.poly.tomlib.logo.AbstractMascot;

/// Christmas Mascot: Elf
public class ElfMascot extends AbstractMascot {
    @Override
    public String[] getArt() {
        return new String[] {
            "   ^   ",
            "  ( )  ",
            " <( )> ",
            "  / \\  ",
            " (___) ",
            "       "
        };
    }

    @Override
    public int[] getColour(char c, int row, int col) {
        if (c == '(' || c == ')') return new int[]{255, 218, 185}; // Peach face
        if (c == '^') return new int[]{255, 0, 0}; // Red hat tip
        return new int[]{50, 205, 50}; // Lime Green hat/body
    }
}
