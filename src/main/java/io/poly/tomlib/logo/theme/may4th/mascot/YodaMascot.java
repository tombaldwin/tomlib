package io.poly.tomlib.logo.theme.may4th.mascot;


import io.poly.tomlib.logo.AbstractMascot;

/// Yoda mascot from Star Wars.
public class YodaMascot extends AbstractMascot {
    @Override
    public String[] getArt() {
        return new String[] {
            "  ___  ",
            " / @ \\ ",
            "<| ^ |>",
            " \\_v_/ ",
            "  | |  ",
            "       "
        };
    }

    @Override
    public int[] getColour(char c, int row, int col) {
        if (c == '<' || c == '>') return new int[]{152, 251, 152}; // Pale Green ears
        return new int[]{34, 139, 34};                            // Forest Green
    }
}
