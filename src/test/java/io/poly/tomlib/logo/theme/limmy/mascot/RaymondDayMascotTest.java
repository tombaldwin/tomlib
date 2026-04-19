package io.poly.tomlib.logo.theme.limmy.mascot;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/// Tests for the Raymond Day mascot.
class RaymondDayMascotTest {

    @Test
    void quoteContainsInferredName() {
        RaymondDayMascot mascot = new RaymondDayMascot();
        String originalInference = System.getProperty("tomlib.inference.enabled");
        String originalOverride = System.getProperty("tomlib.user.name");

        try {
            // Force inference enabled and set a specific user name
            System.setProperty("tomlib.inference.enabled", "true");
            System.setProperty("tomlib.user.name", "test.user");

            String quote = ((io.poly.tomlib.logo.AbstractMascot)mascot).getQuotes().stream()
                    .filter(q -> q.startsWith("I'm getting a name..."))
                    .findFirst()
                    .orElseThrow();

            assertEquals("I'm getting a name... Test.", quote);
        } finally {
            if (originalOverride != null) System.setProperty("tomlib.user.name", originalOverride);
            else System.clearProperty("tomlib.user.name");

            if (originalInference != null) System.setProperty("tomlib.inference.enabled", originalInference);
            else System.clearProperty("tomlib.inference.enabled");
        }
    }

    @Test
    void quoteContainsDefaultNameWhenInferenceDisabled() {
        RaymondDayMascot mascot = new RaymondDayMascot();
        String originalInference = System.getProperty("tomlib.inference.enabled");
        try {
            System.setProperty("tomlib.inference.enabled", "false");
            String quote = ((io.poly.tomlib.logo.AbstractMascot)mascot).getQuotes().stream()
                    .filter(q -> q.startsWith("I'm getting a name..."))
                    .findFirst()
                    .orElseThrow();

            assertEquals("I'm getting a name... David.", quote);
        } finally {
            if (originalInference != null) {
                System.setProperty("tomlib.inference.enabled", originalInference);
            } else {
                System.clearProperty("tomlib.inference.enabled");
            }
        }
    }
}
