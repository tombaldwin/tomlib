package io.poly.tomlib.logo.theme.newyear.mascot;

import io.poly.tomlib.logo.AbstractMascot;

import java.util.Random;

/// New Year Mascot: Fireworks
public class FireworksMascot extends AbstractMascot {
    private static final Random RANDOM = new Random();

    @Override
    public String[] getArt() {
        return new String[] {
            "  \\ | / ",
            " -- * --",
            "  / | \\ ",
            "    |   ",
            "    |   ",
            "       "
        };
    }

    ///
    /// Gets a random colour for the fireworks mascot.
    /// @param c the character to colour
    /// @param row the row of the character in the mascot art
    /// @param col the column of the character in the mascot art
    /// @return the RGB colour as an array of three integers
    ///
    @Override
    public int[] getColour(char c, int row, int col) {
        if (c == '*' || c == '|' || c == '/' || c == '\\' || c == '-') {
            return new int[]{RANDOM.nextInt(256), RANDOM.nextInt(256), RANDOM.nextInt(256)};
        }
        return null;
    }
}
