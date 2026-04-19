package io.poly.tomlib.logo.theme.limmy.mascot;

import io.poly.tomlib.logo.AbstractMascot;
import java.util.List;

/// Falcon (Steel vs Feathers) mascot.
public class SteelMascot extends AbstractMascot {
    @Override
    public String[] getArt() {
        return new String[]{
            "  .----.  ",
            " /      \\ ",
            "|  1kg   |",
            " \\      / ",
            "  '----'  "
        };
    }

    @Override
    public int[] getColour(char c, int row, int col) {
        return new int[]{192, 192, 192}; // Silver/Steel
    }

    @Override
    public List<String> getQuotes() {
        return List.of(
            "Which is heavier? A kilogram of steel, or a kilogram of feathers?",
            "That's right, it's a kilogram of steel. Because steel is heavier than feathers.",
            "I don't get it...",
            "But look at the size of that! That's cheating!",
            "They're both a kilogram.",
            "Steel's heavier than feathers.",
            "Look at that! That's it!"
        );
    }
}
