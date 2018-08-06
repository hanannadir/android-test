package com.example.android.imagejson;


import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.android.imagejson.model.NewsArticle;

import java.util.ArrayList;

 class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<ArrayList<NewsArticle>> {
    ListView listView;
    TextView noConnection;
    ProgressBar progressBar;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.list);
        progressBar = findViewById(R.id.progress);
        noConnection = findViewById(R.id.no_internet_connection);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);
            }
        });


        if (isConnected()) {
            LoaderManager loaderManager = getSupportLoaderManager();
            loaderManager.initLoader(0, null, this).forceLoad();
        } else {
            progressBar.setVisibility(View.GONE);
            noConnection.setVisibility(View.VISIBLE);

        }
    }

    public boolean isConnected() {
        ConnectivityManager cm =
                (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = null;
        if (cm != null) {
            activeNetwork = cm.getActiveNetworkInfo();
        }

        return activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();
    }


    @NonNull
    @Override
    public Loader<ArrayList<NewsArticle>> onCreateLoader(int id, @Nullable Bundle args) {
        return new NewsAsyncTask(this);
    }

    @Override
    public void onLoadFinished(@NonNull Loader<ArrayList<NewsArticle>> loader, ArrayList<NewsArticle> data) {
        progressBar.setVisibility(View.GONE);
        NewsArticleAdapter newsArticleAdapter = new NewsArticleAdapter(MainActivity.this, R.layout.list_item, data);
        listView.setAdapter(newsArticleAdapter);
    }

    @Override
    public void onLoaderReset(@NonNull Loader<ArrayList<NewsArticle>> loader) {

    }
}
