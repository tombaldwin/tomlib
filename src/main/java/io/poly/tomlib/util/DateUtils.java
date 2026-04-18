package io.poly.tomlib.util;

import java.time.LocalDate;

/// Date-related utility methods for logo themes.
public class DateUtils {

    /// Determines if the given date falls within the Easter weekend (Good Friday to Easter Monday).
    ///
    /// @param date the date to check
    /// @return true if it is Easter weekend, false otherwise
    public static boolean isEasterWeekend(LocalDate date) {
        int year = date.getYear();
        LocalDate easterSunday = calculateEasterSunday(year);
        LocalDate goodFriday = easterSunday.minusDays(2);
        LocalDate easterMonday = easterSunday.plusDays(1);
        return !date.isBefore(goodFriday) && !date.isAfter(easterMonday);
    }

    ///
    /// Calculates the date of Easter Sunday for a given year using the Butcher-Meeus algorithm.
    ///
    /// @param year the year to calculate for
    /// @return the LocalDate of Easter Sunday
    public static LocalDate calculateEasterSunday(int year) {
        int a = year % 19;
        int b = year / 100;
        int c = year % 100;
        int d = b / 4;
        int e = b % 4;
        int f = (b + 8) / 25;
        int g = (b - f + 1) / 3;
        int h = (19 * a + b - d - g + 15) % 30;
        int i = c / 4;
        int k = c % 4;
        int l = (32 + 2 * e + 2 * i - h - k) % 7;
        int m = (a + 11 * h + 22 * l) / 451;
        int month = (h + l - 7 * m + 114) / 31;
        int day = ((h + l - 7 * m + 114) % 31) + 1;
        return LocalDate.of(year, month, day);
    }
}
