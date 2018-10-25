package com.capitalistlepton.munchsquad.Model;

import com.capitalistlepton.munchsquad.Database.Launcher;

public class Login {
    private Launcher mLauncher;

    public Login() {
        mLauncher = new Launcher();
//        mLauncher.login("lichtyj", "pass");
        mLauncher.checkUsername("admin");

    }

    public boolean validate(String username, String password) {
        return false; // TODO
    }
}
