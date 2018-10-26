package com.capitalistlepton.munchsquad.Database;

import android.os.StrictMode;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.json.*;


public class DBLink {

    String baseURL = "https://munchsquad-api.herokuapp.com/";

    public boolean createUser(String name, String password, String username) throws IOException {
        boolean result;
        String params = "name=" + encode(name) +
                "&username=" + encode(username) +
                "&password=" + encode(password);
        if (usernameAvailable(username)) {
            post(baseURL + "customers/", params);
            result = true;
        } else {
            System.out.println("That username is already taken.");
            result = false;
        }
        return result;
    }

    public boolean login(String username, String password) throws UnsupportedEncodingException, JSONException, IOException {
        boolean result = false;
        if (!usernameAvailable(username)) {
            result = BCrypt.checkpw(password, getHashedPw(username));
        }
        return result;
    }

    private String getHashedPw(String username) throws JSONException, IOException {
        JSONObject info = new JSONObject(get("customers/" + username));
        return info.getString("password");

    }

    private boolean usernameAvailable(String username) throws UnsupportedEncodingException, IOException {
        String result = get("customers/" + encode(username));
        return (result.equals("null"));
    }

    private void getCustomerNames() throws IOException {
        JSONArray arr = null;
        try {
            arr = new JSONArray(get("customers/"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < arr.length(); i++)
        {
            try {
                System.out.println(arr.getJSONObject(i).getString("name"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public String post(String targetURL, String urlParameters)
    {
        URL url;
        HttpURLConnection connection = null;
        try {
            //Create connection
            url = new URL(targetURL);
            connection = (HttpURLConnection)url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type",
                    "application/x-www-form-urlencoded");

            connection.setRequestProperty("Content-Length", "" +
                    Integer.toString(urlParameters.getBytes().length));
            connection.setRequestProperty("Content-Language", "en-US");

            connection.setUseCaches (false);
            connection.setDoInput(true);
            connection.setDoOutput(true);

            //Send request
            DataOutputStream wr = new DataOutputStream (
                    connection.getOutputStream ());
            wr.writeBytes (urlParameters);
            wr.flush ();
            wr.close ();

            //Get Response
            InputStream is = connection.getInputStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is));
            String line;
            StringBuffer response = new StringBuffer();
            while((line = rd.readLine()) != null) {
                response.append(line);
                response.append('\r');
            }
            rd.close();
            return response.toString();

        } catch (Exception e) {

            e.printStackTrace();
            return null;

        } finally {

            if(connection != null) {
                connection.disconnect();
            }
        }
    }

    private String get(String request) throws IOException {
        //TODO Don't disable network thread checking... bad practice.
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        URL url = new URL(baseURL + request);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        int responseCode = con.getResponseCode();
        //System.out.println("GET Response Code: " + responseCode);
        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            System.out.println(response.toString());
            // print result
            return response.toString();
        } else {
            return "GET failed";
        }

    }

    private String encode(String toEncode) throws UnsupportedEncodingException {
        return URLEncoder.encode(toEncode, "UTF-8");
    }
}