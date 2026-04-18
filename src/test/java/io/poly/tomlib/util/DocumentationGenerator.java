package io.poly.tomlib.util;

import io.poly.tomlib.logo.*;
import io.poly.tomlib.logo.font.AbstractAsciiFont;
import io.poly.tomlib.logo.font.AsciiFont;

import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

/// Utility to auto-generate documentation with examples of themes, mascots, and fonts.
@SuppressWarnings("NewClassNamingConvention")
public class DocumentationGenerator {

    private static final String PRE_STYLE = "style=\"background-color: #0c0c0c; color: #cccccc; padding: 15px; border-radius: 5px; font-family: monospace; line-height: 1.2; overflow-x: auto;\"";

    public static void main(String[] args) throws IOException {
        new DocumentationGenerator().generateAllDocs();
    }

    @Test
    void generateAllDocs() throws IOException {
        generateFontsDocs();
        generateThemesDocs();
        generateMascotsDocs();
        System.out.println("Documentation generated: FONTS.md, THEMES.md, MASCOTS.md");
    }

    private static void generateFontsDocs() throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append("# Fonts\n\n");
        sb.append("<p align=\"right\">\n");
        sb.append("  <img src=\"docs/images/logo.svg\" width=\"100\" alt=\"tomlib Logo\">\n");
        sb.append("</p>\n\n");
        sb.append("This document contains colourful examples of all fonts available in the tomlib library.\n\n");

        List<AsciiFont> fonts = FontRegistry.getFonts().values().stream()
                .sorted(Comparator.comparing(f -> f.getClass().getSimpleName()))
                .toList();

        // Generate Table of Contents
        sb.append("## Table of Contents\n\n");
        for (AsciiFont font : fonts) {
            String name = font.getClass().getSimpleName();
            sb.append("- [").append(name).append("](#").append(name.toLowerCase()).append(")\n");
        }
        sb.append("\n---\n\n");

        for (AsciiFont font : fonts) {
            sb.append("### ").append(font.getClass().getSimpleName()).append("\n\n");
            sb.append("#### Sample Text\n\n");
            sb.append("<pre ").append(PRE_STYLE).append(">\n");

            String logoText = "tomlib";
            appendFontSample(sb, font, logoText);
            sb.append("</pre>\n\n");

            sb.append("#### All Characters\n\n");
            sb.append("<pre ").append(PRE_STYLE).append(">\n");
            appendAllFontCharacters(sb, font);
            sb.append("</pre>\n\n");
        }
        Files.writeString(Paths.get("FONTS.md"), sb.toString());
    }

    private static void appendFontSample(StringBuilder sb, AsciiFont font, String text) {
        String[] rendered = font.render(text);

        // For fonts, we'll use a simple rainbow effect similar to AbstractTheme's default
        for (int row = 0; row < rendered.length; row++) {
            String line = rendered[row];
            for (int col = 0; col < line.length(); col++) {
                char c = line.charAt(col);
                if (Character.isWhitespace(c)) {
                    sb.append(c);
                } else {
                    double hue = (row * 15.0 + col * 5.0) % 360.0;
                    int[] rgb = hsvToRgb(hue, 1.0, 1.0);
                    appendColouredChar(sb, c, rgb);
                }
            }
            sb.append("\n");
        }
    }

    private static void appendAllFontCharacters(StringBuilder sb, AsciiFont font) {
        if (!(font instanceof AbstractAsciiFont abstractFont)) {
            appendFontSample(sb, font, "abcdefghijklmnopqrstuvwxyz0123456789");
            return;
        }

        List<Character> sortedChars = abstractFont.getFontData().keySet().stream()
                .filter(c -> c != ' ')
                .sorted().toList();

        int maxWidth = 100;
        int currentWidth = 0;
        StringBuilder currentLine = new StringBuilder();

        for (Character c : sortedChars) {
            int charWidth = abstractFont.getFontData().get(c).getWidth();
            if (currentWidth + charWidth + (currentLine.isEmpty() ? 0 : 1) > maxWidth && !currentLine.isEmpty()) {
                appendFontSample(sb, font, currentLine.toString());
                sb.append("\n");
                currentLine.setLength(0);
                currentWidth = 0;
            }

            if (!currentLine.isEmpty()) {
                currentLine.append(" ");
                currentWidth += 1;
            }
            currentLine.append(c);
            currentWidth += charWidth;
        }

        if (!currentLine.isEmpty()) {
            appendFontSample(sb, font, currentLine.toString());
        }
    }

    private static void generateThemesDocs() throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append("# Themes\n\n");
        sb.append("<p align=\"right\">\n");
        sb.append("  <img src=\"docs/images/logo.svg\" width=\"100\" alt=\"tomlib Logo\">\n");
        sb.append("</p>\n\n");
        sb.append("This document contains colourful examples of all themes available in the tomlib library.\n\n");
        Map<Class<? extends Theme>, Theme> themes = ThemeRegistry.getThemes();
        List<Theme> sortedThemes = themes.values().stream()
                .sorted(Comparator.comparing(Theme::getName))
                .toList();

        // Generate Table of Contents
        sb.append("## Table of Contents\n\n");
        for (Theme theme : sortedThemes) {
            String name = theme.getName();
            String anchor = name.toLowerCase().replace(" ", "-") + "-theme";
            sb.append("- [").append(name).append(" Theme](#").append(anchor).append(")\n");
        }
        sb.append("\n---\n\n");

        for (Theme theme : sortedThemes) {
            sb.append("### ").append(theme.getName()).append(" Theme\n\n");

            String activationRule = theme.getActivationRule();
            if (activationRule != null) {
                sb.append("**Activation Rule:** ").append(activationRule).append("\n\n");
            }

            sb.append("#### Normal Mode\n\n");
            sb.append("<pre ").append(PRE_STYLE).append(">\n");
            appendThemeExample(sb, theme, false);
            sb.append("</pre>\n\n");

            if (theme.isGlitchable()) {
                sb.append("#### Glitch Mode\n\n");
                sb.append("<pre ").append(PRE_STYLE).append(">\n");
                appendThemeExample(sb, theme, true);
                sb.append("</pre>\n\n");
            }
        }
        Files.writeString(Paths.get("THEMES.md"), sb.toString());
    }

    private static void appendThemeExample(StringBuilder sb, Theme theme, boolean glitchMode) {
        String logoText = "tomlib";
        String[] logo = theme.getLogo(logoText, glitchMode);
        String[] starsLeft = theme.getStarsLeft(glitchMode);
        String[] starsRight = theme.getStarsRight(glitchMode);
        AbstractMascot mascot = theme.getMascot(glitchMode);
        String[] mascotArt = mascot != null ? mascot.getArt() : new String[0];
        Random glitchRand = new Random(42); // Seed for deterministic documentation

        int maxLines = Math.max(logo.length, mascotArt.length);
        int mascotColumn = 52;

        for (int row = 0; row < maxLines; row++) {
            StringBuilder lineContent = new StringBuilder();
            lineContent.append("    "); // Margin

            // Logo and Stars
            if (row < logo.length) {
                if (theme.showStars()) {
                    String left = starsLeft[row];
                    String mid = logo[row];
                    String right = starsRight[row];

                    for (int col = 0; col < left.length(); col++) {
                        appendThemeChar(sb, left.charAt(col), theme, row, col, glitchMode, null, glitchRand);
                    }
                    for (int col = 0; col < mid.length(); col++) {
                        appendThemeChar(sb, mid.charAt(col), theme, row, left.length() + col, glitchMode, null, glitchRand);
                    }
                    for (int col = 0; col < right.length(); col++) {
                        appendThemeChar(sb, right.charAt(col), theme, row, left.length() + mid.length() + col, glitchMode, null, glitchRand);
                    }
                } else {
                    for (int col = 0; col < logo[row].length(); col++) {
                        appendThemeChar(sb, logo[row].charAt(col), theme, row, col, glitchMode, null, glitchRand);
                    }
                }
            }

            // Padding and Mascot
            int currentPos = (row < logo.length) ?
                (4 + (theme.showStars() ? starsLeft[row].length() + logo[row].length() + starsRight[row].length() : logo[row].length()))
                : 4;

            if (mascot != null) {
                while (currentPos < mascotColumn) {
                    sb.append(" ");
                    currentPos++;
                }
                if (row < mascotArt.length) {
                    for (int col = 0; col < mascotArt[row].length(); col++) {
                        appendThemeChar(sb, mascotArt[row].charAt(col), theme, row, currentPos + col, glitchMode, mascot, glitchRand);
                    }
                }
            }
            sb.append("\n");
        }

        String tagLine = theme.getTagLine(glitchMode);
        if (tagLine != null) {
            sb.append("\n");
            // Convert ANSI tag line to HTML
            // Handle both 38;2;R;G;Bm and 38;5;Nm (though 38;2 is most common here)
            String htmlTagLine = tagLine.replaceAll("\u001B\\[38;2;(\\d+);(\\d+);(\\d+)m(.*?)\u001B\\[0m", "<span style=\"color: rgb($1,$2,$3);\">$4</span>");
            // Handle simple bold/underlined if they exist
            htmlTagLine = htmlTagLine.replaceAll("\u001B\\[1m(.*?)\u001B\\[[;\\d]*m", "<b>$1</b>");
            htmlTagLine = htmlTagLine.replaceAll("\u001B\\[[;\\d]*m", ""); // Strip remaining ANSI
            sb.append(htmlTagLine).append("\n");
        }
    }

    private static void appendThemeChar(StringBuilder sb, char c, Theme theme, int row, int col, boolean glitchMode, AbstractMascot mascot, Random rnd) {
        if (Character.isWhitespace(c)) {
            sb.append(c);
            return;
        }

        int[] rgb;
        if (mascot != null && col >= 52) {
            rgb = mascot.getColour(c, row, col);
        } else {
            if (c == '*' || c == '+' || c == '.') {
                rgb = theme.getStarColour(c, row, col, glitchMode);
            } else {
                rgb = theme.getLogoColour(c, row, col, glitchMode);
            }
        }

        appendColouredChar(sb, c, rgb);
    }

    private static void appendColouredChar(StringBuilder sb, char c, int[] rgb) {
        String escaped = switch (c) {
            case '<' -> "&lt;";
            case '>' -> "&gt;";
            case '&' -> "&amp;";
            case '"' -> "&quot;";
            default -> String.valueOf(c);
        };
        sb.append(String.format("<span style=\"color: rgb(%d,%d,%d);\">%s</span>", rgb[0], rgb[1], rgb[2], escaped));
    }

    private static void generateMascotsDocs() throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append("# Mascots\n\n");
        sb.append("<p align=\"right\">\n");
        sb.append("  <img src=\"docs/images/logo.svg\" width=\"100\" alt=\"tomlib Logo\">\n");
        sb.append("</p>\n\n");
        sb.append("This document contains colourful examples of all mascots available in the tomlib library.\n\n");

        Map<Class<? extends Theme>, Theme> themes = ThemeRegistry.getThemes();
        List<Theme> sortedThemes = themes.values().stream()
                .sorted(Comparator.comparing(Theme::getName))
                .toList();

        // Collect all mascots grouped by theme first to generate Table of Contents
        Map<String, List<AbstractMascot>> mascotsByTheme = new LinkedHashMap<>();
        Set<AbstractMascot> documentedMascots = new HashSet<>();

        for (Theme theme : sortedThemes) {
            List<AbstractMascot> themeMascots = getMascotsForTheme(theme);
            if (!themeMascots.isEmpty()) {
                mascotsByTheme.put(theme.getName(), themeMascots);
                documentedMascots.addAll(themeMascots);
            }
        }

        List<AbstractMascot> otherMascots = MascotRegistry.getMascots().values().stream()
                .filter(m -> !documentedMascots.contains(m))
                .sorted(Comparator.comparing(m -> m.getClass().getSimpleName()))
                .toList();

        // Generate Table of Contents
        sb.append("## Table of Contents\n\n");
        for (String themeName : mascotsByTheme.keySet()) {
            String anchor = themeName.toLowerCase().replace(" ", "-") + "-theme";
            sb.append("- [").append(themeName).append(" Theme](#").append(anchor).append(")\n");
            for (AbstractMascot mascot : mascotsByTheme.get(themeName)) {
                String mascotName = mascot.getClass().getSimpleName();
                sb.append("  - [").append(mascotName).append("](#").append(mascotName.toLowerCase()).append(")\n");
            }
        }
        if (!otherMascots.isEmpty()) {
            sb.append("- [Other Mascots](#other-mascots)\n");
            for (AbstractMascot mascot : otherMascots) {
                String mascotName = mascot.getClass().getSimpleName();
                sb.append("  - [").append(mascotName).append("](#").append(mascotName.toLowerCase()).append(")\n");
            }
        }
        sb.append("\n---\n\n");

        for (Map.Entry<String, List<AbstractMascot>> entry : mascotsByTheme.entrySet()) {
            sb.append("## ").append(entry.getKey()).append(" Theme\n\n");
            for (AbstractMascot mascot : entry.getValue()) {
                appendMascotToDocs(sb, mascot);
            }
        }

        if (!otherMascots.isEmpty()) {
            sb.append("## Other Mascots\n\n");
            for (AbstractMascot mascot : otherMascots) {
                appendMascotToDocs(sb, mascot);
            }
        }

        Files.writeString(Paths.get("MASCOTS.md"), sb.toString());
    }

    private static List<AbstractMascot> getMascotsForTheme(Theme theme) {
        List<AbstractMascot> themeMascots = new ArrayList<>();
        if (theme instanceof AbstractTheme abstractTheme) {
            themeMascots.addAll(abstractTheme.getMascots(null));
        } else {
            AbstractMascot normal = theme.getMascot(false);
            if (normal != null) themeMascots.add(normal);
            AbstractMascot glitch = theme.getMascot(true);
            if (glitch != null) themeMascots.add(glitch);
        }

        // Also check package for mascots that might be associated but not registered in the theme
        String themePackage = theme.getClass().getPackageName();
        String mascotPackage = themePackage + ".mascot";
        MascotRegistry.getMascots().values().stream()
                .filter(m -> m.getClass().getPackageName().equals(mascotPackage))
                .forEach(themeMascots::add);

        return themeMascots.stream()
                .distinct()
                .sorted(Comparator.comparing(m -> m.getClass().getSimpleName()))
                .toList();
    }

    private static void appendMascotToDocs(StringBuilder sb, AbstractMascot mascot) {
        sb.append("### ").append(mascot.getClass().getSimpleName()).append("\n\n");
        sb.append("<pre ").append(PRE_STYLE).append(">\n");
        String[] art = mascot.getArt();
        for (int row = 0; row < art.length; row++) {
            String line = art[row];
            for (int col = 0; col < line.length(); col++) {
                char c = line.charAt(col);
                if (Character.isWhitespace(c)) {
                    sb.append(c);
                } else {
                    int[] rgb = mascot.getColour(c, row, col);
                    appendColouredChar(sb, c, rgb);
                }
            }
            sb.append("\n");
        }
        sb.append("</pre>\n\n");

        // Add quotes if they exist
        java.util.List<String> quotes = mascot.getQuotes();
        if (!quotes.isEmpty()) {
            if (quotes.size() == 1) {
                sb.append("**Quote:** *\"").append(quotes.get(0)).append("\"*\n\n");
            } else {
                sb.append("**Quotes:**\n");
                for (String q : quotes) {
                    sb.append("- *\"").append(q).append("\"*\n");
                }
                sb.append("\n");
            }
        }
    }

    private static int[] hsvToRgb(double h, double s, double v) {
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
        return new int[]{(int) ((r + m) * 255), (int) ((g + m) * 255), (int) ((b + m) * 255)};
    }
}
