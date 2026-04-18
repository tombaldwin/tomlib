package io.poly.tomlib.logo.theme.easter.mascot;


import io.poly.tomlib.logo.AbstractMascot;

/// Easter Mascot: Egg
public class EggMascot extends AbstractMascot {
    @Override
    public String[] getArt() {
        return new String[] {
            "   ___   ",
            "  /   \\  ",
            " /  *  \\ ",
            " | * * | ",
            "  \\____/ ",
            "         "
        };
    }

    @Override
    public int[] getColour(char c, int row, int col) {
        return switch (row % 3) {
            case 0 -> new int[]{173, 216, 230};
            case 1 -> new int[]{144, 238, 144};
            default -> new int[]{255, 182, 193};
        };
    }
}
