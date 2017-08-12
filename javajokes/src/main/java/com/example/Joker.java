package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Joker {

    private static Joker INSTANCE = new Joker();

    private List<String> jokes;

    private Joker() {
        jokes = new ArrayList<>();
        jokes.add("FUNNY JOKE!");
        jokes.add("SAD JOKE!");
        jokes.add("SCARED JOKE!");
        jokes.add("NO FUNNY JOKE!");
        jokes.add("SEXY JOKE!");
    }

    public static Joker getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Joker();
        }

        return INSTANCE;
    }

    public String getJoke() {
        Random r = new Random();
        int index = r.nextInt(jokes.size());
        String joke = jokes.get(index);

        System.out.println("TEST: " + index + "\t" + joke);

        return joke;
    }
}
