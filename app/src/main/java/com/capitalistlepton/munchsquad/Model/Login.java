package com.capitalistlepton.munchsquad.Model;

import com.capitalistlepton.munchsquad.Database.BCrypt;
import com.capitalistlepton.munchsquad.Database.DBLink;
import com.capitalistlepton.munchsquad.Database.DeleteRequest;
import com.capitalistlepton.munchsquad.Database.GetRequest;
import com.capitalistlepton.munchsquad.Database.PostRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.concurrent.ExecutionException;

public class Login {

    /**
     * Validates a given username and password with the database.
     *
     * @param username String username to check.
     * @param password String password to check.
     * @return if the username and password are valid.
     */
    public static boolean validate(String username, String password) {
        GetRequest req = new GetRequest();
        try {
            JSONObject resp = req.execute("/customers/" + URLEncoder.encode(username, "UTF-8"))
                    .get();
            if (resp != null) {
                boolean res = BCrypt.checkpw(password, resp.getString("password"));
                return res;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Attempts to create a new user in the database.
     *
     * @param username String username of the new user.
     * @param password String password of the new user.
     * @param name String full name of the new user.
     * @return if the creation was successful or not.
     */
    public static boolean createUser(String name, String password, String username) {
        try {
            String params = "username=" + URLEncoder.encode(username, "UTF-8") +
                    "&password=" +
                    URLEncoder.encode(password, "UTF-8") +
                    "&name=" +
                    URLEncoder.encode(name, "UTF-8");
            PostRequest req = new PostRequest(params);
            JSONObject resp = req.execute("/customers").get();
            if (resp == null || resp.has("error")) {
                return false;
            } else {
                return resp.getString("username").equals(username);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Deletes the user with the given username.
     *
     * @param username String username of user to delete from database.
     * @return whether or not the deletion was successful.
     */
    public static boolean deleteUser(String username) {
        DeleteRequest req = new DeleteRequest();
        try {
            JSONObject resp = req.execute("/customers/" + URLEncoder.encode(username, "UTF-8"))
                    .get();
            return resp == null;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
