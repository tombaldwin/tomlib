package io.poly.tomlib.logo.theme.may4th.mascot;


import io.poly.tomlib.logo.AbstractMascot;

/// R2-D2 mascot from Star Wars.
public class R2D2Mascot extends AbstractMascot {
    @Override
    public String[] getArt() {
        return new String[]{
            "   .-----.   ",
            "  /  @ .  \\  ",
            " |  -===-  | ",
            " | | === | | ",
            " | |_____| | ",
            " /_/     \\_\\ "
        };
    }

    @Override
    public int[] getColour(char c, int row, int col) {
        int[] rgb = {255, 255, 255};
        if (c == '@' || c == '0') rgb = new int[]{255, 0, 0};
        else if (c == '=') rgb = new int[]{0, 0, 255};
        return rgb;
    }
}
