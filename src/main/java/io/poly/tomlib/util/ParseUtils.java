package io.poly.tomlib.util;

import java.util.OptionalInt;
import java.util.OptionalLong;

/// Number parsing that returns "a number or nothing" instead of throwing.
///
/// Each method accepts exactly what its JDK namesake accepts, and is empty wherever that throws.
/// Nothing is trimmed: callers that want to ignore surrounding whitespace strip it themselves.
public class ParseUtils {

    /// Parses a base-10 int with exactly the semantics of [Integer#parseInt(String)], and so of
    /// [Integer#valueOf(String)], returning empty where those throw [NumberFormatException].
    ///
    /// - A single leading `+` or `-` is accepted: `"+5"` is 5 (Guava's `Ints.tryParse` rejects it).
    /// - Nothing is trimmed: `" 5"` and `"5 "` are empty.
    /// - `null` and `""` are empty.
    /// - Anything outside the int range is empty.
    /// - Anything else that isn't wholly a base-10 number is empty, such as `"1000.json"` or `"0x10"`.
    /// - Digits are those of [Character#digit(char, int)], so non-ASCII decimal digits are accepted.
    ///
    /// @param s the string to parse, may be null
    /// @return the parsed value, or empty if `s` is not a valid int
    public static OptionalInt parseInt(String s) {
        try {
            return OptionalInt.of(Integer.parseInt(s));
        } catch (NumberFormatException e) {
            return OptionalInt.empty();
        }
    }

    /// Parses a base-10 long with exactly the semantics of [Long#parseLong(String)], and so of
    /// [Long#valueOf(String)]. The contract is that of [#parseInt(String)], over the long range.
    /// As with the JDK, an `L` suffix is not accepted.
    ///
    /// @param s the string to parse, may be null
    /// @return the parsed value, or empty if `s` is not a valid long
    public static OptionalLong parseLong(String s) {
        try {
            return OptionalLong.of(Long.parseLong(s));
        } catch (NumberFormatException e) {
            return OptionalLong.empty();
        }
    }
}
