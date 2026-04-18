package io.poly.tomlib.util;

import org.junit.jupiter.api.Test;
import java.time.MonthDay;
import static org.junit.jupiter.api.Assertions.*;

public class UserInferenceTest {

    @Test
    public void testGetInferredName() {
        String name = UserInference.getInferredName();
        // We can't know for sure what it will be on different systems,
        // but it should probably not be null if run in a normal environment.
        System.out.println("[DEBUG_LOG] Inferred name: " + name);
    }

    @Test
    public void testGetInferredBirthday() {
        MonthDay birthday = UserInference.getInferredBirthday();
        System.out.println("[DEBUG_LOG] Inferred birthday: " + birthday);
    }

    @Test
    public void testGetInferredAge() {
        int age = UserInference.getInferredAge();
        System.out.println("[DEBUG_LOG] Inferred age: " + age);
        // Age should be -1 or a positive number
        assertTrue(age >= -1);
    }
}
