package com.youknow.jokeactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class JokeActivity extends AppCompatActivity {

    TextView mTvJoke;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);
        ButterKnife.bind(this);

        mTvJoke = (TextView) findViewById(R.id.tv_joke);

        Intent intent = getIntent();
        if (intent != null && intent.hasExtra(getString(R.string.key_joke))) {
            String joke = intent.getStringExtra(getString(R.string.key_joke));
            mTvJoke.setText(joke);
        }
    }
}
