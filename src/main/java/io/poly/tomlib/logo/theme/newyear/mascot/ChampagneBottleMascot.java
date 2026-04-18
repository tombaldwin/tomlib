package io.poly.tomlib.logo.theme.newyear.mascot;


import io.poly.tomlib.logo.AbstractMascot;

/// New Year Mascot: Champagne Bottle
public class ChampagneBottleMascot extends AbstractMascot {
    @Override
    public String[] getArt() {
        return new String[] {
            "   _   ",
            "  | |  ",
            "  | |  ",
            " /   \\ ",
            " |   | ",
            " '---' "
        };
    }

    ///
    /// Gets the colour for the champagne bottle.
    /// @param c the character to colour
    /// @param row the row of the character in the mascot art
    /// @param col the column of the character in the mascot art
    /// @return the RGB colour as an array of three integers
    ///
    @Override
    public int[] getColour(char c, int row, int col) {
        int[] rgb = {34, 139, 34}; // Forest Green
        if (row < 3 && (c == '|' || c == '_')) {
            rgb = new int[]{255, 215, 0}; // Gold foil
        }
        return rgb;
    }
}
