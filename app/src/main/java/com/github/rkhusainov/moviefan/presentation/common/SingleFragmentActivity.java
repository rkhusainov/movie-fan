package com.github.rkhusainov.moviefan.presentation.common;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.github.rkhusainov.moviefan.R;

/**
 * Абстрактный класс для host-activity
 *
 * @author Хусаинов Ринат on 2019-12-15
 */
public abstract class SingleFragmentActivity extends AppCompatActivity {

    @NonNull
    protected abstract Fragment getFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_fragment);

        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, getFragment())
                    .commit();
        }
    }
}
