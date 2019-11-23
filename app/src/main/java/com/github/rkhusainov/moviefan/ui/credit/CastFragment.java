package com.github.rkhusainov.moviefan.ui.credit;

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
import com.github.rkhusainov.moviefan.data.model.credit.Cast;

import java.util.List;

public class CastFragment extends Fragment implements ICastView {

    public static final String MOVIE_KEY = "MOVIE_KEY";

    private RecyclerView mRecyclerView;
    private CastAdapter mCastAdapter = new CastAdapter(CastAdapter.CAST);
    private int mMovieId;
    private ProgressBar mProgressBar;
    private View mErrorView;

    private CastPresenter mCastPresenter;

    public static CastFragment newInstance(int movieId) {

        Bundle args = new Bundle();
        args.putInt(MOVIE_KEY, movieId);
        CastFragment fragment = new CastFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fr_cast, container, false);
        mRecyclerView = view.findViewById(R.id.recycler_cast);
        mProgressBar = view.findViewById(R.id.progress_bar);
        mErrorView = view.findViewById(R.id.errorView);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mCastPresenter = new CastPresenter(this);
        initRecyclerView();
    }

    private void initRecyclerView() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL);
        dividerItemDecoration.getDrawable().setColorFilter(getResources().getColor(R.color.colorWhite), PorterDuff.Mode.SRC_IN);
        mRecyclerView.addItemDecoration(dividerItemDecoration);
        mRecyclerView.setAdapter(mCastAdapter);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mMovieId = getArguments().getInt(MOVIE_KEY);
        mCastPresenter.getCast(mMovieId);
    }

    @Override
    public void getCast(List<Cast> casts) {
        mCastAdapter.addData(casts);
        mErrorView.setVisibility(View.GONE);
        mRecyclerView.setVisibility(View.VISIBLE);
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
        mRecyclerView.setVisibility(View.GONE);
    }
}
