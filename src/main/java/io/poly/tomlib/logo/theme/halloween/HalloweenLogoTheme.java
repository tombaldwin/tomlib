package io.poly.tomlib.logo.theme.halloween;

import io.poly.tomlib.logo.AbstractTheme;
import io.poly.tomlib.logo.theme.halloween.mascot.*;

import java.time.LocalDate;

import static io.poly.tomlib.logo.theme.easter.EasterTheme.arrayOf;

/// Theme for Halloween.
/// Features ghost variants that adapt to the logo text.
public class HalloweenLogoTheme extends AbstractTheme {
    private Integer forcedVariant = null;

    /// Default constructor.
    public HalloweenLogoTheme() {
        super("Halloween", new Class[0], new Class[0]);
    }

    @Override
    public io.poly.tomlib.logo.AbstractMascot getMascot(boolean glitchMode) {
        return null;
    }

    /// Sets a specific ghost variant for testing.
    /// @param variant the variant index (0-2)
    public void setVariant(int variant) {
        this.forcedVariant = variant;
    }

    @Override
    public boolean isActive(LocalDate date) {
        return date.getMonthValue() == 10 && date.getDayOfMonth() == 31;
    }

    @Override
    public int getPriority() {
        return 10;
    }

    @Override
    public String[] getStarsLeft(boolean glitchMode) {
        return new String[]{
            " .   ",
            "   o ",
            " O   ",
            "  o  ",
            "   . ",
            "     "
        };
    }

    @Override
    public String[] getStarsRight(boolean glitchMode) {
        return new String[]{
            "     ",
            "   . ",
            "  o  ",
            "   O ",
            " o   ",
            "  .  "
        };
    }

    @Override
    public int[] getLogoColour(char c, int row, int col, boolean glitchMode) {
        // Logo starts at column 4 in LogoPrinter
        // StarsLeft is 5 chars wide. So logo art starts at col 9.
        if (col < 9) {
            return getStarColour(c, row, col, glitchMode);
        }

        int[] slimeColour = glitchMode ? new int[]{255, 0, 0} : new int[]{127, 255, 0};

        // If it's in the logo text row (index 3), it should be slime/blood (including spaces).
        if (row == 3) {
            return slimeColour;
        }

        // Eyes and mouth/nose/text characters for ghosts
        // '0' (scary ghost eyes), 'o' (cute/classic eyes), 'V'/'^' (mouths), 'u' (cute mouth), text characters.
        if (c == '0') {
            return new int[]{255, 0, 0}; // Red eyes for ghosts (scary/others)
        } else if (c == '.' || c == 'o' || c == 'O') {
            // These characters are used for slime/blood drips (stars).
            // However, '.' is also used in ghost tops (rows 0, 1), and 'o' is used for eyes in row 1.
            // If they are part of the ghost art (rows 0, 1, 2, 4), they should be white.
            // Note: row 2 for Classic/Cute ghost has '|  V  |' or '|  ^  |' which don't have .oO,
            // but Scary ghost has ' ) { ( ' which also doesn't.
            // BUT a future variant might use them.
            // We only want them to be white if they are in the GHOST body, which is centered.
            // For now, rows 0, 1, 2, 4 for col > 9 seems like a safe bet for "in logo area".
            if ((row == 0 || row == 1 || row == 4) && col > 9) {
                // Ghost eyes ('o') and body parts ('.', 'o') should be white
                return new int[]{255, 255, 255};
            }
            // If they are in the background (row 2) where we WANT them to be stars/drips.
            return getStarColour(c, row, col, glitchMode);
        } else if (c == 'f' || c == 'l' || c == 'e' || c == 'x' || c == 'i' || c == '|' || c == '^' || c == 't' || c == 'm' || c == 'b' || c == 'V' || c == 'u') {
            // These characters are used in logo text (box boundaries) or ghost body.
            // If they are part of the ghost art (rows 0, 1, 2, 4), they should be white.
            return new int[]{255, 255, 255};
        } else {
            return new int[]{255, 255, 255}; // White for the ghost body/other chars
        }
    }

    @Override
    public int[] getStarColour(char c, int row, int col, boolean glitchMode) {
        // Only colour as stars if they are outside the logo's horizontal range
        // Standard LogoPrinter uses logoStartColumn = 4
        // And we've seen starsLeft and starsRight are 5 chars wide
        // This is a bit of a hack because LogoPrinter doesn't pass whether it's a star or not.
        // But we can check the column. Stars are roughly in col < 9 and col > 15 (if logo is 6 wide)
        // Actually, LogoPrinter prints: starsLeft + logo[row] + starsRight
        // So we know the first 5 chars and last 5 chars of the logoLine ARE stars.

        // Wait, LogoPrinter.printLogoWithTheme:
        // logoLine = theme.showStars() ? (starsLeft[row] + logo[row] + starsRight[row]) : logo[row];
        // It then iterates through logoLine and calls getStarColour first, THEN getLogoColour.

        // If we want to be safe, we should only return star colours if col is in the star region.
        // However, we don't know the exact logo width here.

        // Let's try to detect if it's a star based on column if possible, but that's hard.
        // Better: detect if it's a star character AND NOT part of a ghost if possible.

        if (c == '.' || c == 'o' || c == 'O') {
            // If it's the ghost's eyes ('o'), it will be in row 1 (for 0-indexed ghost art)
            // But getLogoColour is called AFTER getStarColour in LogoPrinter.
            // Wait, I saw:
            /*
            int[] rgb = theme.getStarColour(c, row, col, glitchMode);
            if (col >= mascotColumn && mascot != null) {
                rgb = mascot.getColour(c, row, col);
            }
            else {
                rgb = theme.getLogoColour(c, row, col, glitchMode);
            }
            */
            // NO! getLogoColour OVERWRITES rgb from getStarColour.
            // So if getLogoColour returns something, it wins.
            // UNLESS it returns the same thing.

            if (glitchMode) {
                return new int[]{255, 0, 0}; // Red blood
            }
            // Shades of green for slime
            return switch (c) {
                case 'O' -> new int[]{50, 205, 50};   // Lime Green
                case '.' -> new int[]{173, 255, 47};  // Green Yellow
                default -> new int[]{127, 255, 0};   // Chartreuse
            };
        }
        return super.getStarColour(c, row, col, glitchMode);
    }

    @Override
    public String getGlitchMessage() {
        return "[!] BOO!";
    }

    @Override
    public String[] getLogo(String logoText, boolean glitchMode) {
        int variant;
        if (forcedVariant != null) {
            variant = forcedVariant;
        } else if (glitchMode) {
            variant = 2; // Scary Ghost
        } else {
            variant = rnd.nextInt(2); // Randomly choose between Classic (0) and Cute (1)
        }
        int textLength = logoText.length();
        int width = Math.max(textLength + 4, 12); // Minimum width for a decent ghost

        return switch (variant % 3) {
            case 1 -> { // Cute Ghost
                String[] art = new CuteGhostMascot().getArt();
                int artWidth = art[0].length();
                int totalWidth = Math.max(width, artWidth);
                String[] result = new String[art.length + 1];
                for (int i = 0; i < art.length; i++) {
                    int padding = (totalWidth - art[i].length()) / 2;
                    result[i < 3 ? i : i + 1] = " ".repeat(padding) + art[i] + " ".repeat(totalWidth - art[i].length() - padding);
                }
                result[3] = centerText(logoText, totalWidth);
                yield result;
            }
            case 2 -> { // Scary/Tall Ghost
                String[] art = new ScaryGhostMascot().getArt();
                int artWidth = art[0].length();
                int totalWidth = Math.max(width, artWidth);
                String[] result = new String[art.length + 1];
                for (int i = 0; i < art.length; i++) {
                    int padding = (totalWidth - art[i].length()) / 2;
                    result[i < 3 ? i : i + 1] = " ".repeat(padding) + art[i] + " ".repeat(totalWidth - art[i].length() - padding);
                }
                result[3] = centerText(logoText, totalWidth);
                yield result;
            }
            default -> { // Classic Ghost (Original)
                String[] art = new ClassicGhostMascot().getArt();
                int artWidth = art[0].length();
                int totalWidth = Math.max(width, artWidth);
                String[] result = new String[art.length + 1];
                for (int i = 0; i < art.length; i++) {
                    int padding = (totalWidth - art[i].length()) / 2;
                    result[i < 3 ? i : i + 1] = " ".repeat(padding) + art[i] + " ".repeat(totalWidth - art[i].length() - padding);
                }
                result[3] = centerText(logoText, totalWidth);
                yield result;
            }
        };
    }

    private String centerText(String text, int width) {
        int totalPadding = width - 2 - text.length();
        int leftPadding = totalPadding / 2;
        int rightPadding = totalPadding - leftPadding;
        return "|" + " ".repeat(leftPadding) + text + " ".repeat(rightPadding) + "|";
    }


    @Override
    public boolean glitchDistortion() {
        return false;
    }

    @Override
    public int noiseCount() {
        return rnd.nextInt(10) + 5;
    }

    @Override
    public void addNoiseColour(StringBuilder colouredLine, int row, int col, char c, boolean glitchMode) {
        // Green noise for Halloween
        int g = rnd.nextInt(150) + 50; // Green component 50-200
        int r = rnd.nextInt(50); // Small red component for variation
        int b = rnd.nextInt(30); // Small blue component for variation
        colouredLine.append(String.format("\u001B[38;2;%d;%d;%dm%c\u001B[0m", r, g, b, c));
    }

    @Override
    public boolean glitchCorruption() {
        return false;
    }
}
