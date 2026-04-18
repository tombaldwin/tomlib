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
        registerCharacter('a', "       ", "  ___  ", " / _` |", "| (_| |", " \\__, |", "       ");
        registerCharacter('b', " _     ", "| |__  ", "| '_ \\ ", "| |_) |", "|_.__/ ", "       ");
        registerCharacter('c', "      ", "  ___ ", " / __|", "| (__ ", " \\___|", "      ");
        registerCharacter('d', "     _ ", "  __| |", " / _` |", "| (_| |", " \\__,_|", "       ");
        registerCharacter('e', "      ", "  ___ ", " / _ \\", "|  __/", " \\___|", "      ");
        registerCharacter('f', "  ___ ", " / _ \\", "| |_  ", "|  _| ", "|_|   ", "      ");
        registerCharacter('g', "       ", "  __ _ ", " / _` |", "| (_| |", " \\__, |", " |___/ ");
        registerCharacter('h', " _     ", "| |__  ", "| '_ \\ ", "| | | |", "|_| |_|", "       ");
        registerCharacter('i', " _ ", "(_)", "| |", "| |", "|_|", "   ");
        registerCharacter('j', "    _ ", "   (_)", "   | |", "   | |", " _ | |", "(___/ ");
        registerCharacter('k', " _     ", "| | ___", "| |/ / ", "|   <  ", "|_|\\_\\ ", "       ");
        registerCharacter('l', " _ ", "| |", "| |", "| |", "|_|", "   ");
        registerCharacter('m', "           ", " _ __ ___  ", "| '_ ` _ \\ ", "| | | | | |", "|_| |_| |_|", "           ");
        registerCharacter('n', "       ", " _ __  ", "| '_ \\ ", "| | | |", "|_| |_|", "       ");
        registerCharacter('o', "       ", "  ___  ", " / _ \\ ", "| (_) |", " \\___/ ", "       ");
        registerCharacter('p', "       ", " _ __  ", "| '_ \\ ", "| |_) |", "| .__/ ", "|_|    ");
        registerCharacter('q', "       ", "  __ _ ", " / _` |", "| (_| |", " \\__, |", "    |_|");
        registerCharacter('r', "      ", " _ __ ", "| '__|", "| |   ", "|_|   ", "      ");
        registerCharacter('s', "     ", " ___ ", "/ __|", "\\__ \\", "|___/", "     ");
        registerCharacter('t', " _   ", "| |_ ", "| __|", "| |_ ", " \\__|", "     ");
        registerCharacter('u', "       ", " _   _ ", "| | | |", "| |_| |", " \\__,_|", "       ");
        registerCharacter('v', "       ", "__   __", "\\ \\ / /", " \\ V / ", "  \\_/  ", "       ");
        registerCharacter('w', "          ", "__      __", "\\ \\ /\\ / /", " \\ V  V / ", "  \\_/\\_/  ", "          ");
        registerCharacter('x', "      ", "__  __", "\\ \\/ /", " >  < ", "/_/\\_\\", "      ");
        registerCharacter('y', "       ", " _   _ ", "| | | |", "| |_| |", " \\__, |", " |___/ ");
        registerCharacter('z', "     ", " ____", "|_  /", " / / ", "/___|", "     ");
        registerCharacter('0', "  ___  ", " / _ \\ ", "| | | |", "| |_| |", " \\___/ ", "       ");
        registerCharacter('1', "  _ ", " / |", " | |", " | |", " |_|", "    ");
        registerCharacter('2', "  ____  ", " |___ \\ ", "   __) |", "  / __/ ", " |_____|", "        ");
        registerCharacter('3', "  _____ ", " |___ / ", "   |_ \\ ", "  ___) |", " |____/ ", "        ");
        registerCharacter('4', "  _  _   ", " | || |  ", " | || |_ ", " |__   _|", "    |_|  ", "         ");
        registerCharacter('5', "  ____  ", " | ___| ", " |___ \\ ", "  ___) |", " |____/ ", "        ");
        registerCharacter('6', "   __   ", "  / /_  ", " | '_ \\ ", " | (_) |", "  \\___/ ", "        ");
        registerCharacter('7', "  _____ ", " |___  |", "    / / ", "   / /  ", "  /_/   ", "        ");
        registerCharacter('8', "   ___  ", "  ( _ ) ", "  / _ \\ ", " | (_) |", "  \\___/ ", "        ");
        registerCharacter('9', "   ___  ", "  / _ \\ ", " | (_) |", "  \\__, |", "    /_/ ", "        ");
        registerCharacter('!', "  _ ", " | |", " | |", " |_|", " (_)", "    ");
        registerCharacter('?', "  ___  ", " |__ \\ ", "   / / ", "  |_|  ", "  (_)  ", "       ");
        registerCharacter('@', "   __ _  ", "  / _` | ", " | (_| | ", "  \\__,_| ", "   | |   ", "   |_|   ");
        registerCharacter('#', "   _  _   ", " _| || |_ ", "|_  ..  _|", " _| || |_ ", "|_  ..  _|", "  |_||_|  ");
        registerCharacter('$', "  _  ", " | | ", " | | ", " | | ", " | | ", " |_| ");
        registerCharacter('%', "  _ __  ", " (_) /  ", "    /   ", "   / _  ", "  / (_) ", "        ");
        registerCharacter('^', "  /\\ ", " |  |", "  \\/ ", "     ", "     ", "     ");
        registerCharacter('&', "   _     ", "  / \\    ", " / _ \\   ", "| (_) |_ ", " \\__,_(_)", "         ");
        registerCharacter('*', "    _    ", "  _| |_  ", " |_   _| ", "   |_|   ", "         ", "         ");
        registerCharacter('(', "  __", " /  ", "|   ", "|   ", " \\__", "    ");
        registerCharacter(')', " __  ", "   \\ ", "    |", "    |", " __/ ", "     ");
        registerCharacter('-', "      ", "      ", " ____ ", "      ", "      ", "      ");
        registerCharacter('+', "       ", "   _   ", " _| |_ ", "|_   _|", "  |_|  ", "       ");
        registerCharacter('=', "      ", " ==== ", "      ", " ==== ", "      ", "      ");
        registerCharacter('[', "  __ ", " |  |", " |  |", " |  |", " |__|", "     ");
        registerCharacter(']', " __  ", "|  | ", "|  | ", "|  | ", "|__| ", "     ");
        registerCharacter('{', "  _  ", " | | ", " <   ", " | | ", "  |_|", "     ");
        registerCharacter('}', "  _ ", " | |", "   >", " | |", "|_| ", "    ");
        registerCharacter(';', "     ", "  _  ", " (_) ", "  _  ", " ( ) ", " / / ");
        registerCharacter(':', "     ", "  _  ", " (_) ", "  _  ", " (_) ", "     ");
        registerCharacter('\'', "  _ ", " ( )", "  / ", "    ", "    ", "    ");
        registerCharacter('"', "  _   _ ", " ( ) ( )", "  /   / ", "        ", "        ", "        ");
        registerCharacter('<', "    ", "  / ", " <  ", "  \\ ", "    ", "    ");
        registerCharacter('>', "    ", " \\  ", "  > ", " /  ", "    ", "    ");
        registerCharacter(',', "     ", "     ", "     ", "  _  ", " ( ) ", " / / ");
        registerCharacter('/', "    /", "   / ", "  /  ", " /   ", "/    ", "     ");
        registerCharacter('\\', "\\    ", " \\   ", "  \\  ", "   \\ ", "    \\", "     ");
        registerCharacter('|', "  _ ", " | |", " | |", " | |", " |_|", "    ");
        registerCharacter('`', " _  ", "( ) ", " \\  ", "    ", "    ", "    ");
        registerCharacter('_', "      ", "      ", "      ", "      ", " ____ ", "      ");
        registerCharacter('.', "   ", "   ", "   ", " _ ", "(_)", "   ");
        registerCharacter(' ', " ", " ", " ", " ", " ", " ");
    }
}
