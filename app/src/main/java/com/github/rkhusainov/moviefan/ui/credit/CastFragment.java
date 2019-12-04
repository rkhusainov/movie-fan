package com.github.rkhusainov.moviefan.ui.credit;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.github.rkhusainov.moviefan.Constants;
import com.github.rkhusainov.moviefan.R;
import com.github.rkhusainov.moviefan.databinding.CastBinding;
import com.github.rkhusainov.moviefan.utils.CastFactory;

public class CastFragment extends Fragment {

    public static final String MOVIE_KEY = "MOVIE_KEY";

    private int mMovieId;

    private CastViewModel mCastViewModel;

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

        mMovieId = getArguments().getInt(MOVIE_KEY);

        CastFactory castFactory = new CastFactory(Constants.CAST, mMovieId);
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
