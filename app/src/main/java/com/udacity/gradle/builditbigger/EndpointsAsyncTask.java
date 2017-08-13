package com.udacity.gradle.builditbigger;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;

import com.youknow.joke.backend.jokeApi.JokeApi;

import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;

/**
 * Created by Aaron on 12/08/2017.
 */

public class EndpointsAsyncTask extends AsyncTask<Void, Void, String> {
    private static JokeApi jokeApiService = null;
    private JokeListener mJokeListener;

    public EndpointsAsyncTask(JokeListener jokeListener) {
        mJokeListener = jokeListener;
    }

    @Override
    protected String doInBackground(Void... params) {
        if (jokeApiService == null) {  // Only do this once
            JokeApi.Builder builder = new JokeApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl("https://build-it-bigger-udacity-176611.appspot.com/_ah/api/");

            jokeApiService = builder.build();
        }

        try {
            return jokeApiService.getJoke().execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String joke) {
        mJokeListener.onLoadJoke(joke);
    }
}
