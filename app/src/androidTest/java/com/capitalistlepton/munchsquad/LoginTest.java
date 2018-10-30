package com.capitalistlepton.munchsquad;

import android.support.test.runner.AndroidJUnit4;

import com.capitalistlepton.munchsquad.Model.Login;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(AndroidJUnit4.class)
public class LoginTest {

    @BeforeClass
    public static void startup() {
        Login.createUser("admin", "password","admin");
    }

    @Test
    public void validLogin() {
        assertTrue(Login.validate("admin", "password"));
    }

    @Test
    public void invalidLoginWrongPassword() {
        assertFalse(Login.validate("admin", "pass"));
    }

    @Test
    public void invalidLoginInvalidUsername() {
        assertFalse(Login.validate("joe", "pass"));
    }

    @Test
    public void validCreateUser() {
        assertTrue(Login.createUser("Joe Bags", "password123",
                "joey") && Login.validate("joey", "password123"));
    }

    @AfterClass
    public static void tearDown() {
        Login.deleteUser("admin");
        Login.deleteUser("joey");
    }
}
