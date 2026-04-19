package io.poly.tomlib.logo.theme.halloween.mascot;


import io.poly.tomlib.logo.AbstractMascot;

/// Valentine Mascot: Skeletor (for glitch mode)
public class SkeletorMascot extends AbstractMascot {
    @Override
    public String[] getArt() {
        return new String[] {
            "                 ",
            "      .---.      ",
            "    / { v } \\    ",
            "   | { > < } |   ",
            "   /  {vvv}  \\   ",
            "  (___________)  "
        };
    }

    @Override
    public int[] getColour(char c, int row, int col) {
        if (c == '>' || c == '<') return new int[]{255, 0, 0};      // Red eyes
        if (c == '{' || c == '}' || c == 'v' || c == 'V') return new int[]{255, 255, 0}; // Yellow skull
        return new int[]{128, 0, 128};                               // Purple hood
    }

    private static final java.util.List<String> QUOTES = java.util.List.of(
        "I don't like to feel good. I like to feel evil!",
        "Love is for the weak, He-Man!",
        "I am the master of evil!",
        "Everything comes to him who waits... and I have waited long enough!",
        "Myaaaa! I'll see you in your nightmares!",
        "I am not nice!",
        "Tell me about the loneliness of good, He-Man. Is it equal to the loneliness of evil?",
        "You sniveling, half-witted bumbling fool!",
        "I'll be back, He-Man! I'll be back!"
    );

    @Override
    public java.util.List<String> getQuotes() {
        return QUOTES;
    }
}
