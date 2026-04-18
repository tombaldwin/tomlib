package io.poly.tomlib.logo;

import java.util.Arrays;

/// Base class for all mascots.
public abstract class AbstractMascot {
    /// Returns the ASCII art for the mascot.
    /// @return array of strings representing the ASCII art.
    public abstract String[] getArt();

    ///
    /// Returns the RGB colour for a given character at a specific position.
    /// Default implementation returns null (no colour).
    /// @param c the character to colour
    /// @param row the row index (0-based)
    /// @param col the column index (0-based)
    /// @return array of [r, g, b] or null
    ///
    public int[] getColour(char c, int row, int col) {
        return null;
    }

    ///
    /// Returns a random quote for the mascot, if applicable.
    /// @return a random quote or null.
    ///
    public String getQuote() {
        return null;
    }

    ///
    /// Returns the ASCII art with ANSI colour codes applied.
    /// @return array of coloured strings.
    ///
    public String[] getColouredArt() {
        return getColouredArt(getArt());
    }

    ///
    /// Returns the provided art with ANSI colour codes applied.
    /// @param art the art to colour
    /// @return array of coloured strings.
    ///
    protected String[] getColouredArt(String[] art) {
        String[] colouredArt = new String[art.length];
        for (int i = 0; i < art.length; i++) {
            StringBuilder line = new StringBuilder();
            for (int j = 0; j < art[i].length(); j++) {
                char c = art[i].charAt(j);
                int[] rgb = getColour(c, i, j);
                if (c == ' ' || rgb == null) {
                    line.append(c);
                } else {
                    line.append(String.format("\u001B[38;2;%d;%d;%dm%c\u001B[0m", rgb[0], rgb[1], rgb[2], c));
                }
            }
            colouredArt[i] = line.toString();
        }
        return colouredArt;
    }

    /// Prints the mascot to System.out.
    public void print() {
        Arrays.stream(getColouredArt()).forEach(System.out::println);
    }

    /// Prints the mascot with custom colouring logic.
    /// @param colourLogic a function that takes a character and returns RGB values.
    public void print(java.util.function.Function<Character, int[]> colourLogic) {
        for (String line : getArt()) {
            StringBuilder colouredLine = new StringBuilder();
            for (int i = 0; i < line.length(); i++) {
                char c = line.charAt(i);
                int[] rgb = colourLogic.apply(c);

                if (c == ' ' || rgb == null) colouredLine.append(c);
                else colouredLine.append(String.format("\u001B[38;2;%d;%d;%dm%c\u001B[0m", rgb[0], rgb[1], rgb[2], c));
            }
            System.out.println(colouredLine);
        }
    }
}
