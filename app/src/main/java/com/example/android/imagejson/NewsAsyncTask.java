package com.example.android.imagejson;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;

import com.example.android.imagejson.model.NewsArticle;
import com.example.android.imagejson.model.Root;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;

public class NewsAsyncTask extends AsyncTaskLoader<ArrayList<NewsArticle>> {
    private static final String url_string = "https://newsapi.org/v2/top-headlines?country=us&category=business&apiKey=25ef44c6f8aa461e81d40a82b3d75fa5";

    public NewsAsyncTask(Context context) {
        super(context);
    }

    @Override
    public ArrayList<NewsArticle> loadInBackground() {
        ArrayList<NewsArticle> newsArticles = null;
        URL url = null;
        try {
            url = new URL(url_string);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        StringBuilder JsonData = new StringBuilder();
        HttpURLConnection httpURLConnection = null;
        InputStream inputStream = null;
        try {

            httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setReadTimeout(10000);
            httpURLConnection.setConnectTimeout(15000);
            httpURLConnection.connect();
            inputStream = httpURLConnection.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader reader = new BufferedReader(inputStreamReader);
            String line = reader.readLine();


            while (line != null) {
                JsonData.append(line);
                line = reader.readLine();

            }
            //this is the Gson
            Gson gson = new Gson();
            Root root = gson.fromJson(JsonData.toString(), Root.class);

            if (root != null) {
                if (root.getArticles() != null) {
                    newsArticles = (ArrayList<NewsArticle>) root.getArticles();
                }
            }

        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return newsArticles;
    }

}
