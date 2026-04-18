package io.poly.tomlib.logo.theme.standard;

import io.poly.tomlib.logo.AbstractTheme;
import io.poly.tomlib.logo.theme.standard.mascot.CatMascot;

import java.time.LocalDate;

import static io.poly.tomlib.logo.theme.easter.EasterTheme.arrayOf;

/// Standard theme for LogoPrinter, providing the default ASCII font logo.
public class StandardLogoTheme extends AbstractTheme {

    /// Creates a new instance of StandardLogoTheme.
    public StandardLogoTheme() {
        super(
            "Standard",
            arrayOf(CatMascot.class),
            arrayOf()
        );
    }

    @Override
    public float getMascotProbability() {
        return 0.01f;
    }

    @Override
    public boolean isActive(LocalDate date) {
        // Standard theme is always a fallback, but we can mark it as active
        // if no other seasonal theme matches.
        return true;
    }
}
