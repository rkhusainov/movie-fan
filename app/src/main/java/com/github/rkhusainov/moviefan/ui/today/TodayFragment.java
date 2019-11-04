package com.github.rkhusainov.moviefan.ui.today;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.rkhusainov.moviefan.R;

public class TodayFragment extends Fragment {

    public static TodayFragment newInstance() {
        return new TodayFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_today, container, false);
    }
}
