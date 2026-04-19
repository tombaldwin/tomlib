package io.poly.tomlib.logo.theme.limmy.mascot;

import io.poly.tomlib.logo.AbstractMascot;
import java.util.List;

/// Dee Dee mascot (the Yoker man).
public class DeeDeeMascot extends AbstractMascot {
    @Override
    public String[] getArt() {
        return new String[]{
            "   _____   ",
            "  /     \\  ",
            " |  O O  | ",
            " |   -   | ",
            "  \\_____/  ",
            "    | |    "
        };
    }

    @Override
    public int[] getColour(char c, int row, int col) {
        // Drug-addled DeeDee has trippy, shifting colours
        int r = (int) (Math.cos(row * 0.4 + col * 0.2) * 127 + 128);
        int g = (int) (Math.sin(row * 0.3 - col * 0.5) * 127 + 128);
        int b = (int) (Math.cos(row * 0.1 + col * 0.4) * 127 + 128);
        return new int[]{r, g, b};
    }

    @Override
    public List<String> getQuotes() {
        return List.of(
            "I've got no business being in Yoker!",
            "I'm going to Yoker!",
            "He's a Yoker man!",
            "Purely mental.",
            "What's that? It's the bus to Yoker.",
            "Am I dead?",
            "Look at that!",
            "Everything is... purely mental.",
            "Lesley!",
            "Where am I? Yoker.",
            "That's the Clyde!"
        );
    }
}
