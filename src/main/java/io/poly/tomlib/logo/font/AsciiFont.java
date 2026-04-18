package io.poly.tomlib.logo.font;

/// Represents a font used to render logo text in ASCII art.
public interface AsciiFont {
    /// Renders the given text in this font.
    /// @param text the text to render.
    /// @return an array of strings representing the rendered lines.
    String[] render(String text);

    /// Returns the height of the font in lines.
    /// @return the font height.
    int getHeight();

    /// Prints all characters available in this font, wrapping at a maximum width.
    ///
    /// This method should include a key to help identify the rendered characters.
    ///
    /// @param maxWidth the maximum width before wrapping.
    void printAllCharacters(int maxWidth);
}
