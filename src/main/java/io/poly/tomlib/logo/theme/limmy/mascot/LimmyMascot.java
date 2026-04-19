package io.poly.tomlib.logo.theme.limmy.mascot;

import io.poly.tomlib.logo.AbstractMascot;
import java.util.List;

/// Limmy mascot - the man himself.
public class LimmyMascot extends AbstractMascot {
    @Override
    public String[] getArt() {
        return new String[]{
            "   .---.   ",
            "  /     \\  ",
            " | (o)(o) |",
            "  \\  ^  /  ",
            "   wgwgw   ",
            "   '---'   "
        };
    }

    @Override
    public int[] getColour(char c, int row, int col) {
        return switch (c) {
            case '(', ')' -> new int[]{255, 255, 255}; // White eyes
            case 'o' -> new int[]{0, 0, 255};          // Blue eyes
            case '^' -> new int[]{255, 200, 150};    // Nose
            case 'w' -> new int[]{255, 255, 255};    // White beard
            case 'g' -> new int[]{255, 140, 0};      // Ginger beard
            default -> new int[]{200, 200, 200};     // Greyish face
        };
    }

    @Override
    public List<String> getQuotes() {
        return List.of(
            "She's turned the weans against us!",
            "That's pure barry.",
            "Don't back doon, double doon.",
            "Requiem!",
            "I've got a surprise for you.",
            "Xylophone.",
            "Wrong way, down a one-way street!",
            "Starry, starry night...",
            "What's your name? What's your story?",
            "Benny Harvey RIP, gone but not forgotten."
        );
    }
}
