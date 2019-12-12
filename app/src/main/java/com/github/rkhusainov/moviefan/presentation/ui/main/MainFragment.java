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
import com.github.rkhusainov.moviefan.presentation.factory.PopularMovieFactory;
import com.github.rkhusainov.moviefan.presentation.factory.TodayMovieFactory;
import com.github.rkhusainov.moviefan.presentation.factory.TopMovieFactory;
import com.github.rkhusainov.moviefan.presentation.factory.UpcomingMovieFactory;
import com.github.rkhusainov.moviefan.presentation.ui.detail.MovieDetailFragment;
import com.github.rkhusainov.moviefan.presentation.ui.popular.PopularMovieFragment;
import com.github.rkhusainov.moviefan.presentation.ui.popular.PopularMovieViewModel;
import com.github.rkhusainov.moviefan.presentation.ui.today.TodayMovieViewModel;
import com.github.rkhusainov.moviefan.presentation.ui.top.TopMovieFragment;
import com.github.rkhusainov.moviefan.presentation.ui.top.TopMovieViewModel;
import com.github.rkhusainov.moviefan.presentation.ui.upcoming.UpcomingMovieFragment;
import com.github.rkhusainov.moviefan.presentation.ui.upcoming.UpcomingMovieViewModel;

import org.jetbrains.annotations.NotNull;

public class MainFragment extends Fragment {

    private PopularMovieViewModel mPopularMovieViewModel;
    private TodayMovieViewModel mTodayMovieViewModel;
    private TopMovieViewModel mTopMovieViewModel;
    private UpcomingMovieViewModel mUpcomingMovieViewModel;
    private MainMovieBinding mMainMovieBinding;

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

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        PopularMovieFactory popularMovieFactory = new PopularMovieFactory(Constants.MAIN);
        TodayMovieFactory todayMoviefactory = new TodayMovieFactory();
        TopMovieFactory topMovieFactory = new TopMovieFactory(Constants.MAIN);
        UpcomingMovieFactory upcomingMovieFactory = new UpcomingMovieFactory(Constants.MAIN);

        mPopularMovieViewModel = new ViewModelProvider(this, popularMovieFactory).get(PopularMovieViewModel.class);
        mTodayMovieViewModel = new ViewModelProvider(this, todayMoviefactory).get(TodayMovieViewModel.class);
        mTopMovieViewModel = new ViewModelProvider(this, topMovieFactory).get(TopMovieViewModel.class);
        mUpcomingMovieViewModel = new ViewModelProvider(this, upcomingMovieFactory).get(UpcomingMovieViewModel.class);

        mPopularMovieViewModel.getLiveDataOnItemClickListener().setValue(mOnItemClickListener);
        mTodayMovieViewModel.getLiveDataOnItemClickListener().setValue(mOnItemClickListener);
        mTopMovieViewModel.getLiveDataOnItemClickListener().setValue(mOnItemClickListener);
        mUpcomingMovieViewModel.getLiveDataOnItemClickListener().setValue(mOnItemClickListener);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mMainMovieBinding = MainMovieBinding.inflate(inflater, container, false);

        mMainMovieBinding.setPopular(mPopularMovieViewModel);
        mMainMovieBinding.setToday(mTodayMovieViewModel);
        mMainMovieBinding.setTop(mTopMovieViewModel);
        mMainMovieBinding.setUpcoming(mUpcomingMovieViewModel);
        mMainMovieBinding.setHandler(this);
        mMainMovieBinding.setLifecycleOwner(this);
        return mMainMovieBinding.getRoot();
    }

    /**
     * @param view нажатый пользователем view
     */
    public void openFragment(@NotNull View view) {
        switch (view.getId()) {
            case R.id.btn_popular:
                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_container, PopularMovieFragment.newInstance())
                        .addToBackStack(null)
                        .commit();
                break;
            case R.id.btn_top:
                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_container, TopMovieFragment.newInstance())
                        .addToBackStack(null)
                        .commit();
                break;
            case R.id.btn_upcoming:
                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_container, UpcomingMovieFragment.newInstance())
                        .addToBackStack(null)
                        .commit();
                break;
        }
    }
}
