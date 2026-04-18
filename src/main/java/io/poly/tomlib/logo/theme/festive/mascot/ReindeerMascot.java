package io.poly.tomlib.logo.theme.festive.mascot;


import io.poly.tomlib.logo.AbstractMascot;

/// Christmas Mascot: Reindeer
public class ReindeerMascot extends AbstractMascot {
    @Override
    public String[] getArt() {
        return new String[] {
            "  \\  / ",
            "  ()() ",
            "  (oo) ",
            "  /--\\ ",
            " (____)",
            "       "
        };
    }

    @Override
    public int[] getColour(char c, int row, int col) {
        if (c == 'o') return new int[]{255, 0, 0}; // Red nose (Rudolph!)
        if (c == '\\' || c == '/') return new int[]{139, 69, 19}; // Brown antlers
        return new int[]{160, 82, 45}; // Reindeer brown
    }
}
