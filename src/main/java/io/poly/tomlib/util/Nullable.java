package io.poly.tomlib.util;

import java.util.Objects;
import java.util.StringJoiner;
import java.util.function.Function;

public class Nullable<T> {
    private final T value;

    private Nullable(T value) {
        this.value = value;
    }

    public static <T> Nullable<T> of(T value) {
        return new Nullable<>(value);
    }

    public static <T> Nullable<T> of(Object value, Class<T> clazz) {
        return of(clazz.cast(value));
    }

    public static Nullable<Integer> ofInteger(Object value) {
        return of(value, Integer.class);
    }

    public static <V> boolean mappedEquals(V o1, V o2, Function<V, ?> mapper) {
        return Objects.equals(Nullable.of(o1).map(mapper), Nullable.of(o2).map(mapper));
    }

    ///  if value isn't null apply the mapper and return the result, otherwise return null
    public <V> V map(Function<? super T, ? extends V> mapper) {
        if (value == null) {
            return null;
        } else {
            return mapper.apply(value);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Nullable<?> nullable = (Nullable<?>) o;
        return Objects.equals(value, nullable.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Nullable.class.getSimpleName() + "[", "]").add("value=" + value).toString();
    }
}
