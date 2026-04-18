package io.poly.tomlib.logo.font;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/// The default ASCII font implementation, providing a 6-line high lowercase-only font.
///
/// This implementation defines the visual behaviour for lowercase letters and some punctuation.
public class DefaultAsciiFont extends AbstractAsciiFont {
    private static final int FONT_HEIGHT = 6;
    private static final AsciiFontCharacter UNKNOWN_CHARACTER = new AsciiFontCharacter("  ", "  ", "  ", "  ", "  ", "  ");

    public DefaultAsciiFont() {
        super(UNKNOWN_CHARACTER,
            new AsciiFontCharacter(
                "       ",
                "  ___  ",
                " / _` |",
                "| (_| |",
                " \\__, |",
                "       "
            )
        );
        registerCompactCharacter('a',
            "       ",
            "  ___  ",
            " / _` |",
            "| (_| |",
            " \\__, |"
        );
        registerCompactCharacter('b',
            " _     ",
            "| |__  ",
            "| '_ \\ ",
            "| |_) |",
            "|_.__/ "
        );
        registerCompactCharacter('c',
            "      ",
            "  ___ ",
            " / __|",
            "| (__ ",
            " \\___|"
        );
        registerCompactCharacter('d',
            "     _ ",
            "  __| |",
            " / _` |",
            "| (_| |",
            " \\__,_|"
        );
        registerCompactCharacter('e',
            "      ",
            "  ___ ",
            " / _ \\",
            "|  __/",
            " \\___|"
        );
        registerCompactCharacter('f',
            "  ___ ",
            " / _ \\",
            "| |_  ",
            "|  _| ",
            "|_|   "
        );
        registerCompactCharacter('g',
            "       ",
            "  __ _ ",
            " / _` |",
            "| (_| |",
            " \\__, |",
            " |___/ "
        );
        registerCompactCharacter('h',
            " _     ",
            "| |__  ",
            "| '_ \\ ",
            "| | | |",
            "|_| |_|"
        );
        registerCompactCharacter('i',
            " _ ",
            "(_)",
            "| |",
            "| |",
            "|_|"
        );
        registerCompactCharacter('j',
            "    _ ",
            "   (_)",
            "   | |",
            "   | |",
            " _ | |",
            "(___/ "
        );
        registerCompactCharacter('k',
            " _     ",
            "| | ___",
            "| |/ / ",
            "|   <  ",
            "|_|\\_\\ "
        );
        registerCompactCharacter('l',
            " _ ",
            "| |",
            "| |",
            "| |",
            "|_|"
        );
        registerCompactCharacter('m',
            "           ",
            " _ __ ___  ",
            "| '_ ` _ \\ ",
            "| | | | | |",
            "|_| |_| |_|"
        );
        registerCompactCharacter('n',
            "       ",
            " _ __  ",
            "| '_ \\ ",
            "| | | |",
            "|_| |_|"
        );
        registerCompactCharacter('o',
            "       ",
            "  ___  ",
            " / _ \\ ",
            "| (_) |",
            " \\___/ "
        );
        registerCompactCharacter('p',
            "       ",
            " _ __  ",
            "| '_ \\ ",
            "| |_) |",
            "| .__/ ",
            "|_|    "
        );
        registerCompactCharacter('q',
            "       ",
            "  __ _ ",
            " / _` |",
            "| (_| |",
            " \\__, |",
            "    |_|"
        );
        registerCompactCharacter('r',
            "      ",
            " _ __ ",
            "| '__|",
            "| |   ",
            "|_|   "
        );
        registerCompactCharacter('s',
            "     ",
            " ___ ",
            "/ __|",
            "\\__ \\",
            "|___/"
        );
        registerCompactCharacter('t',
            " _   ",
            "| |_ ",
            "| __|",
            "| |_ ",
            " \\__|"
        );
        registerCompactCharacter('u',
            "       ",
            " _   _ ",
            "| | | |",
            "| |_| |",
            " \\__,_|"
        );
        registerCompactCharacter('v',
            "       ",
            "__   __",
            "\\ \\ / /",
            " \\ V / ",
            "  \\_/  "
        );
        registerCompactCharacter('w',
            "          ",
            "__      __",
            "\\ \\ /\\ / /",
            " \\ V  V / ",
            "  \\_/\\_/  "
        );
        registerCompactCharacter('x',
            "      ",
            "__  __",
            "\\ \\/ /",
            " >  < ",
            "/_/\\_\\"
        );
        registerCompactCharacter('y',
            "       ",
            " _   _ ",
            "| | | |",
            "| |_| |",
            " \\__, |",
            " |___/ "
        );
        registerCompactCharacter('z',
            "     ",
            " ____",
            "|_  /",
            " / / ",
            "/___|"
        );
        registerCompactCharacter('0',
            "  ___  ",
            " / _ \\ ",
            "| | | |",
            "| |_| |",
            " \\___/ "
        );
        registerCompactCharacter('1',
            "  _ ",
            " / |",
            " | |",
            " | |",
            " |_|"
        );
        registerCompactCharacter('2',
            "  ____  ",
            " |___ \\ ",
            "   __) |",
            "  / __/ ",
            " |_____|"
        );
        registerCompactCharacter('3',
            "  _____ ",
            " |___ / ",
            "   |_ \\ ",
            "  ___) |",
            " |____/ "
        );
        registerCompactCharacter('4',
            "  _  _   ",
            " | || |  ",
            " | || |_ ",
            " |__   _|",
            "    |_|  "
        );
        registerCompactCharacter('5',
            "  ____  ",
            " | ___| ",
            " |___ \\ ",
            "  ___) |",
            " |____/ "
        );
        registerCompactCharacter('6',
            "   __   ",
            "  / /_  ",
            " | '_ \\ ",
            " | (_) |",
            "  \\___/ "
        );
        registerCompactCharacter('7',
            "  _____ ",
            " |___  |",
            "    / / ",
            "   / /  ",
            "  /_/   "
        );
        registerCompactCharacter('8',
            "   ___  ",
            "  ( _ ) ",
            "  / _ \\ ",
            " | (_) |",
            "  \\___/ "
        );
        registerCompactCharacter('9',
            "   ___  ",
            "  / _ \\ ",
            " | (_) |",
            "  \\__, |",
            "    /_/ "
        );
        registerCompactCharacter('!',
            "  _ ",
            " | |",
            " | |",
            " |_|",
            " (_)"
        );
        registerCompactCharacter('?',
            "  ___  ",
            " |__ \\ ",
            "   / / ",
            "  |_|  ",
            "  (_)"
        );
        registerCompactCharacter('@',
            "   __ _  ",
            "  / _` | ",
            " | (_| | ",
            "  \\__,_| ",
            "   | |   ",
            "   |_|   "
        );
        registerCompactCharacter('#',
            "   _  _   ",
            " _| || |_ ",
            "|_  ..  _|",
            " _| || |_ ",
            "|_  ..  _|",
            "  |_||_|  "
        );
        registerCompactCharacter('$',
            "  _  ",
            " | | ",
            " | | ",
            " | | ",
            " | | ",
            " |_| "
        );
        registerCompactCharacter('%',
            "  _ __  ",
            " (_) /  ",
            "    /   ",
            "   / _  ",
            "  / (_) "
        );
        registerCompactCharacter('^',
            "  /\\ ",
            " |  |",
            "  \\/ "
        );
        registerCompactCharacter('&',
            "   _     ",
            "  / \\    ",
            " / _ \\   ",
            "| (_) |_ ",
            " \\__,_(_)"
        );
        registerCompactCharacter('*',
            "    _    ",
            "  _| |_  ",
            " |_   _| ",
            "   |_|   "
        );
        registerCompactCharacter('(',
            "  __",
            " /  ",
            "|   ",
            "|   ",
            " \\__"
        );
        registerCompactCharacter(')',
            " __  ",
            "   \\ ",
            "    |",
            "    |",
            " __/ "
        );
        registerCompactCharacter('-',
            "      ",
            "      ",
            " ____ "
        );
        registerCompactCharacter('+',
            "       ",
            "   _   ",
            " _| |_ ",
            "|_   _|",
            "  |_|  "
        );
        registerCompactCharacter('=',
            "      ",
            " ==== ",
            "      ",
            " ==== "
        );
        registerCompactCharacter('[',
            "  __ ",
            " |  |",
            " |  |",
            " |  |",
            " |__|"
        );
        registerCompactCharacter(']',
            " __  ",
            "|  | ",
            "|  | ",
            "|  | ",
            "|__| "
        );
        registerCompactCharacter('{',
            "  _  ",
            " | | ",
            " <   ",
            " | | ",
            "  |_|"
        );
        registerCompactCharacter('}',
            "  _ ",
            " | |",
            "   >",
            " | |",
            "|_| "
        );
        registerCompactCharacter(';',
            "     ",
            "  _  ",
            " (_) ",
            "  _  ",
            " ( ) ",
            " / / "
        );
        registerCompactCharacter(':',
            "     ",
            "  _  ",
            " (_) ",
            "  _  ",
            " (_) "
        );
        registerCompactCharacter('\'',
            "  _ ",
            " ( )",
            "  / "
        );
        registerCompactCharacter('"',
            "  _   _ ",
            " ( ) ( )",
            "  /   / "
        );
        registerCompactCharacter('<',
            "    ",
            "  / ",
            " <  ",
            "  \\ "
        );
        registerCompactCharacter('>',
            "    ",
            " \\  ",
            "  > ",
            " /  "
        );
        registerCompactCharacter(',',
            "     ",
            "     ",
            "     ",
            "  _  ",
            " ( ) ",
            " / / "
        );
        registerCompactCharacter('/',
            "    /",
            "   / ",
            "  /  ",
            " /   ",
            "/    "
        );
        registerCompactCharacter('\\',
            "\\    ",
            " \\   ",
            "  \\  ",
            "   \\ ",
            "    \\"
        );
        registerCompactCharacter('|',
            "  _ ",
            " | |",
            " | |",
            " | |",
            " |_|"
        );
        registerCompactCharacter('`',
            " _  ",
            " ( ) ",
            " \\  "
        );
        registerCompactCharacter('_',
            "      ",
            "      ",
            "      ",
            "      ",
            " ____ "
        );
        registerCompactCharacter('.',
            "   ",
            "   ",
            "   ",
            " _ ",
            "(_)"
        );
        registerCompactCharacter(' ', " ");
    }
}
