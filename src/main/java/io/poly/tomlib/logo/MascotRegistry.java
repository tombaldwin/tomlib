package io.poly.tomlib.logo;

import java.util.*;
import java.util.stream.Collectors;

/// Registry for all available mascots.
/// Dynamically discovers mascots using ServiceLoader.
public class MascotRegistry {
    private static final Map<Class<? extends AbstractMascot>, AbstractMascot> INSTANCES = new HashMap<>();

    /// Discovers and returns all available mascot instances.
    /// Results are cached for performance.
    ///
    /// @return a map of mascot classes to their instances.
    public static Map<Class<? extends AbstractMascot>, AbstractMascot> getMascots() {
        if (INSTANCES.isEmpty()) {
            ServiceLoader<AbstractMascot> loader = ServiceLoader.load(AbstractMascot.class);
            for (AbstractMascot mascot : loader) {
                INSTANCES.put(mascot.getClass(), mascot);
            }
        }
        return INSTANCES;
    }

    /// Clears the cached mascot instances.
    /// Useful for testing or when dynamic loading behaviour needs to be refreshed.
    public static void clearCache() {
        INSTANCES.clear();
    }

    /// Returns a mascot instance by its class.
    ///
    /// @param mascotClass the class of the mascot to retrieve
    /// @param <T>         the type of the mascot
    /// @return the mascot instance, or null if not found
    public static <T extends AbstractMascot> T getMascot(Class<T> mascotClass) {
        AbstractMascot mascot = getMascots().get(mascotClass);
        if (mascot == null) {
            try {
                // Fallback for classes not registered via ServiceLoader
                mascot = mascotClass.getDeclaredConstructor().newInstance();
                INSTANCES.put(mascotClass, mascot);
            } catch (Exception e) {
                return null;
            }
        }
        return mascotClass.cast(mascot);
    }

    @SafeVarargs
    public static List<? extends AbstractMascot> getMascots(Class<? extends AbstractMascot>... mascotClasses) {
        return Arrays.stream(mascotClasses)
                     .filter(AbstractMascot.class::isAssignableFrom)
                     .map(mascotClass -> getMascot((Class<? extends AbstractMascot>) mascotClass))
                     .filter(Objects::nonNull)
                     .collect(Collectors.toList());
    }
}
