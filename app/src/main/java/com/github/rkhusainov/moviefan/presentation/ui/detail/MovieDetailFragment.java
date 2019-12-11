package com.github.rkhusainov.moviefan.presentation.ui.detail;


import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.github.rkhusainov.moviefan.R;
import com.github.rkhusainov.moviefan.databinding.DetailBinding;
import com.github.rkhusainov.moviefan.presentation.Constants;
import com.github.rkhusainov.moviefan.presentation.factory.CastFactory;
import com.github.rkhusainov.moviefan.presentation.factory.MovieDetailFactory;
import com.github.rkhusainov.moviefan.presentation.ui.credit.CastFragment;
import com.github.rkhusainov.moviefan.presentation.ui.credit.CastViewModel;

import static android.content.ContentValues.TAG;

public class MovieDetailFragment extends Fragment {

    public static final String MOVIE_KEY = "MOVIE_KEY";

    private int mMovieId;

    private MovieDetailViewModel mMovieDetailViewModel;
    private CastViewModel mCastViewModel;

    public static MovieDetailFragment newInstance(int move_id) {

        Bundle args = new Bundle();
        args.putInt(MOVIE_KEY, move_id);
        MovieDetailFragment fragment = new MovieDetailFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        mMovieId = getArguments().getInt(MOVIE_KEY);

        MovieDetailFactory movieDetailFactory = new MovieDetailFactory(mMovieId);
        mMovieDetailViewModel = new ViewModelProvider(this, movieDetailFactory).get(MovieDetailViewModel.class);

        CastFactory castFactory = new CastFactory(Constants.DETAIL, mMovieId);
        mCastViewModel = new ViewModelProvider(this, castFactory).get(CastViewModel.class);
        Log.d(TAG, "onAttach: " + "ViewModel Init");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView: " + "BINDING");
        DetailBinding binding = DetailBinding.inflate(inflater, container, false);
        binding.setDetail(mMovieDetailViewModel);
        binding.setCast(mCastViewModel);
        binding.setHandler(this);
        binding.setLifecycleOwner(this);
        binding.executePendingBindings();
        return binding.getRoot();
    }

    public void openAllCast() {
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, CastFragment.newInstance(mMovieId))
                .addToBackStack(null)
                .commit();
    }
}
