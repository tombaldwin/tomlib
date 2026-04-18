package io.poly.tomlib.logo.theme.standard.mascot;


import io.poly.tomlib.logo.AbstractMascot;

/// A cute cat mascot.
public class CatMascot extends AbstractMascot {
    @Override
    public String[] getArt() {
        return new String[] {
            "  /\\_/\\  ",
            " ( o.o ) ",
            "  > ^ <  ",
            " (     ) ",
            "  |_| |_|",
            "         "
        };
    }

    /// Gets the colour for a specific character in the mascot art.
    @Override
    public int[] getColour(char c, int row, int col) {
        if (c == '^') return new int[]{255, 182, 193}; // Light Pink nose
        if (c == 'o') return new int[]{0, 255, 0};      // Green eyes
        return new int[]{200, 200, 200};             // Light Grey body
    }
}
