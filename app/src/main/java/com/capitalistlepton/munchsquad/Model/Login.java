package com.capitalistlepton.munchsquad.Model;

import com.capitalistlepton.munchsquad.Database.DBLink;

import org.json.JSONException;

import java.io.IOException;

public class Login {
    private DBLink mDBLink;


    public Login() {
        mDBLink = new DBLink();
    }

    public boolean login(String username, String password) {
        boolean result = false;
        try {
            result = mDBLink.login(username, password);
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean createUser(String name, String password, String username) {
        boolean result = false;
        try {
            result = mDBLink.createUser(name, password, username);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean validate(String username, String password) {
        return false; // TODO
    }
}
