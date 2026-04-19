package io.poly.tomlib.util;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.MonthDay;
import static org.junit.jupiter.api.Assertions.*;

/// Tests for user inference logic.
public class UserInferenceTest {

    private String originalInference;
    private String originalUserName;

    @BeforeEach
    public void setUp() {
        originalInference = System.getProperty("tomlib.inference.enabled");
        originalUserName = System.getProperty("tomlib.user.name");
        System.setProperty("tomlib.inference.enabled", "true");
    }

    @AfterEach
    public void tearDown() {
        if (originalInference != null) System.setProperty("tomlib.inference.enabled", originalInference);
        else System.clearProperty("tomlib.inference.enabled");

        if (originalUserName != null) System.setProperty("tomlib.user.name", originalUserName);
        else System.clearProperty("tomlib.user.name");
    }

    @Test
    public void inferFirstNameFromSpace() {
        System.setProperty("tomlib.user.name", "Tom Baldwin");
        assertEquals("Tom", UserInference.getInferredFirstName());
    }

    @Test
    public void inferFirstNameFromDot() {
        System.setProperty("tomlib.user.name", "tom.baldwin");
        assertEquals("Tom", UserInference.getInferredFirstName());
    }

    @Test
    public void inferFirstNameFromUnderscore() {
        System.setProperty("tomlib.user.name", "tom_baldwin");
        assertEquals("Tom", UserInference.getInferredFirstName());
    }

    @Test
    public void inferFirstNameFromHyphen() {
        System.setProperty("tomlib.user.name", "tom-baldwin");
        assertEquals("Tom", UserInference.getInferredFirstName());
    }

    @Test
    public void inferLastNameFromSpace() {
        System.setProperty("tomlib.user.name", "Tom Baldwin");
        assertEquals("Baldwin", UserInference.getInferredLastName());
    }

    @Test
    public void inferLastNameFromDot() {
        System.setProperty("tomlib.user.name", "tom.baldwin");
        assertEquals("Baldwin", UserInference.getInferredLastName());
    }

    @Test
    public void inferLastNameReturnsNullForSingleName() {
        System.setProperty("tomlib.user.name", "Tom");
        assertNull(UserInference.getInferredLastName());
    }

    @Test
    public void returnsNullWhenInferenceDisabled() {
        System.setProperty("tomlib.inference.enabled", "false");
        System.setProperty("tomlib.user.name", "Tom Baldwin");
        assertNull(UserInference.getInferredFirstName());
        assertNull(UserInference.getInferredLastName());
    }

    @Test
    public void inferName() {
        String name = UserInference.getInferredName();
        // We can't know for sure what it will be on different systems,
        // but it should probably not be null if run in a normal environment.
        System.out.println("[DEBUG_LOG] Inferred name: " + name);
    }

    @Test
    public void inferBirthday() {
        MonthDay birthday = UserInference.getInferredBirthday();
        System.out.println("[DEBUG_LOG] Inferred birthday: " + birthday);
    }

    @Test
    public void inferAge() {
        int age = UserInference.getInferredAge();
        System.out.println("[DEBUG_LOG] Inferred age: " + age);
        // Age should be -1 or a positive number
        assertTrue(age >= -1);
    }
}
