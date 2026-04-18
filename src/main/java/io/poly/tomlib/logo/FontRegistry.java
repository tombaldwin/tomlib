package io.poly.tomlib.logo;

import io.poly.tomlib.logo.font.AsciiFont;
import io.poly.tomlib.logo.font.DefaultAsciiFont;
import org.jspecify.annotations.NonNull;

import java.util.*;

/// Registry for all available ASCII fonts.
/// Dynamically discovers fonts using ServiceLoader.
public class FontRegistry {
    private static final Map<Class<? extends AsciiFont>, AsciiFont> INSTANCES = new HashMap<>();

    /// Discovers and returns all available font instances.
    /// Results are cached for performance.
    ///
    /// @return a map of font classes to their instances.
    public static Map<Class<? extends AsciiFont>, AsciiFont> getFonts() {
        if (INSTANCES.isEmpty()) {
            ServiceLoader<AsciiFont> loader = ServiceLoader.load(AsciiFont.class);
            for (AsciiFont font : loader) {
                INSTANCES.put(font.getClass(), font);
            }
        }
        return INSTANCES;
    }

    /// Clears the cached font instances.
    /// Useful for testing or when dynamic loading behaviour needs to be refreshed.
    public static void clearCache() {
        INSTANCES.clear();
    }

    /// Returns a font instance by its class.
    ///
    /// @param fontClass the class of the font to retrieve
    /// @param <T>       the type of the font
    /// @return the font instance, or null if not found
    public static <T extends AsciiFont> Optional<T> getFont(Class<T> fontClass) {
        AsciiFont font = getFonts().get(fontClass);
        if (font == null) {
            try {
                // Fallback for classes not registered via ServiceLoader
                font = fontClass.getDeclaredConstructor().newInstance();
                INSTANCES.put(fontClass, font);
            } catch (Exception e) {
                return Optional.empty();
            }
        }
        return Optional.of(fontClass.cast(font));
    }

    /// Returns the default font.
    ///
    /// @return the default ASCII font.
    public static @NonNull AsciiFont getDefaultFont() {
        return getFont(DefaultAsciiFont.class).orElseGet(DefaultAsciiFont::new);
    }
}
