package com.capitalistlepton.munchsquad;

import android.support.test.runner.AndroidJUnit4;

import com.capitalistlepton.munchsquad.Model.Login;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Unit test for the Login class.
 *
 * NOTE: Since Login relies on Android's AsyncTask for HTTP requests, this test must be executed on
 * Android's sdk so it must be in the androidTest group.
 */
@RunWith(AndroidJUnit4.class)
public class LoginTest {

    /**
     * Creates the accounts needed for testing.
     */
    @BeforeClass
    public static void startup() {
        Login.createUser("Administrator", "password","admin");
    }

    /**
     * Tests a valid password and username combination.
     */
    @Test
    public void validLogin() {
        assertTrue(Login.validate("admin", "password"));
    }

    @Test
    public void getName() {
        assertEquals("Administrator", Login.getFullName("admin"));
    }

    /**
     * Tests a valid username with an invalid password.
     */
    @Test
    public void invalidLoginWrongPassword() {
        assertFalse(Login.validate("admin", "pass"));
    }

    /**
     * Tests an invalid username.
     */
    @Test
    public void invalidLoginInvalidUsername() {
        assertFalse(Login.validate("joe", "pass"));
    }

    /**
     * Creates and tests a new user.
     */
    @Test
    public void validCreateUser() {
        assertTrue(Login.createUser("Joe Bags", "password123",
                "joey") && Login.validate("joey", "password123"));
    }

    /**
     * Fails to create a user with a username that already exists.
     */
    @Test
    public void invalidCreateUser() {
        assertFalse(Login.createUser("Joey", "badpassword","admin"));
    }

    /**
     * Cleans up the accounts created during testing.
     */
    @AfterClass
    public static void tearDown() {
        Login.deleteUser("admin");
        Login.deleteUser("joey");
    }
}
