package com.github.rkhusainov.moviefan.presentation.ui.popular;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.github.rkhusainov.moviefan.R;
import com.github.rkhusainov.moviefan.databinding.PopularBinding;
import com.github.rkhusainov.moviefan.presentation.Constants;
import com.github.rkhusainov.moviefan.presentation.common.OnItemClickListener;
import com.github.rkhusainov.moviefan.presentation.factory.PopularMovieFactory;
import com.github.rkhusainov.moviefan.presentation.ui.detail.MovieDetailFragment;

public class PopularMovieFragment extends Fragment {

    private PopularMovieViewModel mPopularMovieViewModel;

    public static PopularMovieFragment newInstance() {
        return new PopularMovieFragment();
    }

    private OnItemClickListener mOnItemClickListener = new OnItemClickListener() {
        @Override
        public void onClick(int movie_id) {
            if (getFragmentManager() != null) {
                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_container, MovieDetailFragment.newInstance(movie_id))
                        .addToBackStack(null)
                        .commit();
            }
        }
    };

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        PopularMovieFactory factory = new PopularMovieFactory(Constants.POPULAR);
        mPopularMovieViewModel = new ViewModelProvider(this, factory).get(PopularMovieViewModel.class);

        mPopularMovieViewModel.getLiveDataOnItemClickListener().setValue(mOnItemClickListener);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        PopularBinding binding = PopularBinding.inflate(inflater, container, false);

        binding.setPopular(mPopularMovieViewModel);
        binding.setLifecycleOwner(this);
        return binding.getRoot();
    }
}