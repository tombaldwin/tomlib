package io.poly.tomlib.util;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

///
/// Tests for the TomlibConfig class.
///
class TomlibConfigTest {

    @BeforeEach
    @AfterEach
    void clearProperties() {
        System.clearProperty("tomlib.inference.enabled");
        System.clearProperty("tomlib.network.enabled");
    }

    @Test
    void defaultValues() {
        assertTrue(TomlibConfig.isInferenceEnabled());
        assertTrue(TomlibConfig.isNetworkEnabled());
    }

    @Test
    void disableInferenceViaSystemProperty() {
        System.setProperty("tomlib.inference.enabled", "false");
        assertFalse(TomlibConfig.isInferenceEnabled());
    }

    @Test
    void enableInferenceViaSystemProperty() {
        System.setProperty("tomlib.inference.enabled", "true");
        assertTrue(TomlibConfig.isInferenceEnabled());
    }

    @Test
    void disableNetworkViaSystemProperty() {
        System.setProperty("tomlib.network.enabled", "false");
        assertFalse(TomlibConfig.isNetworkEnabled());
    }

    @Test
    void enableNetworkViaSystemProperty() {
        System.setProperty("tomlib.network.enabled", "true");
        assertTrue(TomlibConfig.isNetworkEnabled());
    }

    @Test
    void inferenceRespectsConfig() {
        System.setProperty("tomlib.inference.enabled", "false");
        assertNull(UserInference.getInferredName());
        assertNull(UserInference.getInferredBirthday());
        assertEquals(-1, UserInference.getInferredAge());
    }

    @Test
    void networkRespectsConfig() {
        System.setProperty("tomlib.network.enabled", "false");
        String debt = io.poly.tomlib.util.LiveDataUtils.getUSNationalDebt();
        assertTrue(debt.contains("(ESTIMATED)"));
    }
}
