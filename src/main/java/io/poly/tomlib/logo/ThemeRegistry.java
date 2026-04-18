package io.poly.tomlib.logo;

import io.poly.tomlib.logo.theme.standard.StandardLogoTheme;
import org.jspecify.annotations.NonNull;

import java.util.*;

/// Registry for all available themes.
/// Dynamically discovers themes using ServiceLoader.
public class ThemeRegistry {
    private static final Map<Class<? extends Theme>, Theme> INSTANCES = new HashMap<>();

    /// Discovers and returns all available theme instances.
    /// Results are cached for performance.
    ///
    /// @return a map of theme classes to their instances.
    public static Map<Class<? extends Theme>, Theme> getThemes() {
        if (INSTANCES.isEmpty()) {
            ServiceLoader<Theme> loader = ServiceLoader.load(Theme.class);
            for (Theme theme : loader) {
                INSTANCES.put(theme.getClass(), theme);
            }
            // Fallback: search for AbstractTheme too as that's what's in the SPI file
            ServiceLoader<AbstractTheme> abstractLoader = ServiceLoader.load(AbstractTheme.class);
            for (AbstractTheme theme : abstractLoader) {
                INSTANCES.putIfAbsent(theme.getClass(), theme);
            }
        }
        return INSTANCES;
    }

    /// Clears the cached theme instances.
    /// Useful for testing or when dynamic loading behaviour needs to be refreshed.
    public static void clearCache() {
        INSTANCES.clear();
    }

    /// Returns a theme instance by its class.
    ///
    /// @param themeClass the class of the theme to retrieve
    /// @param <T>        the type of the theme
    /// @return the theme instance, or null if not found
    public static <T extends Theme> Optional<T> getTheme(Class<T> themeClass) {
        Theme theme = getThemes().get(themeClass);
        if (theme == null) {
            try {
                // Fallback for classes not registered via ServiceLoader
                theme = themeClass.getDeclaredConstructor().newInstance();
                INSTANCES.put(themeClass, theme);
            } catch (Exception e) {
                return Optional.empty();
            }
        }
        return Optional.of(themeClass.cast(theme));
    }

    public static @NonNull Theme getStandardTheme() {
        return Objects.requireNonNull(getTheme(StandardLogoTheme.class).orElse(null));
    }
}
