package com.github.rkhusainov.moviefan.presentation.ui.credit;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.github.rkhusainov.moviefan.databinding.CastBinding;
import com.github.rkhusainov.moviefan.presentation.Constants;
import com.github.rkhusainov.moviefan.presentation.factory.CastFactory;

/**
 * Фрагмент для экрана со списком акётров
 *
 * @author Хусаинов Ринат on 2019-12-15
 */
public class CastFragment extends Fragment {

    public static final String MOVIE_KEY = "MOVIE_KEY";

    private CastViewModel mCastViewModel;

    /**
     * @param movieId ид фильма
     */
    public static CastFragment newInstance(int movieId) {

        Bundle args = new Bundle();
        args.putInt(MOVIE_KEY, movieId);
        CastFragment fragment = new CastFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        int movieId = getArguments().getInt(MOVIE_KEY);

        CastFactory castFactory = new CastFactory(Constants.CAST, movieId);
        mCastViewModel = new ViewModelProvider(this, castFactory).get(CastViewModel.class);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        CastBinding binding = CastBinding.inflate(inflater, container, false);

        binding.setCast(mCastViewModel);
        binding.setLifecycleOwner(this);
        binding.executePendingBindings();
        return binding.getRoot();
    }
}
