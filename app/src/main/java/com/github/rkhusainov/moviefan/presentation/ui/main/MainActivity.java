package com.github.rkhusainov.moviefan.presentation.ui.main;

import androidx.fragment.app.Fragment;

import com.github.rkhusainov.moviefan.presentation.common.SingleFragmentActivity;

public class MainActivity extends SingleFragmentActivity {

    @Override
    protected Fragment getFragment() {
        return MainFragment.newInstance();
    }
}
