package io.poly.tomlib.logo.theme.easter.mascot;



import io.poly.tomlib.logo.AbstractMascot;

import java.util.Random;

/// Easter Mascot: Basket
public class BasketMascot extends AbstractMascot {
    private static final Random RANDOM = new Random();

    @Override
    public String[] getArt() {
        return new String[] {
            "  .---.  ",
            " /     \\ ",
            "|  ooo  |",
            " \\_____/ ",
            "  |___|  ",
            "         "
        };
    }

    @Override
    public int[] getColour(char c, int row, int col) {
        if (c == 'o') {
            return switch (RANDOM.nextInt(3)) {
                case 0 -> new int[]{255, 182, 193};
                case 1 -> new int[]{173, 216, 230};
                default -> new int[]{144, 238, 144};
            };
        }
        return new int[]{139, 69, 19};
    }
}
