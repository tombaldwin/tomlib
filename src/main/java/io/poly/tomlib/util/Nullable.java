package io.poly.tomlib.util;

import java.util.Objects;
import java.util.function.Function;

/// A simple wrapper for a value that might be null.
///
/// @param <T> the type of the value
public record Nullable<T>(T value) {

    public static <T> Nullable<T> of(T value) {
        return new Nullable<>(value);
    }

    public static <T> Nullable<T> of(Object value, Class<T> clazz) {
        return of(value == null ? null : clazz.cast(value));
    }

    public static Nullable<Integer> ofInteger(Object value) {
        return of(value, Integer.class);
    }

    /// Compares two objects by mapping them first.
    /// Null objects are mapped to null.
    public static <V> boolean mappedEquals(V o1, V o2, Function<V, ?> mapper) {
        if (o1 == o2) return true;
        Object m1 = o1 == null ? null : mapper.apply(o1);
        Object m2 = o2 == null ? null : mapper.apply(o2);
        return Objects.equals(m1, m2);
    }

    /// If value isn't null apply the mapper and return the result, otherwise return null.
    public <V> V map(Function<? super T, ? extends V> mapper) {
        return value == null ? null : mapper.apply(value);
    }

    /// If value isn't null apply the mapper and return the result, otherwise return `Nullable.of(null)`.
    public <V> Nullable<V> flatMap(Function<? super T, Nullable<V>> mapper) {
        return value == null ? of(null) : mapper.apply(value);
    }

    public T orElse(T other) {
        return value == null ? other : value;
    }
}
