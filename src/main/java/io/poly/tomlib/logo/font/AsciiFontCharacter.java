package io.poly.tomlib.logo.font;

import java.util.Arrays;

/// Represents a single character in an ASCII font.
///
/// This class ensures that all lines in the character have the same length,
/// providing consistent behaviour when rendering strings.
public class AsciiFontCharacter {
    private final String[] lines;
    private final int width;

    /// Creates a new ASCII font character with the specified lines.
    ///
    /// @param lines the lines representing the character in ASCII art.
    /// @throws IllegalArgumentException if the lines array is empty or if lines have different lengths.
    public AsciiFontCharacter(String... lines) {
        if (lines == null || lines.length == 0) {
            throw new IllegalArgumentException("Character lines cannot be null or empty.");
        }
        this.width = lines[0].length();
        for (int i = 1; i < lines.length; i++) {
            if (lines[i].length() != this.width) {
                throw new IllegalArgumentException(String.format(
                        "All lines in a character must have the same length. Expected length %d, but line %d has length %d.",
                        this.width, i, lines[i].length()
                ));
            }
        }
        this.lines = Arrays.copyOf(lines, lines.length);
    }

    /// Returns the lines representing this character.
    ///
    /// @return the lines.
    public String[] getLines() {
        return Arrays.copyOf(lines, lines.length);
    }

    /// Returns the line at the specified index.
    ///
    /// @param index the index of the line to return.
    /// @return the line.
    public String getLine(int index) {
        return lines[index];
    }

    /// Returns the width of the character in columns.
    ///
    /// @return the character width.
    public int getWidth() {
        return width;
    }

    /// Returns the height of the character in lines.
    ///
    /// @return the character height.
    public int getHeight() {
        return lines.length;
    }
}
