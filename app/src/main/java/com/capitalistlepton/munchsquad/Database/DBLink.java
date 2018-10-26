package com.capitalistlepton.munchsquad.Database;

import android.os.StrictMode;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONException;
import org.json.JSONObject;


public class DBLink {

    private static final String BASE_URL = "https://munchsquad-api.herokuapp.com/";
/*

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
*/
    public static JSONObject post(String targetURL, String urlParameters) {
        URL url;
        HttpURLConnection connection = null;
        try {
            //Create connection
            url = new URL(BASE_URL + targetURL);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type",
                    "application/x-www-form-urlencoded");

            connection.setRequestProperty("Content-Length",
                    Integer.toString(urlParameters.getBytes().length));
            connection.setRequestProperty("Content-Language", "en-US");

            connection.setUseCaches(false);
            connection.setDoInput(true);
            connection.setDoOutput(true);

            //Send request
            DataOutputStream wr = new DataOutputStream(connection.getOutputStream ());
            wr.writeBytes(urlParameters);
            wr.flush ();
            wr.close ();

            //Get Response
            InputStream is = connection.getInputStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is));
            String line;
            StringBuilder response = new StringBuilder();
            while((line = rd.readLine()) != null) {
                response.append(line);
                response.append('\r');
            }
            rd.close();

            JSONObject result;
            try {
                result = new JSONObject(response.toString());
            } catch (JSONException e) {
                e.printStackTrace();
                result = null;
            }
            connection.disconnect();
            return result;

        } catch (Exception e) {

            e.printStackTrace();
            return null;

        } finally {

            if(connection != null) {
                connection.disconnect();
            }
        }
    }

    public static JSONObject get(String request) throws IOException {
        //TODO Don't disable network thread checking... bad practice.
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        URL url = new URL(BASE_URL + request);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
//        int responseCode = con.getResponseCode();
        //System.out.println("GET Response Code: " + responseCode);
//        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
//            System.out.println(response.toString());

            JSONObject result;
            try {
                result = new JSONObject(response.toString());
            } catch (JSONException e) {
                e.printStackTrace();
                result = null;
            }
            return result;
   /*     } else {
            return "GET failed";
        }*/

    }
}