package io.poly.tomlib.logo.theme.limmy.mascot;

import io.poly.tomlib.logo.AbstractMascot;
import java.util.List;

/// Adventure Call mascot (Falconhoof).
public class AdventureCallMascot extends AbstractMascot {
    @Override
    public String[] getArt() {
        return new String[]{
            " .\\\\||./.   ",
            " \\/ --- \\/",
            "/| (o o) |\\",
            " /\\  -  /\\",
            "   '-#-'  ",
            "     |  "
        };
    }

    @Override
    public int[] getColour(char c, int row, int col) {
        return switch (c) {
            case 'o' -> new int[]{0, 0, 255}; // Blue eyes
            case '-', '(', ')', '\'' -> new int[]{255, 228, 196}; // Skin tone
            case '|' -> row == 5 ? new int[]{255, 228, 196} : new int[]{0, 0, 0}; // Neck is skin, rest is hair
            case '#' -> new int[]{0, 0, 0}; // Goatee
            default -> new int[]{0, 0, 0}; // Black hair/outline
        };
    }

    @Override
    public List<String> getQuotes() {
        return List.of(
            "Greetings, traveler!",
            "Kill jester.",
            "Jester is dead. Game over.",
            "Welcome to Adventure Call.",
            "You are in a room.",
            "What is your name, traveler?",
            "Look, it's a jester!",
            "Kill jester! It's my show!",
            "Anything else? No.",
            "There is a door."
        );
    }
}
