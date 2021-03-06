package com.capitalistlepton.munchsquad.Database;

import android.os.AsyncTask;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Executes a GET request asynchronously to the specified URL.
 */
public class GetRequest extends AsyncTask<String, String, JSONObject> {

    /** Base URL of the CRUD API */
    private static final String BASE_URL = "https://munchsquad-api.herokuapp.com";

    /**
     * Execute the actual GET request with the given URLs.
     * NOTE: Only the first URL is used.
     *
     * @param urls List of URLs. Only the first is used and the rest are ignored.
     * @return JSONObject of the response from the API.
     */
    @Override
    protected JSONObject doInBackground(String... urls) {
        try {
            // Make URL to send the request to
            URL url = new URL(BASE_URL + urls[0]);
            // Open connection to the URL
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            // Read in the response
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            StringBuilder response = new StringBuilder();
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // Parse the response into a JSONObject
            JSONObject result = new JSONObject(response.toString());
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Returns the result of the request.
     *
     * @param jsonObject JSONObject result of the request.
     */
    @Override
    protected void onPostExecute(JSONObject jsonObject) {
        super.onPostExecute(jsonObject);
    }
}
