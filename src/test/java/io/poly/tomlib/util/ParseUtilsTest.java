package io.poly.tomlib.util;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.OptionalInt;
import java.util.OptionalLong;

import static org.junit.jupiter.api.Assertions.*;

class ParseUtilsTest {

    @ParameterizedTest
    @CsvSource({
            "0, 0",
            "5, 5",
            "007, 7",
            "+5, 5",
            "-5, -5",
            "-0, 0",
            "+0, 0",
            "2147483647, 2147483647",
            "-2147483648, -2147483648",
            "٥, 5"
    })
    void parseIntAccepts(String s, int expected) {
        assertEquals(OptionalInt.of(expected), ParseUtils.parseInt(s));
        assertEquals(Integer.valueOf(s), ParseUtils.parseInt(s).getAsInt());
    }

    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {
            "", " ", " 5", "5 ", "\t5", "5\n", "+", "-", "++5", "+-5", "- 5", "5-",
            "2147483648", "-2147483649", "9223372036854775807", "99999999999999999999",
            "1000.json", "1.0", "1e3", "1,000", "1_000", "5L", "0x10", "#10", "ff", "abc"
    })
    void parseIntIsEmptyWhereTheJdkThrows(String s) {
        assertEquals(OptionalInt.empty(), ParseUtils.parseInt(s));
        assertThrows(NumberFormatException.class, () -> Integer.valueOf(s));
    }

    @ParameterizedTest
    @CsvSource({
            "0, 0",
            "007, 7",
            "+5, 5",
            "-5, -5",
            "-0, 0",
            "2147483648, 2147483648",
            "-2147483649, -2147483649",
            "9223372036854775807, 9223372036854775807",
            "-9223372036854775808, -9223372036854775808"
    })
    void parseLongAccepts(String s, long expected) {
        assertEquals(OptionalLong.of(expected), ParseUtils.parseLong(s));
        assertEquals(Long.valueOf(s), ParseUtils.parseLong(s).getAsLong());
    }

    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {
            "", " ", " 5", "5 ", "+", "-", "++5",
            "9223372036854775808", "-9223372036854775809",
            "1000.json", "1.0", "5L", "0x10", "abc"
    })
    void parseLongIsEmptyWhereTheJdkThrows(String s) {
        assertEquals(OptionalLong.empty(), ParseUtils.parseLong(s));
        assertThrows(NumberFormatException.class, () -> Long.valueOf(s));
    }
}
