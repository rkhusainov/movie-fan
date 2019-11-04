package com.github.rkhusainov.moviefan.ui.main;

import androidx.fragment.app.Fragment;

import com.github.rkhusainov.moviefan.common.SingleFragmentActivity;

public class MainActivity extends SingleFragmentActivity {

    @Override
    protected Fragment getFragment() {
        return MainFragment.newInstance();
    }
}
