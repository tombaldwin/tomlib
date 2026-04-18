package io.poly.tomlib.logo.theme.festive.mascot;


import io.poly.tomlib.logo.AbstractMascot;

/// Christmas Mascot: Tree
public class TreeMascot extends AbstractMascot {
    @Override
    public String[] getArt() {
        return new String[] {
            "   ^   ",
            "  / \\  ",
            " / * \\ ",
            "/ * * \\",
            "  | |  ",
            " '---' "
        };
    }

    @Override
    public int[] getColour(char c, int row, int col) {
        if (c == '*') return new int[]{255, 215, 0}; // Gold stars
        if (c == '|' || c == '-' || c == '\'') return new int[]{139, 69, 19}; // Brown trunk
        return new int[]{34, 139, 34}; // Forest green
    }
}
