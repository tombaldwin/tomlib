package io.poly.tomlib.logo.theme.birthday.mascot;


import io.poly.tomlib.logo.AbstractMascot;

/// Birthday Mascot: Cake
public class BirthdayCakeMascot extends AbstractMascot {
    private final String text;

    /// Default constructor for ServiceLoader.
    public BirthdayCakeMascot() {
        this("Happy Birthday!");
    }

    ///
    /// Creates a new BirthdayCakeMascot with the given text.
    /// @param text the text to display on the cake.
    ///
    public BirthdayCakeMascot(String text) {
        this.text = text;
    }

    @Override
    public String[] getArt() {
        int textLength = text.length();
        int width = Math.max(textLength + 4, 16);

        int totalPadding = width - 2 - textLength;
        int leftPadding = totalPadding / 2;
        int rightPadding = totalPadding - leftPadding;
        String textLine = "|" + " ".repeat(leftPadding) + text + " ".repeat(rightPadding) + "|";

        int candleCount = Math.min(width / 4, 8);
        int candleWidth = width - 2;
        int totalCandleSpace = (candleCount - 1) * 3 + 1;
        int startPos = 1 + (candleWidth - totalCandleSpace) / 2;

        StringBuilder flames = new StringBuilder(" ".repeat(width));
        StringBuilder candles = new StringBuilder(" ".repeat(width));

        for (int i = 0; i < candleCount; i++) {
            int pos = startPos + i * 3;
            if (pos < width - 1) {
                flames.setCharAt(pos, 'i');
                candles.setCharAt(pos, '!');
            }
        }

        String top = " " + "-".repeat(width - 2) + " ";
        String icing = "|" + "  ~".repeat((width - 2) / 3) + " ".repeat((width - 2) % 3) + "|";
        String bottom = "|" + "_".repeat(width - 2) + "|";

        return new String[] {
            flames.toString(),
            candles.toString(),
            top,
            icing,
            textLine,
            bottom
        };
    }

    @Override
    public int[] getColour(char c, int row, int col) {
        if (c == 'i') return new int[]{255, 69, 0};   // Red-Orange flame
        if (c == '!') return new int[]{255, 215, 0}; // Gold candle
        if (row == 4) return new int[]{0, 0, 0};      // Black text
        return new int[]{255, 182, 193};             // Pink icing/cake
    }
}
