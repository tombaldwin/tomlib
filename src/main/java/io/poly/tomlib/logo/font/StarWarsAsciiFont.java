package io.poly.tomlib.logo.font;

/// Star Wars inspired ASCII font.
///
/// This font provides a 6-line high representation of characters in a style
/// reminiscent of the Star Wars logo, featuring distinctive slanted edges
/// and thematic letterforms.
public class StarWarsAsciiFont extends AbstractAsciiFont {
    private static final int FONT_HEIGHT = 6;
    private static final AsciiFontCharacter UNKNOWN_CHARACTER = new AsciiFontCharacter(
        "  ",
        "  ",
        "  ",
        "  ",
        "  ",
        "  "
    );

    public StarWarsAsciiFont() {
        super(UNKNOWN_CHARACTER,
            new AsciiFontCharacter(
                "___    ",
                "/  /   ",
                "/  /   ",
                "/  /__ ",
                "/_____/",
                "       "
            )
        );

        registerCompactCharacter('a',
            "    _____ ",
            "   /     \\",
            "  /  /_\\  \\",
            " /  _____  \\",
            "/__/     \\__\\"
        );
        registerCompactCharacter('b',
            " _______",
            "|  __   \\",
            "| |__)  |",
            "|  __   <",
            "|_______/"
        );
        registerCompactCharacter('c',
            " _______",
            "/  _____|",
            "|  |",
            "|  \\___,",
            "\\______/"
        );
        registerCompactCharacter('d',
            "_______",
            "|  __   \\",
            "| |  \\   |",
            "| |__/   |",
            "|_______/"
        );
        registerCompactCharacter('e',
            " _______",
            "|   ____|",
            "|  |__",
            "|  |____",
            "|_______|"
        );
        registerCompactCharacter('f',
            " _______",
            "|   ____|",
            "|  |__",
            "|  |",
            "|__|"
        );
        registerCompactCharacter('g',
            " _______",
            "/  _____|",
            "|  |  __",
            "|  |__| |",
            "\\_______|"
        );
        registerCompactCharacter('h',
            " __    __",
            "|  |  |  |",
            "|  |__|  |",
            "|  |  |  |",
            "|__|  |__|"
        );
        registerCompactCharacter('i',
            " _______",
            "|__   __|",
            "   | |",
            " __| |__",
            "|_______|"
        );
        registerCompactCharacter('j',
            "   __",
            "  |  |",
            "  |  |",
            " _|  |",
            "\\____/"
        );
        registerCompactCharacter('k',
            " __   __",
            "|  | /  /",
            "|  |/  /",
            "|  |\\  \\",
            "|__| \\__\\"
        );
        registerCompactCharacter('l',
            " __",
            "|  |",
            "|  |",
            "|  `____",
            "|_______|"
        );
        registerCompactCharacter('m',
            " ___    ___",
            "|   \\  /   |",
            "|  |\\  /|  |",
            "|  | \\/ |  |",
            "|__|    |__|"
        );
        registerCompactCharacter('n',
            " ___   ___",
            "|   \\ |   |",
            "|    \\|   |",
            "|   |\\    |",
            "|___| \\___|"
        );
        registerCompactCharacter('o',
            "  _______",
            " /  ___  \\",
            "|  |   |  |",
            "|  |___|  |",
            " \\_______/"
        );
        registerCompactCharacter('p',
            " _______",
            "|   __  \\",
            "|  |__)  |",
            "|   ____/",
            "|__|"
        );
        registerCompactCharacter('q',
            " ________",
            "/   ___  \\",
            "|  |   |  |",
            "|  |___\\  \\",
            " \\______\\_\\"
        );
        registerCompactCharacter('r',
            " _______",
            "|   __  \\   ",
            "|  |__)  |   ",
            "|  | \\  /____",
            "|__|  \\______|"
        );
        registerCompactCharacter('s',
            "    ___________,",
            "   /  _________|",
            "   \\_____  \\  ",
            ",_______|  |  ",
            "|__________/  "
        );
        registerCompactCharacter('t',
            " ________",
            "|__   ___|",
            "   |  |",
            "   |  |",
            "   |__|"
        );
        registerCompactCharacter('u',
            " __    __",
            "|  |  |  |",
            "|  |  |  |",
            "|  `--'  |",
            " \\______/"
        );
        registerCompactCharacter('v',
            "__        __",
            "\\  \\    /  /",
            " \\  \\  /  /",
            "  \\  \\/  /",
            "   \\____/"
        );
        registerCompactCharacter('w',
            "___   ___   ___",
            "\\   \\/   \\/    /",
            " \\            /",
            "  \\    /\\    /",
            "   \\__/  \\__/  "
        );
        registerCompactCharacter('x',
            "___    ___",
            "\\  \\  /  /",
            " \\  \\/  /",
            " /  /\\  \\",
            "/__/  \\__\\"
        );
        registerCompactCharacter('y',
            "___    ___",
            "\\  \\  /  /",
            " \\  \\/  /",
            "  |    |",
            "  `____'"
        );
        registerCompactCharacter('z',
            " _______",
            "|___    |",
            "   /   /",
            "  /   /____",
            " |_________|"
        );
        registerCompactCharacter(' ',
            " "
        );
        registerCompactCharacter('0',
            " _______",
            "/   _  \\",
            "|  | |  |",
            "|  |_|  |",
            "\\______/"
        );
        registerCompactCharacter('1',
            " __",
            "/_ |",
            " | |",
            " | |",
            " |_|"
        );
        registerCompactCharacter('2',
            "_______",
            "|___    \\",
            " ___)   |",
            "|  |____",
            "|_______|"
        );
        registerCompactCharacter('3',
            " _______",
            "|___    \\",
            " |__    <",
            "  __)   |",
            "|_______/"
        );
        registerCompactCharacter('4',
            " _    _",
            "| |  | |",
            "| |__| |__",
            "|____   __|",
            "     |_|"
        );
        registerCompactCharacter('5',
            " _______",
            "|   ____|",
            "|  |__",
            " ___)   |",
            "|_______/"
        );
        registerCompactCharacter('6',
            " _______",
            "/  _____|",
            "|   __  \\",
            "|  |__)  |",
            "\\_______/"
        );
        registerCompactCharacter('7',
            " _______",
            "|___    |",
            "    /  /",
            "   /  /",
            "  /__/"
        );
        registerCompactCharacter('8',
            " _______",
            "/  ___  \\",
            ">  ___  <",
            "|  | |  |",
            "\\_______/"
        );
        registerCompactCharacter('9',
            " _______",
            "/   ___  \\",
            "|  |___|  |",
            " \\______  |",
            "|________/"
        );
    }

    /// Registers a character by padding its lines to the same length and font height.
    ///
    /// This method ensures that characters can be defined compactly in the source code
    /// while still meeting the rectangular requirement of {@link AsciiFontCharacter}.
    ///
    /// @param c the character to register.
    /// @param lines the ASCII art lines for the character.
    @Override
    protected void registerCompactCharacter(char c, String... lines) {
        super.registerCompactCharacter(c, lines);
    }
}
