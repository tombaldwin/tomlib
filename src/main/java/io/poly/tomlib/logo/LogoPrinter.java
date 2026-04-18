package io.poly.tomlib.logo;

import io.poly.tomlib.util.UserInference;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.random.RandomGenerator;

/// Utility to print a startup ascii logo with various seasonal and glitch modes.
public class LogoPrinter {

    private static final Logger logger = LogManager.getLogger();

    private static LogoPrinter instance;

    private final String logoText;
    private double glitchProbability = 0.2;
    private final List<Theme> themes = new ArrayList<>();


    public LogoPrinter() {
        this("tomlib");
    }

    public LogoPrinter(String logoText) {
        this(logoText, 0.2);
    }


    ///
    /// Constructor with all configuration options.
    /// @param logoText the text to display in the logo
    /// @param glitchProbability the probability of a glitch occurring (0.0 to 1.0)
    ///
    public LogoPrinter(String logoText, double glitchProbability) {
        this.logoText = logoText;
        this.glitchProbability = glitchProbability;
        initialiseThemes();
    }

    private void initialiseThemes() {
        themes.addAll(ThemeRegistry.getThemes().values());
        themes.sort(Comparator.comparingInt(Theme::getPriority).reversed());
    }

    ///
    /// Returns the ordered list of themes.
    /// @return the list of themes.
    public List<Theme> getThemes() {
        return new ArrayList<>(themes);
    }

    /// Gets the singleton instance of LogoPrinter.
    public static LogoPrinter instance() {
        if (instance == null) {
            instance = new LogoPrinter();
        }
        return instance;
    }

    ///
    /// Main entry point to print the logo from the command line.
    /// @param args command line arguments (ignored)
    ///
    public static void main(String[] args) {
        instance().printLogo();
    }

    /// Prints the logo using the configured instance settings.
    public void printLogo() {
        printLogo(glitch());
    }

    boolean glitch() {
        return new java.util.Random().nextDouble() < glitchProbability;
    }

    ///
    /// Prints the logo with optional glitch mode and automatically detected seasonal modes.
    ///
    /// @param glitchMode whether to enable glitch effects
    public void printLogo(boolean glitchMode) {
        LocalDate now = LocalDate.now();
        Theme selectedTheme = themes.stream()
                                    .filter(theme -> theme.isActive(now))
                                    .findFirst()
                                    .orElse(ThemeRegistry.getStandardTheme());

        printLogoWithTheme(glitchMode, selectedTheme);
    }

    ///
    /// Prints the logo using the specified theme.
    /// @param glitchMode whether to enable glitch effects
    /// @param theme the theme to use
    protected void printLogoWithTheme(boolean glitchMode, Theme theme) {
        // Option 1: Bold Block (Lowercase)
        String[] logo = theme.getLogo(getLogoText(), glitchMode);



//        if (halloweenMode) {
//            // Check if logo matches classic ghost to determine variant
//            if (logo.length >= 5) {
//                if (logo[0].contains(".-''-.")) halloweenVariant = 1;
//                else if (logo[0].contains(",.")) halloweenVariant = 2;
//                else halloweenVariant = 0;
//            }
//        }


        // Selection of seasonal mascot
        int mascotType = 0; // Christmas: 0:Snowman, 1:Reindeer, 2:Tree, 3:Elf, 4:Gift, 5:HappyGrinch, -1:Grinch.
        // New Year: 10:Bottle, 11:Glass, 12:Fireworks, 13:Hat
        // Valentine: 20:Heart, 21:Letter, 22:Arrow
        // Easter: 40:Bunny, 41:Chick, 42:Egg, 43:Basket, -40:BrokenEgg
        // May 4th: 50:Falcon, 51:X-Wing, 52:R2D2, 53:Vader, 54:Stormtrooper, 55:DeathStar, 56:TIE, -50:JarJar
        // 4th of July: 60:Flag, 61:Eagle, 62:Fireworks
        // Cat: 30:Mascot
        boolean catMode = false;

        AbstractMascot mascot = theme.getMascot(glitchMode);
        String[] mascotArt = Optional.ofNullable(mascot).map(AbstractMascot::getArt).orElse(new String[0]);


        double shear = 0;
        double slant = 0;
        RandomGenerator glitchRand = RandomGenerator.getDefault();
        if (glitchMode && theme.glitchDistortion()) {
            shear = glitchRand.nextDouble() * 4 - 2; // Random initial offset between -2 and 2
            // Force a non-zero slant in most cases
            slant = (glitchRand.nextDouble() * 2 - 1) * (glitchRand.nextBoolean() ? 1.0 : 0.5);
        }

        // 24-bit diagonal rainbow effect: hue is a function of both row and column
        String[] starsLeft = theme.getStarsLeft(glitchMode);
        String[] starsRight = theme.getStarsRight(glitchMode);


        int maxLogoWidth = 0;
        for (String line : logo) {
            String logoLine = theme.showStars() ? (starsLeft[0] + line + starsRight[0]) : line;
            maxLogoWidth = Math.max(maxLogoWidth, logoLine.length());
        }

        int maxMascotWidth = 0;
        for (String line : mascotArt) {
            maxMascotWidth = Math.max(maxMascotWidth, line.length());
        }

        int logoStartColumn = 4;
        int mascotMargin = 4;
        int mascotColumn = Math.max(72, logoStartColumn + maxLogoWidth + mascotMargin);
        int totalWidth = mascotColumn + maxMascotWidth + 4;

        int maxLines = Math.max(logo.length, mascot != null ? 6 : 0);
        for (int row = 0; row < maxLines; row++) {

            char[] lineArr = new char[totalWidth];
            java.util.Arrays.fill(lineArr, ' ');

            int shift = 0;
            if (glitchMode && row < logo.length) {
                shift = (int) Math.round(shear + (row * slant));
            }

            // Main Logo and Stars
            String logoLine = "";
            if (row < logo.length) {
                logoLine = theme.showStars() ? (starsLeft[row] + logo[row] + starsRight[row]) : logo[row];
            }
            int actualLogoStart = Math.max(0, logoStartColumn + shift);
            for (int i = 0; i < logoLine.length() && (actualLogoStart + i) < mascotColumn; i++) {
                lineArr[actualLogoStart + i] = logoLine.charAt(i);
            }

            // Mascot (Seasonal or Cat)
            String mascotPart = "";
            if (mascot != null) {
                if (row < mascotArt.length) {
                    mascotPart = mascotArt[row];
                    for (int i = 0; i < mascotPart.length() && (mascotColumn + i) < totalWidth; i++) {
                        lineArr[mascotColumn + i] = mascotPart.charAt(i);
                    }
                }
            }

            // Glitch Noise
            boolean[] noiseFlags = new boolean[totalWidth];
            if (glitchMode) {
                // Leading noise
                if (actualLogoStart > 0) {
                    int leadingNoiseCount = theme.noiseCount();
                    for (int i = 0; i < leadingNoiseCount; i++) {
                        int pos = glitchRand.nextInt(actualLogoStart);
                        lineArr[pos] = theme.glitchNoise();
                        noiseFlags[pos] = true;
                    }
                }

                int logoEnd = actualLogoStart + logoLine.length();

                // Middle noise (between logo and mascot)
                if (mascot != null && mascotColumn > logoEnd) {
                    int middleNoiseCount = theme.noiseCount();
                    for (int i = 0; i < middleNoiseCount; i++) {
                        int pos = logoEnd + glitchRand.nextInt(mascotColumn - logoEnd);
                        if (pos < totalWidth) {
                            lineArr[pos] = theme.glitchNoise();
                            noiseFlags[pos] = true;
                        }
                    }
                }

                // Trailing noise
                int contentEnd = mascot != null ? (mascotColumn + mascotPart.length()) : logoEnd;
                int trailingNoiseCount = theme.noiseCount();
                for (int i = 0; i < trailingNoiseCount; i++) {
                    int pos = contentEnd + glitchRand.nextInt(Math.max(1, Math.min(6, totalWidth - contentEnd)));
                    if (pos < totalWidth) {
                        lineArr[pos] = theme.glitchNoise();
                        noiseFlags[pos] = true;
                    }
                }
            }

            StringBuilder colouredLine = new StringBuilder();

            for (int col = 0; col < totalWidth; col++) {
                char c = lineArr[col];

                if (noiseFlags[col]) {
                    theme.addNoiseColour(colouredLine, row, col, c, glitchMode);
                    continue;
                }

                if (Character.isWhitespace(c)) {
                    // Subtle whitespace corruption in glitch mode (1 in 50) - increased from 1 in 100
                    if (glitchMode && theme.glitchCorruption() && glitchRand.nextInt(50) == 0 && col < mascotColumn) {
                        char noiseChar = "░▒. ".charAt(glitchRand.nextInt(4));
                        int grey = glitchRand.nextInt(80) + 40; // Brighter greyscale - increased from (60+30)
                        colouredLine.append(String.format("\u001B[38;2;%d;%d;%dm%c\u001B[0m", grey, grey, grey, noiseChar));
                    } else {
                        colouredLine.append(c);
                    }
                } else {
                    // Random character substitution in glitch mode (1 in 30 chance) - increased from 1 in 50
                    // Only for main logo area
                    if (glitchMode && theme.glitchCorruption() && glitchRand.nextInt(30) == 0 && col < mascotColumn) {
                        c = (char) (33 + glitchRand.nextInt(94));
                    }

                    int[] rgb = theme.getStarColour(c, row, col, glitchMode);
                    if (col >= mascotColumn && mascot != null) {
                        rgb = mascot.getColour(c, row, col);
                    }
                    else {
                        rgb = theme.getLogoColour(c, row, col, glitchMode);
                    }

                    // Apply flashing effect to some star characters (*)
                    // BUT NOT for the mascot (Grinch/Snowman)
                    if ((c == '*' || c == '#') && col < mascotColumn) {
                        colouredLine.append("\u001B[5m");
                    }

                    colouredLine.append(String.format("\u001B[38;2;%d;%d;%dm%c\u001B[0m", rgb[0], rgb[1], rgb[2], c));
                }
            }

            System.out.println(colouredLine);
        }

        String tagLine = theme.getTagLine(glitchMode);
        if (tagLine != null) { System.out.println(tagLine); }

        System.out.println();
    }

    ///
    /// Simple HSV to RGB conversion for the rainbow effect.
    /// @param h Hue [0, 360)
    /// @param s Saturation [0, 1]
    /// @param v Value [0, 1]
    /// @return Array of [r, g, b] in [0, 255]
    ///
    private int[] hsvToRgb(double h, double s, double v) {
        double c = v * s;
        double x = c * (1 - Math.abs((h / 60.0) % 2 - 1));
        double m = v - c;
        double r, g, b;
        if (h < 60) { r = c; g = x; b = 0; }
        else if (h < 120) { r = x; g = c; b = 0; }
        else if (h < 180) { r = 0; g = c; b = x; }
        else if (h < 240) { r = 0; g = x; b = c; }
        else if (h < 300) { r = x; g = 0; b = c; }
        else { r = c; g = 0; b = x; }
        return new int[] {
            (int) ((r + m) * 255),
            (int) ((g + m) * 255),
            (int) ((b + m) * 255)
        };
    }

    protected String getInferredName() {
        return UserInference.getInferredName();
    }

    ///
    /// Returns the text used in the ASCII art logo.
    /// @return the logo text
    ///
    protected String getLogoText() {
        if (logoText != null && !logoText.isEmpty()) {
            return logoText;
        }
        return "tomlib";
    }

}
