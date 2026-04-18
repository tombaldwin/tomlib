package io.poly.tomlib.logo.theme.fourthofjuly.mascot;


import io.poly.tomlib.logo.AbstractMascot;

/// 4th of July Mascot: Eagle
public class EagleMascot extends AbstractMascot {
    @Override
    public String[] getArt() {
        return new String[] {
            "   /\\    ",
            "  /  \\   ",
            " ( o o ) ",
            "  \\ V /  ",
            "   / \\   ",
            "  (   )  "
        };
    }

    @Override
    public int[] getColour(char c, int row, int col) {
        if (c == 'V') return new int[]{255, 215, 0}; // Gold beak
        if (row < 3) return new int[]{255, 255, 255}; // White head
        return new int[]{139, 69, 19};               // Brown body
    }
}
