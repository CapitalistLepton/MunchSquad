package com.capitalistlepton.munchsquad.Database;

import android.os.AsyncTask;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GetRequest extends AsyncTask<String, String, JSONObject> {

    private static final String BASE_URL = "https://munchsquad-api.herokuapp.com";

    @Override
    protected JSONObject doInBackground(String... urls) {
        try {
            URL url = new URL(BASE_URL + urls[0]);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            StringBuilder response = new StringBuilder();
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            JSONObject result;
            try {
                result = new JSONObject(response.toString());
            } catch (JSONException e) {
                e.printStackTrace();
                result = null;
            }
            return result;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    protected void onPostExecute(JSONObject jsonObject) {
        super.onPostExecute(jsonObject);
    }
}
