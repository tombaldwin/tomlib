package io.poly.tomlib.logo.theme;

import io.poly.tomlib.logo.AbstractMascot;
import io.poly.tomlib.logo.AbstractTheme;
import io.poly.tomlib.logo.LogoPrinter;
import io.poly.tomlib.logo.Theme;
import io.poly.tomlib.logo.theme.limmy.LimmyTheme;
import io.poly.tomlib.logo.theme.may4th.May4thTheme;
import io.poly.tomlib.logo.theme.may4th.mascot.JarJarMascot;
import java.time.LocalDate;

/// Utility class for theme tests.
public class ThemeTestUtils {

    /// A test implementation of LogoPrinter that exposes the protected printLogoWithTheme method.
    public static class TestLogoPrinter extends LogoPrinter {
        public TestLogoPrinter(String text) {
            super(text);
        }

        /// Prints the logo with the specified theme and glitch mode.
        /// @param glitchMode whether to use glitch mode.
        /// @param theme the theme to use.
        public void printWithTheme(boolean glitchMode, Theme theme) {
            super.printLogoWithTheme(glitchMode, theme);
        }
    }

    /// Prints the theme in both normal and glitch modes.
    /// @param theme the theme to print.
    /// @param sampleText the text to use for the logo.
    public static void printTheme(Theme theme, String sampleText) {
        TestLogoPrinter printer = new TestLogoPrinter(sampleText);
        System.out.println("--- Normal " + theme.getName() + " Theme ---");
        printer.printWithTheme(false, theme);
        System.out.println("\n--- Glitch " + theme.getName() + " Theme ---");
        printer.printWithTheme(true, theme);
    }

    /// Prints the theme with all possible mascots in both normal and glitch modes.
    /// Only mascots allowed in a given mode are shown.
    /// @param theme the theme to print.
    /// @param sampleText the text to use for the logo.
    public static void printThemeAllMascots(Theme theme, String sampleText) {
        if (theme instanceof AbstractTheme abstractTheme) {
            TestLogoPrinter printer = new TestLogoPrinter(sampleText);

            // Normal mode mascots
            System.out.println("--- Normal " + theme.getName() + " Theme (All Mascots) ---");
            for (AbstractMascot mascot : abstractTheme.getMascots(false)) {
                System.out.println("\nMascot: " + mascot.getClass().getSimpleName());
                printer.printWithTheme(false, new MascotOverrideTheme(theme, mascot));
            }

            // Glitch mode mascots
            System.out.println("\n--- Glitch " + theme.getName() + " Theme (All Mascots) ---");
            for (AbstractMascot mascot : abstractTheme.getMascots(true)) {
                System.out.println("\nMascot: " + mascot.getClass().getSimpleName());
                printer.printWithTheme(true, new MascotOverrideTheme(theme, mascot));
            }
        } else {
            printTheme(theme, sampleText);
        }
    }

    /// A wrapper theme that overrides the mascot returned by the original theme.
    private static class MascotOverrideTheme implements Theme {
        private final Theme delegate;
        private final AbstractMascot mascotOverride;

        public MascotOverrideTheme(Theme delegate, AbstractMascot mascotOverride) {
            this.delegate = delegate;
            this.mascotOverride = mascotOverride;
        }

        @Override
        public String getName() {
            return delegate.getName();
        }

        @Override
        public String[] getLogo(String logoText, boolean glitchMode) {
            return delegate.getLogo(logoText, glitchMode);
        }

        @Override
        public void printMascots(Boolean glitchMode) {
            delegate.printMascots(glitchMode);
        }

        @Override
        public AbstractMascot getMascot(boolean glitchMode) {
            return mascotOverride;
        }

        @Override
        public String[] getStarsLeft(boolean glitchMode) {
            return delegate.getStarsLeft(glitchMode);
        }

        @Override
        public String[] getStarsRight(boolean glitchMode) {
            return delegate.getStarsRight(glitchMode);
        }

        @Override
        public int[] getLogoColour(char c, int row, int col, boolean glitchMode) {
            return delegate.getLogoColour(c, row, col, glitchMode);
        }

        @Override
        public int[] getStarColour(char c, int row, int col, boolean glitchMode) {
            return delegate.getStarColour(c, row, col, glitchMode);
        }

        @Override
        public String getGlitchMessage() {
            if (delegate instanceof LimmyTheme) {
                return mascotOverride.getQuote();
            }
            if (delegate instanceof May4thTheme) {
                String prefix = "[!] ";
                if (mascotOverride instanceof JarJarMascot) {
                    prefix += "JAR-JAR SAYS: ";
                }
                return prefix + mascotOverride.getQuote();
            }
            return delegate.getGlitchMessage();
        }

        @Override
        public boolean isActive(LocalDate date) {
            return delegate.isActive(date);
        }

        @Override
        public int getPriority() {
            return delegate.getPriority();
        }

        @Override
        public boolean isGlitchable() {
            return delegate.isGlitchable();
        }

        @Override
        public float getMascotProbability() {
            return delegate.getMascotProbability();
        }

        @Override
        public boolean glitchDistortion() {
            return delegate.glitchDistortion();
        }

        @Override
        public boolean showStars() {
            return delegate.showStars();
        }

        @Override
        public String getTagLine(boolean glitchMode) {
            if (delegate instanceof LimmyTheme) {
                if (glitchMode) {
                    return "\u001B[31m" + getGlitchMessage() + "\u001B[0m";
                }
                return "\u001B[38;2;128;0;128m" + mascotOverride.getQuote() + "\u001B[0m";
            }
            return delegate.getTagLine(glitchMode);
        }

        @Override
        public String getActivationRule() {
            return delegate.getActivationRule();
        }

        @Override
        public char glitchNoise() {
            return delegate.glitchNoise();
        }

        @Override
        public int noiseCount() {
            return delegate.noiseCount();
        }

        @Override
        public void addNoiseColour(StringBuilder sb, int row, int col, char c, boolean glitchMode) {
            delegate.addNoiseColour(sb, row, col, c, glitchMode);
        }

        @Override
        public boolean glitchCorruption() {
            return delegate.glitchCorruption();
        }
    }
}
