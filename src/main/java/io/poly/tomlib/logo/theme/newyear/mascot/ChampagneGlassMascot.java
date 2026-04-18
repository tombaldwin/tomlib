package io.poly.tomlib.logo.theme.newyear.mascot;


import io.poly.tomlib.logo.AbstractMascot;

/// New Year Mascot: Champagne Glass
public class ChampagneGlassMascot extends AbstractMascot {
    @Override
    public String[] getArt() {
        return new String[] {
            " \\___/ ",
            "  \\ /  ",
            "   |   ",
            "   |   ",
            "  ---  ",
            "       "
        };
    }

    ///
    /// Gets the colour for the champagne glass.
    /// @param c the character to colour
    /// @param row the row of the character in the mascot art
    /// @param col the column of the character in the mascot art
    /// @return the RGB colour as an array of three integers
    ///
    @Override
    public int[] getColour(char c, int row, int col) {
        int[] rgb = {192, 192, 192}; // Silver
        if (row == 0 && c != ' ') {
            rgb = new int[]{255, 215, 0}; // Gold liquid
        }
        return rgb;
    }
}
