package io.poly.tomlib.util;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DebtUtilsTest {

    @Test
    void getNationalDebtEstimate() {
        String estimate = DebtUtils.getNationalDebtEstimate();
        assertNotNull(estimate);
        assertTrue(estimate.startsWith("$"));
        assertTrue(estimate.endsWith("(ESTIMATED)"));
        // Basic format check: $XX,XXX,XXX,XXX,XXX.XX (ESTIMATED)
        assertTrue(estimate.matches("\\$\\d{1,3}(,\\d{3})*\\.\\d{2} \\(ESTIMATED\\)"));
    }

    @Test
    void getUSNationalDebt() {
        String debt = DebtUtils.getUSNationalDebt();
        assertNotNull(debt);
        assertTrue(debt.startsWith("$"));
        // Should either be a real value or an estimate
        if (debt.endsWith("(ESTIMATED)")) {
            assertTrue(debt.matches("\\$\\d{1,3}(,\\d{3})*\\.\\d{2} \\(ESTIMATED\\)"));
        } else {
            assertTrue(debt.matches("\\$\\d{1,3}(,\\d{3})*\\.\\d{2}"));
        }
    }
}
