package io.poly.tomlib.logo.theme.newyear.mascot;


import io.poly.tomlib.logo.AbstractMascot;

/// New Year Mascot: Party Hat
public class PartyHatMascot extends AbstractMascot {
    @Override
    public String[] getArt() {
        return new String[] {
            "   .   ",
            "  / \\  ",
            " /   \\ ",
            "/_____\\",
            "(     )",
            " '---' "
        };
    }

    ///
    /// Gets the colour for the party hat mascot.
    /// @param c the character to colour
    /// @param row the row of the character in the mascot art
    /// @param col the column of the character in the mascot art
    /// @return the RGB colour as an array of three integers
    ///
    @Override
    public int[] getColour(char c, int row, int col) {
        if (c == '.') return new int[]{255, 0, 0}; // Red pom-pom
        return new int[]{255, 165, 0};             // Orange hat
    }
}
