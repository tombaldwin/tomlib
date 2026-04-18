package io.poly.tomlib.logo.font;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/// An abstract base class for ASCII fonts.
///
/// This class handles the common logic for rendering text and validating font height.
/// It ensures all characters in the font have the same height.
public abstract class AbstractAsciiFont implements AsciiFont {
    protected final Map<Character, AsciiFontCharacter> fontData = new HashMap<>();
    protected final int fontHeight;
    protected final AsciiFontCharacter unknownCharacter;

    /// Creates a new ASCII font with the given characters.
    ///
    /// @param unknownCharacter the character to use for unknown characters.
    /// @param characters the characters supported by this font.
    /// @throws IllegalArgumentException if no characters are provided or if characters have different heights.
    public AbstractAsciiFont(AsciiFontCharacter unknownCharacter, AsciiFontCharacter... characters) {
        if (characters == null || characters.length == 0) {
            throw new IllegalArgumentException("Font must have at least one character.");
        }
        if (unknownCharacter == null) {
            throw new IllegalArgumentException("Unknown character cannot be null.");
        }

        this.fontHeight = characters[0].getHeight();
        this.unknownCharacter = unknownCharacter;

        if (unknownCharacter.getHeight() != this.fontHeight) {
            throw new IllegalArgumentException(String.format(
                    "Unknown character must have the same height as font characters. Expected %d, but got %d.",
                    this.fontHeight, unknownCharacter.getHeight()
            ));
        }

        for (int i = 0; i < characters.length; i++) {
            AsciiFontCharacter character = characters[i];
            if (character.getHeight() != this.fontHeight) {
                throw new IllegalArgumentException(String.format(
                        "All characters in a font must have the same height. Expected %d, but character at index %d has height %d.",
                        this.fontHeight, i, character.getHeight()
                ));
            }
        }
    }

    /// Associates a character with its ASCII representation.
    ///
    /// @param c the character.
    /// @param lines the lines representing the character in ASCII art.
    protected void registerCharacter(char c, String... lines) {
        registerCharacter(c, new AsciiFontCharacter(lines));
    }

    /// Associates a character with its ASCII representation.
    ///
    /// @param c the character.
    /// @param asciiChar the ASCII representation.
    protected void registerCharacter(char c, AsciiFontCharacter asciiChar) {
        if (asciiChar.getHeight() != this.fontHeight) {
            throw new IllegalArgumentException(String.format(
                    "Registered character must have font height %d, but got %d.",
                    this.fontHeight, asciiChar.getHeight()
            ));
        }
        fontData.put(c, asciiChar);
    }

    /// Returns the font data mapping.
    /// @return the font data map.
    public Map<Character, AsciiFontCharacter> getFontData() {
        return fontData;
    }

    @Override
    public String[] render(String text) {
        String lowercaseText = text.toLowerCase();
        String[] result = new String[fontHeight];
        Arrays.fill(result, "");

        for (char c : lowercaseText.toCharArray()) {
            AsciiFontCharacter character = fontData.getOrDefault(c, unknownCharacter);
            for (int i = 0; i < fontHeight; i++) {
                result[i] += character.getLine(i);
            }
        }
        return result;
    }

    @Override
    public int getHeight() {
        return fontHeight;
    }

    @Override
    public void printAllCharacters(int maxWidth) {
        StringBuilder currentText = new StringBuilder();
        StringBuilder keyBuilder = new StringBuilder();
        int currentWidth = 0;

        java.util.List<Character> sortedChars = fontData.keySet().stream()
                .filter(c -> c != ' ')
                .sorted().toList();

        for (Character c : sortedChars) {
            AsciiFontCharacter character = fontData.get(c);
            int charWidth = character.getWidth();

            int widthToAdd = charWidth + (!currentText.isEmpty() ? 1 : 0);

            if (currentWidth + widthToAdd > maxWidth && !currentText.isEmpty()) {
                System.out.println("Key: " + keyBuilder);
                printRenderedText(currentText.toString());
                System.out.println();
                currentText.setLength(0);
                keyBuilder.setLength(0);
                currentWidth = 0;
            }

            if (!currentText.isEmpty()) {
                currentText.append(' ');
                keyBuilder.append(' ');
                currentWidth += 1;
            }

            currentText.append(c);
            keyBuilder.append(c);
            int spaces = charWidth - 1;
            keyBuilder.append(" ".repeat(Math.max(0, spaces)));

            currentWidth += charWidth;
        }

        if (!currentText.isEmpty()) {
            System.out.println("Key: " + keyBuilder);
            printRenderedText(currentText.toString());
        }
    }

    private void printRenderedText(String text) {
        String[] rendered = render(text);
        for (String line : rendered) {
            System.out.println(line);
        }
    }

    /// Registers a character by padding its lines to the same length and font height.
    ///
    /// This method ensures that characters can be defined compactly in the source code
    /// while still meeting the rectangular requirement of {@link AsciiFontCharacter}.
    ///
    /// @param c the character to register.
    /// @param lines the ASCII art lines for the character.
    protected void registerCompactCharacter(char c, String... lines) {
        int maxWidth = 0;
        for (String line : lines) {
            maxWidth = Math.max(maxWidth, line.length());
        }

        String[] paddedLines = new String[fontHeight];
        for (int i = 0; i < fontHeight; i++) {
            String line = (i < lines.length) ? lines[i] : "";
            paddedLines[i] = String.format("%-" + maxWidth + "s", line);
        }

        registerCharacter(c, paddedLines);
    }
}
