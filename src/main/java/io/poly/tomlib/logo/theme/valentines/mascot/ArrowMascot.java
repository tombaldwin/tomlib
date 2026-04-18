package io.poly.tomlib.logo.theme.valentines.mascot;


import io.poly.tomlib.logo.AbstractMascot;

/// Valentine Mascot: Arrow
public class ArrowMascot extends AbstractMascot {
    @Override
    public String[] getArt() {
        return new String[] {
            "   /|    ",
            "  / |    ",
            " >>--->  ",
            "  \\ |    ",
            "   \\|    ",
            "         "
        };
    }

    @Override
    public int[] getColour(char c, int row, int col) {
        if (c == '>' || c == '/' || c == '\\') {
            return new int[]{255, 0, 0};     // Red
        }
        return new int[]{192, 192, 192};      // Silver
    }
}
