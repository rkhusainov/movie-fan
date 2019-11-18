package com.github.rkhusainov.moviefan.ui.popular;

import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.github.rkhusainov.moviefan.R;
import com.github.rkhusainov.moviefan.common.OnItemClickListener;
import com.github.rkhusainov.moviefan.data.model.Movie;
import com.github.rkhusainov.moviefan.ui.detail.DetailFragment;

import java.util.List;

import static com.github.rkhusainov.moviefan.ui.popular.PopularAdapter.POPULAR;

public class PopularFragment extends Fragment implements IPopularView, OnItemClickListener {

    private RecyclerView mRecyclerView;
    private PopularAdapter mPopularAdapter = new PopularAdapter(POPULAR, this);
    private PopularPresenter mPresenter;
    private View mErrorView;
    private ProgressBar mProgressBar;

    public static PopularFragment newInstance() {
        return new PopularFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fr_popular, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRecyclerView = view.findViewById(R.id.recycler);
        mErrorView = view.findViewById(R.id.errorView);
        mProgressBar = view.findViewById(R.id.progress_bar);
        mPresenter = new PopularPresenter(this);

        mPresenter.getMovies();
        initRecyclerView();
    }

    private void initRecyclerView() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL);
        dividerItemDecoration.getDrawable().setColorFilter(getResources().getColor(R.color.colorWhite), PorterDuff.Mode.SRC_IN);
        mRecyclerView.addItemDecoration(dividerItemDecoration);
        mRecyclerView.setAdapter(mPopularAdapter);
    }

    @Override
    public void showPopularMovies(List<Movie> movies) {
        mPopularAdapter.addData(movies);
        mRecyclerView.setVisibility(View.VISIBLE);
        mErrorView.setVisibility(View.GONE);
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
        mRecyclerView.setVisibility(View.GONE);
        mErrorView.setVisibility(View.VISIBLE);
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
}