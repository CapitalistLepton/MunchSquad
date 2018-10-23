package com.capitalistlepton.munchsquad;

import com.capitalistlepton.munchsquad.Model.Login;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class LoginTest {

    private Login login;

    @Before
    public void init() {
        login = new Login();
    }

    @Test
    public void validLogin() {
        assertTrue(login.validate("admin", "password"));
    }

    @Test
    public void invalidLoginWrongPassword() {
        assertFalse(login.validate("admin", "pass"));
    }

    @Test
    public void invalidLoginInvalidUsername() {
        assertFalse(login.validate("joe", "pass"));
    }
}
