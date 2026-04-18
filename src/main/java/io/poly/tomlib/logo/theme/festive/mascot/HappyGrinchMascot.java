package io.poly.tomlib.logo.theme.festive.mascot;


import io.poly.tomlib.logo.AbstractMascot;

/// Christmas Mascot: Happy Grinch (standard)
public class HappyGrinchMascot extends AbstractMascot {
    @Override
    public String[] getArt() {
        return new String[] {
            "  _\\/_  ",
            " /  _ \\ ",
            " ( . . )",
            "  \\ v / ",
            "  / m \\ ",
            " (_____) "
        };
    }

    @Override
    public int[] getColour(char c, int row, int col) {
        if (c == '.') return new int[]{0, 191, 255}; // Deep Sky Blue (happy eyes)
        return new int[]{50, 205, 50};              // Lime Green
    }
}
