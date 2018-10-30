package com.capitalistlepton.munchsquad.Database;

import android.os.AsyncTask;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class PostRequest extends AsyncTask<String, String, JSONObject> {

    private static final String BASE_URL = "https://munchsquad-api.herokuapp.com";

    private String urlParameters;

    public PostRequest(String urlParameters) {
        this.urlParameters = urlParameters;
    }

    @Override
    protected JSONObject doInBackground(String... urls) {
        try {
            URL url = new URL(BASE_URL + urls[0]);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type",
                    "application/x-www-form-urlencoded");
            con.setRequestProperty("Content-Length",
                    Integer.toString(urlParameters.getBytes().length));
            con.setRequestProperty("Content-Language", "en-US");

            con.setUseCaches(false);
            con.setDoInput(true);
            con.setDoOutput(true);

            //Send request
            DataOutputStream wr = new DataOutputStream(con.getOutputStream ());
            wr.writeBytes(urlParameters);
            wr.flush ();
            wr.close ();

            //Get Response
            InputStream is = con.getInputStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is));
            String line;
            StringBuilder response = new StringBuilder();
            while((line = rd.readLine()) != null) {
                response.append(line);
                response.append('\n');
            }
            rd.close();

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
