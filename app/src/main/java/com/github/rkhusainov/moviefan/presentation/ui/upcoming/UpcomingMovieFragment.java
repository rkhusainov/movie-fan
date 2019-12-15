package com.github.rkhusainov.moviefan.presentation.ui.upcoming;

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
import com.github.rkhusainov.moviefan.databinding.UpcomingBinding;
import com.github.rkhusainov.moviefan.presentation.Constants;
import com.github.rkhusainov.moviefan.presentation.common.OnItemClickListener;
import com.github.rkhusainov.moviefan.presentation.factory.UpcomingMovieFactory;
import com.github.rkhusainov.moviefan.presentation.ui.detail.MovieDetailFragment;

/**
 * Фрагмент для экрана с фильмами, которые скоро покажут в кинотеатрах
 *
 * @author Хусаинов Ринат on 2019-12-15
 */
public class UpcomingMovieFragment extends Fragment {

    private UpcomingMovieViewModel mUpcomingMovieViewModel;

    private OnItemClickListener mOnItemClickListener = movieId -> {
        if (getFragmentManager() != null) {
            getFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, MovieDetailFragment.newInstance(movieId))
                    .addToBackStack(null)
                    .commit();
        }
    };

    public static UpcomingMovieFragment newInstance() {
        return new UpcomingMovieFragment();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        UpcomingMovieFactory factory = new UpcomingMovieFactory(Constants.UPCOMING);
        mUpcomingMovieViewModel = new ViewModelProvider(this, factory).get(UpcomingMovieViewModel.class);

        mUpcomingMovieViewModel.getLiveDataOnItemClickListener().setValue(mOnItemClickListener);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        UpcomingBinding binding = UpcomingBinding.inflate(inflater, container, false);
        binding.setUpcoming(mUpcomingMovieViewModel);
        binding.setLifecycleOwner(this);
        return binding.getRoot();
    }
}
