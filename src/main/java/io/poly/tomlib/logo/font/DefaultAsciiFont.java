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
            new AsciiFontCharacter("       ", "  ___  ", " / _` |", "| (_| |", " \\__, |", "       ")
        );
        registerCharacter('a', new AsciiFontCharacter("       ", "  ___  ", " / _` |", "| (_| |", " \\__, |", "       "));
        registerCharacter('b', new AsciiFontCharacter(" _     ", "| |__  ", "| '_ \\ ", "| |_) |", "|_.__/ ", "       "));
        registerCharacter('c', new AsciiFontCharacter("      ", "  ___ ", " / __|", "| (__ ", " \\___|", "      "));
        registerCharacter('d', new AsciiFontCharacter("     _ ", "  __| |", " / _` |", "| (_| |", " \\__,_|", "       "));
        registerCharacter('e', new AsciiFontCharacter("      ", "  ___ ", " / _ \\", "|  __/", " \\___|", "      "));
        registerCharacter('f', new AsciiFontCharacter("  ___ ", " / _ \\", "| |_  ", "|  _| ", "|_|   ", "      "));
        registerCharacter('g', new AsciiFontCharacter("       ", "  __ _ ", " / _` |", "| (_| |", " \\__, |", " |___/ "));
        registerCharacter('h', new AsciiFontCharacter(" _     ", "| |__  ", "| '_ \\ ", "| | | |", "|_| |_|", "       "));
        registerCharacter('i', new AsciiFontCharacter(" _ ", "(_)", "| |", "| |", "|_|", "   "));
        registerCharacter('j', new AsciiFontCharacter("    _ ", "   (_)", "   | |", "   | |", " _ | |", "(___/ "));
        registerCharacter('k', new AsciiFontCharacter(" _     ", "| | ___", "| |/ / ", "|   <  ", "|_|\\_\\ ", "       "));
        registerCharacter('l', new AsciiFontCharacter(" _ ", "| |", "| |", "| |", "|_|", "   "));
        registerCharacter('m', new AsciiFontCharacter("           ", " _ __ ___  ", "| '_ ` _ \\ ", "| | | | | |", "|_| |_| |_|", "           "));
        registerCharacter('n', new AsciiFontCharacter("       ", " _ __  ", "| '_ \\ ", "| | | |", "|_| |_|", "       "));
        registerCharacter('o', new AsciiFontCharacter("       ", "  ___  ", " / _ \\ ", "| (_) |", " \\___/ ", "       "));
        registerCharacter('p', new AsciiFontCharacter("       ", " _ __  ", "| '_ \\ ", "| |_) |", "| .__/ ", "|_|    "));
        registerCharacter('q', new AsciiFontCharacter("       ", "  __ _ ", " / _` |", "| (_| |", " \\__, |", "    |_|"));
        registerCharacter('r', new AsciiFontCharacter("      ", " _ __ ", "| '__|", "| |   ", "|_|   ", "      "));
        registerCharacter('s', new AsciiFontCharacter("     ", " ___ ", "/ __|", "\\__ \\", "|___/", "     "));
        registerCharacter('t', new AsciiFontCharacter(" _   ", "| |_ ", "| __|", "| |_ ", " \\__|", "     "));
        registerCharacter('u', new AsciiFontCharacter("       ", " _   _ ", "| | | |", "| |_| |", " \\__,_|", "       "));
        registerCharacter('v', new AsciiFontCharacter("       ", "__   __", "\\ \\ / /", " \\ V / ", "  \\_/  ", "       "));
        registerCharacter('w', new AsciiFontCharacter("          ", "__      __", "\\ \\ /\\ / /", " \\ V  V / ", "  \\_/\\_/  ", "          "));
        registerCharacter('x', new AsciiFontCharacter("      ", "__  __", "\\ \\/ /", " >  < ", "/_/\\_\\", "      "));
        registerCharacter('y', new AsciiFontCharacter("       ", " _   _ ", "| | | |", "| |_| |", " \\__, |", " |___/ "));
        registerCharacter('z', new AsciiFontCharacter("     ", " ____", "|_  /", " / / ", "/___|", "     "));
        registerCharacter('0', new AsciiFontCharacter("  ___  ", " / _ \\ ", "| | | |", "| |_| |", " \\___/ ", "       "));
        registerCharacter('1', new AsciiFontCharacter("  _ ", " / |", " | |", " | |", " |_|", "    "));
        registerCharacter('2', new AsciiFontCharacter("  ____  ", " |___ \\ ", "   __) |", "  / __/ ", " |_____|", "        "));
        registerCharacter('3', new AsciiFontCharacter("  _____ ", " |___ / ", "   |_ \\ ", "  ___) |", " |____/ ", "        "));
        registerCharacter('4', new AsciiFontCharacter("  _  _   ", " | || |  ", " | || |_ ", " |__   _|", "    |_|  ", "         "));
        registerCharacter('5', new AsciiFontCharacter("  ____  ", " | ___| ", " |___ \\ ", "  ___) |", " |____/ ", "        "));
        registerCharacter('6', new AsciiFontCharacter("   __   ", "  / /_  ", " | '_ \\ ", " | (_) |", "  \\___/ ", "        "));
        registerCharacter('7', new AsciiFontCharacter("  _____ ", " |___  |", "    / / ", "   / /  ", "  /_/   ", "        "));
        registerCharacter('8', new AsciiFontCharacter("   ___  ", "  ( _ ) ", "  / _ \\ ", " | (_) |", "  \\___/ ", "        "));
        registerCharacter('9', new AsciiFontCharacter("   ___  ", "  / _ \\ ", " | (_) |", "  \\__, |", "    /_/ ", "        "));
        registerCharacter('!', new AsciiFontCharacter("  _ ", " | |", " | |", " |_|", " (_)", "    "));
        registerCharacter('?', new AsciiFontCharacter("  ___  ", " |__ \\ ", "   / / ", "  |_|  ", "  (_)  ", "       "));
        registerCharacter('@', new AsciiFontCharacter("   __ _  ", "  / _` | ", " | (_| | ", "  \\__,_| ", "   | |   ", "   |_|   "));
        registerCharacter('#', new AsciiFontCharacter("   _  _   ", " _| || |_ ", "|_  ..  _|", " _| || |_ ", "|_  ..  _|", "  |_||_|  "));
        registerCharacter('$', new AsciiFontCharacter("  _  ", " | | ", " | | ", " | | ", " | | ", " |_| "));
        registerCharacter('%', new AsciiFontCharacter("  _ __  ", " (_) /  ", "    /   ", "   / _  ", "  / (_) ", "        "));
        registerCharacter('^', new AsciiFontCharacter("  /\\ ", " |  |", "  \\/ ", "     ", "     ", "     "));
        registerCharacter('&', new AsciiFontCharacter("   _     ", "  / \\    ", " / _ \\   ", "| (_) |_ ", " \\__,_(_)", "         "));
        registerCharacter('*', new AsciiFontCharacter("    _    ", "  _| |_  ", " |_   _| ", "   |_|   ", "         ", "         "));
        registerCharacter('(', new AsciiFontCharacter("  __", " /  ", "|   ", "|   ", " \\__", "    "));
        registerCharacter(')', new AsciiFontCharacter(" __  ", "   \\ ", "    |", "    |", " __/ ", "     "));
        registerCharacter('-', new AsciiFontCharacter("      ", "      ", " ____ ", "      ", "      ", "      "));
        registerCharacter('+', new AsciiFontCharacter("       ", "   _   ", " _| |_ ", "|_   _|", "  |_|  ", "       "));
        registerCharacter('=', new AsciiFontCharacter("      ", " ==== ", "      ", " ==== ", "      ", "      "));
        registerCharacter('[', new AsciiFontCharacter("  __ ", " |  |", " |  |", " |  |", " |__|", "     "));
        registerCharacter(']', new AsciiFontCharacter(" __  ", "|  | ", "|  | ", "|  | ", "|__| ", "     "));
        registerCharacter('{', new AsciiFontCharacter("  _  ", " | | ", " <   ", " | | ", "  |_|", "     "));
        registerCharacter('}', new AsciiFontCharacter("  _ ", " | |", "   >", " | |", "|_| ", "    "));
        registerCharacter(';', new AsciiFontCharacter("     ", "  _  ", " (_) ", "  _  ", " ( ) ", " / / "));
        registerCharacter(':', new AsciiFontCharacter("     ", "  _  ", " (_) ", "  _  ", " (_) ", "     "));
        registerCharacter('\'', new AsciiFontCharacter("  _ ", " ( )", "  / ", "    ", "    ", "    "));
        registerCharacter('"', new AsciiFontCharacter("  _   _ ", " ( ) ( )", "  /   / ", "        ", "        ", "        "));
        registerCharacter('<', new AsciiFontCharacter("    ", "  / ", " <  ", "  \\ ", "    ", "    "));
        registerCharacter('>', new AsciiFontCharacter("    ", " \\  ", "  > ", " /  ", "    ", "    "));
        registerCharacter(',', new AsciiFontCharacter("     ", "     ", "     ", "  _  ", " ( ) ", " / / "));
        registerCharacter('/', new AsciiFontCharacter("    /", "   / ", "  /  ", " /   ", "/    ", "     "));
        registerCharacter('\\', new AsciiFontCharacter("\\    ", " \\   ", "  \\  ", "   \\ ", "    \\", "     "));
        registerCharacter('|', new AsciiFontCharacter("  _ ", " | |", " | |", " | |", " |_|", "    "));
        registerCharacter('`', new AsciiFontCharacter(" _  ", "( ) ", " \\  ", "    ", "    ", "    "));
        registerCharacter('_', new AsciiFontCharacter("      ", "      ", "      ", "      ", " ____ ", "      "));
        registerCharacter('.', new AsciiFontCharacter("   ", "   ", "   ", " _ ", "(_)", "   "));
        registerCharacter(' ', new AsciiFontCharacter(" ", " ", " ", " ", " ", " "));
    }
}
