package io.poly.tomlib.logo.theme.festive.mascot;


import io.poly.tomlib.logo.AbstractMascot;

/// Christmas Mascot: Snowman
public class SnowmanMascot extends AbstractMascot {
    @Override
    public String[] getArt() {
        return new String[] {
            "  _==_ ",
            " (\" \") ",
            " ( : ) ",
            " ( : ) ",
            " '---' ",
            "       "
        };
    }

    @Override
    public int[] getColour(char c, int row, int col) {
        if (c == '"') return new int[]{255, 165, 0}; // Orange carrot nose
        if (c == ':') return new int[]{0, 0, 0};     // Black buttons/eyes
        return new int[]{255, 255, 255};            // White snow
    }
}
