package io.poly.tomlib.logo.font;

import java.util.List;

/// A Star Trek inspired ASCII font.
///
/// This font uses a sleek, futuristic design inspired by the Star Trek title fonts.
public class StarTrekAsciiFont extends AbstractAsciiFont {

    private static final AsciiFontCharacter UNKNOWN_CHARACTER = new AsciiFontCharacter("  ", "  ", "  ", "  ", "  ", "  ");

    public StarTrekAsciiFont() {
        super(UNKNOWN_CHARACTER,
            new AsciiFontCharacter(
                "      ",
                "      ",
                "      ",
                "      ",
                "      ",
                "      "
            )
        );
        registerCharacters();
    }

    private void registerCharacters() {
        registerStarTrekChar('A',
            "   /\\   ",
            "  /  \\  ",
            " / /\\ \\ ",
            "/ /--\\ \\",
            "/_/    \\_\\"
        );
        registerStarTrekChar('B',
            "|----\\ ",
            "| |  | ",
            "| |__| ",
            "|  __  \\",
            "| |  | |",
            "|____/ /"
        );
        registerStarTrekChar('C',
            " /-----|",
            "/ /-----|",
            "| |     ",
            "| |     ",
            "\\ \\-----|",
            " \\-----|"
        );
        registerStarTrekChar('D',
            "|-----\\ ",
            "| | \\  \\",
            "| |  | |",
            "| |  | |",
            "| |_/  /",
            "|_____/ "
        );
        registerStarTrekChar('E',
            "|-------",
            "| |-----",
            "| |---  ",
            "| |---  ",
            "| |-----",
            "|-------"
        );
        registerStarTrekChar('F',
            "|-------",
            "| |-----",
            "| |---  ",
            "| |---  ",
            "| |     ",
            "|_|     "
        );
        registerStarTrekChar('G',
            " /-----|",
            "/ /-----|",
            "| |  ---|",
            "| | |__ |",
            "\\ \\----/|",
            " \\-----|"
        );
        registerStarTrekChar('H',
            "| |  | |",
            "| |  | |",
            "| |__| |",
            "|  __  |",
            "| |  | |",
            "|_|  |_|"
        );
        registerStarTrekChar('I',
            "|-----|",
            "   | |   ",
            "   | |   ",
            "   | |   ",
            "   | |   ",
            "|-----|"
        );
        registerStarTrekChar('J',
            "      | |",
            "      | |",
            "      | |",
            "| |   | |",
            "| \\---/ |",
            " \\-----/ "
        );
        registerStarTrekChar('K',
            "| | / /",
            "| |/ / ",
            "|   /  ",
            "|   \\  ",
            "| |\\ \\ ",
            "|_| \\_\\"
        );
        registerStarTrekChar('L',
            "| |     ",
            "| |     ",
            "| |     ",
            "| |     ",
            "| |-----",
            "|-------"
        );
        registerStarTrekChar('M',
            "|\\    /|",
            "| \\  / |",
            "|  \\/  |",
            "| |\\/| |",
            "| |  | |",
            "|_|  |_|"
        );
        registerStarTrekChar('N',
            "|\\    |",
            "| \\   |",
            "|  \\  |",
            "| | \\ |",
            "| |  \\|",
            "|_|   \\"
        );
        registerStarTrekChar('O',
            " /-----\\ ",
            "/ /---\\ \\",
            "| |   | |",
            "| |   | |",
            "\\ \\---/ /",
            " \\-----/ "
        );
        registerStarTrekChar('P',
            "|----\\ ",
            "| |  | ",
            "| |__| ",
            "|  ___/",
            "| |    ",
            "|_|    "
        );
        registerStarTrekChar('Q',
            " /-----\\ ",
            "/ /---\\ \\",
            "| |   | |",
            "| | \\ | |",
            "\\ \\--\\/ /",
            " \\----\\_\\"
        );
        registerStarTrekChar('R',
            "|----\\ ",
            "| |  | ",
            "| |__| ",
            "|  _  /",
            "| | \\ \\",
            "|_|  \\_\\"
        );
        registerStarTrekChar('S',
            " /-----|",
            "| |----- ",
            " \\-----\\ ",
            "  ----\\ \\",
            "|-----/ /",
            "|------/ "
        );
        registerStarTrekChar('T',
            "|-------|",
            "|---|---|",
            "    | |   ",
            "    | |   ",
            "    | |   ",
            "    |_|   "
        );
        registerStarTrekChar('U',
            "| |   | |",
            "| |   | |",
            "| |   | |",
            "| |   | |",
            "\\ \\---/ /",
            " \\-----/ "
        );
        registerStarTrekChar('V',
            "| |   | |",
            "| |   | |",
            "| |   | |",
            " \\ \\ / / ",
            "  \\ V /  ",
            "   \\_/   "
        );
        registerStarTrekChar('W',
            "| |  | |",
            "| |  | |",
            "| |  | |",
            "| |\\/| |",
            "|  /\\  |",
            "|_/  \\_|"
        );
        registerStarTrekChar('X',
            "\\ \\ / /",
            " \\ V / ",
            "  > <  ",
            " / ^ \\ ",
            "/ / \\ \\",
            "|_| |_|"
        );
        registerStarTrekChar('Y',
            "\\ \\ / /",
            " \\ V / ",
            "  | |  ",
            "  | |  ",
            "  | |  ",
            "  |_|  "
        );
        registerStarTrekChar('Z',
            "|-------",
            "|----- /",
            "     / / ",
            "    / /  ",
            "   / /---",
            "  /------"
        );
        registerStarTrekChar(' ',
            "    "
        );
    }

    private void registerStarTrekChar(char c, String... lines) {
        registerCompactCharacter(Character.toLowerCase(c), lines);
    }
}
