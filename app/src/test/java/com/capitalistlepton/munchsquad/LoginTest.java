package com.capitalistlepton.munchsquad;

import com.capitalistlepton.munchsquad.Model.Login;

import org.junit.Test;

import static org.junit.Assert.*;

public class LoginTest {

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
}
