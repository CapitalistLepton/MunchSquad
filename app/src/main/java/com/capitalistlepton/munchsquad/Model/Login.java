package com.capitalistlepton.munchsquad.Model;

import com.capitalistlepton.munchsquad.Database.BCrypt;
import com.capitalistlepton.munchsquad.Database.DBLink;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URLEncoder;

public class Login {

    public static boolean validate(String username, String password) {
        try {
            JSONObject resp = DBLink.get("/customers/" + URLEncoder.encode(username, "UTF-8"));
            if (resp != null) {
                boolean res = BCrypt.checkpw(password, resp.getString("password"));
                return res;
            } else {
                return false;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Attempts to create a new user in the database
     *
     * @param username Username of the new user
     * @param password Password of the new user
     * @param name Full name of the new user
     * @return if the creation was successful or not
     */
    public static boolean createUser(String name, String password, String username) {
        try {
            String params = "username=" + URLEncoder.encode(username, "UTF-8") +
                    "&password=" +
                    URLEncoder.encode(password, "UTF-8") +
                    "&name=" +
                    URLEncoder.encode(name, "UTF-8");
            JSONObject resp = DBLink.post("/customers", params);
            return resp != null;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
