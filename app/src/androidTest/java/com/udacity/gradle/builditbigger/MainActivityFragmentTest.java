package com.udacity.gradle.builditbigger;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Aaron on 13/08/2017.
 */

public class MainActivityFragmentTest {
    @Test
    public void getJokeTest() throws Exception {
        EndpointsAsyncTask asyncTask = new EndpointsAsyncTask(new JokeListener() {
            @Override
            public void onLoadJoke(String joke) {
                // nothing to do
            }
        });

        asyncTask.execute();

        String joke = asyncTask.get(30, TimeUnit.SECONDS);
        System.out.println("Joke: " + joke);
        assertTrue(joke.length() > 0);
    }
}
