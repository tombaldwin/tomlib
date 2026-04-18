package io.poly.tomlib.logo;

import org.jspecify.annotations.Nullable;

/// Represents a pluggable theme for LogoPrinter.
/// Each theme defines its own mascot, logo variant, and optional mascots.
public interface Theme {
    /// Returns the name of the theme.
    /// @return the theme name.
    String getName();

    /// Returns the logo variant for this theme.
    /// @param logoText the text to include in the logo.
    /// @return the logo lines.
    default String[] getLogo(String logoText) {
        return getLogo(logoText, false);
    }

    /// Returns the logo variant for this theme.
    /// @param logoText the text to include in the logo.
    /// @param glitchMode whether to return the glitch variant.
    /// @return the logo lines.
    String[] getLogo(String logoText, boolean glitchMode);

    /// Prints the mascots for this theme.
    /// @param glitchMode whether to print the glitch variants of mascots, or null to print all
    void printMascots(Boolean glitchMode);

    /// Returns a mascot for this theme.
    /// @return the mascot lines.
    @Nullable
    AbstractMascot getMascot(boolean glitchMode);

    /// Returns the stars to display on the left side.
    /// @param glitchMode whether to return the glitch variant.
    /// @return the stars lines.
    String[] getStarsLeft(boolean glitchMode);

    /// Returns the stars to display on the right side.
    /// @param glitchMode whether to return the glitch variant.
    /// @return the stars lines.
    String[] getStarsRight(boolean glitchMode);

    /// Returns the RGB colour for a logo character at a given position.
    /// @param row the row index.
    /// @param col the column index.
    /// @param glitchMode whether to use glitch effects.
    /// @return the RGB array {r, g, b}.
    int[] getLogoColour(char c, int row, int col, boolean glitchMode);

    /// Returns the RGB colour for a star character at a given position.
    /// @param c the character.
    /// @param row the row index.
    /// @param col the column index.
    /// @param glitchMode whether to use glitch effects.
    /// @return the RGB array {r, g, b}.
    int[] getStarColour(char c, int row, int col, boolean glitchMode);

    /// Returns the glitch message for this theme.
    /// @return the glitch message, or null if no special message.
    String getGlitchMessage();

    /// Returns whether this theme is currently active based on the date.
    /// @param date the date to check.
    /// @return true if the theme should be active.
    boolean isActive(java.time.LocalDate date);

    /// Returns the priority of the theme.
    /// Higher values mean higher priority.
    /// @return the theme priority.
    default int getPriority() {
        return 0;
    }

    default boolean isGlitchable() {
        return true;
    }

    default float getMascotProbability() {
        return 1.0f;
    }

    default boolean glitchDistortion() {
        return true;
    }

    default boolean showStars() {
        return true;
    }

    @Nullable
    default String getTagLine(boolean glitchMode) {
        if (glitchMode) {
            return "\u001B[31m" + getGlitchMessage() + "\u001B[0m";
        }
        return null;
    }

    /// Returns a human-readable description of when this theme is active.
    /// @return the activation rule description.
    @Nullable
    default String getActivationRule() {
        return null;
    }

    char glitchNoise();

    int noiseCount();

    void addNoiseColour(StringBuilder sb, int row, int col, char c, boolean glitchMode);

    default boolean glitchCorruption() {
        return true;
    }
}
