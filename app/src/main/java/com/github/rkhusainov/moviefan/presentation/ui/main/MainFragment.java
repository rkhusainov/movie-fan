package com.github.rkhusainov.moviefan.presentation.ui.main;

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
import com.github.rkhusainov.moviefan.databinding.MainMovieBinding;
import com.github.rkhusainov.moviefan.presentation.Constants;
import com.github.rkhusainov.moviefan.presentation.common.OnItemClickListener;
import com.github.rkhusainov.moviefan.presentation.ui.detail.DetailFragment;
import com.github.rkhusainov.moviefan.presentation.ui.popular.PopularFragment;
import com.github.rkhusainov.moviefan.presentation.ui.popular.PopularViewModel;
import com.github.rkhusainov.moviefan.presentation.ui.today.TodayViewModel;
import com.github.rkhusainov.moviefan.presentation.ui.top.TopFragment;
import com.github.rkhusainov.moviefan.presentation.ui.top.TopViewModel;
import com.github.rkhusainov.moviefan.presentation.ui.upcoming.UpcomingFragment;
import com.github.rkhusainov.moviefan.presentation.ui.upcoming.UpcomingViewModel;
import com.github.rkhusainov.moviefan.presentation.utils.PopularMovieFactory;
import com.github.rkhusainov.moviefan.presentation.utils.TodayMovieFactory;
import com.github.rkhusainov.moviefan.presentation.utils.TopMovieFactory;
import com.github.rkhusainov.moviefan.presentation.utils.UpcomingMovieFactory;

public class MainFragment extends Fragment {

    private PopularViewModel mPopularViewModel;
    private TodayViewModel mTodayViewModel;
    private TopViewModel mTopViewModel;
    private UpcomingViewModel mUpcomingViewModel;

    private OnItemClickListener mOnItemClickListener = new OnItemClickListener() {
        @Override
        public void onClick(int movie_id) {
            if (getFragmentManager() != null) {
                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_container, DetailFragment.newInstance(movie_id))
                        .addToBackStack(null)
                        .commit();
            }
        }
    };

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        PopularMovieFactory popularMovieFactory = new PopularMovieFactory(mOnItemClickListener, Constants.MAIN);
        TodayMovieFactory todayMoviefactory = new TodayMovieFactory(mOnItemClickListener);
        TopMovieFactory topMovieFactory = new TopMovieFactory(mOnItemClickListener, Constants.MAIN);
        UpcomingMovieFactory upcomingMovieFactory = new UpcomingMovieFactory(mOnItemClickListener, Constants.MAIN);

        mPopularViewModel = new ViewModelProvider(this, popularMovieFactory).get(PopularViewModel.class);
        mTodayViewModel = new ViewModelProvider(this, todayMoviefactory).get(TodayViewModel.class);
        mTopViewModel = new ViewModelProvider(this, topMovieFactory).get(TopViewModel.class);
        mUpcomingViewModel = new ViewModelProvider(this, upcomingMovieFactory).get(UpcomingViewModel.class);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        MainMovieBinding mainMovieBinding = MainMovieBinding.inflate(inflater, container, false);
        mainMovieBinding.setPopular(mPopularViewModel);
        mainMovieBinding.setToday(mTodayViewModel);
        mainMovieBinding.setTop(mTopViewModel);
        mainMovieBinding.setUpcoming(mUpcomingViewModel);
        mainMovieBinding.setHandler(this);
        mainMovieBinding.setLifecycleOwner(this);
        return mainMovieBinding.getRoot();
    }

    public void openFragment(View view) {
        switch (view.getId()) {
            case R.id.btn_popular:
                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_container, PopularFragment.newInstance())
                        .addToBackStack(null)
                        .commit();
                break;
            case R.id.btn_top:
                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_container, TopFragment.newInstance())
                        .addToBackStack(null)
                        .commit();
                break;
            case R.id.btn_upcoming:
                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_container, UpcomingFragment.newInstance())
                        .addToBackStack(null)
                        .commit();
                break;
        }
    }
}