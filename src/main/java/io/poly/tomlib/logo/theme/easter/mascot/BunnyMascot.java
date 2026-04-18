package io.poly.tomlib.logo.theme.easter.mascot;


import io.poly.tomlib.logo.AbstractMascot;

/// Easter Mascot: Bunny
public class BunnyMascot extends AbstractMascot {
    @Override
    public String[] getArt() {
        return new String[] {
            "  /\\ /\\  ",
            " ( o.o ) ",
            "  > ^ <  ",
            " (  -  ) ",
            "  | | |  ",
            " (___|___)"
        };
    }

    @Override
    public String getQuote() {
        String[] quotes = {
            "I'm having an egg-stra special day!",
            "Don't worry, be hoppy!",
            "I'm egg-cited for Easter!",
            "That's all, yolks!",
            "No bunny compares to you!",
            "I'm some-bunny special!",
            "Let's get cracking!",
            "You're an egg-ceptional friend!",
            "Have a hollow-day!",
            "I'm feeling a bit sheepish!"
        };
        return quotes[new java.util.Random().nextInt(quotes.length)];
    }

    @Override
    public int[] getColour(char c, int row, int col) {
        if (row == 1 && c == 'o') return new int[]{0, 0, 0};
        if (row == 2 && c == '^') return new int[]{255, 182, 193};
        return new int[]{255, 255, 255};
    }
}
