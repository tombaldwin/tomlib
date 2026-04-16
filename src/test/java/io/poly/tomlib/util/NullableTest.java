package io.poly.tomlib.util;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class NullableTest {

    @Test
    void ofValue() {
        Nullable<String> n = Nullable.of("test");
        assertEquals("test-mapped", n.map(s -> s + "-mapped"));
    }

    @Test
    void ofNull() {
        Nullable<String> n = Nullable.of(null);
        assertNull(n.map(s -> s + "-mapped"));
    }

    @Test
    void ofClass() {
        Object val = 123;
        Nullable<Integer> n = Nullable.of(val, Integer.class);
        assertEquals(Integer.valueOf(246), n.map(i -> i * 2));
    }

    @Test
    void ofClassNullValue() {
        Nullable<Integer> n = Nullable.of(null, Integer.class);
        assertNull(n.value());
    }

    @Test
    void ofClassSubclass() {
        Object val = "test";
        Nullable<CharSequence> n = Nullable.of(val, CharSequence.class);
        assertEquals("test", n.value());
    }

    @Test
    void ofClassInvalid() {
        Object val = "not an int";
        assertThrows(ClassCastException.class, () -> Nullable.of(val, Integer.class));
    }

    @Test
    void ofInteger() {
        Object val = 456;
        Nullable<Integer> n = Nullable.ofInteger(val);
        assertEquals(Integer.valueOf(912), n.map(i -> i * 2));
    }

    @Test
    void ofIntegerNullValue() {
        Nullable<Integer> n = Nullable.ofInteger(null);
        assertNull(n.value());
    }

    @Test
    void mappedEquals() {
        assertTrue(Nullable.mappedEquals("A", "A", String::toLowerCase));
        assertTrue(Nullable.mappedEquals("a", "A", String::toLowerCase));
        assertFalse(Nullable.mappedEquals("a", "B", String::toLowerCase));
        assertTrue(Nullable.mappedEquals(null, null, Object::toString));
        assertFalse(Nullable.mappedEquals("a", null, Object::toString));
        assertFalse(Nullable.mappedEquals(null, "a", Object::toString));
        assertTrue(Nullable.mappedEquals("a", "a", o -> null));
        assertTrue(Nullable.mappedEquals(null, null, o -> "never called"));
    }

    @Test
    void equalsHashCode() {
        Nullable<String> n1 = Nullable.of("test");
        Nullable<String> n2 = Nullable.of("test");
        Nullable<String> n3 = Nullable.of("other");
        Nullable<String> n4 = Nullable.of(null);

        assertEquals(n1, n2);
        assertNotEquals(n1, n3);
        assertNotEquals(n1, n4);
        assertEquals(n1.hashCode(), n2.hashCode());
        assertNotEquals(n1.hashCode(), n3.hashCode());
    }

    @Test
    void toString_behavior() {
        Nullable<String> n = Nullable.of("test");
        assertEquals("Nullable[value=test]", n.toString());
    }

    @Test
    void flatMap() {
        Nullable<String> n = Nullable.of("test");
        Nullable<Integer> result = n.flatMap(s -> Nullable.of(s.length()));
        assertEquals(4, result.value());

        Nullable<String> nullN = Nullable.of(null);
        Nullable<Integer> nullResult = nullN.flatMap(s -> Nullable.of(s.length()));
        assertNull(nullResult.value());

        Nullable<String> n2 = Nullable.of("test");
        Nullable<String> result2 = n2.flatMap(s -> Nullable.of(null));
        assertNull(result2.value());
    }

    @Test
    void orElse() {
        Nullable<String> n = Nullable.of("test");
        assertEquals("test", n.orElse("default"));

        Nullable<String> nullN = Nullable.of(null);
        assertEquals("default", nullN.orElse("default"));

        Nullable<String> nullN2 = Nullable.of(null);
        assertNull(nullN2.orElse(null));
    }
}
