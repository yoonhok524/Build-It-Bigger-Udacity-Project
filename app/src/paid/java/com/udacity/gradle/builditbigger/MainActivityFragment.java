package com.udacity.gradle.builditbigger;

import com.udacity.gradle.builditbigger.EndpointsAsyncTask;
import com.udacity.gradle.builditbigger.JokeListener;
import com.udacity.gradle.builditbigger.R;
import com.youknow.jokeactivity.JokeActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment implements JokeListener {

    @BindView(R.id.btn_tell_joke)
    Button mBtnTellJoke;
    @BindView(R.id.progressbar)
    ProgressBar mProgressBar;

    public MainActivityFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, root);

        return root;
    }

    @OnClick(R.id.btn_tell_joke)
    public void onClickTellJoke() {
        mProgressBar.setVisibility(View.VISIBLE);
        new EndpointsAsyncTask(this).execute();
    }

    @Override
    public void onLoadJoke(String joke) {
        mProgressBar.setVisibility(View.GONE);
        Intent intent = new Intent(getContext(), JokeActivity.class);
        intent.putExtra(getString(R.string.key_joke), joke);
        startActivity(intent);
    }
}