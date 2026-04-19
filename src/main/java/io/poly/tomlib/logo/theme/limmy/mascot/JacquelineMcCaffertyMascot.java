package io.poly.tomlib.logo.theme.limmy.mascot;

import io.poly.tomlib.logo.AbstractMascot;
import java.util.List;

/// Jacqueline McCafferty mascot - she's lost three year of her life on heroin.
public class JacquelineMcCaffertyMascot extends AbstractMascot {
    @Override
    public String[] getArt() {
        return new String[]{
            "   ~~~~~   ",
            "  ~~~~~~~  ",
            " ~~(o o)~~ ",
            "~~\\  -  /~~",
            "~~ '---' ~~",
            "~~~     ~~~"
        };
    }

    @Override
    public int[] getColour(char c, int row, int col) {
        return switch (c) {
            case '~' -> new int[]{255, 255, 0};    // Blonde hair
            case '(', ')' -> new int[]{255, 255, 255}; // Eyes
            case 'o' -> new int[]{0, 0, 255};       // Blue eyes
            default -> new int[]{255, 200, 150};    // Skin tone
        };
    }

    @Override
    public List<String> getQuotes() {
        return List.of(
            "I've lost three year of my life on heroin!",
            "Another five year on a methadone programme.",
            "I'm clean now.",
            "Marti Pellow!",
            "I used to be a heroin addict.",
            "Gizza chocolate choux!",
            "I'm a survivor.",
            "That's for me!",
            "I want my life back."
        );
    }
}
