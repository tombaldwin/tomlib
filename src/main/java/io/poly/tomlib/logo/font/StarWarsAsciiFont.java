package io.poly.tomlib.logo.font;

/// Star Wars inspired ASCII font.
///
/// This font provides a 6-line high representation of characters in a style
/// reminiscent of the Star Wars logo, featuring distinctive slanted edges
/// and thematic letterforms.
public class StarWarsAsciiFont extends AbstractAsciiFont {
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
            " ________",
            "|   __   \\",
            "|  |__)  /",
            "|   __   \\",
            "|________/"
        );
        registerCompactCharacter('c',
            " _______",
            "/   ____|",
            "|   |",
            "|   \\___,",
            "\\_______|"
        );
        registerCompactCharacter('d',
            " ________",
            "|    __  \\",
            "|   |  \\  |",
            "|   |__/  |",
            "|________/"
        );
        registerCompactCharacter('e',
            " _______",
            "|   .___|",
            "|   |___",
            "|   |___",
            "|_______|"
        );
        registerCompactCharacter('f',
            " ________",
            "|    ____|",
            "|   |__",
            "|   |",
            "|___|"
        );
        registerCompactCharacter('g',
            " _______",
            "/  _____|",
            "|  |  __",
            "|  |__| |",
            "\\_______|"
        );
        registerCompactCharacter('h',
            " ___    ____",
            "|   |  |   |",
            "|   |__|   |",
            "|   |  |   |",
            "|___|  |___|"
        );
        registerCompactCharacter('i',
            " ____",
            "|    |",
            "|    |",
            "|    |",
            "|____|"
        );
        registerCompactCharacter('j',
            "    ___",
            "   |   |",
            "   |   |",
            ",__|   |",
            "\\______/"
        );
        registerCompactCharacter('k',
            " ___   ___",
            "|   | /   /",
            "|   |/   /",
            "|   |\\   \\",
            "|___| \\___\\"
        );
        registerCompactCharacter('l',
            " ___",
            "|   |",
            "|   |",
            "|   `____",
            "|________|"
        );
        registerCompactCharacter('m',
            " ____    ____",
            "|    \\  /    |",
            "|     \\/     |",
            "|   |    |   |",
            "|___|\\__/|___|"
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
            " ________",
            "|    __  \\",
            "|   |__)  |",
            "|    ____/",
            "|___|"
        );
        registerCompactCharacter('q',
            " ________",
            "/   ___  \\",
            "|  |   |  |",
            "|  |___\\  \\",
            " \\______\\_\\"
        );
        registerCompactCharacter('r',
            " ________",
            "|    __  \\   ",
            "|   |__)  |   ",
            "|   | \\  /____",
            "|___|  \\______|"
        );
        registerCompactCharacter('s',
            "    ___________,",
            "   /  _________|",
            "   \\_____  \\  ",
            ",_______|  |  ",
            "|__________/  "
        );
        registerCompactCharacter('t',
            " _________",
            "|__    ___|",
            "   |   |",
            "   |   |",
            "   |___|"
        );
        registerCompactCharacter('u',
            " __    __",
            "|  |  |  |",
            "|  |  |  |",
            "|  `--'  |",
            " \\______/"
        );
        registerCompactCharacter('v',
            "___        ___",
            "\\   \\    /   /",
            " \\   \\  /   /",
            "  \\   \\/   /",
            "   \\______/"
        );
        registerCompactCharacter('w',
            "___   ___   ___",
            "\\   \\/   \\/    /",
            " \\            /",
            "  \\    /\\    /",
            "   \\__/  \\__/  "
        );
        registerCompactCharacter('x',
            "____    ____",
            "\\   \\  /   /",
            " \\   \\/   /",
            " /   /\\   \\",
            "/___/  \\___\\"
        );
        registerCompactCharacter('y',
            "____  ____",
            "\\   \\/   /",
            " \\      /",
            "  |    |",
            "  `____'"
        );
        registerCompactCharacter('z',
            " _________",
            "|____    /",
            "    /   /",
            "   /   /____",
            "  /_________|"
        );
        registerCompactCharacter(' ',
            " "
        );
        registerCompactCharacter('0',
            " ______",
            "/   _  \\",
            "|  | |  |",
            "|  |_|  |",
            "\\______/"
        );
        registerCompactCharacter('1',
            " ____",
            "/_   |",
            " |   |",
            " |   |",
            " |___|"
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
            "   _____",
            "  /     |",
            " / /|   |_",
            "|___     _|",
            "    |___|"
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
