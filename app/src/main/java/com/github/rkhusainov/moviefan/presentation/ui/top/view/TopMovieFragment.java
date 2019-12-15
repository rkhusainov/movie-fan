package com.github.rkhusainov.moviefan.presentation.ui.top.view;

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
import com.github.rkhusainov.moviefan.databinding.TopBinding;
import com.github.rkhusainov.moviefan.presentation.Constants;
import com.github.rkhusainov.moviefan.presentation.common.OnItemClickListener;
import com.github.rkhusainov.moviefan.presentation.factory.TopMovieFactory;
import com.github.rkhusainov.moviefan.presentation.ui.detail.view.MovieDetailFragment;
import com.github.rkhusainov.moviefan.presentation.ui.top.viewmodel.TopMovieViewModel;

/**
 * Фрагмент для экрана с топ фильмами
 *
 * @author Хусаинов Ринат on 2019-12-15
 */
public class TopMovieFragment extends Fragment {

    private TopMovieViewModel mTopMovieViewModel;

    private OnItemClickListener mOnItemClickListener = movie_id -> {
        if (getFragmentManager() != null) {
            getFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, MovieDetailFragment.newInstance(movie_id))
                    .addToBackStack(null)
                    .commit();
        }
    };

    public static TopMovieFragment newInstance() {
        return new TopMovieFragment();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        TopMovieFactory factory = new TopMovieFactory(Constants.TOP);
        mTopMovieViewModel = new ViewModelProvider(this, factory).get(TopMovieViewModel.class);

        mTopMovieViewModel.getLiveDataOnItemClickListener().setValue(mOnItemClickListener);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        TopBinding binding = TopBinding.inflate(inflater, container, false);
        binding.setTop(mTopMovieViewModel);
        binding.setLifecycleOwner(this);
        return binding.getRoot();
    }
}
