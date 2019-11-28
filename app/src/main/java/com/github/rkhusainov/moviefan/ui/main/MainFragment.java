package com.github.rkhusainov.moviefan.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.github.rkhusainov.moviefan.R;
import com.github.rkhusainov.moviefan.common.OnItemClickListener;
import com.github.rkhusainov.moviefan.data.model.movie.Movie;
import com.github.rkhusainov.moviefan.ui.detail.DetailFragment;
import com.github.rkhusainov.moviefan.ui.popular.PopularAdapter;
import com.github.rkhusainov.moviefan.ui.popular.PopularFragment;
import com.github.rkhusainov.moviefan.ui.popular.PopularPresenter;
import com.github.rkhusainov.moviefan.ui.today.TodayAdapter;
import com.github.rkhusainov.moviefan.ui.today.TodayPresenter;
import com.github.rkhusainov.moviefan.ui.top.TopAdapter;
import com.github.rkhusainov.moviefan.ui.top.TopFragment;
import com.github.rkhusainov.moviefan.ui.top.TopPresenter;
import com.github.rkhusainov.moviefan.ui.upcoming.UpcomingAdapter;
import com.github.rkhusainov.moviefan.ui.upcoming.UpcomingFragment;
import com.github.rkhusainov.moviefan.ui.upcoming.UpcomingPresenter;

import java.util.List;

public class MainFragment extends Fragment implements IMainView, OnItemClickListener {

    private Button mPopularBtn;
    private Button mTopBtn;
    private Button mUpcomingBtn;
    private RecyclerView mPopularRecyclerView;
    private RecyclerView mTodayRecyclerView;
    private RecyclerView mTopRecyclerView;
    private RecyclerView mUpcomingRecyclerView;
    private PopularAdapter mPopularAdapter = new PopularAdapter(PopularAdapter.MAIN, this);
    private TodayAdapter mTodayAdapter = new TodayAdapter(this);
    private TopAdapter mTopAdapter = new TopAdapter(TopAdapter.MAIN, this);
    private UpcomingAdapter mUpcomingAdapter = new UpcomingAdapter(UpcomingAdapter.MAIN, this);
    private ProgressBar mProgressBar;
    private PopularPresenter mPopularPresenter;
    private TodayPresenter mTodayPresenter;
    private TopPresenter mTopPresenter;
    private UpcomingPresenter mUpcomingPresenter;
    private View mMainLayout;
    private View mErrorView;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fr_main, container, false);
        mPopularBtn = view.findViewById(R.id.btn_popular);
        mTopBtn = view.findViewById(R.id.btn_top);
        mUpcomingBtn = view.findViewById(R.id.btn_upcoming);
        mPopularRecyclerView = view.findViewById(R.id.recycler_popular);
        mTodayRecyclerView = view.findViewById(R.id.recycler_today);
        mTopRecyclerView = view.findViewById(R.id.recycler_top);
        mUpcomingRecyclerView = view.findViewById(R.id.recycler_upcoming);
        mMainLayout = view.findViewById(R.id.main_layout);
        mErrorView = view.findViewById(R.id.errorView);
        mProgressBar = view.findViewById(R.id.progress_bar);
        mPopularPresenter = new PopularPresenter(this);
        mTodayPresenter = new TodayPresenter(this);
        mTopPresenter = new TopPresenter(this);
        mUpcomingPresenter = new UpcomingPresenter(this);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mPopularRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));
        mPopularRecyclerView.setAdapter(mPopularAdapter);
        mTodayRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));
        mTodayRecyclerView.setAdapter(mTodayAdapter);
        mTopRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));
        mTopRecyclerView.setAdapter(mTopAdapter);
        mUpcomingRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));
        mUpcomingRecyclerView.setAdapter(mUpcomingAdapter);

        mPopularPresenter.getMovies();
        mTodayPresenter.getTodayMovies();
        mTopPresenter.getMovies();
        mUpcomingPresenter.getMovies();

        mPopularBtn.setOnClickListener(v -> {
            getFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, PopularFragment.newInstance())
                    .addToBackStack(null)
                    .commit();
        });

        mTopBtn.setOnClickListener(v -> {
            getFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, TopFragment.newInstance())
                    .addToBackStack(null)
                    .commit();
        });

        mUpcomingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_container, UpcomingFragment.newInstance())
                        .addToBackStack(null)
                        .commit();
            }
        });
    }

    @Override
    public void showPopularMovies(List<Movie> movies) {
        mMainLayout.setVisibility(View.VISIBLE);
        mErrorView.setVisibility(View.GONE);
        mPopularAdapter.addData(movies);
    }

    @Override
    public void showTodayMovies(List<Movie> movies) {
        mMainLayout.setVisibility(View.VISIBLE);
        mErrorView.setVisibility(View.GONE);
        mTodayAdapter.addData(movies);
    }

    @Override
    public void showTopMovies(List<Movie> movies) {
        mMainLayout.setVisibility(View.VISIBLE);
        mErrorView.setVisibility(View.GONE);
        mTopAdapter.addData(movies);
    }

    @Override
    public void showUpcomingMovies(List<Movie> movies) {
        mMainLayout.setVisibility(View.VISIBLE);
        mErrorView.setVisibility(View.GONE);
        mUpcomingAdapter.addData(movies);
    }

    @Override
    public void showProgress() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        mProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void showError() {
        mErrorView.setVisibility(View.VISIBLE);
        mMainLayout.setVisibility(View.GONE);
    }

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

    @Override
    public void onDetach() {
        super.onDetach();
        if (mPopularPresenter != null) {
            mPopularPresenter.disposeAll();
        }

        if (mTodayPresenter != null) {
            mTodayPresenter.disposeAll();
        }

        if (mTopPresenter != null) {
            mTopPresenter.disposeAll();
        }

        if (mUpcomingPresenter != null) {
            mUpcomingPresenter.disposeAll();
        }
    }
}
