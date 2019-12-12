package com.github.rkhusainov.moviefan.presentation.ui.main;

import androidx.fragment.app.Fragment;

import com.github.rkhusainov.moviefan.presentation.common.SingleFragmentActivity;

import org.jetbrains.annotations.NotNull;

public class MainActivity extends SingleFragmentActivity {

    @NotNull
    @Override
    protected Fragment getFragment() {
        return MainFragment.newInstance();
    }
}
