package io.poly.tomlib.util;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

public class DateUtilsTest {

    @Test
    public void calculateEasterSunday() {
        // 2024: March 31
        assertEquals(LocalDate.of(2024, 3, 31), DateUtils.calculateEasterSunday(2024));
        // 2025: April 20
        assertEquals(LocalDate.of(2025, 4, 20), DateUtils.calculateEasterSunday(2025));
        // 2026: April 5
        assertEquals(LocalDate.of(2026, 4, 5), DateUtils.calculateEasterSunday(2026));
    }

    @Test
    public void isEasterWeekend() {
        // Easter 2024 was Sunday March 31.
        // Good Friday: March 29
        // Easter Monday: April 1
        assertTrue(DateUtils.isEasterWeekend(LocalDate.of(2024, 3, 29))); // Good Friday
        assertTrue(DateUtils.isEasterWeekend(LocalDate.of(2024, 3, 30))); // Saturday
        assertTrue(DateUtils.isEasterWeekend(LocalDate.of(2024, 3, 31))); // Easter Sunday
        assertTrue(DateUtils.isEasterWeekend(LocalDate.of(2024, 4, 1)));  // Easter Monday

        assertFalse(DateUtils.isEasterWeekend(LocalDate.of(2024, 3, 28))); // Maundy Thursday
        assertFalse(DateUtils.isEasterWeekend(LocalDate.of(2024, 4, 2)));  // Tuesday after
    }
}
