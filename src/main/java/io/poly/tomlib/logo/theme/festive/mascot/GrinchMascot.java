package io.poly.tomlib.logo.theme.festive.mascot;


import io.poly.tomlib.logo.AbstractMascot;

/// Christmas Mascot: Grinch (for glitch mode)
public class GrinchMascot extends AbstractMascot {
    @Override
    public String[] getArt() {
        return new String[] {
            "  _\\/_  ",
            " /  _ \\ ",
            " ( > < )",
            "  \\ v / ",
            "  / m \\ ",
            " (_____) "
        };
    }

    private static final java.util.List<String> QUOTES = java.util.List.of(
        "I'm a mean one, Mr. Grinch!",
        "Hate, hate, hate. Hate, hate, hate. Double hate. LOATHE ENTIRELY!",
        "The Whos young and old would sit down to a feast. And they'd feast! And they'd feast! And they'd FEAST! FEAST! FEAST!",
        "Blast this Christmas music! It's joyful and triumphant.",
        "I must stop this Christmas from coming!",
        "Even if I wanted to go, my schedule wouldn't allow it. 4:00, wallow in self-pity; 4:30, stare into the abyss; 5:00, solve world hunger, tell no one; 5:30, jazzercize; 6:30, dinner with me - I can't cancel that again; 7:00, wrestle with my self-loathing... I'm booked.",
        "One man's toxic sludge is another man's potpourri.",
        "That's it, I'm not going.",
        "Santa, bye-bye!",
        "Am I just eating because I'm bored?"
    );

    @Override
    public java.util.List<String> getQuotes() {
        return QUOTES;
    }

    @Override
    public int[] getColour(char c, int row, int col) {
        if (c == '>' || c == '<') return new int[]{255, 0, 0}; // Red angry eyes
        return new int[]{50, 205, 50};                         // Lime Green
    }
}
